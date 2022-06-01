package application.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import application.Main;
import application.entities.Employé;
import application.entities.Vendeur;
import application.service.AppService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddController implements Initializable {
	
	AppService AppS = new AppService();
	Employé emp ;
	Vendeur ven;

    @FXML
    private TextField hsupp;

    @FXML
    private TextField matricule;

    @FXML
    private TextField nom;

    @FXML
    private TextField percent;

    @FXML
    private TextField rec;

    @FXML
    private Button ajouté;

    @FXML
    private TextField phsupp;

    @FXML
    private Button annulé;

    @FXML
    private ComboBox<String> cat;

    @FXML
    private Label phsupplabel;

    @FXML
    private Label percentlabel;

    @FXML
    private TextField email;

    @FXML
    private TextField vente;

    @FXML
    private Label hsupplabel;

    @FXML
    private Label ventlabel;

   
    String  cv_id;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		cat.getItems().addAll("Vendeur","Employee");
		
		
		
		
	}
	
	public void empPHSupp() {
		File inputFile = new File("C:\\fichiers\\employee.txt");
		FileReader fr;
		BufferedReader br;
		String PHSupp="";
		try {
		
			fr =  new FileReader(inputFile);
			br = new BufferedReader(fr);
			String s;
			boolean ok = false;
			while((s=br.readLine())!=null) {
				String [] fileData = s.split(" ");
				if (fileData [0].equals("PHSupp")) {
					PHSupp=fileData[1];
				}
			}
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		phsupp.setText(PHSupp);

	}
	public void vendPourcentage() {
		File inputFile = new File("C:\\fichiers\\employee.txt");
		FileReader fr;
		BufferedReader br;
		String pourcentage="";
		try {
		
			fr =  new FileReader(inputFile);
			br = new BufferedReader(fr);
			String s;
			boolean ok = false;
			while((s=br.readLine())!=null) {
				String [] fileData = s.split(" ");
				if (fileData [0].equals("pourcentage")) {
					pourcentage=fileData[1];
				}
			}
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		phsupp.setText(pourcentage);

	}
	
	
	@FXML
    private void onajout(ActionEvent event) {
		
		if("".equals(nom.getText().toString()))
		{
			JOptionPane.showMessageDialog(null, "data should not null");
		}
		else if("".equals(matricule.getText().toString()))
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
		
		
		  else if (cat.getSelectionModel().getSelectedItem() == null){
        JOptionPane.showMessageDialog(null, "Selected a categoryid!"); 
      }
		
		  
		else {
			
			String nom1 = nom.getText().toString();
			String email1 = email.getText().toString();
			Double rec1 = Double.parseDouble(rec.getText().toString());
			
			
			 String  cv_id = cat.getSelectionModel().getSelectedItem().toString();
			 System.out.println("okkk");
			 System.out.println(cv_id);
			 
			 if (cv_id.toLowerCase().equals("employee"))
			 {
				 
//				 phsupp.setVisible(true);
//				 hsupp.setVisible(true);
//				 phsupplabel.setVisible(true);
//				 hsupplabel.setVisible(true);
				 
				 if("".equals(phsupp.getText().toString()))
					{
						JOptionPane.showMessageDialog(null, "data should not null");
					}
					
					else if("".equals(hsupp.getText().toString()))
					{
						JOptionPane.showMessageDialog(null, "data should not null");
					}
				 
				 
					else  {
						
						 Double phsupp_ = Double.parseDouble(phsupp.getText().toString());
						 Double  hsupp_= Double.parseDouble(hsupp.getText().toString());
						 String mat_ = matricule.getText().toString();
						 int matricule_ = Integer.parseInt(mat_);
						 emp = new Employé(nom1, email1, rec1,cv_id, hsupp_,phsupp_);
						 emp.setMatricule(matricule_);
						 AppS.createEmployee(emp);
						 JOptionPane.showMessageDialog(null, "employee ajouter");
						 
					}
				 
				 
				 
			 }else  {
				 
				/* vente.setVisible(true);
				 percent.setVisible(true);
				 ventlabel.setVisible(true);
				 percentlabel.setVisible(true);*/
				 
				 if("".equals(vente.getText().toString()))
					{
						JOptionPane.showMessageDialog(null, "data should not null");
					}
					
					else if("".equals(percent.getText().toString()))
					{
						JOptionPane.showMessageDialog(null, "data should not null");
					}
				 
				 
					else  {
						
						 Double vente_ = Double.parseDouble(vente.getText().toString());
						 Double  perc_= Double.parseDouble(percent.getText().toString());
						 
						 ven = new Vendeur(nom1, email1, rec1, cv_id, vente_, perc_);
						 String mat_ = matricule.getText().toString();
						 int matricule_ = Integer.parseInt(mat_);
						 ven.setMatricule(matricule_);
						 AppS.createVendeur(ven);
						 JOptionPane.showMessageDialog(null, "vendeur ajouter ");
				 
				 
			           }
			 
			 
//			 String  ent_item = nomEnt.getSelectionModel().getSelectedItem().toString();
//			salarie.setCatgory(cv_id);
//			AppS.createEmployee(salarie);
			 
			 
		//}
			 }
		}
		
	}
	
	@FXML
    private void onannulle(ActionEvent event) {
		Main.mudaTela("home");
		
	}

	
	@FXML
	
	private void onchosse(ActionEvent event)
	{
		
		System.out.println(cat.getSelectionModel().getSelectedItem());
		
		
		if(!cat.getSelectionModel().isEmpty() )
		{
			cv_id = cat.getSelectionModel().getSelectedItem().toString();
			 System.out.println("okkk");
			 System.out.println(cv_id);
			 
			 if (cv_id.toLowerCase().equals("employee"))
			 {
				 
				 phsupp.setVisible(true);
				 hsupp.setVisible(true);
				 phsupplabel.setVisible(true);
				 hsupplabel.setVisible(true);
			 }
			 else  {
				 
				 vente.setVisible(true);
				 percent.setVisible(true);
				 ventlabel.setVisible(true);
				 percentlabel.setVisible(true);
			 }
		}
	}
}
