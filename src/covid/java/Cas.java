package covid.java;

import covid.java.tests.WrongCovidInputException;

public class Cas {
	private static long nb_cas=0;
	private long id_cas;
	private String nom_complet;
	private String telephone;
	private String adresse;
	private String code_postale;
	private int etat;
	
	public Cas() {
		id_cas = ++nb_cas;
	}
	
	public Cas(String nom_complet, String code_postale, String adresse, int etat, String telephone) throws WrongCovidInputException {
		id_cas = ++nb_cas;
		this.setNom_complet(nom_complet);
		this.setCode_postale(code_postale);
		this.setTelephone(telephone);
		this.setAdresse(adresse);
		this.setEtat(etat);
	}

	public String getNom_complet() {
		return nom_complet;
	}

	public void setNom_complet(String nom_complet) throws WrongCovidInputException {
		int index = nom_complet.indexOf(" ");
		if (index <= 0 || index >= (nom_complet.length() - 1)) {
			throw new WrongCovidInputException("Le nom complet doit contenir un espace entre nom et prénom");
		}
		this.nom_complet = nom_complet;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) throws WrongCovidInputException {
		if (telephone.length() < 8) {
			throw new WrongCovidInputException("Le téléphone est de longueur minimale 8");
		}
		if (!telephone.substring(0, 2).equals("00") && !telephone.substring(0, 1).equals("+")) {
			throw new WrongCovidInputException("Le téléphone commence par + ou 00");
		}
		if (telephone.indexOf(" ") != -1) {
			throw new WrongCovidInputException("Le téléphone ne contient pas d'espaces");
		}
		this.telephone = telephone;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) throws WrongCovidInputException {
		if (adresse.length() < 8) {
			throw new WrongCovidInputException("L'adresse est de longueur 8 minimum");
		}
		this.adresse = adresse;
	}

	public String getCode_postale() {
		return code_postale;
	}

	public void setCode_postale(String code_postale) throws WrongCovidInputException, NumberFormatException {
		if (code_postale.length() != 5) {
			throw new WrongCovidInputException("Le code postale doit être de longueur 5");
		}
		Integer.parseInt(code_postale);
		this.code_postale = code_postale;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) throws WrongCovidInputException {
		if (etat != -1 && etat != 1) {
			throw new WrongCovidInputException("L'état est un, entier (1- ou 1)");
		}
		this.etat = etat;
	}

	public long getId_cas() {
		return id_cas;
	}
	
	public void setId_cas(long id) {
		this.id_cas = id;
	}

	@Override
	public String toString() {
		return "Cas [id_cas=" + id_cas + ", nom_complet=" + nom_complet + ", telephone=" + telephone + ", adresse="
				+ adresse + ", code_postale=" + code_postale + ", etat=" + etat + "]";
	}
		
}
