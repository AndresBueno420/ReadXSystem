package model;
import java.util.Calendar;

public class Book extends BibliographicProduct {

    private Genre bookGenre;
    private int copiesSold;

    public Book(String productName, int bookPages, Calendar publicationDate, double productPrice, Genre bookGenre){

        super(productName, bookPages, publicationDate, productPrice);
        this.copiesSold = 0;
        this.bookGenre = bookGenre;
    }
  /**
   * The function increments the number of copies sold by one.
   */
    public void setCopiesSold(){
        this.copiesSold +=1;
    }
    /**
     * This function returns the genre of a book.
     * 
     * @return The method `getBookGenre()` is returning the `Genre` object associated with the book.
     */
    public Genre getBookGenre(){
        return this.bookGenre;
    }
    /**
     * The function returns the number of copies sold.
     * 
     * @return The method `getCopiesSold()` is returning the value of the `copiesSold` variable.
     */
    public int getCopiesSold(){
        return this.copiesSold;
    }

}

    

