/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook.view;

import addressbook.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Valentin
 */
public class PersonEditDialogController {
    
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField streetField;
    @FXML
    private TextField cityField;
    @FXML
    private TextField postCodeField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField phonelField;
    @FXML
    private TextField phonemField;
    
    @FXML
    private Label errorLabel;
    
    
    private Stage dialogStage;
    private Person person;
    private boolean okClicked = false;
    
    
    @FXML
    private void initialize(){
    }
        
    public void setDialogStage(Stage dialogStage){
        this.dialogStage = dialogStage;
    }
    
    
    //Person will be loaded into the controller class
    public void setPerson(Person person){
        this.person = person;
        
        firstNameField.setText(person.getFirstName());
        lastNameField.setText(person.getLastName());
        streetField.setText(person.getStreet());
        cityField.setText(person.getCity());
        postCodeField.setText(Integer.toString(person.getPostCode()));
        emailField.setText(person.getEmail());
        phonelField.setText(person.getPhoneLocal());
        phonemField.setText(person.getPhoneMobile());
    }
    
    public boolean isOkClicked(){
        return okClicked;
    }
    
    @FXML
    private void handleOk(){
        if(isInputValid()){
            person.setFirstName(firstNameField.getText());
            person.setLastName(lastNameField.getText());
            person.setStreet(streetField.getText());
            person.setCity(cityField.getText());
            person.setPostCode(Integer.parseInt(postCodeField.getText()));
            person.setEmail(emailField.getText());
            person.setPhoneLocal(phonelField.getText());
            person.setPhoneMobile(phonemField.getText());
            
            okClicked = true;
            dialogStage.close();
            
            
        }
        
        
    }
    
    private boolean isInputValid(){
        String errorMessage="";
        
        if(firstNameField.getText()==null||firstNameField.getText().length()==0){
            errorMessage += "Kein gültiger Vorname! \n";
        }
        
        if(lastNameField.getText()==null||lastNameField.getText().length()==0){
            errorMessage += "Kein gültiger Nachname! \n";
        }
        
        if(streetField.getText()==null||streetField.getText().length()==0){
            errorMessage += "Kein gültiger Straßenname! \n";
        }
        
        if(cityField.getText()==null||cityField.getText().length()==0){
            errorMessage += "Kein gültiger Stadtname! \n";
        }
        
        if(postCodeField.getText()==null||postCodeField.getText().length()==0){
            errorMessage += "Keine gültige Postleitzahl! \n";
        }else{
            try{
                Integer.parseInt(postCodeField.getText());
            }catch(NumberFormatException e){
                errorMessage += "Keine gültige Postleitzahl (nur Zahlen gültig)";
            }
        
        }
        
        if(emailField.getText()==null||emailField.getText().length()==0){
            errorMessage += "Keine gültige E-Mail-Adresse! \n";
        }
        
        if(phonelField.getText()==null||phonelField.getText().length()==0){
            errorMessage += "Keine gültige Festnetznummer! \n";
        }
        
        if(phonemField.getText()==null||phonemField.getText().length()==0){
            errorMessage += "Keine gültige Mobilfunknummer! \n";
        }
        
        if(errorMessage.length()==0){
            return true;
        }else{
            errorLabel.setText(errorMessage);
            return false;
        }
      
    }
    
    
    
    
    
    
    
    
    
    
    
}
