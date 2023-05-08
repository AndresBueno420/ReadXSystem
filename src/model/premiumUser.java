package model;
import java.util.Calendar;

public class premiumUser extends User {

    private Calendar linkDate;

    public premiumUser(String name, String identification){
        super(name, identification);
        this.linkDate = Calendar.getInstance();
    }

}
