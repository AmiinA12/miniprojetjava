package application.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import application.Main;
import application.entities.Salarié;
import application.service.ApplicationService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class UpdateController implements Initializable {
	
	
	private ApplicationService as = new ApplicationService();
	@FXML
    private TextField nom;
	
	@FXML
    private TextField matricule;
    @FXML
    private TextField email;
    @FXML
    private TextField rec;
    @FXML
    private TextField sal;
   
    
    @FXML
    private Button upd;
    
    @FXML 
    private Button annule;
    
    @FXML
    private Button checkupdate;
  

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
   
	@FXML
    private void oncheckupdate(ActionEvent event) throws NumberFormatException, SQLException {
		
		
		
		if(!matricule.getText().toString().equals(""))
			
		{
			
			Salarié fg = as.getSalariéupdate(Integer.parseInt(matricule.getText()));
			
			if(fg.equals(null))
				JOptionPane.showMessageDialog(null, "data should not null");
			else 
			{
				nom.setText(fg.getNom());
				email.setText(fg.getEmail());
				
				
				rec.setText(fg.getRecrutement().toString());
				sal.setText(fg.getSalaire().toString());
				
				
				
				nom.setVisible(true);
				email.setVisible(true);
				rec.setVisible(true);
				sal.setVisible(true);
				
				upd.setDisable(false);
				
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
		
			
		}
		
		
		
		
		
	
		
	}
	
	@FXML
    private void onanulle(ActionEvent event) {
		Main.mudaTela("home");
		//Main.mudaTela("home");
		
	}
	
	
	
	@FXML
    private void onupdate(ActionEvent event) {
		//Main.mudaTela("home");
		//Main.mudaTela("home");
		
		
		  
		  
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
		  
		else {
			Salarié dfup = new Salarié();
			dfup.setNom(nom.getText().toString());
			dfup.setEmail(email.getText().toString());
			dfup.setRecrutement(Double.parseDouble(rec.getText().toString()));
			dfup.setSalaire(Double.parseDouble(sal.getText().toString()));
			dfup.setSalaire(Double.parseDouble(matricule.getText().toString()));
			
			if(!matricule.getText().toString().equals(""))
			{
				
				dfup.setSalaire(Double.parseDouble(matricule.getText().toString()));
				as.update(dfup,Integer.parseInt(matricule.getText().toString()));
			}
			
			else JOptionPane.showMessageDialog(null, "matricule should not null");
		}
		
		 
		
		
	}
}
