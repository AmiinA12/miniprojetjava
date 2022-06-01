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

public class MaxventeController implements Initializable {
	
	
	private List<Salari�> salaries = new ArrayList<>();
	AppService AppS = new AppService();


    @FXML
    private TableColumn<Salari�, Integer> mat;

    @FXML
    private TableColumn<Salari�, String> categorie;

    @FXML
    private TableColumn<Salari�, Double> recrt;

    @FXML
    private TableView<Salari�> tableview;

    @FXML
    private TableColumn<Salari�, Double> salaire;

    @FXML
    private TableColumn<Salari�, String> nom;

    @FXML
    private TableColumn<Salari�, String> email;

    @FXML
    private Button home;

   

    @FXML
    void onhome(ActionEvent event) {
    	
    	Main.mudaTela("home");

    }



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		mat.setCellValueFactory(new PropertyValueFactory<>("mat"));
		 nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
		 email.setCellValueFactory(new PropertyValueFactory<>("email"));
		 categorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
		 recrt.setCellValueFactory(new PropertyValueFactory<>("recrt"));
		
		 salaire.setCellValueFactory(new PropertyValueFactory<>("salaire"));
		 
		 
		 
		 
		 try {
			 
			 salaries =  AppS.getMaxVente();
			 
			 for (Salari� s : salaries)System.out.println(s.getCatgory());
			 
			 tableview.setItems(FXCollections.observableArrayList(salaries));
			 
			 
			 
			 
		 }catch(Exception ex)
		 {
			 
		 }
		
		
	}

}

