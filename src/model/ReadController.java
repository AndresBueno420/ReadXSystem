package model;
import java.util.ArrayList;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class ReadController {

    ArrayList<User> users;
    ArrayList<BibliographicProduct> bibliographicProducts;
    ArrayList<String> dates;

    public ReadController(){
        users = new ArrayList<>();
        bibliographicProducts = new ArrayList<>();
    }
    /**
     * The function adds a new user to a list based on their user type and returns a message indicating
     * the success of the operation.
     * 
     * @param username The username of the user being registered.
     * @param identification It is a String variable that represents the identification of the user
     * being registered. It could be a unique identifier such as an ID number or a username.
     * @param userKind an integer value representing the type of user to be registered. 1 represents a
     * premium user and 2 represents a regular user.
     * @return The method `registUser` returns a message indicating whether a Premium or Regular user
     * has been added and at what date.
     */
    public String registUser(String username, String identification, int userKind){

        User user = null;
        String msg = " ";


        switch(userKind) {
            case 1:
                user = new premiumUser(username, identification);
                users.add(user);
                msg = "The Premium user has been added at: " + user.getLinkDate();
                break;
            case 2:
                user = new regularUser(username, identification);
                users.add(user);
                msg = "The Regular user has been added at: " + user.getLinkDate();
                break;
        }
        return msg;
    }

    /**
     * This Java function registers a new magazine product with specified attributes and adds it to a
     * list of bibliographic products.
     * 
     * @param productName A string representing the name of the bibliographic product (in this case, a
     * magazine).
     * @param bookPages The number of pages in the book.
     * @param publicationDate A string representing the date of publication of the bibliographic
     * product.
     * @param productPrice A string representing the price of the product.
     * @param magCategory an integer representing the category of the magazine product being
     * registered.
     * @param emPeriodicity The frequency of publication for a magazine, represented as an integer
     * value. 1 represents daily, 2 represents weekly, 3 represents monthly, and any other integer
     * value represents annual.
     * @return The method is returning a String message that confirms the registration of a
     * bibliographic product and includes the unique ID of the product.
     */
    public String registBiblioProduct(String productName, int bookPages, String publicationDate, String productPrice, int magCategory, int emPeriodicity){

        Category magKind;
        Periodicity magPeriod;

        if(magCategory == 1){
            magKind = Category.VARIETY;
        }
        else if(magCategory == 2){
            magKind = Category.DESIGN;
        }
        else{
            magKind = Category.CIENTIFIC;
        }

        if(emPeriodicity == 1){
            magPeriod = Periodicity.DAILY;
        }
        else if(emPeriodicity == 2){
            magPeriod = Periodicity.WEEKLY;
        }
        else if(emPeriodicity == 3){
            magPeriod = Periodicity.MONTHLY;
        }
        else{
            magPeriod = Periodicity.ANNUAL;
        }

        BibliographicProduct magazine = new Magazine(productName, bookPages, publicationDate, productPrice, magKind, magPeriod);
        bibliographicProducts.add(magazine);
        String msj = " The product has been registered and its Unique id is: " + magazine.getUniqueId();
        
        return msj;
    }

   /**
    * The function registers a book with its details and adds it to a list of bibliographic products.
    * 
    * @param productName A string representing the name of the book being registered as a bibliographic
    * product.
    * @param bookPages The number of pages in the book.
    * @param publicationDate A string representing the publication date of the book in the format
    * "YYYY-MM-DD".
    * @param productPrice a String representing the price of the book.
    * @param bookGenre an integer representing the genre of the book. 1 represents science fiction, 2
    * represents fantasy, and any other integer represents a historic novel.
    * @return The method is returning a message that confirms the registration of a book and includes
    * its unique ID.
    */
    public String registBiblioProduct(String productName, int bookPages, String publicationDate, String productPrice, int bookGenre){

        Genre bookType;

        if(bookGenre == 1){
            bookType = Genre.SCIENCE_FICTION;
        }
        else if(bookGenre == 2){
            bookType = Genre.FANTASY;
        }
        else{
            bookType = Genre.HISTORIC_NOVEL;
        }

        BibliographicProduct book = new Book(productName, bookPages, publicationDate, productPrice, bookType);
        bibliographicProducts.add(book);
        String msj = "The book has been registered and its Unique id is: " + book.getUniqueId();

        return msj;

    }

    
   /**
    * The function deletes a product from a list of bibliographic products and returns a message
    * indicating whether the product was successfully removed or not.
    * 
    * @param productName a String representing the name of the product that needs to be deleted from a
    * list of bibliographic products.
    * @return A message indicating whether the product was successfully removed or not.
    */
    public String deleteProduct(String productName){

        String msj = " ";
        boolean foundProduct = false; 

        for(int i = 0; i < bibliographicProducts.size() && !foundProduct; i++){
            BibliographicProduct product = bibliographicProducts.get(i);
            if(product.getProductName().equals(productName)){
                bibliographicProducts.remove(i);
                msj = "The product has been removed succesfully.";
                foundProduct = true;
                
            }
            else{
                msj = "The product has not been found. ";
            }
        }
        return msj;
    }
    public String modifyProductName(String id, String newName){

        String msj = " ";
        for(int i = 0; i < bibliographicProducts.size(); i++){
            if(bibliographicProducts.get(i).getUniqueId().equals(id)){
                bibliographicProducts.get(i).setProductName(newName);
                msj = "The name has been updated.";
            }
            else{
                msj = "The product has not been found.";
            }
        }
        return msj;

    }
    public String modifyProductPages(String id, int newPages){

        String msj = " ";
        for(int i = 0; i < bibliographicProducts.size(); i++){
            if(bibliographicProducts.get(i).getUniqueId().equals(id)){
                bibliographicProducts.get(i).setBookPages(newPages);
                msj = "The pages have been updated.";
            }
            else{
                msj = "The product has not been found.";
            }
        }
        return msj;
    }
    public String modifyProductPrice(String id, String newPrice){

        String msj = " ";
        for(int i = 0; i < bibliographicProducts.size(); i++){
            if(bibliographicProducts.get(i).getUniqueId().equals(id)){
                bibliographicProducts.get(i).setProductPrice(newPrice);
                msj = "The price has been updated.";
            }
            else{
                msj = "The product has not been found.";
            }
        }
        return msj;
    }

    /**
     * This Java function searches for a bibliographic product by name and returns it if found.
     * 
     * @param productName a String representing the name of a bibliographic product that needs to be
     * searched for in a list of bibliographic products.
     * @return The method `searchProduct` returns a `BibliographicProduct` object.
     */
    public BibliographicProduct searchProduct(String productName){

        boolean foundProject = false;
        BibliographicProduct product = null;

        for(int i = 0; i < bibliographicProducts.size() && !foundProject;i++){
            if(bibliographicProducts.get(i).getProductName().equalsIgnoreCase(productName)){
                foundProject = true;
                product = bibliographicProducts.get(i);
            }
        }
        return product;
    }

   /**
    * The function allows a user to buy a book and updates the copies sold and purchase date, while
    * also checking if the user and book exist.
    * 
    * @param userName A String representing the username of the user who wants to buy the book.
    * @param bookName A String representing the name of the book that the user wants to buy.
    * @return The method returns a String message that indicates whether the book was bought
    * successfully or not, and includes the date of purchase. The message can be one of the following:
    * - "The user does not exist."
    * - "The book does not exist."
    * - A message returned by the addProduct() method of the User class, concatenated with the date of
    * purchase.
    */
    public String buyBook(String userName, String bookName){

        boolean foundUser = false;
        boolean foundProduct = false;
        String msj = " ";

        for(int i = 0; i < bibliographicProducts.size() && !foundProduct; i++){
            BibliographicProduct product = bibliographicProducts.get(i);
            if(product.getProductName().equalsIgnoreCase(bookName) && product instanceof Book){
                foundProduct = true;
                for(int x = 0; x < users.size() && !foundUser; x++){
                    User user = users.get(x);
                    if(user.getUsername().equals(userName) && user instanceof regularUser){

                        foundUser = true;
                       
                        Calendar calendar = Calendar.getInstance();
                        ((Book)bibliographicProducts.get(i)).setCopiesSold();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                        String buyDate = dateFormat.format(calendar.getTime());
                        dates.add(buyDate);
                        msj = user.addProduct(product) + buyDate;

                        
                    }
                    else if(user.getUsername().equals(userName) && user instanceof premiumUser){

                        foundUser = true;
                        Calendar calendar = Calendar.getInstance();
                        ((Book)bibliographicProducts.get(i)).setCopiesSold();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                        String buyDate = dateFormat.format(calendar.getTime());
                        dates.add(buyDate);
                        msj = user.addProduct(product) + buyDate;
                    }
                    else{
                        msj = "The user does not exist.";
                    }
                    
                }

            }
            else{
                msj = "The book does not exist.";
            }

        }

        return msj;
    }

   /**
    * The function allows a user to buy a magazine and adds it to their list of products, while also
    * setting the subscription as active and recording the date of purchase.
    * 
    * @param userName The username of the user who wants to buy the magazine.
    * @param magazineName The name of the magazine that the user wants to buy.
    * @return The method returns a String message that indicates whether the magazine was successfully
    * purchased or not, and includes the date of the purchase if it was successful.
    */
    public String buyMagazine(String userName, String magazineName){

        boolean foundUser = false;
        boolean foundProduct = false;
        String msj = " ";

        for(int i = 0; i < bibliographicProducts.size() && !foundProduct; i++){
            BibliographicProduct product = bibliographicProducts.get(i);
            if(product.getProductName().equalsIgnoreCase(magazineName) && product instanceof Magazine){
                foundProduct = true;
                for(int x = 0; x < users.size() && !foundUser; x++){
                    User user = users.get(x);
                    if(user.getUsername().equals(userName) && user instanceof regularUser){

                        foundUser = true;
                        Calendar calendar = Calendar.getInstance();
                        ((Magazine)bibliographicProducts.get(i)).setActiveSubscriptions();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                        String linkingDate = dateFormat.format(calendar.getTime());
                        dates.add(linkingDate);
                        msj = user.addProduct(product) + linkingDate;

                        
                    }
                    else if(user.getUsername().equals(userName) && user instanceof premiumUser){

                        foundUser = true;
                        Calendar calendar = Calendar.getInstance();
                        ((Magazine)bibliographicProducts.get(i)).setActiveSubscriptions();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                        String linkingDate = dateFormat.format(calendar.getTime());
                        dates.add(linkingDate);
                        msj = user.addProduct(product) + linkingDate;
                    }
                    else{
                        msj = "The user does not exist.";
                    }
                    
                }

            }
            else{
                msj = "The book does not exist.";
            }

        }

        return msj;
    }

   /**
    * This Java function displays a list of books from a collection of bibliographic products.
    * 
    * @return The method `displayBooks` returns a string that contains the names of all the books in
    * the `bibliographicProducts` list, along with a number assigned to each book as an option.
    */
    public String displayBooks(){

        String msj = " ";
        int optionCount = 0;

        for(int i = 0; i < bibliographicProducts.size() && bibliographicProducts.get(i) instanceof Book; i ++){
            optionCount =+ 1;
            msj = optionCount + "." + bibliographicProducts.get(i).getProductName() + "\n" ;
        }
        return msj;
    }

   /**
    * This Java function displays a list of magazines from a collection of bibliographic products.
    * 
    * @return The method `displayMagazines` returns a string that contains the names of all the
    * magazines in the `bibliographicProducts` list.
    */
    public String displayMagazines(){

        String msj = " ";
        int optionCount = 0;

        for(int i = 0; i < bibliographicProducts.size() && bibliographicProducts.get(i) instanceof Magazine; i ++){
            optionCount =+ 1;
            msj = optionCount + "." + bibliographicProducts.get(i).getProductName() + "\n" ;
        }
        return msj;
    }
    
}
