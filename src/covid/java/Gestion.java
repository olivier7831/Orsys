package covid.java;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import covid.java.dao.AdminDAO;
import covid.java.dao.CasDAO;
import covid.java.dao.TestPcrDAO;
import covid.java.tests.WrongCovidInputException;
import covid.java.dao.Connecteur;

public class Gestion {
	private static Gestion gestion=null;
	private Connection connectionDAO=null;
	private AdminDAO adminDOA=null;
	private CasDAO casDAO=null;
	private TestPcrDAO testPcrDAO=null;
	private Admin user=null;
	private long id;
	private StringBuilder error;
	
	private Gestion() {
		super();
		connectionDAO = (new Connecteur()).getConnection();
		adminDOA = new AdminDAO(connectionDAO);
		casDAO = new CasDAO(connectionDAO);
		testPcrDAO = new TestPcrDAO(connectionDAO);
		user = new Admin();
		error = new StringBuilder();
	}

	public static Gestion getGestionInstance() {
		if (gestion == null)
			gestion = new Gestion();
		return gestion;
	}

	public AdminDAO getAdminDOA() {
		return adminDOA;
	}

	public CasDAO getCasDAO() {
		return casDAO;
	}

	public TestPcrDAO getTestDAO() {
		return testPcrDAO;
	}

	public Admin getUser() {
		return user;
	}

	public void setUser(Admin user) {
		this.user = user;
	}
	
	public void addCas(Cas cas) throws SQLException {
		casDAO.add(cas);
	}
	
	public void addTestPcr(TestPcr test) throws SQLException {
		testPcrDAO.add(test);
	}
	
	public ArrayList<Cas> getCasList() throws SQLException, WrongCovidInputException {
		ArrayList<Cas> result;
		
		result = casDAO.get();
		ListCas.setList(result);
		return result;
	}
	
	public ArrayList<TestPcr> getTestList() throws SQLException, WrongCovidInputException {
		return testPcrDAO.get();
	}
	
	public ArrayList<TestPcr> getTestListFiltre() throws SQLException, WrongCovidInputException {
		return testPcrDAO.get(id);
	}
	
	public void setCasId(long id) {
		this.id = id;
	}
	
	public void addError(Exception e) {
		error.append(e.getMessage());
	}
	
	public String getError() {
		return error.toString();
	}
}
