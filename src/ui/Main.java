package ui;

import java.util.Scanner;
import model.ReadController;
import java.util.Calendar;

public class Main{

    private ReadController controller;
    private Scanner reader;

    public Main() throws Exception{
        controller = new ReadController();
        reader = new Scanner(System.in);
    }

    public static void main(String[] args)throws Exception{

        Main main = new Main();
        int option = 0;

        do{
            main.menu();
            option = main.validateIntegerInput();
            main.executeOption(option);

        }while(option != 14);

    }
    public void menu(){
        String title = "ReadX Book Store";
        int length = title.length() + 4;

        System.out.println("-".repeat(length));
        System.out.printf("* %s *\n", title);
        System.out.println("-".repeat(length));
        System.out.println("Choose your option : ");
        System.out.println("1. Register User.");
        System.out.println("2. Register Product.");
        System.out.println("3. Modify Product.");
        System.out.println("4. Delete Product.");
        System.out.println("5. Buy a book.");
        System.out.println("6. Subscribe to a magazine.");
        System.out.println("7. Show user library.");
        System.out.println("8. Show read pages for each type.");
        System.out.println("9. Show most read genre and category");
        System.out.println("10. Show top 5 most read products.");
        System.out.println("11. Show books sales.");
        System.out.println("12. Show magazines sales.");
        System.out.println("13. Unsubscibe to a magazine.");
        System.out.println("14. Exit.");
        System.out.println("-------------------");

    }

    public void executeOption(int option)throws Exception{
        switch(option){
            case 1:
            registerNewUser();
                break;
            case 2:
            registerNewProduct();
                break;
            case 3:
            modifyProduct();
                break;
            case 4:
            deleteProduct();
                break;
            case 5:
            buyBook();
                break;
            case 6:
            subscribeMagazine();
                break;
            case 7:
            showLibrary();
                break;
            case 8:
            showReadPagesProduct();
                break;
            case 9:
            showMostReadGenreAndCategory();
                break;
            case 10:
            showTopFive();
                break;
            case 11: 
            showGenreSales();
                break;
            case 12:
            showCategoriesSales();
                break;
            case 13:
            unsubMagazine();
                break;

            case 14 :
            System.out.println("Thanks for using the system");
                break;
            
            default:
            System.out.println("Please choose a correct option.");
                break;

            

        }
    }

    /**
     * This function validates user input to ensure it is an integer and returns the integer value or
     * -1 if the input is invalid.
     * 
     * @return The method is returning an integer value.
     */
    public int validateIntegerInput(){
        int option = 0; 
        if(reader.hasNextInt()){
            option = reader.nextInt(); 
        }
        else{
            reader.nextLine();
            option = -1; 
            System.out.println("Type a valid value."); 
        }
        return option; 
    }

    /**
     * This function registers a new user by taking input for their name, identification, and type of
     * user, and then calling a controller method to register the user.
     */
    public void registerNewUser() {
        System.out.println("Type the user's Name");
        String name = reader.next();

        System.out.println("Type your identification");
        String identification = reader.next();

        System.out.println("Choose your type of User:");
        System.out.println("1. Premium User. ");
        System.out.println("2. Regular User. ");
        int typeOfUser = reader.nextInt();

        String msg = controller.registUser(name, identification, typeOfUser);
        System.out.println(msg);
    }

