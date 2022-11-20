package Controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import Autre.Examen;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class EventController implements Initializable {
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfduree;
    @FXML
    private Button btncreer;
    @FXML
    private TableView<Examen> table;
    @FXML
    private TableColumn<Examen, String> col_nom;
    @FXML
    private TableColumn<Examen, String> col_duree;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    }
    @FXML
    void handleButtonAction(ActionEvent event) {
    	if(event.getSource() == getBtncreer()) {
    		CalendrierController c = new CalendrierController();	
    		showexam();
    	}	
    }
	 public ObservableList<Examen> getExamList(){
		 ObservableList<Examen> oblist = FXCollections.observableArrayList();
			
			try {
				Connection con = getConnection();
		
ResultSet rs=con.createStatement().executeQuery("Select  titre, duree from examens WHERE titre = '"+tfnom.getText()+"' AND duree ='" + tfduree.getText() + "'");
			
				while(rs.next()) {
					Examen exam = new Examen(
							rs.getString("titre"),
							rs.getString("duree")
							);
					oblist.add(exam);
				} 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return oblist;
	 }
	public void showexam() {
		ObservableList<Examen> list = getExamList();
		 col_nom.setCellValueFactory(new PropertyValueFactory<Examen, String>("titre"));
		 col_duree.setCellValueFactory(new PropertyValueFactory<Examen, String>("durée"));
	 table.setItems(list);
			
		}
 
	  ////////Connection
	  
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

public Button getBtncreer() {
	return btncreer;
}

public void setBtncreer(Button btncreer) {
	this.btncreer = btncreer;
}



}
