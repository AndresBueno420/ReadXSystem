package model;


public class premiumUser extends User {

    public premiumUser(String name, String identification){
        super(name, identification);
    }
    @Override
    public String addProduct(BibliographicProduct product){

        inventory.add(product);
        String msj = " The product has been added succesfully" + "\n";

        return msj;
    }

}
