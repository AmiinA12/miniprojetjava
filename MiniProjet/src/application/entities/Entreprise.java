package application.entities;

import java.util.HashMap;

public class Entreprise {
	private String nomE;
	private HashMap<Integer,Salarié> liste_salariee;
	public Entreprise(String nomE) {
		super();
		this.nomE = nomE;
		
	}
	public String getNomE() {
		return nomE;
	}
	public void setNomE(String nomE) {
		this.nomE = nomE;
	}
	public HashMap<Integer, Salarié> getListe_salariee() {
		return liste_salariee;
	}
	public void setListe_salariee(HashMap<Integer, Salarié> liste_salariee) {
		this.liste_salariee = liste_salariee;
	}
	@Override
	public String toString() {
		return "Entreprise [nomE=" + nomE + ", liste_salariee=" + liste_salariee + "]";
	}
	

}
