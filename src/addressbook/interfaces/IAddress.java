
package addressbook.interfaces;



/**
 *
 * @author Valentin
 */
public abstract interface IAddress {

    

    
abstract void setPostCode(int postCode);

abstract int getPostCode();

   
    
abstract  void setCity(String city);

abstract String getCity();
    

abstract void setStreet(String street);
    
abstract String getStreet();
    
    
}
