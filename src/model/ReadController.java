package model;
import java.util.ArrayList;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Random;


public class ReadController {

    ArrayList<User> users;
    ArrayList<BibliographicProduct> bibliographicProducts;
    ArrayList<Bill> bills;
    Random random;

    public ReadController()throws Exception{
        users = new ArrayList<>();
        bibliographicProducts = new ArrayList<>();
        bills = new ArrayList<>();
        random = new Random();
        testCase();
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
    public String registBiblioProduct(String productName, int bookPages, Calendar publicationDate, double productPrice, int magCategory, int emPeriodicity) throws Exception{

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
    public String registBiblioProduct(String productName, int bookPages, Calendar publicationDate, double productPrice, int bookGenre)throws Exception{

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

        String msj = "";
        boolean foundProduct = false; 

        for(int i = 0; i < bibliographicProducts.size() && !foundProduct; i++){
            BibliographicProduct product = bibliographicProducts.get(i);
            if(product.getProductName().equals(productName)){
                bibliographicProducts.remove(i);
                msj = "The product has been removed succesfully.";
                foundProduct = true;
                
            }
            if(!foundProduct){
                msj = "The product has not been found.";
            }
        }
        for(int j = 0; j < users.size(); j ++){
            User user = users.get(j);
            BibliographicProduct product2 = user.searchProduct(productName);
            if(product2 != null){
                user.deleteProduct(product2);
            }
        }   
        return msj;
    }
 /**
  * This Java function modifies the name of a bibliographic product based on its unique ID and returns
  * a message indicating whether the update was successful or not.
  * 
  * @param id A String representing the unique identifier of a bibliographic product.
  * @param newName The new name that you want to set for a bibliographic product.
  * @return A message indicating whether the product name has been updated or if the product has not
  * been found.
  */
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
/**
 * This Java function modifies the number of pages of a bibliographic product with a given ID and
 * returns a message indicating whether the update was successful or not.
 * 
 * @param id A String representing the unique identifier of a bibliographic product.
 * @param newPages An integer representing the new number of pages for a book product.
 * @return A message indicating whether the pages of a bibliographic product have been updated or if
 * the product has not been found.
 */
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
  /**
   * This function modifies the price of a bibliographic product with a given ID and returns a message
   * indicating whether the product was found and the price was updated or not.
   * 
   * @param id A String representing the unique identifier of a bibliographic product.
   * @param newPrice A String representing the new price of a bibliographic product.
   * @return A message indicating whether the price of the product with the given ID has been updated
   * or if the product has not been found.
   */
    public String modifyProductPrice(String id, double newPrice){

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
     * The function allows a user to buy a book and updates the necessary information such as the
     * number of copies sold and the purchase date, and adds the bill to the array.
     * 
     * @param userName A String representing the username of the user who wants to buy a book.
     * @param bookName The name of the book that the user wants to buy.
     * @return The method returns a String message that indicates whether the book was bought
     * successfully or not, and includes information about the user, the book, the date of purchase,
     * and the price. If the user or the book does not exist, it returns a message indicating that.
     */
    public String buyBook(String userName, String bookName){
       
        if (bibliographicProducts == null) {
            return "Error: bibliographicProducts is null";
        }
    
        if (users == null) {
            return "Error: users is null";
        }
    
        boolean foundUser = false;
        boolean foundProduct = false;
        String msj = "";
    
        for (int i = 0; i < bibliographicProducts.size() && !foundProduct; i++) {
            BibliographicProduct product = bibliographicProducts.get(i);
            if (product != null && product.getProductName().equalsIgnoreCase(bookName) && product instanceof Book) {
                foundProduct = true;
                for (int x = 0; x < users.size() && !foundUser; x++) {
                    User user = users.get(x);
                    if (user != null && user.getUsername().equalsIgnoreCase(userName)) {
                        foundUser = true;
                        Calendar calendar = Calendar.getInstance();
                        ((Book) bibliographicProducts.get(i)).setCopiesSold();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                        String buyDate = dateFormat.format(calendar.getTime());
                        double billPrice = product.getProductPrice();
                        String id = product.getUniqueId();
                        Bill bill = new Bill(billPrice, buyDate, id);
                        bills.add(bill);
    
                        if (user instanceof regularUser) {
                            msj = ((regularUser) user).addProduct(product) + "\nAt " + buyDate + "\nby a price of " + product.getProductPrice();
                        } else if (user instanceof premiumUser) {
                            msj = ((premiumUser) user).addProduct(product) + "\nAt " + buyDate + "\nby a price of " + product.getProductPrice();
                        }
                    }
                }
    
                if (!foundUser) {
                    msj = "The user does not exist.";
                }
            } else {
                msj = "The book does not exist.";
            }
        }
    
        return msj;
    
    }

        

 
  /**
   * The function allows a user to buy a magazine and updates the necessary information such as the
     * number of active subscriptions and the purchase date, and adds the bill to the array.
     * 
   * 
   * @param userName The username of the user who wants to buy the magazine.
   * @param magazineName The name of the magazine that the user wants to buy.
   * @return The method returns a String message that indicates whether the purchase of a magazine was
   * successful or not, and includes information such as the user who made the purchase, the date and
   * time of the purchase, and the price of the product. The message may also indicate if the user or
   * the magazine does not exist.
   */
    public String buyMagazine(String userName, String magazineName){

        if (bibliographicProducts == null) {
            return "Error: bibliographicProducts is null";
        }
    
        if (users == null) {
            return "Error: users is null";
        }
    
        boolean foundUser = false;
        boolean foundProduct = false;
        String msj = "";
    
        for (int i = 0; i < bibliographicProducts.size() && !foundProduct; i++) {
            BibliographicProduct product = bibliographicProducts.get(i);
            if (product != null && product.getProductName().equalsIgnoreCase(magazineName) && product instanceof Magazine) {
                foundProduct = true;
                for (int x = 0; x < users.size() && !foundUser; x++) {
                    User user = users.get(x);
                    if (user != null && user.getUsername().equalsIgnoreCase(userName)) {
                        foundUser = true;
                        Calendar calendar = Calendar.getInstance();
                        ((Magazine) bibliographicProducts.get(i)).setActiveSubscriptions();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                        String buyDate = dateFormat.format(calendar.getTime());
                        double billPrice = product.getProductPrice();
                        String id = product.getUniqueId();
                        Bill bill = new Bill(billPrice, buyDate, id);
                        bills.add(bill);
    
                        if (user instanceof regularUser) {
                            msj = ((regularUser) user).addProduct(product) + "\nAt " + buyDate + "\nby a price of " + product.getProductPrice();
                        } else if (user instanceof premiumUser) {
                            msj = ((premiumUser) user).addProduct(product) + "\nAt " + buyDate + "\nby a price of " + product.getProductPrice();
                        }
                    }
                }
    
                if (!foundUser) {
                    msj = "The user does not exist.";
                }
            } else {
                msj = "The Magazine does not exist.";
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

        String msj = "";
        int optionCount = 0;

        for(int i = 0; i < bibliographicProducts.size() && bibliographicProducts.get(i) instanceof Book ; i ++){
            optionCount += 1;
            msj += optionCount + "." + bibliographicProducts.get(i).getProductName() + "\n" ;
        }
        return msj;
    }

   /**
    * This Java function displays a list of magazines from a collection of bibliographic products.
    * 
    * @return The method `displayMagazines` returns a string that contains the names of all the
    * magazines in the `bibliographicProducts` list.
    */
    public String displayMag(){

        String msj = "";
        int optionCount = 0;

        for(int i = 0; i < bibliographicProducts.size() ; i ++){
            BibliographicProduct product = bibliographicProducts.get(i);
            if(product instanceof Magazine){
                optionCount += 1;
                msj += optionCount + "." + bibliographicProducts.get(i).getProductName() + "\n" ;
            } 
        }
        return msj;
    }
    /**
     * The function creates instances of a book, magazine, regular user, and premium user and adds them
     * to their respective lists.
     */
    public void testCase()throws Exception{

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String date = "09/19/2005";
        Calendar newDate = Calendar.getInstance();
        newDate.setTime(formatter.parse(date));

        

        BibliographicProduct book = new Book("100 Anios de soledad", 320, newDate, 87000, Genre.HISTORIC_NOVEL);
        BibliographicProduct magazine = new Magazine("El Clavo", 320, newDate, 98000, Category.DESIGN, Periodicity.DAILY);
        User regularUser = new regularUser("Andres", "1117349952");
        User premiumUser = new premiumUser("Alejo", "24604311");

        bibliographicProducts.add(book);
        bibliographicProducts.add(magazine);
        System.out.println("Se agrego" + magazine.getProductName());
        users.add(regularUser);
        users.add(premiumUser);
    }

   /**
    * This Java function returns the name of a product based on its unique ID from a list of
    * bibliographic products.
    * 
    * @param id a String representing the unique ID of a bibliographic product.
    * @return The method `returnProductName` returns a `String` variable `name`, which represents the
    * name of a bibliographic product with a unique ID that matches the input parameter `id`.
    */
    public String returnProductName(String id){

        String name = "";
        for(int i = 0; i < bibliographicProducts.size();i++){
            if(bibliographicProducts.get(i).getUniqueId().equals(id)){
                name = bibliographicProducts.get(i).getProductName();
            }
        }
        return name;
    }
    /**
     * This Java function returns the number of pages of a book with a given unique ID from a list of
     * bibliographic products.
     * 
     * @param id a String representing the unique ID of a bibliographic product (e.g. a book) in a list
     * called "bibliographicProducts".
     * @return The method `returnBookPages` returns an integer value representing the number of pages
     * of a book with the given unique ID.
     */
    public int returnBookPages(String id){

        int pages = 0;
        for(int i = 0; i < bibliographicProducts.size();i++){
            if(bibliographicProducts.get(i).getUniqueId().equals(id)){
                pages = bibliographicProducts.get(i).getBookPages();
            }
        }
        return pages;

    }
   /**
    * This function calculates the total number of pages read from all the books in a list of
    * bibliographic products.
    * 
    * @return The method is returning a String message that indicates the total amount of pages that
    * have been read from all the books in the bibliographicProducts list.
    */
    public String showReadPagesOfBooks(){
        String msj = " ";
        int pagesRead = 0;
        for(int i = 0; i < bibliographicProducts.size();i++){
            if(bibliographicProducts.get(i) instanceof Book){
                pagesRead += bibliographicProducts.get(i).getAmountReadPages();
            }
            msj = pagesRead + " pages of books have been read.";
        }
        return msj;
    }
  /**
   * This function calculates the total number of pages read from all magazines in a list of
   * bibliographic products.
   * 
   * @return The method is returning a String message indicating the total number of pages read from
   * all the magazines in the bibliographicProducts list.
   */
    public String showReadPagesOfMagazines(){
        String msj = " ";
        int pagesRead = 0;
        for(int i = 0; i < bibliographicProducts.size();i++){
            if(bibliographicProducts.get(i) instanceof Magazine){
                pagesRead += bibliographicProducts.get(i).getAmountReadPages();
            }
            msj = pagesRead + " pages of magazines have been read.";
        }
        return msj;
    }

  /**
   * This function determines the most read genre among books in a library and returns a message with
   * the genre and the total amount of pages read.
   * 
   * @return A String message indicating the most read genre and the total amount of pages read for
   * that genre.
   */
    public String showMostReadGenre(){

        String msj = "";
        Genre mostReadGenre = null;
        int mostReadPages = 0;

        int readScienceFictionPages = 0;
        int readFantasyPages = 0;
        int readHistoricPages = 0;

        for(int i = 0; i < bibliographicProducts.size();i++){
            if(bibliographicProducts.get(i) instanceof Book){
                Genre genre = ((Book)bibliographicProducts.get(i)).getBookGenre();
                int readPages = bibliographicProducts.get(i).getAmountReadPages();

                switch(genre){

                    case SCIENCE_FICTION:
                        readScienceFictionPages += readPages;
                        break;
                    case FANTASY:
                        readFantasyPages += readPages;
                        break;
                    case  HISTORIC_NOVEL:
                        readHistoricPages += readPages;
                        break;
                }
            }
        }
        if(readScienceFictionPages >= readFantasyPages && readScienceFictionPages >= readHistoricPages){
            mostReadGenre = Genre.SCIENCE_FICTION;
            mostReadPages = readScienceFictionPages;
            msj = "The most read genre is:" + mostReadGenre + "\n" + "By a total amount of pages of :" + mostReadPages;

        }else if(readFantasyPages >= readHistoricPages && readFantasyPages >= readScienceFictionPages){
            mostReadGenre = Genre.FANTASY;
            mostReadPages = readFantasyPages;
            msj = "The most read genre is:" + mostReadGenre + "\n" + "By a total amount of pages of :" + mostReadPages;
        }else if( readFantasyPages == readHistoricPages && readHistoricPages == readScienceFictionPages){
            
            msj = "No products has been read yet.";
        }
        else{
            mostReadGenre = Genre.HISTORIC_NOVEL;
            mostReadPages = readFantasyPages;
            msj = "The most read genre is:" + mostReadGenre + "\n" + "By a total amount of pages of :" + mostReadPages;
        }

        return msj;
    }
   /**
    * The function returns a message indicating the most read category of magazines and the total
    * amount of pages read in that category.
    * 
    * @return A String message indicating the most read category and the total amount of pages read in
    * that category, or a message indicating that no product has been read yet.
    */
    public String showMostReadCategory(){

        String msj = "";
        Category mostReadCategory = null;
        int mostReadPages = 0;

        int readVarietyPages = 0;
        int readDesignPages = 0;
        int readCientificPages = 0;

        for(int i = 0; i < bibliographicProducts.size();i++){
            if(bibliographicProducts.get(i) instanceof Magazine){
                Category category = ((Magazine)bibliographicProducts.get(i)).getCategory();
                int readPages = bibliographicProducts.get(i).getAmountReadPages();

                switch(category){

                    case VARIETY:
                        readVarietyPages += readPages;
                        break;
                    case DESIGN:
                        readDesignPages += readPages;
                        break;
                    case  CIENTIFIC:
                        readCientificPages += readPages;
                        break;
                }
            }
        }
        if(readVarietyPages >= readDesignPages && readVarietyPages >= readCientificPages){
            mostReadCategory = Category.VARIETY;
            mostReadPages = readVarietyPages;
            msj = "The most read category is:" + mostReadCategory + "\n" + "By a total amount of pages of :" + mostReadPages;

        }else if(readDesignPages >= readVarietyPages && readDesignPages >= readCientificPages){
            mostReadCategory = Category.DESIGN;
            mostReadPages = readDesignPages;
            msj = "The most read category is:" + mostReadCategory + "\n" + "By a total amount of pages of :" + mostReadPages;
        }else if ( readCientificPages == readDesignPages && readDesignPages == readVarietyPages){

            msj = "No product has been read yet.";
        }
        else{
            mostReadCategory = Category.CIENTIFIC;
            mostReadPages = readCientificPages;
            msj = "The most read category is:" + mostReadCategory + "\n" + "By a total amount of pages of :" + mostReadPages;
        }

        return msj;
        
    }
  /**
   * The function counts the number of books in a list of bibliographic products.
   * 
   * @return The method `countBooks()` returns an integer value which represents the number of books in
   * the `bibliographicProducts` list.
   */
    public int countBooks(){
        int bookCounter = 0;
        for(int i = 0; i < bibliographicProducts.size();i++){
            if(bibliographicProducts.get(i) instanceof Book){
                bookCounter +=1;
            }
        }
        return bookCounter;
    }
   /**
    * The function counts the number of Magazine objects in a list of bibliographic products.
    * 
    * @return The method is returning an integer value which represents the number of magazines in the
    * bibliographicProducts list.
    */
    public int countMagazines(){
        int magazineCounter = 0;
        for(int i = 0; i < bibliographicProducts.size();i++){
            if(bibliographicProducts.get(i) instanceof Magazine){
                magazineCounter +=1;
            }
        }
        return magazineCounter;
    }
  /**
   * The function returns a string with the top 5 magazines sorted by the amount of read pages.
   * 
   * @return The method is returning a String that contains the names and amount of pages of the top 5
   * magazines in the bibliographicProducts list.
   */
    public String showTop5Magazines(){

        String msj = "";
        int positionCounter = 1;
        Collections.sort(bibliographicProducts);

        for(int i = 0; i < bibliographicProducts.size(); i++){
            if(bibliographicProducts.get(i) instanceof Magazine && positionCounter < 6){
                Category category = ((Magazine)bibliographicProducts.get(i)).getCategory();
                msj += positionCounter + "." + bibliographicProducts.get(i).getProductName() + ", and the amount of pages is: " + bibliographicProducts.get(i).getAmountReadPages() + "The category is: " + category + "\n" ;
                positionCounter += 1;
            }
        }
        return msj;
    }
    /**
     * The function returns a string with the top 5 books sorted by the amount of pages read.
     * 
     * @return The method is returning a String that contains the top 5 books in the
     * bibliographicProducts list, sorted by the amount of pages they have. The String includes the
     * position of the book in the top 5, the name of the book, and the amount of pages it has.
     */
    public String showTop5Books(){

        String msj = "";
        int positionCounter = 1;
        Collections.sort(bibliographicProducts);

        for(int i = 0; i < bibliographicProducts.size(); i++){
            if(bibliographicProducts.get(i) instanceof Book && positionCounter < 6){
                Genre genre =  ((Book)bibliographicProducts.get(i)).getBookGenre();
                msj += positionCounter + "." + bibliographicProducts.get(i).getProductName() + ",the amount of pages is: " + bibliographicProducts.get(i).getAmountReadPages() + ",and the genre is:" + genre +  "\n" ;
                positionCounter += 1;
            }
        }
        return msj;
    }
   /**
    * The function counts the number of copies sold and the total sales value of fantasy books in a
    * list of bibliographic products.
    * 
    * @return The method is returning a String message that includes the total number of copies sold
    * and the total sales value of all the books in the bibliographicProducts list that have a genre of
    * FANTASY.
    */
    public String countFantasySales(){
        
        String msj = "";
        int copiesCount = 0;
        int salesCount = 0;

        for(int i = 0; i < bibliographicProducts.size();i++){
            if(bibliographicProducts.get(i) instanceof Book){
                Genre genre = ((Book)bibliographicProducts.get(i)).getBookGenre();
                if( genre == Genre.FANTASY){
                    double localCount = ((Book)bibliographicProducts.get(i)).getCopiesSold() * bibliographicProducts.get(i).getProductPrice();
                    salesCount += localCount;
                    copiesCount += ((Book)bibliographicProducts.get(i)).getCopiesSold();
                }
            }
        }
        msj = "The copies sold are:" + copiesCount + ", and the total sales value is: " + salesCount + "$";

        return msj;
    }
    /**
     * This Java function counts the number of copies sold and total sales value for all science
     * fiction books in a list of bibliographic products.
     * 
     * @return The method is returning a String message that includes the total number of copies sold
     * and the total sales value of all the books in the Science Fiction genre.
     */
    public String countScienceFictionSales(){
        
        String msj = "";
        int copiesCount = 0;
        int salesCount = 0;

        for(int i = 0; i < bibliographicProducts.size();i++){
            if(bibliographicProducts.get(i) instanceof Book){
                Genre genre = ((Book)bibliographicProducts.get(i)).getBookGenre();
                if( genre == Genre.SCIENCE_FICTION){
                    double localCount = ((Book)bibliographicProducts.get(i)).getCopiesSold() * bibliographicProducts.get(i).getProductPrice() ;
                    salesCount += localCount;
                    copiesCount += ((Book)bibliographicProducts.get(i)).getCopiesSold();
                }
            }
        }
        msj = "The copies sold are:" + copiesCount + ", and the total sales value is: " + salesCount + "$";

        return msj;
    }
   /**
    * This function counts the number of copies sold and the total sales value of historic novels in a
    * list of bibliographic products.
    * 
    * @return The method returns a String message that includes the total number of copies sold and the
    * total sales value of all historic novels in the bibliographicProducts list.
    */
    public String countHistoricSales(){
        
        String msj = "";
        int copiesCount = 0;
        int salesCount = 0;

        for(int i = 0; i < bibliographicProducts.size();i++){
            if(bibliographicProducts.get(i) instanceof Book){
                Genre genre = ((Book)bibliographicProducts.get(i)).getBookGenre();
                if( genre == Genre.HISTORIC_NOVEL){
                    double localCount = ((Book)bibliographicProducts.get(i)).getCopiesSold() * bibliographicProducts.get(i).getProductPrice();
                    salesCount += localCount;
                    copiesCount += ((Book)bibliographicProducts.get(i)).getCopiesSold();
                }
            }
        }
        msj = "The copies sold are:" + copiesCount + ", and the total sales value is: " + salesCount + "$";

        return msj;
    }
    /**
     * This function counts the number of copies sold and the total sales value for all books in the
     * "variety" category.
     * 
     * @return The method is returning a String message that includes the total number of copies sold
     * and the total sales value for all the products in the bibliographicProducts list that are
     * magazines with a category of VARIETY.
     */
    public String countVarietySales(){
        
        String msj = "";
        int copiesCount = 0;
        int salesCount = 0;

        for(int i = 0; i < bibliographicProducts.size();i++){
            if(bibliographicProducts.get(i) instanceof Magazine){
                Category category = ((Magazine)bibliographicProducts.get(i)).getCategory();
                if( category == Category.VARIETY){
                    double localCount = ((Magazine)bibliographicProducts.get(i)).getActiveSubscriptions() * bibliographicProducts.get(i).getProductPrice();
                    salesCount += localCount;
                    copiesCount += ((Magazine)bibliographicProducts.get(i)).getActiveSubscriptions();
                }
            }
        }
        msj = "The copies sold are:" + copiesCount + ", and the total sales value is: " + salesCount + "$";

        return msj;
    }
    /**
     * The function counts the number of copies sold and the total sales value of magazines in the
     * design category.
     * 
     * @return The method is returning a String message that includes the total number of copies sold
     * and the total sales value of all magazines in the DESIGN category.
     */
    public String countDesignSales(){
        
        String msj = "";
        int copiesCount = 0;
        int salesCount = 0;

        for(int i = 0; i < bibliographicProducts.size();i++){
            if(bibliographicProducts.get(i) instanceof Magazine){
                Category category = ((Magazine)bibliographicProducts.get(i)).getCategory();
                if( category == Category.DESIGN){
                    double localCount = ((Magazine)bibliographicProducts.get(i)).getActiveSubscriptions() * bibliographicProducts.get(i).getProductPrice();
                    salesCount += localCount;
                    copiesCount += ((Magazine)bibliographicProducts.get(i)).getActiveSubscriptions();
                }
            }
        }
        msj = "The copies sold are:" + copiesCount + ", and the total sales value is: " + salesCount + "$";

        return msj;
    }
   /**
    * This Java function counts the number of copies sold and the total sales value of scientific
    * magazines in a list of bibliographic products.
    * 
    * @return The method returns a String message that includes the total number of copies sold and the
    * total sales value of all the magazines in the CIENTIFIC category.
    */
    public String countCientificSales(){
        
        String msj = "";
        int copiesCount = 0;
        int salesCount = 0;

        for(int i = 0; i < bibliographicProducts.size();i++){
            if(bibliographicProducts.get(i) instanceof Magazine){
                Category category = ((Magazine)bibliographicProducts.get(i)).getCategory();
                if( category == Category.CIENTIFIC){
                    double localCount = ((Magazine)bibliographicProducts.get(i)).getActiveSubscriptions() * bibliographicProducts.get(i).getProductPrice();
                    salesCount += localCount;
                    copiesCount += ((Magazine)bibliographicProducts.get(i)).getActiveSubscriptions();
                }
            }
        }
        msj = "The copies sold are:" + copiesCount + ", and the total sales value is: " + salesCount + "$";

        return msj;
    }
   /**
    * This Java function converts a string representation of a date in the format "dd/MM/yyyy" to a
    * Calendar object.
    * 
    * @param date The date parameter is a string representing a date in the format "dd/MM/yyyy".
    * @return A Calendar object is being returned.
    */
    public Calendar convertStringToCalendar(String date) throws Exception{
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        Calendar newDate = Calendar.getInstance();
        newDate.setTime(formatter.parse(date));

        return newDate; 
    }

   /**
    * This Java function checks if a list of bibliographic products is empty and returns a boolean
    * value.
    * 
    * @return The method is returning a boolean value, which indicates whether the
    * bibliographicProducts list is empty or not. If the list is empty, the method will return true,
    * otherwise it will return false.
    */
    public boolean checkProductsEmpty(){

        boolean flag = bibliographicProducts.isEmpty();

        return flag;
    }
   /**
    * This Java function checks if a list of users is empty and returns a boolean value.
    * 
    * @return A boolean value indicating whether the "users" collection is empty or not.
    */
    public boolean checkUsersEmpty(){

        boolean flag = users.isEmpty();

        return flag;
    }
   /**
    * This function returns an ArrayList of String matrices representing the products owned by a user,
    * with each matrix containing up to 25 product IDs.
    * 
    * @param userName The username of the user for whom we want to generate a matrix of their products.
    * @return An ArrayList of String matrices representing the products owned by a user, with each
    * matrix containing up to 25 product IDs. The number of matrices returned depends on whether the
    * user is a premium or regular user.
    */
    public ArrayList<String[][]> userProductsMatrix(String userName) {

        boolean userFound = false;
        int ROW = 5;
        int COLUMN = 5;
        ArrayList<String[][]> library = new ArrayList<>();

        for (int i = 0; i < users.size() && !userFound; i++){
            User user = users.get(i);
            if (user != null && user.getUsername().equals(userName) && user instanceof premiumUser) {
                userFound = true;
                ArrayList<BibliographicProduct> userInventory = user.getInventorySorted();
                int k = 0;
                do{
                    String[][] productIdMatrix = new String[ROW][COLUMN];

                    for (int j = 0; j < ROW; j++) {
                        for (int l = 0; l < COLUMN; l++) {
                            if (k < userInventory.size()) {
                                productIdMatrix[j][l] = userInventory.get(k).getUniqueId();
                                k++;
                            } 
                            else{
 
                                productIdMatrix[i][j] = "__"; 

                            }
                        }
                    
                    }

                    library.add(productIdMatrix);

                }while(library.size() != 3);

            }     
            else if(user.getUsername().equals(userName) && user instanceof regularUser){
                userFound = true;
                ArrayList<BibliographicProduct> regularUserInventory = user.getInventorySorted();
                int l = 0;
                do{
                    String[][] productIdMatrix = new String[ROW][COLUMN];

                    for (int m = 0; m < ROW; m++) {
                        for (int n = 0; n < COLUMN; n++) {
                            if (l < regularUserInventory.size()) {
                                productIdMatrix[m][n] = regularUserInventory.get(l).getUniqueId();
                                l++;    
                            } 
                            else{

                                productIdMatrix[m][n] = "__"; 
                            }
                        }
                    }
                    library.add(productIdMatrix);

                }while(library.size() != 3);

            }
        }

        return library;
    }
    /**
     * This function prints a user's library in a formatted string.
     * 
     * @param userName The username of the user whose library is being printed.
     * @param indexOfLibrary The index of the library to be printed from the ArrayList of libraries
     * returned by the method userProductsMatrix.
     * @return The method is returning a String that represents the product matrix of a specific
     * library for a given user.
     */
    public String printlIbrary(String userName, int indexOfLibrary){

        ArrayList<String[][]> showLibrary = userProductsMatrix(userName);
        String[][] productMatrix = showLibrary.get(indexOfLibrary);
        String msg = "";

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(productMatrix[i][j] != null){
                    msg += productMatrix[i][j] + " ";
                }
                else{
                    msg += "__";
                }
                    
            }
            msg += "\n";
        }
        return msg;
    }

  
    /**
     * This function checks if a user has a specific book in their collection.
     * 
     * @param username The username of the user whose products are being searched for.
     * @param productId The ID of the bibliographic product that needs to be checked for its property.
     * @return The method is returning a boolean value, which indicates whether a specific book
     * (identified by its productId) is owned by a specific user (identified by their username).
     */
    public boolean checkBookProperty(String username, String productId){
        boolean foundProduct = false;
        boolean foundUser = false;
        for(int i = 0; i < users.size() && !foundUser; i++){
            User user = users.get(i);
            if(user.getUsername().equalsIgnoreCase(username)){
                foundUser = true;
                BibliographicProduct product = user.searchProductById(productId);
                if(product != null){
                    foundProduct = true;
                }
                
            }
        }
        return foundProduct;   
    }
    /**
     * The function checks if a user with a given username is a premium user.
     * 
     * @param userName The username of the user whose premium status needs to be checked.
     * @return The method is returning a boolean value. It returns true if the user with the given
     * username is a premium user, and false otherwise.
     */
    public boolean checkPremium(String userName) {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.getUsername().equals(userName) && user instanceof premiumUser) {
                return true; 
            }
        }
        return false; 
    }
  /**
   * The function takes a username as input, searches for a regular user with that username, generates
   * a random number, and returns an ad based on that number.
   * 
   * @param userName The username of the user for whom the ad needs to be reproduced.
   * @return The method is returning a String that represents an advertisement. The specific
   * advertisement being returned depends on the username passed as a parameter and a random number
   * generated within the method.
   */
    public String reproduceAd(String userName){
        String ad = "";
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.getUsername().equals(userName) && user instanceof regularUser) {
                int randomNumber =  random.nextInt(3);
                ad = ((regularUser)user).displayAds(randomNumber);
            }
        }
        return ad;
    }
    /**
     * This function increases the number of read pages for a bibliographic product with a given ID.
     * 
     * @param productId a String representing the unique identifier of a bibliographic product.
     */
    public void increaseProductReadPages(String productId){
        boolean flag = false; 
        for(int i = 0; i < bibliographicProducts.size() && !flag; i++){
            BibliographicProduct product = bibliographicProducts.get(i);
            if(product.getUniqueId().equalsIgnoreCase(productId)){
                product.increaseReadPages();
                flag = true;
            }
        }
    }
   /**
    * The function allows a user to unsubscribe from a magazine and decreases the active subscriptions
    * count for that magazine.
    * 
    * @param userName The username of the user who wants to unsubscribe from a magazine.
    * @param productName The name of the magazine that the user wants to unsubscribe from.
    * @return The method is returning a String message indicating whether the user has successfully
    * unsubscribed from a magazine or not.
    */
    public String unsubscribeToMagazine(String userName, String productName){
        boolean foundUser = false;
        String msj = " ";
        for(int i = 0; i < users.size() && !foundUser; i++){
            User user = users.get(i);
            if(user.getUsername().equalsIgnoreCase(userName)){
                foundUser = true;
                BibliographicProduct product = user.searchProduct(productName);
                if(product != null){
                    user.removeMagazine(product);
                    msj = "The user has unsubbed from the magazine.";
                    
                }else{
                    msj = "The user does not own that magazine. ";
                }
                
            }else{
                msj = "The user does not exist.";
            }

        }
        
        for(int x = 0; x < bibliographicProducts.size();x++){
            BibliographicProduct product = bibliographicProducts.get(x);
            if(product.getProductName().equalsIgnoreCase(productName)){
                ((Magazine)product).decreaseActiveSubscriptions();
            }
        }
        return msj; 
    }
       
}

