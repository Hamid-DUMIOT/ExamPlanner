package Controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class InterfaceAddController {

//private  Button btnexam1;
	
	
//private Button btnfil;

//private Button btnSalle;


public void Salle(ActionEvent event) {
	try {
		//	  Stage stagebis = (Stage) btnSalle.getScene().getWindow();  	
     //    stagebis.close();
		
	 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/InterfaceSalle.fxml"));
	   
			Parent root2 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
		    stage.setScene(new Scene(root2,950,500));  
		    stage.show();
	}
	catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}    
}

public void Filiere(ActionEvent event) {
	try {
		
		 //Stage stagebis = (Stage) btnfil.getScene().getWindow();
      	
        //  stagebis.close();
		
		
	 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/InterfaceFiliere.fxml"));
	   
		
	 
	 
			Parent root2 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
		    stage.setScene(new Scene(root2,1155,500));  
		    stage.show();
		
	}
	catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	
}
	    
	}

public void Appuyer(ActionEvent event) {
	try {
		
		// Stage stagebis = (Stage) btnexam1.getScene().getWindow();
      	
         //  stagebis.close();
		
		
	 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/InterfaceExamen.fxml"));
	   
		
	 
	 
			Parent root2 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
		    stage.setScene(new Scene(root2,809,448));  
		    stage.show();
		
	}
	catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	
}
	    
	}
}