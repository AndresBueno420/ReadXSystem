package model;

public class Book extends BibliographicProduct {

    private Genre bookGenre;
    private int copiesSold;

    public Book(String productName, int bookPages, String publicationDate, String productPrice, Genre bookGenre){

        super(productName, bookPages, publicationDate, productPrice);
        this.copiesSold = 0;
        this.bookGenre = bookGenre;
    }

    public void increaseCopiesSold(){
        this.copiesSold +=1;
    }

    
}