    /**
     * This function allows the user to register a new book or magazine product with various attributes
     * and categories.
     */
    public void registerNewProduct() throws Exception{

        String productName = " ";
        int bookPages = 0;
        String publicationDate = " ";
        double productPrice = 0;
        Calendar publicDate = null;
        int magCategory = 0;
        int emPeriodicity = 0;
        int bookType = 0;
        
        System.out.println("Choose the kind of product that is going to be registered: ");
        System.out.println("1. Magazine product. ");
        System.out.println("2. Book product.");

        int kind = reader.nextInt();

        switch(kind){

            case 1:
            System.out.println("Type the name of the magazine: ");
            reader.next();
            productName = reader.nextLine();
            System.out.println("Type the amount of pages: ");
            bookPages = reader.nextInt();
            System.out.println("Type the publication date: ");
            publicationDate = reader.next();
            publicDate = controller.convertStringToCalendar(publicationDate);

            System.out.println("Type the price of the magazine: ");
            productPrice = reader.nextDouble();

            System.out.println("Choose the magazine's category:");
            System.out.println("1. Variety");
            System.out.println("2. Design");
            System.out.println("3. Cientific");

            magCategory = reader.nextInt();

            System.out.println("Choose the periodicity of emision: ");
            System.out.println("1. Daily.");
            System.out.println("2. Weekly.");
            System.out.println("3. Monthly.");
            System.out.println("4. Annually.");

            emPeriodicity = reader.nextInt();
       

            String msg = controller.registBiblioProduct(productName, bookPages, publicDate, productPrice, magCategory, emPeriodicity);

            System.out.println(msg);

            break;

            case 2:
            System.out.println("Type the name of the book: ");
            reader.next();
            productName = reader.nextLine();
            System.out.println("Type the amount of pages: ");
            bookPages = reader.nextInt();
            System.out.println("Type the publication date: ");
            publicationDate = reader.next();
            publicDate = controller.convertStringToCalendar(publicationDate);
            System.out.println("Type the price of the book: ");
            productPrice = reader.nextDouble();

            System.out.println("Choose the book's genre: ");
            System.out.println("1. Science Fiction. ");
            System.out.println("2. Fantasy. ");
            System.out.println("3. Historic novel");

            bookType = reader.nextInt();

            String msg2 = controller.registBiblioProduct(productName, bookPages, publicDate, productPrice, bookType);

            System.out.println(msg2);

            break;
        }
    }
    public void deleteProduct(){

        boolean controlFlag = controller.checkProductsEmpty();

        if(controlFlag == false){
            System.out.println("Type the name of the product that is going to be deleted:");
            reader.nextLine();
            String productName = reader.nextLine();
    
            String msj = controller.deleteProduct(productName);
            System.out.println(msj);
        }
        else{
            System.out.println("There is no product registered yet.");
        }

    }

   /**
    * The function allows a user to buy a book by displaying a list of available books and prompting
    * the user to select a book to buy.
    */
    public void buyBook(){

        boolean userFlag = controller.checkUsersEmpty();
        boolean productsFlag = controller.checkProductsEmpty();

        if(userFlag == false && productsFlag == false){
            System.out.println("Type the user name:");
            String name = reader.next();

            String menu = controller.displayBooks();
            System.out.println("Available products:");
             System.out.println(menu);
             System.out.println("-------------------");

            System.out.println("Type the book to buy: ");
            reader.nextLine();
            String bookName = reader.nextLine();

            String msj = controller.buyBook(name, bookName);

            System.out.println(msj);
        }
        else{
            System.out.println("There is no products or users registered.");
        }

       
    }
   /**
    * This function allows a user to subscribe to a magazine by selecting a magazine from a list and
    * entering their name.
    */
    public void subscribeMagazine(){

        boolean userFlag = controller.checkUsersEmpty();
        boolean productsFlag = controller.checkProductsEmpty();

        if(userFlag == false && productsFlag == false){
            System.out.println("Type the user name:");
            String name = reader.next();

            String menuMagazine = controller.displayMag();
            System.out.println("Available products:");
            System.out.println(menuMagazine);
            System.out.println("-------------------");

            System.out.println("Type the magazine's name: ");
            reader.nextLine();
            String bookName = reader.nextLine();

            String msj = controller.buyMagazine(name, bookName);

            System.out.println(msj);
        }
        else{
            System.out.println("There is no products or users registered yet. ");
        }
       
    }
    /**
     * The function "modifyMenu" prints out options to change the name, pages, or prices of a menu.
     */
    public void modifyMenu(){

        System.out.println("1. Change name.");
        System.out.println("2. Change pages.");
        System.out.println("3. Change prices.");
        
    }
    /**
     * This Java function allows the user to modify a product's name, pages, or price by selecting an
     * option and entering the new information.
     */
    public void modifyProduct(){

        boolean productFlag = controller.checkProductsEmpty();
        String productId = " ";
        String newProductName = " ";
        String msj = " ";
        double newProductPrice = 0;
        int newPages = 0;

        if(productFlag == false){
            modifyMenu();
            System.out.println("------------------");
            System.out.println("Choose your option : ");
            int option = reader.nextInt();

            switch(option){
                case 1:
                System.out.println("Type the product id.");
                productId = reader.next();
                System.out.println("Type the new name:");
                reader.next();
                newProductName = reader.nextLine();

                msj = controller.modifyProductName(productId, newProductName);
                System.out.println(msj);

                    break;
                case 2:
                System.out.println("Type the product id.");
                productId = reader.next();
                System.out.println("Type the new amount of pages:");
                newPages = reader.nextInt();

                msj = controller.modifyProductPages(productId, newPages);
                System.out.println(msj);

                    break;
                case 3:
                System.out.println("Type the product id.");
                productId = reader.next();
                System.out.println("Type the new price:");
                newProductPrice = reader.nextDouble();

                msj = controller.modifyProductPrice(productId, newProductPrice);
                System.out.println(msj);

                    break; 

            }
        }
        else{

            System.out.println("There are no products registered yet.");
        }

        
    }
    
