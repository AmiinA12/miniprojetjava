package application.controller;



import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import application.entities.Employé;
import application.entities.Salarié;
import application.service.AppService;
import application.service.ApplicationService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class EmployeeController implements Initializable {
	
	
	Salarié  salaries_ = new Salarié();
	AppService AppS = new AppService();
	
	//private ApplicationService as = new ApplicationService();
	List<Integer> salmat = new ArrayList<>();

    @FXML
    private TextField categorie;

    @FXML
    private TextField matricule;

    @FXML
    private TextField phsupp;

    @FXML
    private TextField hsupp;

    @FXML
    private TextField recrt;

    @FXML
    private TextField salaire;

    @FXML
    private ComboBox<Integer> detail;

    @FXML
    private TextField nom;

    @FXML
    private TextField email;

    @FXML
    private Button home;

    @FXML
    void onhome(ActionEvent event) {
    	
    	Main.mudaTela("home");

    }

    
     public void initText()
     {
    		nom.setText("");
        	email.setText("");
        	categorie.setText("");
        	salaire.setText("");
        
        	hsupp.setText(""  );
        
        	phsupp.setText("");
        
        	matricule.setText("");
        	
        	recrt.setText("");
    	 
     }
    
    @FXML
    void ongetdetai(ActionEvent event) {
    	
    	int _idmat = detail.getSelectionModel().getSelectedItem();
    	
    	
    	
    	Employé em = AppS.EmployeDetails(_idmat);
    	initText();
    	
    	nom.setText(em.getNom());
    	email.setText(em.getEmail());
    	categorie.setText(em.getCatgory());
    	salaire.setText(em.getSalaire().toString());
    	Double j = em.getHsupp();
    	hsupp.setText(j.toString()  );
    	Double df_ = em.getPHsupp();
    	phsupp.setText(df_.toString());
    	Integer poi = em.getMatricule();
    	matricule.setText(poi.toString());
    	
    	recrt.setText(em.getRecrutement().toString());
    	

    }

    
    //ongetdetai
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		try {
			
			salmat = AppS.getmatricule();
					
					for(Integer df: salmat) 
						detail.getItems().add(df);
					
				}catch(Exception ex)
				{
					ex.printStackTrace();
				}
				
			}
			
	

}

