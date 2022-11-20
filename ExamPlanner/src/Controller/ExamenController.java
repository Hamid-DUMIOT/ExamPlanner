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


public class ExamenController implements Initializable{
	 @FXML
	    private TableView<Examen> table;
	    @FXML
	    private TableColumn<Examen, Integer> col_id;
	    @FXML
	    private TableColumn<Examen, String> col_titre;
	    @FXML
	    private TableColumn<Examen, String> col_duree;
	    @FXML
	    private TableColumn<Examen, String> col_filiere;
	    @FXML
	    private TextField tfid;
	    @FXML
	    private TextField tftitre;
	    @FXML
	    private TextField tfduree;
	    @FXML
	    private TextField tffil;
	    @FXML
	    private Button btninsert;
	    @FXML
	    private Button btnupdate;
	    @FXML
	    private Button btndelete;
	    @Override
		public void initialize(URL arg0, ResourceBundle arg1) {
		showexam();	
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
		   String query = "INSERT INTO `examens`(`idExamen`, `titre`, `duree`, `IdFiliere`) "+
	   "VALUES ('"+tfid.getText()+"','"+ tftitre.getText() +"','" + tfduree.getText()+"','"+ tffil.getText() +"')";
  		   executeQuery(query);
  		   showexam();  
	   }
	   private void updateButton() {
		   String query = "UPDATE `examens` SET `titre`='" +tftitre.getText() + "',`duree`='" +  tfduree.getText() + 
				   "',`IdFiliere`='" +  tffil.getText() + 
				   "' WHERE `idExamen`='" + tfid.getText() +"'";
		   executeQuery(query);
		   showexam();
	   } 
	 private void deleteButton() {
		 
		String query = "DELETE FROM `examens`  WHERE `idExamen`='" + tfid.getText() +"'";
		executeQuery(query);
		   showexam();
	 }
	    private void executeQuery(String query) {
	    	Connection con = getConnection();
			Statement st;
			try {
	    		st =con.prepareStatement(query);
	    		st.executeUpdate(query);
	    	 }catch(Exception e) {	  }	 
	    }
	    public Connection getConnection() {
	    	Connection conn;
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet?serverTimezone=UTC", "root","");
				return conn;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;}
	    }
	 public ObservableList<Examen> getExamList(){
		 ObservableList<Examen> oblist = FXCollections.observableArrayList();
			try {
				Connection con = getConnection();
				ResultSet rs = con.createStatement().executeQuery("Select * from examens INNER JOIN filliere ON examens.idFiliere = filliere.idFiliere");
				while(rs.next()) {
					Examen exam = new Examen(rs.getInt("idExamen"),
							rs.getString("titre"),
							rs.getString("duree"),
							rs.getString("nom"));
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
		 col_id.setCellValueFactory(new PropertyValueFactory<Examen, Integer>("id"));
		 col_titre.setCellValueFactory(new PropertyValueFactory<Examen, String>("titre"));
		 col_duree.setCellValueFactory(new PropertyValueFactory<Examen, String>("durée"));
		 col_filiere.setCellValueFactory(new PropertyValueFactory<Examen, String>("idfilliere"));
		 table.setItems(list);
		
	}
}

