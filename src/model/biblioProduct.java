package model;
import java.util.UUID;

public abstract class biblioProduct {
    private String uniqueId;
    private String productName;
    private int bookPages;
    private String publicationDate;
    private String productPrice;
    private int amountReadPages;

    public biblioProduct(String productName, int bookPages, String publicationDate, String productPrice){
        this.productName = productName;
        this.bookPages = bookPages;
        this.publicationDate = publicationDate;
        this.productPrice = productPrice;
        this.amountReadPages = 0;
        generateUniqueId();

    }
    private void generateUniqueId(){
        String id = UUID.randomUUID().toString().substring(0, 3).toUpperCase();
        this.uniqueId = id;
    }
    public String getUniqueId(){
        return uniqueId;
    }
    public String getProductName(){
        return productName;
    }
    public void setProductName(String newProductName){
        this.productName = newProductName;
    }
    public int getBookPages(){
        return bookPages;
    }
    public void setBookPages(int newBookPages){
        this.bookPages = newBookPages;
    }
    









    
}
