package application.entities;

public class Employé extends Salarié {
	private double Hsupp;
	private double PHsupp ;
	
	public Employé(int matricule, String nom, String email, Double recrutement, Double salaire, double hsupp,
			double pHsupp) {
		super(matricule, nom, email, recrutement, salaire);
		Hsupp = hsupp;
		PHsupp = pHsupp;
	}
	public double getHsupp() {
		return Hsupp;
	}
	public void setHsupp(double hsupp) {
		Hsupp = hsupp;
	}
	public double getPHsupp() {
		return PHsupp;
	}
	public void setPHsupp(double pHsupp) {
		PHsupp = pHsupp;
	}
	public Employé( String nom, String email, Double recrutement, Double salaire
		) {
		super( nom, email, recrutement, salaire);
		
	}
	

	public Employé(int matricule, String nom, String email, String cat, double anneRecruit, double salaire,
			double hSupp, double pHsupp) {
		super(matricule, nom, email, cat, anneRecruit, salaire);
		Hsupp = hSupp;
		PHsupp = pHsupp;
	}
	public Employé(int matricule, String nom, String email, Double recrutement, Double salaire) {
		super(matricule, nom, email, recrutement, salaire);
	}
	public Employé( String nom, String email, Double recrutement,String cat , double hsupp,
			double pHsupp) {
		super( nom, email, recrutement,cat);
		Hsupp = hsupp;
		PHsupp = pHsupp;
	}
	
	public Employé( String nom, String email, Double recrutement , double hsupp,
			double pHsupp) {
		super( nom, email, recrutement);
		Hsupp = hsupp;
		PHsupp = pHsupp;
	}
	
	
	
	
	

}
