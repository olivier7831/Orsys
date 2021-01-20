package covid.java.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import covid.java.tests.WrongCovidInputException;

public abstract class DAO<T> {
	protected Connection connection;

	public DAO(Connection connection) {
		super();
		this.connection = connection;
	}
	
	public abstract void add(T object) throws SQLException;
	public abstract ArrayList<T> get() throws SQLException, WrongCovidInputException;
}
