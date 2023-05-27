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
        inventory = new ArrayList<>();
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

   /**
    * This function sorts a list of BibliographicProducts by their publication date using a bubble sort
    * algorithm.
    */
    public void sortProductsByPublicationDate() {
        
        int size = inventory.size();

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                BibliographicProduct currentProduct = inventory.get(j);
                BibliographicProduct nextProduct = inventory.get(j + 1);
                if (currentProduct.getPublicationDate().after(nextProduct.getPublicationDate())) {

                    inventory.set(j, nextProduct);
                    inventory.set(j + 1, currentProduct);
                }
            }
        }
    }
    /**
     * This Java function searches for a BibliographicProduct in an inventory by its name and returns
     * it.
     * 
     * @param productName a String representing the name of a product that needs to be searched in an
     * inventory of BibliographicProducts. The method searches for a BibliographicProduct object in the
     * inventory that has the same name as the productName parameter and returns it. If no such product
     * is found, the method returns null.
     * @return The method is returning a BibliographicProduct object.
     */
    public BibliographicProduct searchProduct(String productName){

        boolean foundProject = false;
        BibliographicProduct product = null;

        for(int i = 0; i < inventory.size() && !foundProject;i++){
            if(inventory.get(i).getProductName().equalsIgnoreCase(productName)){
                foundProject = true;
                product = inventory.get(i);
            }
        }
        return product;
    }

   /**
    * This function deletes a bibliographic product from the inventory.
    * 
    * @param product The parameter "product" is an object of the class "BibliographicProduct" that
    * represents a product in the inventory that needs to be deleted. The method "deleteProduct" takes
    * this object as input and removes it from the inventory.
    */
    public void deleteProduct(BibliographicProduct product){
        inventory.remove(product);
    }


       
}