    /**
     * This function prints the message containing the number of read pages of books and magazines.
     */
    public void showReadPagesProduct(){
        boolean productFlag = controller.checkProductsEmpty();
        if(productFlag ==  false){
            String msjBook = controller.showReadPagesOfBooks();
            String msjMagazine = controller.showReadPagesOfMagazines();

            String msjToPrint = msjBook + "\n" + msjMagazine;

            System.out.println(msjToPrint);
        }
        else{
            System.out.println("There is no product registered yet. ");
        }
       
    }
   /**
    * The function prints the most read genre and category of books and magazines.
    */
    public void showMostReadGenreAndCategory(){

        boolean productflag = controller.checkProductsEmpty();

        if(productflag == false){
            String msjBook = controller.showMostReadGenre();
            String msjMagazine = controller.showMostReadCategory();
    
            String msjToPrint = msjBook + "\n" + msjMagazine;
    
            System.out.println(msjToPrint);
        }
        else{
            System.out.println("There is no product registered yet.");
        }
       
    }

    /**
     * The function displays the top 5 most read books and magazines if there are enough products
     * registered, otherwise it displays a message indicating that there are not enough products.
     */
    public void showTopFive(){

        boolean productFlag = controller.checkProductsEmpty();

        if(productFlag == false){
            String msjBooks = controller.showTop5Books();
            String msjMagazines = controller.showTop5Magazines();
            int controlFlagMag = controller.countBooks();
            int controlFlagBook = controller.countMagazines();

            if(controlFlagBook >= 5 && controlFlagMag >= 5){
                System.out.println("The top 5 most read magazines are : ");
                System.out.println(msjMagazines);
                System.out.println("The top 5 most read books are :");
                System.out.println(msjBooks);
            }
            else{
            System.out.println("There are not enough products registered yet.");
            }
        }
        else{
            System.out.println("There are no products registered yet.");
        }
        
    }

   /**
    * The function displays the sales count for different magazine categories if there are products
    * registered, otherwise it displays a message indicating that there are no products registered.
    */
    public void showCategoriesSales(){

        boolean productFlag = controller.checkProductsEmpty();

        if(productFlag == false){

            System.out.println("For the variety magazine category: ");
            String varietyMsj = controller.countVarietySales();
            System.out.println(varietyMsj);

            System.out.println("For the design magazine category: ");
            String designMsj = controller.countDesignSales();
            System.out.println(designMsj);

            System.out.println("For the cientific magazine category: ");
            String cientificMsj = controller.countCientificSales();
            System.out.println(cientificMsj);

        }else{
            System.out.println("There are no products registered yet.");
        }

    }

   /**
    * The function displays the sales count for different genres of products, or a message
    * indicating that there are no products registered yet.
    */
    public void showGenreSales(){

        boolean productFlag = controller.checkProductsEmpty();

        if(productFlag == false){

            System.out.println("For the Science fiction genre: ");
            String scienceFicMsj = controller.countScienceFictionSales();
            System.out.println(scienceFicMsj);

            System.out.println("For the Fantasy genre : ");
            String fantasyMsj = controller.countFantasySales();
            System.out.println(fantasyMsj);

            System.out.println("For the historic novel genre : ");
            String historicNovelMsj = controller.countHistoricSales();
            System.out.println(historicNovelMsj);

        }else{
            System.out.println("There are no products registered yet.");
        }

    }

