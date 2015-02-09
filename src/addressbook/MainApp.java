/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook;

import addressbook.model.Person;

import addressbook.view.PersonEditDialogController;
import addressbook.view.PersonOverviewController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.logging.Logger;
import java.util.logging.Level;



/**
 *
 * @author Valentin
 */


public class MainApp extends Application {
    
    private final static Logger log = Logger.getLogger(MainApp.class.getName());
    
    
   
    
    private ObservableList<Person>personData = FXCollections.observableArrayList();
     
    public MainApp(){
        
        //some sample data
        
        Thread initializeThread = new Thread(){@Override public void run(){
           personData.add(new Person("Valentin", "Kauth", "Möhringer Straße 43", "Stuttgart", "valentinkauth@me.com", "07141/281328", "015122953327", 70199));
           personData.add(new Person("Vanessa", "Beck", "Nelkenweg 11", "Ludwigsburg", "vanessa.beck@gmx.de", "07141/382799", "01712274883", 71642));
           personData.add(new Person("Tom", "Fischer", "Böblinger Straße 82/5", "Stuttgart", "tomfischer90@web.de", "0711/295482", "01517374867", 70199));
           personData.add(new Person("Valentin", "Kauth", "Möhringer Straße 43", "Stuttgart", "valentinkauth@me.com", "07141/281328", "015122953327", 70199));
           personData.add(new Person("Valentin", "Kauth", "Möhringer Straße 43", "Stuttgart", "valentinkauth@me.com", "07141/281328", "015122953327", 70199));
           log.info("Start-Daten eingefügt");
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
        
        log.info("Startfenster wurde vollständig geladen und initialisiert");
        
        
        
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
        log.log(Level.SEVERE,"RootLayout konnte nicht geladen werden", e);
    }
    
    log.info("RootLayout wurde erfolgreich geladen und wird nun angezeigt");

   
    
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
            log.log(Level.SEVERE,"PersonOverview konnte nicht geladen werden", e);
        }
        log.info("PersonOverview wurde erfolgreich geladen und wird nun angezeigt");
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
            log.log(Level.SEVERE,"PersonEditDialog konnte nicht geladen/gestartet werden", e);
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
