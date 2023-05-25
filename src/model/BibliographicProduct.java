package model;
import java.util.UUID;
import java.util.Calendar;

public abstract class BibliographicProduct implements Comparable<BibliographicProduct> {
    
    private String uniqueId;
    private String productName;
    private int bookPages;

    private Calendar publicationDate;
    private double productPrice;
    private int amountReadPages;
    

    public BibliographicProduct(String productName, int bookPages, Calendar publicationDate, double productPrice){
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
    public void setProductPrice(double newProductPrice){
        this.productPrice = newProductPrice;
    }
    /**
     * The function returns the product price as a string.
     * 
     * @return The method `getProductPrice()` is returning a `String` value which represents the price
     * of a product.
     */
    public double getProductPrice(){
        return this.productPrice;
    }
    /**
     * This function returns the amount of pages that have been read.
     * 
     * @return The method `getAmountReadPages()` is returning an integer value which represents the
     * amount of pages that have been read.
     */
    public int getAmountReadPages(){
        return this.amountReadPages;
    }
    /**
     * This is a Java function that compares the amount of pages read between two BibliographicProduct
     * objects.
     * 
     * @param Object The parameter "Object" is the object of the class "BibliographicProduct" that we
     * are comparing to the current object.
     * @return The method is returning an integer value that represents the comparison between the
     * amount of pages read in the current object and the amount of pages read in the object passed as
     * a parameter. The comparison is done using the `Integer.compare()` method, which returns a
     * negative integer, zero, or a positive integer depending on whether the first argument is less
     * than, equal to, or greater than the second argument.
     */
    @Override
    public int compareTo(BibliographicProduct Object) {
        return Integer.compare(this.amountReadPages, Object.amountReadPages);
    }
    /**
     * This function returns the publication date as a Calendar object.
     * 
     * @return A Calendar object representing the publication date.
     */
    public Calendar getPublicationDate(){
        return this.publicationDate;
    }
       
}

