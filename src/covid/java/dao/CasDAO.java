package covid.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import covid.java.Cas;
import covid.java.tests.WrongCovidInputException;

public class CasDAO extends DAO<Cas> {

	public CasDAO() {
		super();
	}

	@Override
	public void add(Cas cas) throws SQLException {
		Connection connection = (new Connecteur()).getConnection();
		
		PreparedStatement prst = connection.prepareStatement("INSERT INTO cas(nom_complet, telephone, adresse, code_postale, etat) VALUES (?, ?, ?, ?, ?)");
		prst.setString(1, cas.getNom_complet());
		prst.setString(2, cas.getTelephone());
		prst.setString(3, cas.getAdresse());
		prst.setInt(4, Integer.parseInt(cas.getCode_postale()));
		prst.setInt(5, cas.getEtat());
		prst.executeUpdate();
		
	}

	@Override
	public ArrayList<Cas> get() throws SQLException, WrongCovidInputException {
		ArrayList<Cas> collection=null;
		Connection connection = (new Connecteur()).getConnection();
		
		collection = new ArrayList<Cas>();
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery("select * from cas");
		while(rs.next()) {
			Cas a = new Cas();
			a.setId_cas(rs.getLong("id_cas"));
			a.setNom_complet(rs.getString("nom_complet"));
			a.setTelephone(rs.getString("telephone"));
			a.setAdresse(rs.getString("adresse"));
			a.setCode_postale(rs.getString("code_postale"));
			a.setEtat(Integer.parseInt(rs.getString("etat")));
			collection.add(a);
		}
		return collection;
	}
	
}
