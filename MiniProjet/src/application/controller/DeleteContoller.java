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

public class DeleteContoller implements Initializable {
	
	Salarié  salaries = new Salarié();
	AppService AppS = new AppService();
	
	//Sprivate ApplicationService as = new ApplicationService();
	List<Integer> salmat = new ArrayList<>();

    @FXML
    private ComboBox<Integer> salarie;

    @FXML
    private Button del;
    
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		
try {
			
	salmat = AppS.getmatricule();
			
			for(Integer df: salmat) 
				salarie.getItems().add(df);
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}

    @FXML
    void ondelete(ActionEvent event) {
    	
    	int _io = salarie.getSelectionModel().getSelectedItem()  ;
    	System.out.println(_io);
    	
    boolean bool_ = 	AppS.deleteSalarie(_io);
    
    if(bool_ == true) {
    	
    	JOptionPane.showMessageDialog(null, "delete salarie success");
    	Main.mudaTela("home");
    }
    	
    else  JOptionPane.showMessageDialog(null, "something wrong");
    	
    	
    	

    }

	
	
	
}
