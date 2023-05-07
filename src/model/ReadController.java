package model;
import java.util.ArrayList;

public class ReadController {

    ArrayList<User> users;

    public ReadController(){
        users = new ArrayList<>();
    }
    public void registUser(String username, String identification, int userKind){

        User user = null;

        switch(userKind) {
            case 1:
                user = new premiumUser(username, identification);
                break;
            case 2:
                user = new regularUser(username, identification);
                break;
        }
        users.add(user);
    }


    

    
    
}
