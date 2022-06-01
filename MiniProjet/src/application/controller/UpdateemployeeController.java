package application.controller;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

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

public class UpdateemployeeController implements Initializable {
	
	Salarié  salaries = new Salarié();
	AppService AppS = new AppService();
	
	private ApplicationService as = new ApplicationService();
	List<Integer> salmat = new ArrayList<>();


    @FXML
    private TextField rect;

    @FXML
    private TextField phsupp;

    @FXML
    private TextField hsupp;
    
    @FXML
    private ComboBox<Integer> matid;


    @FXML
    private Button modifier;

    @FXML
    private Button acce;

    @FXML
    private TextField nom;

    @FXML
    private TextField email;

    @FXML
    void onmodif(ActionEvent event) {
    	
    	if("".equals(nom.getText().toString()))
		{
			JOptionPane.showMessageDialog(null, "data should not null");
		}
		else if("".equals(rect.getText().toString()))
		{
			JOptionPane.showMessageDialog(null, "data should not null");
		}
		
		else if("".equals(email.getText().toString()))
		{
			JOptionPane.showMessageDialog(null, "data should not null");
		}
		
		else  if("".equals(phsupp.getText().toString()))
		{
			JOptionPane.showMessageDialog(null, "data should not null");
		}
    	
		else  if("".equals(hsupp.getText().toString()))
		{
			JOptionPane.showMessageDialog(null, "data should not null");
		}
    	
		else   {
			
			Employé upem = new Employé(nom.getText(),email.getText(),Double.parseDouble( rect.getText() ),Double.parseDouble(hsupp.getText()),Double.parseDouble(phsupp.getText())  );
			
			
			//updateEmploye
			
			int ty  = matid.getSelectionModel().getSelectedItem();
			
			AppS.updateEmploye(upem, ty);
			JOptionPane.showMessageDialog(null, "update");
			
			
		}
    	
    	

    }

    @FXML
    void onacce(ActionEvent event) {
    	Main.mudaTela("home");

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
try {
			
			salmat = AppS.getmatricule();
					
					for(Integer df: salmat) 
						matid.getItems().add(df);
					
				}catch(Exception ex)
				{
					ex.printStackTrace();
				}
				
			}
		
	

}
