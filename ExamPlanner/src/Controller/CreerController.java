package Controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class CreerController implements Initializable {
	 @FXML
	    private TextField emailField;
	    @FXML
	    private TextField newpasswordField;
	    @FXML
	    private Button btncreer;
	    @FXML
	    private ChoiceBox<String> TypeProfilField;
	    ObservableList<String> list =  FXCollections.observableArrayList();
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			loadData();
			
		}
		
	    private void loadData() {
	    	list.removeAll(list);
	    	String a = "secretariat";
	    	String b = "scolarité";
	    	String c = "administrateur";
	    	String d = "root";
	    	list.addAll(a,b,c,d);
	    	TypeProfilField.getItems().addAll(list);
	    }
	    @FXML
	    void Confirmer(ActionEvent event) throws SQLException {
	   String profil = TypeProfilField.getValue();
	   if(profil== null) {
		   infoBox("Please, select a profil!", null, "Failed");	
	    }
	   else if(profil == "secretariat") {
		   insertButtonsecretariat();
		   infoBox("Le profil "+ profil +" a été crée", null, "Failed");   
	   }
	   else if(profil == "scolarité") {
		   insertButtonscolarité();
		   infoBox("Le profil "+ profil +" a été crée", null, "Failed");	   
	   }
	   else if(profil == "administrateur") {
		   insertButtonadministrateur();
		   infoBox("Le profil "+ profil +" a été crée", null, "Failed");   
	   }
	 }  
	   private void insertButtonsecretariat() {
		   String query =  "INSERT INTO `user`(`idProfil` , `email`, `password`) "+
				   "VALUES ('1','"+emailField.getText()+"','"+ newpasswordField.getText() +"')";		  
		   executeQuery(query); 
	   }
	   private void insertButtonscolarité() {
		   String query =  "INSERT INTO `user`(`idProfil`,`email`, `password`) "+
				   "VALUES ('3','"+emailField.getText()+"','"+ newpasswordField.getText() +"')";	  
		   executeQuery(query); 
	   }
	   private void insertButtonadministrateur() {
		   String query =  "INSERT INTO `user`(`idProfil`,`email`, `password`) "+
				   "VALUES ('2','"+emailField.getText()+"','"+ newpasswordField.getText() +"')";	  
		   executeQuery(query); 
	   }
	    private void executeQuery(String query) {
	    	Connection con = getConnection();
			Statement st;
			try {
	    		st =con.prepareStatement(query);
	    		st.executeUpdate(query);
	    	 }catch(Exception e) { 
	    	 } 
	    }
	    public Connection getConnection() {
	    	Connection conn;
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet?serverTimezone=UTC", "root","");
				return conn;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}	
	    }

	    public static void infoBox(String infoMessage, String headerText, String title) {
	        Alert alert = new Alert(AlertType.CONFIRMATION);
	        alert.setContentText(infoMessage);
	        alert.setTitle(title);
	        alert.setHeaderText(headerText);
	        alert.showAndWait();
	    }





	



		
	 
			 
			
  }

