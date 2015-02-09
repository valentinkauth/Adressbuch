/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook.model;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Valentin
 */
public class Person extends PersonSuper {
    
    
    //adding variables for extra data (mail, phone local, mobile phone)
    private final StringProperty email;
    private final StringProperty phonel;
    private final StringProperty phonem;
    
    
    
    public Person(){
                   this(null, null, null, null, null, null, null, 0);


    }
    
    //Contructor to add dummy data
    
    public Person(String firstName, String lastName, String street, String city, 
            String email, String phonel, String phonem, int postCode){
        
        
        //calling the Contructor of the Super class
        super(firstName, lastName, street, city, postCode);
        
        this.email = new SimpleStringProperty(email);
        this.phonel = new SimpleStringProperty(phonel);
        this.phonem = new SimpleStringProperty(phonem);
        
       }
    
    
    
    
    
    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public StringProperty emailProperty() {
        return email;
    }
    
    public String getPhoneLocal() {
        return phonel.get();
    }

    public void setPhoneLocal(String phonel) {
        this.phonel.set(phonel);
    }

    public StringProperty phoneLocalProperty() {
        return phonel;
    }
    
    public String getPhoneMobile() {
        return phonem.get();
    }

    public void setPhoneMobile(String phonem) {
        this.phonem.set(phonem);
    }

    public StringProperty phoneMobileProperty() {
        return phonem;
    }

    
    
   
    
}