   /**
    * The function displays a library of products for a given user and allows them to simulate a
    * lecture, navigate through pages, and exit.
    */
    public void showLibrary(){

        
        String productId= " ";
        String userName = " ";
        int option = 0;
        int actualPage = 0;
        
        System.out.println("Type the username:");
        userName = reader.next();

        do{

            System.out.println(" ");
            System.out.println(userName + " Library : ");
            System.out.println(" ");
            System.out.println("0 " + " 1 " + " 2 " + " 3 " + " 4");
            System.out.println(controller.printlIbrary(userName, actualPage));
            System.out.println(" ");
            System.out.println("0. Simulate a lecture");
            System.out.println("1. Next page");
            System.out.println("2. Previous page");
            System.out.println("3. Exit.");
            option = reader.nextInt();

            if(option == 0){

                System.out.println("Enter the product id: ");
                productId = reader.next();
                lectureSession(userName, productId);
                productId = " ";

            }
            else if(option == 1){
                
                if(actualPage == 2){

                    System.out.println("You are in the last page, theres not next page.");

                }
                else{
                    
                    actualPage++;
                }
                


            }
            else if(option == 2){

                if(actualPage == 0){

                    System.out.println("You are in the first page, theres not previous page.");

                }
                else{

                    actualPage--;
                }
            }
        }while(option != 3);
    }
   
    /**
     * This function simulates a lecture session for a user reading a book, allowing them to navigate
     * through pages and displaying ads for non-premium users.
     * 
     * @param userName The username of the user who wants to start a lecture session.
     * @param prodId The ID of the product (book) that the user wants to read.
     */
    public void lectureSession(String userName, String prodId){

        

        boolean checkProperty = controller.checkBookProperty(userName,prodId);
        boolean checkTypeOfUser = controller.checkPremium(userName);
        String productName = "";
        int bookPages = 0;
        int counterPages = 1;
        int option = 0;

            productName = controller.returnProductName(prodId);
            bookPages = controller.returnBookPages(prodId);

            if(checkProperty == true){
                if(checkTypeOfUser == true){
                    do{
                        System.out.println("Lecture session in progress: " + "\n");
                        System.out.println("Reading: " + productName);
                        System.out.println(" ");
                        System.out.println(" ");
                        System.out.println("Reading page " + counterPages + " of" + bookPages);
                        System.out.println(" ");
                        System.out.println("1. Next page.");
                        System.out.println("2. Previous page.");
                        System.out.println("3. Finish the lecture session.");
                        System.out.println("Type your option: ");
                        option = reader.nextInt();
        
                        if(option == 1){
        
                        counterPages++;
                        controller.increaseProductReadPages(prodId);
                        }
                        else if(option == 2){
        
                        counterPages--;
                        }
                    }while(option != 3 || counterPages != bookPages );

                } else if( checkTypeOfUser == false){
                    do{
                        System.out.println("Lecture session in progress: " + "\n");
                        System.out.println("Reading: " + productName);
                        System.out.println(" ");
                        System.out.println(" ");
                        System.out.println("Reading page " + counterPages + " of" + " "+ bookPages);
                        System.out.println(" ");
                        System.out.println("1. Next page.");
                        System.out.println("2. Previous page.");
                        System.out.println("3. Finish the lecture session.");
                        System.out.println("Type your option: ");
                        option = reader.nextInt();
        
                        if(option == 1){
                            if(counterPages %20 == 0 || counterPages == 1){
                                String ad = controller.reproduceAd(userName);
                                System.out.println(ad);
                            }
                        counterPages++;
                        controller.increaseProductReadPages(prodId);
                        }
                        else if(option == 2){
        
                        counterPages--;
                        }
                    }while(option != 3 && counterPages != bookPages );
                }
                
            }
            else{
                System.out.println("The user doesn't have a product by that id.");
            }
        }
       /**
        * This Java function allows a user to unsubscribe from a magazine by entering the name of the
        * product and their username.
        */
        public void unsubMagazine(){

            boolean controlFlag = controller.checkProductsEmpty();
            String productName;
            String username;
            if(controlFlag == false){

                System.out.println("Type the name of the product that is going to be deleted:");
                reader.nextLine();
                productName = reader.nextLine();
                System.out.println("Type the username: ");
                username = reader.next();
                String msj = controller.unsubscribeToMagazine(username, productName);
                System.out.println(msj);
            }
            else{
                System.out.println("There is no product registered yet.");
            }
    
        }
        
        
    }


