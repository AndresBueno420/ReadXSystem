package model;


public class Bill {

    private double price;
    private String operationDate;
    private String productId;

    public Bill(double price, String operationDate, String productId){
        this.price = price;
        this.operationDate = operationDate;
        this.productId = productId;
    }
    
}
