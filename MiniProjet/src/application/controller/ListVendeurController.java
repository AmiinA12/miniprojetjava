package application.controller;



import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import application.entities.Salari�;
import application.service.AppService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListVendeurController implements Initializable {
	
	private List<Salari�> salaries = new ArrayList<>();
	AppService AppS = new AppService();

	@FXML
	private TableView<Salari�> tableview;
    @FXML
    private TableColumn<Salari�, String> categorie;

    @FXML
    private TableColumn<Salari�, Integer> matricule;

    @FXML
    private TableColumn<Salari�, Double> recrutement;

    @FXML
    private TableColumn<Salari�, Double> salaire;

    @FXML
    private Button modif;

    @FXML
    private TableColumn<Salari�, String> nom;

    @FXML
    private Button delete;

    @FXML
    private TableColumn<Salari�, String> email;

    @FXML
    private Button home;

    
    @FXML
    private Button mvente;

    @FXML
    void onhome(ActionEvent event) {
        Main.mudaTela("home");
    }

    
    @FXML
    void onmaxvente(ActionEvent event) {
        Main.mudaTela("ventemax");
    }

    @FXML
    void ondelete(ActionEvent event) {
    	  Main.mudaTela("deletesal");
    	  try {
 			 
 			 salaries =  AppS.listerEmployee();
 			 
 			 for (Salari� s : salaries)System.out.println(s.getCatgory());
 			 
 			 tableview.setItems(FXCollections.observableArrayList(salaries));
 			 
 			 
 			 
 			 
 		 }catch(Exception ex)
 		 {
 			 
 		 }
    }

    @FXML
    void onmodif(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		matricule.setCellValueFactory(new PropertyValueFactory<>("matricule"));
		 nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
		 email.setCellValueFactory(new PropertyValueFactory<>("email"));
		 categorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
		 recrutement.setCellValueFactory(new PropertyValueFactory<>("recrutement"));
		
		 salaire.setCellValueFactory(new PropertyValueFactory<>("salaire"));
		 
		 
		 
		 
		 try {
			 
			 salaries =  AppS.listerVendeur();
			 
			 for (Salari� s : salaries)System.out.println(s.getCatgory());
			 
			 tableview.setItems(FXCollections.observableArrayList(salaries));
			 
			 
			 
			 
		 }catch(Exception ex)
		 {
			 
		 }
		
		
	}

}
