package Controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


import Autre.Salle;
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


public class SalleController implements Initializable {
    @FXML
    private TableView<Salle> table;
    @FXML
    private TableColumn<Salle,Integer> col_idsalle;
    @FXML
    private TableColumn<Salle,String> col_nom;
    @FXML
    private TableColumn<Salle,Integer> col_capacc;
    @FXML
    private TableColumn<Salle,String> col_plage;
    @FXML
    private TextField tfidSalle;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfcapacc;
    @FXML
    private TextField tfplage;
    @FXML
    private Button btninsert;
    @FXML
    private Button btnupdate;
    @FXML
    private Button btndelete;
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	showsalle();	
	}
    @FXML
    void handleButtonAction(ActionEvent event) throws SQLException {
    	if(event.getSource()==btninsert) {
    		System.out.println("HELLO WORD");
    insertButton();
    	}
    	else if( event.getSource()==btnupdate) {
    		System.out.println("HELLO WORD");
    		updateButton();
    	}
    	else if( event.getSource()==btndelete) {
    		System.out.println("HELLO WORD");
    		deleteButton();
    }
 }  
    private void insertButton()  {
	   String query = "INSERT INTO `salles`(`idSalle`, `nom`, `capaciteAcceuil`, `plageDispo`) "+
			   "VALUES ('"+tfidSalle.getText()+"','"+ tfnom.getText() +"','" + tfcapacc.getText()+"','"+ tfplage.getText() +"')";
		  executeQuery(query);
		   showsalle();   
   }
   private void updateButton() {
String query = "UPDATE `salles` SET `nom`='" +tfnom.getText() + "',`capaciteAcceuil`=" +  tfcapacc.getText() +  ",`plageDispo`='" +  tfplage.getText() +  
"'WHERE `idSalle`=" + tfidSalle.getText();
	   executeQuery(query);
	   showsalle();
   } 
 private void deleteButton() {
	String query = "DELETE FROM `salles`  WHERE `idSalle`='" + tfidSalle.getText() +"'";
	executeQuery(query);
	   showsalle();
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
 public ObservableList<Salle> getSalleList(){
	 ObservableList<Salle> oblist = FXCollections.observableArrayList();
	 try {
			Connection con = getConnection();
			ResultSet rs = con.createStatement().executeQuery("Select *  from salles");
			while(rs.next()) {	
				oblist.add(new Salle(rs.getInt("idSalle"),
						rs.getString("nom"),
						rs.getInt("capaciteAcceuil"),
						rs.getString("plageDispo")));	
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oblist;
 }
public void showsalle() {
	ObservableList<Salle> list = getSalleList();
	 col_idsalle.setCellValueFactory(new PropertyValueFactory<>("idSalle"));
	 col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
	col_capacc.setCellValueFactory(new PropertyValueFactory<>("capaciteAcceuil"));
	 col_plage.setCellValueFactory(new PropertyValueFactory<>("plageDispo"));
	 table.setItems(list);
}


}


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
    

	




