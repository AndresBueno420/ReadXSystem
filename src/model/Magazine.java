package model;

import java.util.Calendar;

public class Magazine extends BibliographicProduct {

    private Category magCategory;
    private Periodicity emisionPeriodicity;
    private int activeSubscription;

    public Magazine(String productName, int bookPages, Calendar publicationDate, double productPrice, Category magCategory, Periodicity emPeriodicity){

        super(productName, bookPages, publicationDate, productPrice);
        this.magCategory = magCategory;
        this.emisionPeriodicity = emPeriodicity;
        this.activeSubscription = 0;
    }
    
   /**
    * The function increments the value of the activeSubscription variable by 1.
    */
    public void setActiveSubscriptions(){
        this.activeSubscription +=1;
    }
   /**
    * The function returns the category of a magazine.
    * 
    * @return The method `getCategory()` is returning an object of the `Category` class, which is
    * stored in the instance variable `magCategory`.
    */
   public Category getCategory(){
        return this.magCategory;
   }
   /**
    * This Java function returns the number of active subscriptions.
    * 
    * @return The method is returning an integer value which represents the number of active
    * subscriptions.
    */
   public int getActiveSubscriptions(){
        return this.activeSubscription;
   }
    /**
     * This Java function decreases the value of the activeSubscription variable by 1 if it is not
     * already 0.
     */
    public void decreaseActiveSubscriptions(){
        if(this.activeSubscription != 0){
            this.activeSubscription -= 1;
        }
    }

}
