package model;
import java.util.ArrayList;

public class ReadController {

    ArrayList<User> users;
    ArrayList<BibliographicProduct> bibliographicProducts;

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
}
