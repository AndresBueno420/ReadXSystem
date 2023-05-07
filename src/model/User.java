package model;
import java.util.Calendar;


public abstract class User {

    private String userName;
    private String identification;

    public User(String userName, String identification){

        this.userName = userName;
        this.identification = identification;
       
    }
    public String getUsername() {
        return userName;
    }
    
    public String getIdentification() {
        return identification;
    }
    
      
}
