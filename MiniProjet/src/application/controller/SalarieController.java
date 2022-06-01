package application.controller;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import application.entities.Salari�;
import application.service.ApplicationService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class SalarieController implements Initializable {
	
	private ApplicationService as = new ApplicationService();
	private List<Salari�> salaries = new ArrayList<>();
	@FXML
	private  TableView tableview;
	
	@FXML
	private TextField search ;
	
	
	
	@FXML
	private TableView<Salari�> table;
	
	//table column
	@FXML 
	 private TableColumn<Salari�, Integer> mat;
	
	@FXML 
	 private TableColumn<Salari�, String> nom;
	
	@FXML 
	 private TableColumn<Salari�, String> email;
	
	@FXML 
	 private TableColumn<Salari�, Double> rec;
	
	@FXML 
	 private TableColumn<Salari�, String> cat;
	
	@FXML 
	 private TableColumn<Salari�, Double> salaire;
	
	
	
	
	@FXML
	private Button enter;
	
	@FXML
	private Button salbtn;
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		mat.setCellValueFactory(new PropertyValueFactory<>("mat"));
		 nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
		 email.setCellValueFactory(new PropertyValueFactory<>("email"));
		 rec.setCellValueFactory(new PropertyValueFactory<>("rec"));
		
		 salaire.setCellValueFactory(new PropertyValueFactory<>("salaire"));
		 
		 cat.setCellValueFactory(new PropertyValueFactory<>("cat"));
		 
		 
		 try {
			 
			 salaries =  as.getAllSalaries();
			 
			 for (Salari� s : salaries)System.out.println(s.getEmail());
			 
			 tableview.setItems(FXCollections.observableArrayList(salaries));
			 
			 
			 
			 
		 }catch(Exception ex)
		 {
			 
		 }
		
	}
	
	  @FXML
	    private void gotoenter(ActionEvent event) {
	        System.out.print("enter");
	        
	        Main.mudaTela("addsalary");
	    }
	  
	  @FXML
	    private void gotosal(ActionEvent event) {
		  System.out.print("salar");
	    }
	
	

}
