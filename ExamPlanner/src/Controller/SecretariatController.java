package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;
import utils.ConnectionSecretariat;


public class SecretariatController {


    @FXML
    private Button submitButton;
    
    @FXML
    private TextField emailIdField;

    @FXML
    private PasswordField passwordField;


    @FXML
    public void login(ActionEvent event) throws SQLException, IOException {

        Window owner = submitButton.getScene().getWindow();

        System.out.println(passwordField.getText());

  
        if (passwordField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                "Please enter a password");
            return;
        }

        String password = passwordField.getText();

        ConnectionSecretariat jdbcDao = new ConnectionSecretariat();
        boolean flag = jdbcDao.validate(password);

        if (!flag) {
            infoBox("Please enter correct Password", null, "Failed");
        } else {
            infoBox("Login Successful!", null, "Failed");
            
            Stage stagebis = (Stage) submitButton.getScene().getWindow();
        	
            stagebis.close();
        	
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/InterfaceAdd.fxml"));
    	    Parent root1 = (Parent) fxmlLoader.load();
    	    Stage stage = new Stage();
    	    stage.setScene(new Scene(root1,600,400));  
    	    stage.show();
    	
        }
    }

    public static void infoBox(String infoMessage, String headerText, String title) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }

    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}
