package model;


public class regularUser extends User {

    private int magazineCounter;
    private int bookCounter;
    
    public regularUser(String name, String identification){
        super(name, identification);
        this.bookCounter = 0;
        this.magazineCounter = 0;
  
    }
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
