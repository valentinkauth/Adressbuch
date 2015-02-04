/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook.view;

import addressbook.MainApp;
import addressbook.model.Person;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Valentin
 */
public class PersonOverviewController {
    
    @FXML
    private TableView<Person> personTable;
    
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    
    @FXML
    private TableColumn<Person, String> lastNameColumn;
    
     @FXML
    private Label firstNameLabel;
    
     @FXML
    private Label lastNameLabel;
     
    @FXML
    private Label streetLabel;
      
    @FXML
    private Label cityLabel;
       
    @FXML
    private Label emailLabel;
        
    @FXML
    private Label phonelLabel;
         
    @FXML
    private Label phonemLabel;
    
    @FXML
    private Label postCodeLabel;
    
    @FXML
    private Label errorLabel;
    
    
   
    //Reference to the main Application
    
    private MainApp mainApp;
    
   
    //Constructor
    
    public PersonOverviewController(){
    
    }
        
     @FXML
     private void initialize(){
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        
        errorLabel.setText("");
        
        showPersonDetails(null);
        
        //Listen for changes in the selection
         personTable.getSelectionModel().selectedItemProperty().addListener(
        (observable, oldValue, newValue)->showPersonDetails(newValue));
        
    }
     
     
    //reference to the main application, called by main application 
    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;
        
        personTable.setItems(mainApp.getPersonData());
        
        
        
       
        
    }
    
    
    private void showPersonDetails(Person person){
        if(person!=null){
            firstNameLabel.setText(person.getFirstName());
            lastNameLabel.setText(person.getLastName());
            streetLabel.setText(person.getStreet());
            cityLabel.setText(person.getCity());
            emailLabel.setText(person.getEmail());
            phonelLabel.setText(person.getPhoneLocal());
            phonemLabel.setText(person.getPhoneMobile());
            postCodeLabel.setText(Integer.toString(person.getPostCode()));
            
            
        }else{
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            streetLabel.setText("");
            cityLabel.setText("");
            emailLabel.setText("");
            phonelLabel.setText("");
            phonemLabel.setText("");
            postCodeLabel.setText("");
         
            
        }
    }
    
    
   @FXML
   private void handleDeletePerson(){
       int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
       
       if (selectedIndex>=0){
       personTable.getItems().remove(selectedIndex);
       }
       
       else{
          errorLabel.setText("Bitte wählen Sie einen Kontakt zum Löschen aus");
          
          //TODO: Thread, der den Text nach 5 Sekunden wieder verschwinden lässt
           
       }
       
      
       
   }
   
   @FXML
   private void handleNewPerson(){
       Person tempPerson = new Person();
       boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
       if(okClicked){
           mainApp.getPersonData().add(tempPerson);
       }
   }
   
   @FXML
   private void handleEditPerson(){
       Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
       if(selectedPerson!=null){
           boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
           if(okClicked){
               showPersonDetails(selectedPerson);
           }
       }else{
           errorLabel.setText("Bitte Person auswählen");
       }
   }
     
     
    
        
    
    
    
}
