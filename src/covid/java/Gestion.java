package covid.java;

import java.sql.SQLException;
import java.util.ArrayList;

import covid.java.dao.AdminDAO;
import covid.java.dao.CasDAO;
import covid.java.dao.TestPcrDAO;
import covid.java.tests.WrongCovidInputException;

public class Gestion {
	private static Gestion gestion=null;
//	private Connection connectionDAO=null;
	private AdminDAO adminDOA=null;
	private CasDAO casDAO=null;
	private TestPcrDAO testPcrDAO=null;
	private Admin user=null;
	private long id;
	private StringBuilder error;
	
	public Gestion() {
		super();
//		connectionDAO = (new Connecteur()).getConnection();
		adminDOA = new AdminDAO();
		casDAO = new CasDAO();
		testPcrDAO = new TestPcrDAO();
		user = new Admin();
		error = new StringBuilder();
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
	
	public Admin getAdmin(String login) throws SQLException {
		return this.getAdminDOA().getLogin(login);
	}
}
