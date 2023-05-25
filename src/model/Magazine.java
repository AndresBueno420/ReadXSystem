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
    
}
