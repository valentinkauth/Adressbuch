/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook.view;

import addressbook.MainApp;
import addressbook.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
    
    
   
    //Reference to the main Application
    
    private MainApp mainApp;
    
   
    //Constructor
    
    public PersonOverviewController(){
    
    }
        
     @FXML
     private void initialize(){
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        
        showPersonDetails(null);
        
        
        
    }
     
     
    //reference to the main application, called by main application 
    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;
        
        personTable.setItems(mainApp.getPersonData());
        
        //Listen for changes in the selection
        
        personTable.getSelectionModel().selectedItemProperty().addListener(
        (observable, oldValue, newValue)->showPersonDetails(newValue));
        
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
    
    
   
     
     
    
        
    
    
    
}
