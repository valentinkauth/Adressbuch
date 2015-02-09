/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook.model;

import addressbook.interfaces.IName;
import addressbook.interfaces.IAddress;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Valentin
 */
public class PersonSuper implements IAddress, IName {
    protected final StringProperty firstName;
    protected final StringProperty lastName;
    protected final StringProperty street;
    protected final StringProperty city;
    protected final IntegerProperty postCode;
    
    
    public PersonSuper(){
        this(null, null, null, null, 0);
    }

    public PersonSuper(String firstName, String lastName, String street, String city, int postCode) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.street = new SimpleStringProperty(street);
        this.city = new SimpleStringProperty(city);
        this.postCode = new SimpleIntegerProperty(postCode);
        
        
        
    }

    

    @Override
    public String getFirstName() {
        return firstName.get();
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    
    public StringProperty firstNameProperty() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName.get();
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

   
    public StringProperty lastNameProperty() {
        return lastName;
    }

    @Override
    public String getStreet() {
        return street.get();
    }

    @Override
    public void setStreet(String street) {
        this.street.set(street);
    }

    
    public StringProperty streetProperty() {
        return street;
    }

    @Override
    public String getCity() {
        return city.get();
    }

    @Override
    public void setCity(String city) {
        this.city.set(city);
    }

    
    public StringProperty cityProperty() {
        return city;
    }

    @Override
    public int getPostCode() {
        return postCode.get();
    }

    @Override
    public void setPostCode(int postCode) {
        this.postCode.set(postCode);
    }

    
    public IntegerProperty postCodeProperty() {
        return postCode;
    }
    
}
