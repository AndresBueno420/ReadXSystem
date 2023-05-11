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
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                        String linkingDate = dateFormat.format(calendar.getTime());
                        dates.add(linkingDate);
                        msj = user.addProduct(product) + linkingDate;

                        
                    }
                    else if(user.getUsername().equals(userName) && user instanceof premiumUser){

                        foundUser = true;
                        Calendar calendar = Calendar.getInstance();
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

    
}
