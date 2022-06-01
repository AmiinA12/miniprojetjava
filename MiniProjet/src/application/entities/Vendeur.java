package application.entities;

public class Vendeur extends Salarié{
	private double vente ;
	private double pourcentage ;
	public Vendeur(int matricule, String nom, String email, Double recrutement, Double salaire, double vente,
			double pourcentage) {
		super(matricule, nom, email, recrutement, salaire);
		this.vente = vente;
		this.pourcentage = pourcentage;
	}
	public double getVente() {
		return vente;
	}
	public void setVente(double vente) {
		this.vente = vente;
	}
	public double getPourcentage() {
		return pourcentage;
	}
	public void setPourcentage(double pourcentage) {
		this.pourcentage = pourcentage;
	}
	
	public Vendeur(int matricule, String nom, String email, String cat, double anneRecruit, double salaire,
			double vente, double pourcentage) {
		super(matricule, nom, email, cat, anneRecruit, salaire);
		this.vente = vente;
		this.pourcentage = pourcentage;
	}
	
	public Vendeur( String nom, String email, Double recrutement,String cat , double vente_,
			double percent_) {
		super( nom, email, recrutement,cat);
		vente = vente_;
		pourcentage = percent_;
	}

}
