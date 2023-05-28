package model;


public class regularUser extends User implements Displayable {

    private int magazineCounter;
    private int bookCounter;
    
    public regularUser(String name, String identification){
        super(name, identification);
        this.bookCounter = 0;
        this.magazineCounter = 0;
  
    }
  
   /**
    * This Java function adds a bibliographic product to an inventory, with limits on the number of
    * books and magazines that can be added.
    * 
    * @param product The BibliographicProduct object that needs to be added to the inventory. It can be
    * either a Book or a Magazine object.
    * @return A message indicating whether the product (book or magazine) was added successfully or
    * not, depending on the current state of the inventory and the type of product being added.
    */
    @Override
    public String addProduct(BibliographicProduct product){

        String msj = " ";
        if(inventory.size() <= 7){
            if(product instanceof Book){
                if(this.bookCounter < 5){
                    inventory.add(product);
                     this.bookCounter +=1;
                    msj = " The book has been added succesfully ";
                }
                else{
                    msj = "The maximum amount of books has been reached.";
                }
            } else if(product instanceof Magazine){
                if(this.magazineCounter < 2){
                    inventory.add(product);
                    this.magazineCounter += 1;
                    msj = "The magazine has been added succesfully.";
                }
                else{
                    msj = "The maximum amount of magazines has been reached.";
                }
            }
        } else{
            msj = "The inventory is full";
        }
        return msj;

    }

    /**
     * The function returns a randomly selected advertisement from an array of three options.
     * 
     * @param randomNumber an integer value that determines which ad to display from the array of ads.
     * @return The method is returning a String that corresponds to the ad at the index indicated by
     * the randomNumber parameter.
     */
    @Override
    public String displayAds(int randomNumber){

        String[] ads = new String[3];
        ads[0] = "¡Suscríbete al Combo Plus y llévate Disney+ y Star+ a un precio increíble!";
        ads[1] = "Ahora tus mascotas tienen una app favorita: Laika. Los mejores productos para tu peludito.";
        ads[2] = "¡Estamos de aniversario! Visita tu Éxito más cercano y sorpréndete con las mejores ofertas.";


        return ads[randomNumber];
    }

}
