package model;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public abstract class User {

    private String userName;
    private String identification;
    private String linkDate;
    ArrayList<BibliographicProduct> inventory;
   

    public User(String userName, String identification){

        this.userName = userName;
        this.identification = identification;
        setLinkDate();
       
    }
    public String getUsername() {
        return userName;
    }
    
    public String getIdentification() {
        return identification;
    }
    public void setLinkDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String linkingDate = dateFormat.format(calendar.getTime());
        this.linkDate = linkingDate;
    }
    public String getLinkDate(){
        return linkDate;
    }
    public abstract String addProduct(BibliographicProduct product);
       
}
