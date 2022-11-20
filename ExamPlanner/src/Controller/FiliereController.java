package Controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import Autre.Etudiant;

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

public class FiliereController implements Initializable {
    @FXML
    private TableView<Etudiant> table;
    @FXML
    private TableColumn<Etudiant, String> col_id;
    @FXML
    private TableColumn<Etudiant, String> col_nom;
    @FXML
    private TableColumn<Etudiant, String> col_prenom;
    @FXML
    private TableColumn<Etudiant, Integer> col_numetu;
    @FXML
    private TableColumn<Etudiant, String> col_filiere;
    @FXML
    private TableColumn<Etudiant, String> col_annee;
    ObservableList<Etudiant> oblist = FXCollections.observableArrayList();
    @FXML
    private Button btninsert;
    @FXML
    private Button btnupdate;
    @FXML
    private Button btndelete;
    @FXML
    private TextField tfide;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfprenom;
    @FXML
    private TextField tfnumetu;
    @FXML
    private TextField tffil;
    @FXML
    private TextField tfannee;
 
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	showetudiant();	
	}
    
    @FXML
    void handleButtonAction(ActionEvent event) throws SQLException {
    	if(event.getSource()==btninsert) {
    		System.out.println("HELLO WORD");
    insertButton();
    	}
    	else if( event.
    			getSource()==btnupdate) {
    		System.out.println("HELLO WORD");
    		updateButton();
    	}
    	else if( event.
    			getSource()==btndelete) {
    		System.out.println("HELLO WORD");
    		deleteButton();	
    }
 }  
   private void insertButton() throws SQLException {
	   String query = "INSERT INTO `eleves`(`idEleve`, `nom`, `prenom`, `numEtu`, `IdFiliere`, `annee`) "+
   "VALUES ('"+tfide.getText()+"','"+ tfnom.getText() +"','" + tfprenom.getText()+"','"+ tfnumetu.getText()
   +"','"+ tffil.getText()
   +"','"+ tfannee.getText()
   +"')";
		   executeQuery(query);
		   showetudiant();   
   }
   private void updateButton() {
	   String query = "UPDATE `eleves` SET `nom`='" +tfnom.getText() + "',`prenom`='" +  tfprenom.getText() + 
"',`numEtu`='" +  tfnumetu.getText() +  "',`IdFiliere`='" +tffil.getText()+ "',`annee`='" +  tfannee.getText()+ "' WHERE `idEleve`='" + tfide.getText() +"'";
	   executeQuery(query);
	   showetudiant();
   }
 private void deleteButton() {
	String query = "DELETE FROM `eleves`  WHERE `idEleve`='" + tfide.getText() +"'";
	executeQuery(query);
	   showetudiant();
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
 public ObservableList<Etudiant> getEtudiantList(){
	 ObservableList<Etudiant> oblist = FXCollections.observableArrayList();
		try {
			Connection con = getConnection();
			ResultSet rs = con.createStatement().executeQuery("Select * from eleves INNER JOIN filliere  ON eleves.idFiliere = filliere.idFiliere ");
		 
			while(rs.next()) {
				
				oblist.add(new Etudiant(rs.getInt("idEleve"),
						rs.getString("nom"),
						rs.getString("prenom"),
						rs.getInt("numEtu"),
						rs.getString("filliere.nom"),
						rs.getString("annee")));	
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return oblist;
 }
public void showetudiant() {
	ObservableList<Etudiant> list = getEtudiantList();
	 col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
	 col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
	col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
	 col_numetu.setCellValueFactory(new PropertyValueFactory<>("numEtu"));
	 col_filiere.setCellValueFactory(new PropertyValueFactory<>("filiere"));
	 col_annee.setCellValueFactory(new PropertyValueFactory<>("annee"));
	 table.setItems(list);
	
}
}


    
	
	



		
	


