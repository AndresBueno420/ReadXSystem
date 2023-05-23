package model;
import java.util.UUID;

public abstract class BibliographicProduct implements Comparable<BibliographicProduct> {
    
    private String uniqueId;
    private String productName;
    private int bookPages;

    private String publicationDate;
    private String productPrice;
    private int amountReadPages;
    

    public BibliographicProduct(String productName, int bookPages, String publicationDate, String productPrice){
        this.productName = productName;
        this.bookPages = bookPages;
        this.publicationDate = publicationDate;
        this.productPrice = productPrice;
        this.amountReadPages = 0;
        generateUniqueId();

    }
  /**
   * This function generates a unique ID using UUID and sets it to the object's uniqueId attribute.
   */
    private void generateUniqueId(){
        String id = UUID.randomUUID().toString().substring(0, 3).toUpperCase();
        this.uniqueId = id;
    }
   /**
    * The function returns a unique identifier as a string.
    * 
    * @return The method is returning a String value which is the uniqueId.
    */
    public String getUniqueId(){
        return uniqueId;
    }
   /**
    * The function returns the name of a product.
    * 
    * @return The method `getProductName()` is returning the value of the variable `productName`.
    */
    public String getProductName(){
        return productName;
    }
    /**
     * This function sets the value of the productName variable to a new value passed as a parameter.
     * 
     * @param newProductName The new name that will be assigned to the product's name attribute.
     */
    public void setProductName(String newProductName){
        this.productName = newProductName;
    }
    /**
     * The function returns the number of pages in a book.
     * 
     * @return The method `getBookPages()` is returning an integer value representing the number of
     * pages in a book.
     */
    public int getBookPages(){
        return bookPages;
    }
   /**
    * This Java function sets the number of pages for a book object.
    * 
    * @param newBookPages The new number of pages to set for a book. This method is likely part of a
    * Book class and is used to update the number of pages for a specific book object.
    */
    public void setBookPages(int newBookPages){
        this.bookPages = newBookPages;
    }
   /**
    * This function sets the value of the productPrice variable to a new value passed as a parameter.
    * 
    * @param newProductPrice The new price value that will be assigned to the productPrice attribute of
    * an object.
    */
    public void setProductPrice(String newProductPrice){
        this.productPrice = newProductPrice;
    }
    /**
     * The function returns the product price as a string.
     * 
     * @return The method `getProductPrice()` is returning a `String` value which represents the price
     * of a product.
     */
    public String getProductPrice(){
        return this.productPrice;
    }
    public int getAmountReadPages(){
        return this.amountReadPages;
    }
    @Override
    public int compareTo(BibliographicProduct Object) {
        return Integer.compare(this.amountReadPages, Object.amountReadPages);
    }
       
}

