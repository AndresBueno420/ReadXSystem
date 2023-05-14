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
  /**
   * The function returns the username.
   * 
   * @return The method `getUsername()` is returning the value of the variable `userName`, which is
   * likely a string representing the username of an object or user.
   */
    public String getUsername() {
        return userName;
    }
    
   /**
    * The function returns the identification string.
    * 
    * @return The method `getIdentification()` is returning a `String` variable called
    * `identification`.
    */
    public String getIdentification() {
        return identification;
    }
    /**
     * This function sets the link date to the current date and time in the format of "dd/MM/yyyy
     * HH:mm:ss".
     */
    public void setLinkDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String linkingDate = dateFormat.format(calendar.getTime());
        this.linkDate = linkingDate;
    }
   /**
    * The function returns the value of the variable "linkDate" as a string.
    * 
    * @return The method `getLinkDate()` is returning a `String` value, which is the value of the
    * variable `linkDate`.
    */
    public String getLinkDate(){
        return linkDate;
    }
   /**
    * This is an abstract Java function that adds a bibliographic product and returns a string.
    * 
    * @param product The "product" parameter is an object of type "BibliographicProduct" that
    * represents a bibliographic product that needs to be added. The method is expected to return a
    * String value.
    * @return A String is being returned.
    */
    public abstract String addProduct(BibliographicProduct product);
       
}
