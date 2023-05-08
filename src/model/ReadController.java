package model;
import java.util.ArrayList;

public class ReadController {

    ArrayList<User> users;
    ArrayList<biblioProduct> bibliographicProducts;

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


    

    
    
}
