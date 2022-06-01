package application.entities;

public class PayloadSalaré {
	
	
	private int matricule ;
	private String nom ;
	private String email ;
	private Double Recrutement ;
	private Double Salaire ; 
	private String catgory ;
	
	private double Hsupp;

	public PayloadSalaré(int matricule, String nom, String email, Double recrutement, Double salaire, String catgory,
			double hsupp) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.email = email;
		Recrutement = recrutement;
		Salaire = salaire;
		this.catgory = catgory;
		Hsupp = hsupp;
		
	}
	public int getMatricule() {
		return matricule;
	}
	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getRecrutement() {
		return Recrutement;
	}
	public void setRecrutement(Double recrutement) {
		Recrutement = recrutement;
	}
	public Double getSalaire() {
		return Salaire;
	}
	public void setSalaire(Double salaire) {
		Salaire = salaire;
	}
	public String getCatgory() {
		return catgory;
	}
	public void setCatgory(String catgory) {
		this.catgory = catgory;
	}
	public double getHsupp() {
		return Hsupp;
	}
	public void setHsupp(double hsupp) {
		Hsupp = hsupp;
	}
	
	public PayloadSalaré() {
		super();
	}
	
	
	
	
	
	

}
