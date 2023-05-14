package model;


public class regularUser extends User {

    private int magazineCounter;
    private int bookCounter;
    
    public regularUser(String name, String identification){
        super(name, identification);
        this.bookCounter = 0;
        this.magazineCounter = 0;
  
    }
   /**
    * This function adds a bibliographic product to the inventory if there is space and updates the
    * book/magazine counter accordingly.
    * 
    * @param product BibliographicProduct object that represents a product to be added to the
    * inventory. It can be either a Book or a Magazine.
    * @return The method is returning a String message indicating whether the product was added
    * successfully or not. The message can be "The product has been added successfully" if the product
    * was added to the inventory, or "The inventory is full" if the inventory is already full and the
    * product cannot be added.
    */
    @Override
    public String addProduct(BibliographicProduct product){

        String msj = " ";
        if(inventory.size() <= 7 && this.bookCounter !=5 && product instanceof Book){
            inventory.add(product);
            this.bookCounter +=1;
            msj = " The product has been added succesfully ";
        }
        else if(inventory.size() <= 7 && this.magazineCounter !=2 && product instanceof Magazine){
            inventory.add(product);
            this.magazineCounter +=1;
            msj = " The product has been added succesfully ";

        }
        else{
            msj = " The inventory is full";
        }
          
        return msj;

    }

}
