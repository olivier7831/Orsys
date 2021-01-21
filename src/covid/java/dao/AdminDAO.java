package covid.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import covid.java.Admin;

public class AdminDAO extends DAO<Admin> {

	public AdminDAO() {
		super();
	}

	@Override
	public void add(Admin admin) throws SQLException {
		Connection connection = (new Connecteur()).getConnection();
		PreparedStatement prst = connection.prepareStatement("INSERT INTO admin(login, password) VALUES (?, ?)");
		prst.setString(1, admin.getLogin());
		prst.setString(2, admin.getPassword());

		prst.executeUpdate();
		
	}

	@Override
	public ArrayList<Admin> get() throws SQLException {
		ArrayList<Admin> collection=null;
		
		Connection connection = (new Connecteur()).getConnection();
		collection = new ArrayList<Admin>();
		Statement st = connection.createStatement();
		ResultSet rs = st.executeQuery("select * from admin");
		while(rs.next()) {
			Admin a = new Admin();
			a.setId_admin(rs.getLong("id_admin"));
			a.setLogin(rs.getString("login"));
			a.setPassword(rs.getString("password"));
			collection.add(a);
		}
		return collection;
	}
	
	public static Admin getLogin(String login) throws SQLException {
		Admin admin=null;
		
		Connection connection = (new Connecteur()).getConnection();
		admin = new Admin();
		PreparedStatement prst = connection.prepareStatement("select * from admin where login = ?");
		prst.setString(1, login);
		ResultSet rs = prst.executeQuery();
		
		if (rs.next()) {
			admin.setId_admin(rs.getLong("id_admin"));
			admin.setLogin(rs.getString("login"));
			admin.setPassword(rs.getString("password"));
		
			return admin;
		}
		return null;
	}
}
