package model;
import java.util.Calendar;

public class regularUser extends User {

    private Calendar linkDate;

    public regularUser(String name, String identification){
        super(name, identification);
        this.linkDate = Calendar.getInstance();   
    }
    public Calendar getLinkDate() {
        return linkDate;
    }

    

}
