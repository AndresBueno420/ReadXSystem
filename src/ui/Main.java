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

    }

    public void executeOption(int option){
        switch(option){
            case 1:
            registerNewUser();
            

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

}