package covid.java;

public class Admin {
	private static double nb_admins = 0;
	private double id_admin;
	private String login;
	private String password;
	
	public Admin() {
		super();
		id_admin = nb_admins++;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getId_admin() {
		return id_admin;
	}
	
	public void setId_admin(long id) {
		this.id_admin = id;
	}
	
	public boolean isValidAdminLogin() {
		if (password == null || login == null)
			return false;
		if (this.getPassword().indexOf("orsys") == -1 || !this.getLogin().equals("admin")) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		if (login == null || other.login == null) {
			return false;
		}
		if (password == null || other.password == null) {
			return false;
		}
		if (!login.equals(other.getLogin()) || !password.equals(other.getPassword()))
			return false;
		
		return true;
	}
	
	
}
