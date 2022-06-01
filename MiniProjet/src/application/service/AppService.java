package application.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import application.connexion.connexion;
import application.entities.Employé;
import application.entities.Salarié;
import application.entities.Vendeur;

public class AppService {

	public boolean createEmployee(Employé E) {
		try {
			
			Statement stmt = connexion.getConx().createStatement();
			
	
			
			if (E.getRecrutement() < 2005)
				E.setSalaire(400.0);
			else
				E.setSalaire(280.0);
			String reqSalarie = "Insert into salarie(matricule,nom,email,	anneRecruit,salaire,categorie,	idEntreprise)  values(" + E.getMatricule() + ",'" + E.getNom() + "','"
					+ E.getEmail() + "'," + E.getRecrutement() + "," + E.getSalaire() + ",'Employee'" + ",'1');";
			if (stmt.executeUpdate(reqSalarie) == 1) {
				String reqEmployee = "Insert into employee(Matricule,HSupp,	PHSupp) values (" + E.getMatricule() + "," + E.getHsupp() + ","
						+ E.getPHsupp() + ");";
				if (stmt.executeUpdate(reqEmployee) == 1) {
					return true;
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Erreur SQL");
		}
		return false;
	}

	public boolean createVendeur(Vendeur V) {
		try {
			Statement stmt = connexion.getConx().createStatement();
			if (V.getRecrutement() < 2005)
				V.setSalaire(400.0);
			else
				V.setSalaire(280.0);
			String reqSalarie = "Insert into salarie(matricule,nom,email,	anneRecruit,salaire,categorie,	idEntreprise)  values(" + V.getMatricule() + ",'" + V.getNom() + "','"
					+ V.getEmail() + "'," + V.getRecrutement() + "," + V.getSalaire() + ",'Vendeur'"+ ",'1');";
			if (stmt.executeUpdate(reqSalarie) == 1) {
				String reqEmployee = "Insert into vendeur(Matricule,Vente,	Pourcentage) values (" + V.getMatricule() + "," + V.getVente() + ","
						+ V.getPourcentage() + ");";
				if (stmt.executeUpdate(reqEmployee) == 1) {
					return true;
				}
			}

		} catch (SQLException ex) {
			System.out.println("Erreur SQL" + ex);
		}
		return false;
	}

	public List<Salarié> listerEmployee() {
		List<Salarié> employés = new ArrayList<>();
		try {
			String reqE = "SELECT s.matricule, nom, email, categorie, anneRecruit, salaire + HSupp * PHSupp   from salarie s, employee e where s.matricule = e.Matricule;";
			Statement stmt = connexion.getConx().createStatement();
			ResultSet rsE = stmt.executeQuery(reqE);

			while (rsE.next()) {
				employés.add(new Salarié(rsE.getInt(1), rsE.getString(2), rsE.getString(3), rsE.getString(4),
						rsE.getDouble(5), rsE.getDouble(6)));
			}
			return employés;

		} catch (SQLException ex) {
			System.out.println("Erreur SQL" + ex);
		}
		return null;
	}

	public List<Salarié> listerVendeur() {
		List<Salarié> vdrs = new ArrayList<>();
		try {
			String reqV = "SELECT s.matricule, nom, email, anneRecruit, salaire + vente * pourcentage , categorie from salarie s, vendeur v where s.matricule = v.Matricule;";
			Statement stmt = connexion.getConx().createStatement();
			ResultSet rsE = stmt.executeQuery(reqV);
			while (rsE.next()) {
				vdrs.add(new Salarié(rsE.getInt(1), rsE.getString(2), rsE.getString(3), rsE.getString(6),
						rsE.getDouble(4), rsE.getDouble(5)));
			}
			return vdrs;
		} catch (SQLException ex) {
			System.out.println("Erreur SQL" + ex);
		}
		return null;

	}

	public Employé EmployeDetails(int matriculeId) {

		try {
			String req = "SELECT s.matricule, nom, email, anneRecruit,salaire + HSupp * PHSupp ,  HSupp, PHSupp, categorie  from employee e, salarie s where e.Matricule = s.matricule and e.Matricule ="
					+ matriculeId;
			Statement stmt = connexion.getConx().createStatement();
			ResultSet rs = stmt.executeQuery(req);

			if (rs.next())
				return new Employé(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(8), rs.getDouble(4),
						rs.getDouble(5), rs.getDouble(6), rs.getDouble(7));

		} catch (SQLException ex) {
			System.out.println("Erreur SQL " + ex);
		}
		return null;
	}
	
	public List<Integer>  getmatricule() throws SQLException
	{
		
	
			 ResultSet response = null;
			String reqEt = "select matricule  from salarie where categorie='Employee' ";
			List<Integer>  gf = new ArrayList<>();
			
			 Statement sessao = connexion.getConx().createStatement();
			    response = sessao.executeQuery(reqEt);
			  
			    while(response.next()){
			    	Integer  cat =response.getInt("matricule");
			    	gf.add(cat);
			    }
			    return gf;
			
		
		
	}

	public Vendeur VendeurDetails(int vdrmatricule) {
		try {
			String req = "SELECT s.matricule, nom, email, anneRecruit,salaire + Vente * Pourcentage, Vente, Pourcentage, categorie from vendeur v, salarie s where v.Matricule = s.matricule and  v.Matricule ="
					+ vdrmatricule;
			Statement stmt = connexion.getConx().createStatement();
			ResultSet rs = stmt.executeQuery(req);

			if (rs.next()) {
				return new Vendeur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(8), rs.getDouble(4),
						rs.getDouble(5), rs.getDouble(6), rs.getDouble(7));
			}

		} catch (SQLException ex) {
			System.out.println("Erreur SQL " + ex);
		}
		return null;
	}

	public boolean deleteSalarie(int empmatricule) {
		try {
			String req = "Delete from salarie where matricule =" + empmatricule;
			Statement stmt = connexion.getConx().createStatement();
			if (stmt.executeUpdate(req) == 1) {
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("SQL EXCEPTION");
		}
		return false;
	}

	public static  Salarié getSalarie(int matricule) {
		try {
			String reqRole = "Select categorie from salarie where matricule = " + matricule;
			Statement stmt = connexion.getConx().createStatement();
			ResultSet rs = stmt.executeQuery(reqRole);
			if (rs.next()) {
				if (rs.getString(1).equals("Vendeur")) {
					String req = "Select s.matricule, nom, email, categorie, anneRecruit,(salaire + Vente * Pourcentage) from salarie s, vendeur v where s.matricule = v.Matricule and s.matricule = "
							+ matricule;
					ResultSet rsv = stmt.executeQuery(req);
					if (rsv.next())
						return new Salarié(rsv.getInt(1), rsv.getString(2), rsv.getString(3), rsv.getString(4),
								rsv.getDouble(5), rsv.getDouble(6));
				} else {
					String req = "Select s.matricule, nom, email, categorie, anneRecruit,(salaire + HSupp * PHSupp) from salarie s, employee v where s.matricule = v.Matricule and s.matricule = "
							+ matricule;
					ResultSet rsv = stmt.executeQuery(req);
					if (rsv.next())
						return new Salarié(rsv.getInt(1), rsv.getString(2), rsv.getString(3), rsv.getString(4),
								rsv.getDouble(5), rsv.getDouble(6));
				}
			}
		} catch (SQLException ex) {
			System.out.println("SQL ERROR" + ex);
		}
		return null;
	}

	public void updateVendeur(Vendeur v) {
		try {
			String req = "update salarie set matricule=" + v.getMatricule() + ",nom='" + v.getNom() + "', email='"
					+ v.getEmail() + "', anneRecruit=" + v.getRecrutement() + " where matricule=" + v.getMatricule();
			Statement stmt = connexion.getConx().createStatement();
			if (stmt.executeUpdate(req) == 1) {
				System.out.println("Salarie Updated");
			}
			String req1 = "update vendeur set  Matricule=" + v.getMatricule() + ", Pourcentage=" + v.getPourcentage()
					+ ",Vente=" + v.getVente() + " where Matricule=" + v.getMatricule();

			if (stmt.executeUpdate(req1) == 1) {
				System.out.println("Vendeur Updated");
			}
		} catch (SQLException ex) {
			System.out.println("SQL ERROR" + ex);
		}
	}

	public void updateEmploye(Employé e,int matid) {
		try {
			String req = "update salarie set nom='" + e.getNom() + "', email='"
					+ e.getEmail() + "', anneRecruit=" + e.getRecrutement() + " where matricule=" +matid;
			Statement stmt = connexion.getConx().createStatement();
			if (stmt.executeUpdate(req) == 1) {
				System.out.println("Salarie Updated");
			}
			String req1 = "update employee set   PHSupp=" + e.getPHsupp() + ",HSupp="
					+ e.getPHsupp() + " where Matricule=" + matid;

			if (stmt.executeUpdate(req1) == 1) {
				System.out.println("Employe Updated");
			}
		} catch (SQLException ex) {
			System.out.println("SQL ERROR" + ex);
		}

	}

	
	
	public static  List<Salarié> getMinSalarie ()
	{
		
		try {
			String req = "Select s.matricule, nom, email, categorie, anneRecruit,(salaire + Vente * Pourcentage) from salarie s, vendeur v where s.matricule = v.Matricule ORDER by (salaire + Vente * Pourcentage) Asc;";
			Statement stmt = connexion.getConx().createStatement();
			ResultSet rsv = stmt.executeQuery(req);
			//rsv.next();
			List<Salarié> lstsal = new ArrayList<>();
			while(rsv.next())
			{
				Salarié sl =  new Salarié(rsv.getInt(1), rsv.getString(2), rsv.getString(3), rsv.getString(4),
							rsv.getDouble(5), rsv.getDouble(6));
				lstsal.add(sl);
				
			}
				return lstsal;
			
			
		}catch(Exception  ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
	public List<Salarié> getMaxVente() {
		try {
			String req = "Select s.matricule, nom, email, categorie, anneRecruit,(salaire + Vente * Pourcentage) from salarie s, vendeur v where s.matricule = v.Matricule ORDER by (salaire + Vente * Pourcentage) desc;";
			Statement stmt = connexion.getConx().createStatement();
			ResultSet rsv = stmt.executeQuery(req);
			List<Salarié> lstsal = new ArrayList<>();
			while(rsv.next()) {
			Salarié sl = 	new Salarié(rsv.getInt(1), rsv.getString(2), rsv.getString(3), rsv.getString(4),
						rsv.getDouble(5), rsv.getDouble(6));
			lstsal.add(sl);
			}
				return lstsal; 
		}catch(SQLException ex) {
			System.out.println(ex);
		}
		return null;
	}

//	public static void main(String Args[]) {
//		AppService AppS = new AppService();
//		// AppS.createEmployee(new Employé(103, "Amina3", "Amina3@email.com",2012.0,0.0, 552.0, 50));
//		// AppS.createVendeur(new Vendeur(105, "Amina", "Amina@email.com", "V", 2007, 0, 432, 0.5));
//		// List<Salarié> emps = AppS.listerEmployee();
//		 //for (Salarié e : emps)
//		 //System.out.println(e.getSalaire());
//
//		
//		 //List<Salarié> emps = AppS.listerVendeur();
//			//	 for (Salarié e : emps)
//				// System.out.println(e.getSalaire());
//
//		//List<Salarié> vdrs = AppS.getSalariesMinMax(600.0, 800.0);
//		//for (Salarié v : vdrs)
//			//System.out.println(v.getSalaire());
//
//		//Employé emp = AppS.EmployeDetails(102);
//		//System.out.println(emp.getEmail());
//
//		
//		//Salarié gh =getSalarie(105);
//		//System.out.println(gh.getCatgory());
//		
//		//AppS.updateEmploye(new Employé(102, "Amina2", "Amina2@email.com",2012.0,0.0, 32.0, 20));
//		//List<Salarié> fg = getMinSalarie();
//		
//		//for (Salarié fg_ : fg ) System.out.println(fg_.getSalaire());
//		
//		// Vendeur vdr = AppS.VendeurDetails(105);
//		AppS.getMaxVente().forEach(er -> System.out.println( er.getSalaire()) );
//
//		// AS.deleteSalarie(101);
//	}
}
