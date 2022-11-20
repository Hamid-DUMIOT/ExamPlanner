package Controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import Autre.Examen;
import Autre.Salle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.stage.Stage;


public class CalendrierController  {

	//private Button AddBtn;

	//private Button btnadmin;

	// private Button btnprec;

	//private Button btnnext;

	//private Button btnevent;

	@FXML
	void Admin(ActionEvent event) {

		try {

			//Stage stagebis = (Stage) AddBtn.getScene().getWindow();

			// stagebis.close();

			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/MdpAdmin.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root1,394,300));  
			stage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
    
@FXML
void Click(ActionEvent event) {
	
	try {
		
		  
	    //Stage stagebis = (Stage) AddBtn.getScene().getWindow();
      	
       //stagebis.close();
		
	    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/MdpSecretariat.fxml"));
	    Parent root1 = (Parent) fxmlLoader.load();
	    Stage stage = new Stage();
	    stage.setScene(new Scene(root1,394,300));  
	    stage.show();

	} catch(Exception e) {
		e.printStackTrace();
	}
}

@FXML
void event(ActionEvent event) {
	try {
		
		  
	    //Stage stagebis = (Stage) AddBtn.getScene().getWindow();
      	
       //stagebis.close();
		
	    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/Scolarité.fxml"));
	    Parent root1 = (Parent) fxmlLoader.load();
	    Stage stage = new Stage();
	    stage.setScene(new Scene(root1,394,300));  
	    stage.show();

	} catch(Exception e) {
		e.printStackTrace();
	}
}










}