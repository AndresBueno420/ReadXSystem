package model;


public class regularUser extends User {
    
    public regularUser(String name, String identification){
        super(name, identification);
  
    }
    @Override
    public String addProduct(BibliographicProduct product){

        String msj = " ";
        if(books.size() <= 5){
            books.add(product);
            msj = " The product has been added succesfully ";
        }
        else{
            msj = "The inventory is full. ";
        }
        return msj;

    }

}
