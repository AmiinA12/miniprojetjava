package application.entities;

public class Employ� extends Salari� {
	private double Hsupp;
	private double PHsupp ;
	
	public Employ�(int matricule, String nom, String email, Double recrutement, Double salaire, double hsupp,
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
	public Employ�( String nom, String email, Double recrutement, Double salaire
		) {
		super( nom, email, recrutement, salaire);
		
	}
	

	public Employ�(int matricule, String nom, String email, String cat, double anneRecruit, double salaire,
			double hSupp, double pHsupp) {
		super(matricule, nom, email, cat, anneRecruit, salaire);
		Hsupp = hSupp;
		PHsupp = pHsupp;
	}
	public Employ�(int matricule, String nom, String email, Double recrutement, Double salaire) {
		super(matricule, nom, email, recrutement, salaire);
	}
	public Employ�( String nom, String email, Double recrutement,String cat , double hsupp,
			double pHsupp) {
		super( nom, email, recrutement,cat);
		Hsupp = hsupp;
		PHsupp = pHsupp;
	}
	
	public Employ�( String nom, String email, Double recrutement , double hsupp,
			double pHsupp) {
		super( nom, email, recrutement);
		Hsupp = hsupp;
		PHsupp = pHsupp;
	}
	
	
	
	
	

}
