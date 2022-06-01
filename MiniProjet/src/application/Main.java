package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	 private static Stage stage;
	 private static Scene Salary;
	 private static Scene addSalary;
	 private static Scene updateSalary;
	 
	 private static  Scene listemploees;
	 
	 
	 private static  Scene listevendors;
	 private static Scene detailsalary;
	 
	 private static Scene detemployee ;
	 
	 
	 private static Scene ventemax;
	 
	 private static Scene deletesal;
	 private static Scene upempl;
	 private static Scene home;
	 //application.controller
	 
	 
	@Override
	public void start(Stage primaryStage) {
		try {
			stage = primaryStage;
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			
			
			Parent salry = FXMLLoader.load(getClass().getResource("salary.fxml"));
			Salary = new Scene(salry,758,564);
			
			
			
			Parent ventm = FXMLLoader.load(getClass().getResource("ventemax.fxml"));
			ventemax = new Scene(ventm,758,564);
			
			
			//ventemax
			
			
			Parent salrydet = FXMLLoader.load(getClass().getResource("detailsalary.fxml"));
			detailsalary = new Scene(salrydet,758,564);
			
			
			
			
			Parent upsalry = FXMLLoader.load(getClass().getResource("updatesalary.fxml"));
			updateSalary = new Scene(upsalry,758,564);
			
			
			//upempl
			Parent upempll = FXMLLoader.load(getClass().getResource("updempl.fxml"));
			upempl = new Scene(upempll,758,564);
			//detemployee
			
			Parent detemployeee = FXMLLoader.load(getClass().getResource("detemployees.fxml"));
			detemployee = new Scene(detemployeee,758,564);
			
			Parent addsalry1 = FXMLLoader.load(getClass().getResource("adds.fxml"));
			addSalary = new Scene(addsalry1,758,564);
			
			Salary.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(addSalary);
			
			Parent listem = FXMLLoader.load(getClass().getResource("listemployees.fxml"));
			listemploees = new Scene(listem,758,564);
			
			Parent listven = FXMLLoader.load(getClass().getResource("listvendeurs.fxml"));
			listevendors = new Scene(listven,758,564);
			//listemploees
			
			//deletesal
			
			Parent saldelk = FXMLLoader.load(getClass().getResource("delsal.fxml"));
			deletesal = new Scene(saldelk,758,564);
			
			
			Parent home_ = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
			home = new Scene(home_,758,564);
			//home
			primaryStage.setScene(home);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	 public static void mudaTela(String tela){
	        switch(tela){

	            case "addsalary":
	                stage.setScene(addSalary);
	                break;
	                
	                
	                //upempl
	                
	            case "upempl":
	                stage.setScene(upempl);
	                break;
	                
	            case "ventemax":
	                stage.setScene(ventemax);
	                break;
	                
	            case "employedet":
	                stage.setScene(detemployee);
	                break;
	                
	            case "listemployees":
	                stage.setScene(listemploees);
	                break;
	                
	            case "listvendores":
	                stage.setScene(listevendors);
	                break;
	                
	            case "updatesalary" :
	                stage.setScene(updateSalary);
	                break;
	               
	                
	                //deletesal
	                
	            case "deletesal":
	                stage.setScene(deletesal);
	                break;  
	            case "home":
	                stage.setScene(home);
	                break;
	        }
	    }
	
	

	
	public static void main(String[] args) {
		launch(args);
	}
}
