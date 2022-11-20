package Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ActifAdminController {

    @FXML
    private Button btnReini;

    @FXML
    private Button btncreer;

    @FXML
    void Creer(ActionEvent event) {
    	try {
			  
		    //Stage stagebis = (Stage) btnReini.getScene().getWindow();
	      	
	       // stagebis.close();
			
		    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/Profil.fxml"));
		    Parent root1 = (Parent) fxmlLoader.load();
		    Stage stage = new Stage();
		    stage.setScene(new Scene(root1,700,500));  
		    stage.show();
		  
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void Reinitialiser(ActionEvent event) {
    	try {
		
		    //Stage stagebis = (Stage) btncreer.getScene().getWindow();	
	       // stagebis.close();
			
		    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/Reinitialiser.fxml"));
		    Parent root1 = (Parent) fxmlLoader.load();
		    Stage stage = new Stage();
		    stage.setScene(new Scene(root1,700,500));  
		    stage.show();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

}
