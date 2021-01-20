package covid.java;

import covid.java.tests.WrongCovidInputException;

public class TestPcr {
	private long id_testpcr;
	private int jour;
	private int mois;
	private int annee;
	private long id_teste;
	private int resultat;
	
	public TestPcr(int jour, int mois, int annee, long id_teste, int resultat) throws WrongCovidInputException {
		super();
		if (!ValideDate.isValide(jour, mois, annee))
			throw new WrongCovidInputException("Wrong date format");
		if (resultat != 1 && resultat !=-1)
			throw new WrongCovidInputException("Resultat est un entier (-1 ou 1)");
		if (!ListCas.checkID(id_teste)) {
			throw new WrongCovidInputException("id_teste n'existe pas");
		}
		this.jour = jour;
		this.mois = mois;
		this.annee = annee;
		this.id_teste = id_teste;
		this.resultat = resultat;
	}

	public int getJour() {
		return jour;
	}

	public int getMois() {
		return mois;
	}

	public int getAnnee() {
		return annee;
	}

	public long getId_teste() {
		return id_teste;
	}

	public int getResultat() {
		return resultat;
	}
	
	public void setId_testpcr(long id) {
		this.id_testpcr = id;
	}

	
	
	public long getId_testpcr() {
		return id_testpcr;
	}

	@Override
	public String toString() {
		return "TestPcr [jour=" + jour + ", mois=" + mois + ", annee=" + annee + ", id_teste=" + id_teste
				+ ", resultat=" + resultat + "]";
	}
	
}
