package covid.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import covid.java.Cas;
import covid.java.TestPcr;
import covid.java.tests.WrongCovidInputException;

public class TestPcrDAO extends DAO<TestPcr> {

	public TestPcrDAO() {
		super();
	}

	@Override
	public void add(TestPcr test) throws SQLException {
		Connection connection = (new Connecteur()).getConnection();
		
		PreparedStatement prst = connection.prepareStatement("INSERT INTO testpcr(jour, mois, annee, resultat, id_cas) VALUES (?, ?, ?, ?, ?)");
		prst.setInt(1, test.getJour());
		prst.setInt(2, test.getMois());
		prst.setInt(3, test.getAnnee());
		prst.setInt(4, test.getResultat());
		prst.setLong(5, test.getId_teste());
		prst.executeUpdate();
		
	}

	@Override
	public ArrayList<TestPcr> get() throws SQLException, WrongCovidInputException {
		ArrayList<TestPcr> collection=null;
		Connection connection = (new Connecteur()).getConnection();
		
		collection = new ArrayList<TestPcr>();
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery("select * from testpcr");
		while(rs.next()) {
			long id = rs.getLong("id_tespcr");
			int j = rs.getInt("jour");
			int m = rs.getInt("mois");
			int y = rs.getInt("annee");
			int r = rs.getInt("resultat");
			long id_teste = rs.getLong("id_cas");
			TestPcr a = new TestPcr(j, m, y, id_teste, r);
			a.setId_testpcr(id);
			collection.add(a);
		}
		return collection;
	}
	
	public ArrayList<TestPcr> get(long id_cas) throws SQLException, WrongCovidInputException {
		ArrayList<TestPcr> collection = new ArrayList<TestPcr>();
		Connection connection = (new Connecteur()).getConnection();
		TestPcr testPcr;
		int jour;
		int mois;
		int annee;
		int resultat;
		long id_teste;
		
		PreparedStatement prst = connection.prepareStatement("select * from testpcr where id_cas = ?");
		prst.setLong(1, id_cas);
		ResultSet rs = prst.executeQuery();
		while(rs.next()) {
			long id = rs.getLong("id_tespcr");
			jour = rs.getInt("jour");
			mois = rs.getInt("mois");
			annee = rs.getInt("annee");
			resultat = rs.getInt("resultat");
			id_teste = rs.getLong("id_cas");
			testPcr = new TestPcr(jour, mois, annee, id_teste, resultat);
			testPcr.setId_testpcr(id);
			collection.add(testPcr);
		}

		return collection;
	}
	
}
