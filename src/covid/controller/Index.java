package covid.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import covid.java.Admin;
import covid.java.Cas;
import covid.java.Gestion;
import covid.java.TestPcr;
import covid.java.dao.AdminDAO;
import covid.java.tests.WrongCovidInputException;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String action = null;
		Gestion gestion;
		RequestDispatcher rd;
		
		if (session.getAttribute("gestion") == null) {
			session.setAttribute("gestion", new Gestion());
		}
		gestion = (Gestion) session.getAttribute("gestion");
		if (request.getParameter("action") == null) {
			action = "login";
		} else {
			action = request.getParameter("action").toString();
		}
		switch (action) {
		case "login":
			Admin user = gestion.getUser();
			if (request.getParameter("login") != null)
				user.setLogin(request.getParameter("login"));
			if (request.getParameter("password") != null)
				user.setPassword(request.getParameter("password"));
//			if (!user.isValidAdminLogin()) {
//				rd = request.getRequestDispatcher("WEB-INF/login/login.jsp");
//				rd.forward(request, response);
//			} else {
//				rd = request.getRequestDispatcher("WEB-INF/site/gestion.jsp");
//				rd.include(request, response);
//			}
			try {
				if (!user.equals(gestion.getAdmin(user.getLogin())) || !user.isValidAdminLogin()) {
					rd = request.getRequestDispatcher("WEB-INF/login/login.jsp");
					rd.include(request, response);
				} else {
					rd = request.getRequestDispatcher("WEB-INF/site/gestion.jsp");
					rd.include(request, response);
				}
			} catch (SQLException | ServletException | IOException e1) {
				gestion.addError(e1);
				e1.printStackTrace();
				rd = request.getRequestDispatcher("WEB-INF/site/error.jsp");
				rd.include(request, response);
			}
			break;
		case "updatecas":
			Cas cas = new Cas();
			try {
				cas.setAdresse(request.getParameter("adresse"));
				cas.setCode_postale(request.getParameter("code_postal"));
				cas.setEtat(Integer.parseInt(request.getParameter("etat")));
				cas.setNom_complet(request.getParameter("nom_complet"));
				cas.setTelephone(request.getParameter("telephone"));
				gestion.addCas(cas);
				rd = request.getRequestDispatcher("WEB-INF/site/gestion.jsp");
				rd.include(request, response);
			} catch (WrongCovidInputException e) {
				gestion.addError(e);
				e.printStackTrace();
				rd = request.getRequestDispatcher("WEB-INF/site/error.jsp");
				rd.include(request, response);
			} catch (SQLException e) {
				gestion.addError(e);
				e.printStackTrace();
				rd = request.getRequestDispatcher("WEB-INF/site/error.jsp");
				rd.include(request, response);
			}
			break;
		case "formulairecas":
			rd = request.getRequestDispatcher("WEB-INF/site/ajoutcas.jsp");
			rd.include(request, response);
			break;
		case "affichetests":
			rd = request.getRequestDispatcher("WEB-INF/site/testspcr.jsp");
			rd.include(request, response);
			break;
		case "formulairetest":
			rd = request.getRequestDispatcher("WEB-INF/site/ajouttest.jsp");
			rd.include(request, response);
			break;
		case "udpatetest":
			TestPcr test;
		
			try {
				int jour = Integer.parseInt(request.getParameter("jour"));
				int mois = Integer.parseInt(request.getParameter("mois"));
				int annee = Integer.parseInt(request.getParameter("annee"));
				int id_teste = Integer.parseInt(request.getParameter("casteste"));
				int resultat = Integer.parseInt(request.getParameter("etat"));
				test = new TestPcr(jour, mois, annee, id_teste, resultat);
				gestion.getCasList();
				gestion.addTestPcr(test);
				rd = request.getRequestDispatcher("WEB-INF/site/gestion.jsp");
				rd.include(request, response);
			} catch (WrongCovidInputException e) {
				gestion.addError(e);
				e.printStackTrace();
				rd = request.getRequestDispatcher("WEB-INF/site/error.jsp");
				rd.include(request, response);
			} catch (SQLException e) {
				gestion.addError(e);
				e.printStackTrace();
				rd = request.getRequestDispatcher("WEB-INF/site/error.jsp");
				rd.include(request, response);
			}
			break;
		case "filtre":
			gestion.setCasId(Long.parseUnsignedLong(request.getParameter("id")));
			rd = request.getRequestDispatcher("WEB-INF/site/testspcrfiltre.jsp");
			rd.include(request, response);
			break;
		case "deconnection":
			session.invalidate();
			rd = request.getRequestDispatcher("WEB-INF/login/login.jsp");
			rd.include(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
