package application.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import application.Main;
import application.entities.Salarié;
import application.service.AppService;
import application.service.ApplicationService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class AddSalaryController implements Initializable {
	
	Salarié  salarie = new Salarié();
	AppService AppS = new AppService();
	
	private ApplicationService as = new ApplicationService();
	List<String> enterprises = new ArrayList<>();
	@FXML
    private TextField nom;
    @FXML
    private TextField email;
    @FXML
    private TextField rec;
    @FXML
    private TextField sal;
    @FXML
    private ComboBox<String> cat;
  
    
    @FXML
    private ComboBox<String> nomEnt;
    @FXML
    private Button ajouté;
    
    @FXML
    private Button annulé;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		cat.getItems().addAll("Vendeur","mployee");
		
		
		
		try {
			
			enterprises = as.getEnterprise();
			
			for(String df: enterprises) 
				nomEnt.getItems().add(df);
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	
	
	
	@FXML
    private void onajout(ActionEvent event) {
		
		if("".equals(nom.getText().toString()))
		{
			JOptionPane.showMessageDialog(null, "data should not null");
		}
		
		else if("".equals(email.getText().toString()))
		{
			JOptionPane.showMessageDialog(null, "data should not null");
		}
		
		else  if("".equals(rec.getText().toString()))
		{
			JOptionPane.showMessageDialog(null, "data should not null");
		}
		else if("".equals(sal.getText().toString()))
		{
			JOptionPane.showMessageDialog(null, "data should not null");
		}
		
		  else if (cat.getSelectionModel().getSelectedItem() == null){
        JOptionPane.showMessageDialog(null, "Sselected a categoryid!"); 
      }
		
		  else if (nomEnt.getSelectionModel().getSelectedItem() == null){
		        JOptionPane.showMessageDialog(null, "Sselected a categoryid!"); 
		      }
		else {
			
			salarie.setNom(nom.getText().toString());
			salarie.setEmail(email.getText().toString());
			salarie.setRecrutement(Double.parseDouble(rec.getText().toString()));
			salarie.setSalaire(Double.parseDouble(sal.getText().toString()));
			
			 String  cv_id = cat.getSelectionModel().getSelectedItem().toString();
			 
			 
			 String  ent_item = nomEnt.getSelectionModel().getSelectedItem().toString();
			salarie.setCatgory(cv_id);
			 
			 
			 
		}
	  
		
	}
	
	@FXML
    private void onannulle(ActionEvent event) {
		Main.mudaTela("home");
		
	}
	
	
	

}
