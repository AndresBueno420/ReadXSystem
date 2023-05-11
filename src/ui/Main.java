package ui;

import java.util.Scanner;
import model.ReadController;

public class Main{

    private ReadController controller;
    private Scanner reader;

    public Main(){
        controller = new ReadController();
        reader = new Scanner(System.in);
    }

    public static void main(String[] args){

        Main main = new Main();
        int option = 0;

        do{
            main.menu();
            option = main.validateIntegerInput();
            main.executeOption(option);

        }while(option != 10);

    }
    public void menu(){
        String title = "ReadX Book Store";
        int length = title.length() + 4;

        System.out.println("-".repeat(length));
        System.out.printf("* %s *\n", title);
        System.out.println("-".repeat(length));
        System.out.println("Choose your option : ");
        System.out.println("1. Register User.");
        System.out.println("2. Register Bibliographic Product.");
        System.out.println("4. Buy a book.");
        System.out.println("-------------------");

    }

    public void executeOption(int option){
        switch(option){
            case 1:
            registerNewUser();
            case 2:
            registerNewProduct();
            case 4:
            buyBook();

            

        }
    }

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

    public void registerNewUser(){
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

    public void registerNewProduct(){

        String productName = " ";
        int bookPages = 0;
        String publicationDate = " ";
        String productPrice = " ";
        int magCategory = 0;
        int emPeriodicity = 0;
        int bookType = 0;
        
        System.out.println("Choose the kind of product that is going to be registered: ");
        System.out.println("1. Book product. ");
        System.out.println("2. Magazine product.");

        int kind = reader.nextInt();

        switch(kind){

            case 1:
            System.out.println("Type the name of the magazine: ");
            productName = reader.next();
            System.out.println("Type the amount of pages: ");
            bookPages = reader.nextInt();
            System.out.println("Type the publication date: ");
            publicationDate = reader.next();
            System.out.println("Type the price of the magazine: ");
            productPrice = reader.next();

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

            String msg = controller.registBiblioProduct(productName, bookPages, publicationDate, productPrice, magCategory, emPeriodicity);

            System.out.println(msg);

            case 2:
            System.out.println("Type the name of the book: ");
            productName = reader.next();
            System.out.println("Type the amount of pages: ");
            bookPages = reader.nextInt();
            System.out.println("Type the publication date: ");
            publicationDate = reader.next();
            System.out.println("Type the price of the book: ");
            productPrice = reader.next();

            System.out.println("Choose the book's genre: ");
            System.out.println("1. Science Fiction. ");
            System.out.println("2. Fantasy. ");
            System.out.println("3. Historic novel");

            bookType = reader.nextInt();

            String msg2 = controller.registBiblioProduct(productName, bookPages, publicationDate, productPrice, bookType);

            System.out.println(msg2);
        }
    }

    public void buyBook(){

        System.out.println("Type the user name:");
        String name = reader.next();

        System.out.println("Type the book to buy: ");
        String bookName = reader.next();

        String msj = controller.buyBook(name, bookName);

        System.out.println(msj);
    }

}