package application.entities;

public class Salarié {
	private int matricule ;
	private String nom ;
	private String email ;
	private Double Recrutement ;
	private Double Salaire ; 
	private String catgory ;
	
	public Salarié(int matricule, String nom, String email, Double recrutement, Double salaire) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.email = email;
		Recrutement = recrutement;
		Salaire = salaire;
	}
	public String getCatgory() {
		return catgory;
	}
	public void setCatgory(String catgory) {
		this.catgory = catgory;
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
	public Salarié(String nom, String email, Double recrutement, Double salaire) {
		super();
		this.nom = nom;
		this.email = email;
		Recrutement = recrutement;
		Salaire = salaire;
	}
	public Salarié(int matricule, String nom, String email, Double recrutement, Double salaire, String catgory) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.email = email;
		Recrutement = recrutement;
		Salaire = salaire;
		this.catgory = catgory;
	}
	public Salarié(String nom, String email, Double recrutement, Double salaire, String catgory) {
		super();
		this.nom = nom;
		this.email = email;
		Recrutement = recrutement;
		Salaire = salaire;
		this.catgory = catgory;
	}
	public Salarié() {
		super();
	}
	
	
	public Salarié(String nom, String email, Double recrutement) {
		super();
		this.nom = nom;
		this.email = email;
		Recrutement = recrutement;
	}
	public Salarié(int matricule, String nom, String email, String cat, Double recrutement, Double salaire) {
		super();
		this.matricule = matricule;
		this.nom = nom;
		this.email = email;
		Recrutement = recrutement;
		Salaire = salaire;
		this.catgory = cat;
		
		Salaire = salaire;
	}
	public Salarié( String nom, String email, Double recrutement, String catgory) {
		super();
	
		this.nom = nom;
		this.email = email;
		Recrutement = recrutement;
		this.catgory = catgory;
	}
	
	

	

}
