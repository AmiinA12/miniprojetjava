package application.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import application.connexion.connexion;
import application.entities.Employ�;
//import application.entities.PayloadSalar�;
import application.entities.Salari�;



public class ApplicationService {
	
	
	private List<Salari�>  salaries   = new ArrayList<>();
	
	
	public void createEmployee(Employ� E, String nomEnt) {
		try {
			String reqEt = "select idEntreprise from entreprise where nom = '" + nomEnt + "';";
			Statement stmt = connexion.getConx().createStatement();
			ResultSet rs = stmt.executeQuery(reqEt);
			rs.next();
			if(E.getRecrutement()< 2005) 
				E.setSalaire(400.0);
			else 
				E.setSalaire(280.0);
//			String reqSalarie = "Insert into salari� values(" + E.getMatricule() + ",'" + E.getNom() + "','"
//					+ E.getEmail() + "'," + E.getRecrutement() + "," + E.getSalaire() + "," + rs.getInt(1) + ")";
//			if(stmt.executeUpdate(reqSalarie) == 1) {
//				System.out.println("Insertion a Salari� a �t� effectuer !");
//			}
			String reqEmployee = "Insert into Employ� values ("+E.getMatricule()+","+E.getHsupp()+","+E.getPHsupp()+");";
			if(stmt.executeUpdate(reqEmployee) == 1) {
				System.out.println("Insertion a Employee  a �t� effectuer !");
			}
		} catch (SQLException ex) {
			System.out.println("Erreur SQL"+ex);
		}
	}
	
	
	public List<String>  getEnterprise() throws SQLException
	{
		
	
			 ResultSet response = null;
			String reqEt = "select nom from entreprise ";
			List<String>  gf = new ArrayList<>();
			
			 Statement sessao = connexion.getConx().createStatement();
			    response = sessao.executeQuery(reqEt);
			  
			    while(response.next()){
			    	String cat =response.getString("nom");
			    	gf.add(cat);
			    }
			    return gf;
			
		
		
	}
	
	public void createSalarieemp(Salari� E, String nomEnt) {
		try {
			String reqEt = "select idEntreprise from entreprise where nom = '" + nomEnt + "';";
			Statement stmt = connexion.getConx().createStatement();
			ResultSet rs = stmt.executeQuery(reqEt);
			rs.next();
			if(E.getRecrutement()< 2005) 
				E.setSalaire(400.0);
			else 
				E.setSalaire(280.0);
			//+ E.getMatricule() + ",'"
			String reqSalarie = "Insert into salari� values("  + E.getNom() + "','"
					+ E.getEmail() + "'," + E.getRecrutement() + "," + E.getSalaire() + ","  + rs.getInt(1)+ ","+ E.getCatgory() + ")";
			if(stmt.executeUpdate(reqSalarie) == 1) {
				System.out.println("Insertion a Salari� a �t� effectuer !");
			}
//			String reqEmployee = "Insert into Employ� values ("+E.getMatricule()+","+E.getHsupp()+","+E.getPHsupp()+");";
//			if(stmt.executeUpdate(reqEmployee) == 1) {
//				System.out.println("Insertion a Employee  a �t� effectuer !");
//			}
		} catch (SQLException ex) {
			System.out.println("Erreur SQL"+ex);
		}
	}
	
	public  void update(Salari� s,int id) {
		
	        try {
	        	String reqEt=("update salari� set  nom =? ,email=?,Recrutement=?,Salaire=?,where matricule = ?");
	        	PreparedStatement stmt = connexion.getConx().prepareStatement(reqEt);
	        	
	        	//System.out.println(stmt.executeUpdate(reqEt));
	        	
	        	if (stmt.executeUpdate(reqEt) == 1) {
	        	
	        		
	        		stmt.setString(1, s.getNom());
	        		stmt.setString(2, s.getEmail());
	        	 	stmt.setDouble(3, s.getRecrutement());
	        		stmt.setDouble(4, s.getSalaire());
	        		stmt.setInt(5, s.getMatricule());
	        	}
	        	
	        	else {
	        		System.out.println("not passed");
	        	}
	        	  
	                
	        } catch (SQLException ex) {
	            System.out.println("Erreur");
	        }
	        
	    }
	
	
	
	
	
	
  public Salari�  getSalari�update(int id) throws SQLException
  {
	  ResultSet response = null;
	  Salari� cat = null;
	   String sql = "select * from salari� where matricule = '" + id + "';";
	    
	    
	 
	   
	    Statement sessao = connexion.getConx().createStatement();
	    response = sessao.executeQuery(sql);
	
	       response.next();
	    	cat = new Salari�(response.getInt("matricule"), response.getString("nom"),response.getString("email"),
	    			response.getDouble("Recrutement"),response.getDouble("salaire"),response.getString("category")
	    			
	    			);
	    	
	    
	    return cat;
  }
	
	public List<Salari�> getAllSalaries() throws SQLException, ClassNotFoundException{
	    ResultSet response = null;
	   
	    String sql = "SELECT * FROM salari�;";
	    
	    
	 
	   
	    Statement sessao = connexion.getConx().createStatement();
	    response = sessao.executeQuery(sql);
	    List<Salari�> salarys = new ArrayList<>();
	    while(response.next()){
	    	Salari� cat = new Salari�(response.getInt("matricule"), response.getString("nom"),response.getString("email"),
	    			response.getDouble("Recrutement"),response.getDouble("salaire"),response.getString("category")
	    			
	    			);
	    	salarys.add(cat);
	    }
	    return salarys;
	}

	
	
		    
		    
	}

		
//select  * from salari� s INNER join employ� e where s.matricule = e.matricule 

//	public static void main(String Args[]) throws SQLException {
//		
//		ApplicationService AS=new ApplicationService();
//		//AS.createEntreprise(new Entreprise ("Entrp2"));
//		//AS.createEmployee(new Employ�(18, "EmployeeName", "email@email.com", 2012.0, 420.0, 10, 20), "Entrp2");
//		//AS.update(new  Employ�("EmployeeName22", "email12@email.com", 2012.0, 420.0),18);
//		Salari� df = AS.getSalari�update(18);
//		
//		List<PayloadSalar�> hj=  AS.getJoinSalaryEmploi();
//		
//		for (PayloadSalar� p  : hj)
//		{
//			System.out.println(p.getEmail());
//			
//			System.out.println(p.getHsupp());
//			System.out.println(p.getSalaire());
//			
//			
//		}
//		
//		
//		System.out.println(df.getEmail());
//	}



