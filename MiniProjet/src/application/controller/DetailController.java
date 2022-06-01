package application.controller;

import java.net.URL;
//import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.entities.PayloadSalaré;
//import application.entities.PayloadSalaré;
import application.entities.Salarié;
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

public class DetailController implements Initializable {
	
	private ApplicationService as = new ApplicationService();
	private List<PayloadSalaré> salaries = new ArrayList<>();
	@FXML
	private  TableView tableview;
	
	@FXML
	private TextField search ;
	
	
	
	@FXML
	private TableView<Salarié> table;
	
	//table column
	@FXML 
	 private TableColumn<Salarié, Integer> mar;
	
	@FXML 
	 private TableColumn<Salarié, String> nom;
	
	@FXML 
	 private TableColumn<Salarié, String> email;
	
	@FXML 
	 private TableColumn<Salarié, Double> rec;
	
	@FXML 
	 private TableColumn<Salarié, String> cat;
	
	@FXML 
	 private TableColumn<Salarié, Double> salaire;
	
	@FXML 
	 private TableColumn<Salarié, Double> tauxvente;
	
	
	@FXML
	private Button home;
	
	//tauxvente

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		mar.setCellValueFactory(new PropertyValueFactory<>("mar"));
		 nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
		 email.setCellValueFactory(new PropertyValueFactory<>("email"));
		 rec.setCellValueFactory(new PropertyValueFactory<>("rec"));
		
		 salaire.setCellValueFactory(new PropertyValueFactory<>("salaire"));
		 
		 cat.setCellValueFactory(new PropertyValueFactory<>("cat"));
		 
		 tauxvente.setCellValueFactory(new PropertyValueFactory<>("tauxvente"));
		 
	/*	 
		 try {
			 
			 salaries =  as.getJoinSalaryEmploi();
			 
			 for (PayloadSalaré s : salaries)System.out.println(s.getEmail());
			 
			 tableview.setItems(FXCollections.observableArrayList(salaries));
			 
		
		
	}catch(Exception ex) {
		ex.printStackTrace();
	}*/
	}

	  @FXML
	    private void onhome(ActionEvent event) {
		  System.out.print("home");
	    }
	 
}


