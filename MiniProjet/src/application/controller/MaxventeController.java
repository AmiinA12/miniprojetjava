package application.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import application.entities.Salarié;
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
	
	
	private List<Salarié> salaries = new ArrayList<>();
	AppService AppS = new AppService();


    @FXML
    private TableColumn<Salarié, Integer> mat;

    @FXML
    private TableColumn<Salarié, String> categorie;

    @FXML
    private TableColumn<Salarié, Double> recrt;

    @FXML
    private TableView<Salarié> tableview;

    @FXML
    private TableColumn<Salarié, Double> salaire;

    @FXML
    private TableColumn<Salarié, String> nom;

    @FXML
    private TableColumn<Salarié, String> email;

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
			 
			 for (Salarié s : salaries)System.out.println(s.getCatgory());
			 
			 tableview.setItems(FXCollections.observableArrayList(salaries));
			 
			 
			 
			 
		 }catch(Exception ex)
		 {
			 
		 }
		
		
	}

}

