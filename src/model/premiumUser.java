package model;


public class premiumUser extends User {

    public premiumUser(String name, String identification){
        super(name, identification);
    }
    /**
     * This Java function adds a bibliographic product to an inventory and returns a success message.
     * 
     * @param product BibliographicProduct object that represents a product to be added to the
     * inventory.
     * @return The method is returning a String message indicating that the product has been added
     * successfully to the inventory.
     */
    @Override
    public String addProduct(BibliographicProduct product){

        inventory.add(product);
        String msj = " The product has been added succesfully" + "\n";

        return msj;
    }

}
