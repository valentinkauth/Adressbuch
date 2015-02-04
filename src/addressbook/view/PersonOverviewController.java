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
    private Label sreetLabel;
      
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
    private Label birthdayLabel;
    
   
    //Reference to the main Application
    
    private MainApp mainApp;
    
   
    //Constructor
    
    public PersonOverviewController(){
    
    }
        
     @FXML
     private void initialize(){
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
    }
     
     
    //reference to the main application, called by main application 
    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;
        
        personTable.setItems(mainApp.getPersonData());
        
    }
     
     
    
        
    
    
    
}
