package model;

public class Magazine extends BibliographicProduct {

    private Category magCategory;
    private Periodicity emisionPeriodicity;
    private int activeSubscription;

    public Magazine(String productName, int bookPages, String publicationDate, String productPrice, Category magCategory, Periodicity emPeriodicity){

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
   
    
}
