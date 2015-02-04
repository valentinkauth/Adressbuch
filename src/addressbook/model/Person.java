/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook.model;

import java.time.LocalDate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Valentin
 */
public class Person {
    
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty street;
    private final StringProperty city;
    private final StringProperty email;
    private final StringProperty phonel;
    private final StringProperty phonem;
    private final IntegerProperty postCode;
    private final ObjectProperty<LocalDate>birthday;
    
    
    public Person(){
        this(null, null);
    }
    
    public Person(String firstName, String lastName){
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        
       //Dummy data for testing
        
        this.street = new SimpleStringProperty("MyStreet");
        this.city = new SimpleStringProperty("MyCity");
        this.email = new SimpleStringProperty("MyEmail@mail.com");
        this.phonel = new SimpleStringProperty("07141281328");
        this.phonem = new SimpleStringProperty("015122953327");
        this.postCode = new SimpleIntegerProperty(70199);
        this.birthday = new SimpleObjectProperty<LocalDate>(LocalDate.of(1993, 9, 16));
    }
    
    
    
    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getStreet() {
        return street.get();
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public StringProperty streetProperty() {
        return street;
    }
    
      public String getCity() {
        return city.get();
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public StringProperty cityProperty() {
        return city;
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

    public int getPostCode() {
        return postCode.get();
    }

    public void setPostCode(int postCode) {
        this.postCode.set(postCode);
    }

    public IntegerProperty postCodeProperty() {
        return postCode;
    }
    
    
    public LocalDate getBirthday() {
        return birthday.get();
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday.set(birthday);
    }

    public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }
    
}
