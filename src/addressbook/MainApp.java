/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook;

import addressbook.model.Person;

import addressbook.view.PersonEditDialogController;
import addressbook.view.PersonOverviewController;

import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Valentin
 */
public class MainApp extends Application {
    
    private ObservableList<Person>personData = FXCollections.observableArrayList();
     
    public MainApp(){
        
        //some sample data
        
        Thread initializeThread = new Thread(){@Override public void run(){
           personData.add(new Person("Valentin", "Kauth", "Möhringer Straße 43", "Stuttgart", "valentinkauth@me.com", "07141/281328", "015122953327", 70199));
        }};
        
        initializeThread.start();
        
    }
    
    
    
    
      
   
        
        
        
    
    
    public ObservableList<Person>getPersonData(){
        return personData;
    }
    
    
    private Stage primaryStage;
    private BorderPane rootLayout;
   
    
    
    @Override
    public void start(Stage primaryStage){
        this.primaryStage=primaryStage;
        this.primaryStage.setTitle("Adressbuch");
        
        initRootLayout();
        
        showPersonOverview();
        
        
        
    }
    
    
    public void initRootLayout() {
    try {
        // Load root layout from fxml file.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class
                .getResource("view/RootLayout.fxml"));
        rootLayout = (BorderPane) loader.load();

        // Show the scene containing the root layout.
        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);

       

        primaryStage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }

   
    
}
    
    public void showPersonOverview(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PersonOverview.fxml"));
            AnchorPane personOverview = (AnchorPane)loader.load();
            
            rootLayout.setCenter(personOverview);
            
            PersonOverviewController controller = loader.getController();
            controller.setMainApp(this);
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    
    public boolean showPersonEditDialog(Person person){
        try{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("view/PersonEditDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        
        Stage dialogStage= new Stage();
        dialogStage.setTitle("Person bearbeiten");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        
        PersonEditDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setPerson(person);
        
        dialogStage.showAndWait();
        
        return controller.isOkClicked();
        }catch(IOException e){
            e.printStackTrace();
            return false;
        }
        
        
    }
    
    public Stage getPrimaryStage(){
        return primaryStage;
    }
    
   public static void main(String[]args){
       launch(args);
   }
   
   
   
    
}
