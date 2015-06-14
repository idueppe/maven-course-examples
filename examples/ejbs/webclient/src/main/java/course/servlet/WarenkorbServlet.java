package course.servlet;

import java.io.IOException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import course.common.Warenkorb;

public class WarenkorbServlet extends HttpServlet {

	private static final long serialVersionUID = 1364235522913699943L;
	private static final String WARENKORB_GLOBAL_JNDI_NAME = "java:app/ejb3.sessionbeans/WarenkorbBean!course.common.Warenkorb";
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		if (session.isNew()) {
			try {
				Context ic = new InitialContext();
				Warenkorb warenkorb = (Warenkorb) ic
						.lookup(WARENKORB_GLOBAL_JNDI_NAME);
				System.out.println("Putting " + warenkorb
						+ " into session with ID " + session.getId());
				session.setAttribute("warenkorb", warenkorb);
			} catch (NamingException e) {
				e.printStackTrace();
			}
		} else {
			String l = req.getParameter("logout");
			Warenkorb warenkorb = (Warenkorb) session.getAttribute("warenkorb");
			if (l != null) {
				warenkorb.abmelden();
				session.invalidate();
				return; // oder neuen Warenkorb erzeugen
			} else {
				String p = req.getParameter("produkt");
				if (p != null) {
					int a = Integer.parseInt(req.getParameter("anzahl"));
					warenkorb.kaufen(p, a);
				}
			}
		}
		String url = "Warenkorb.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}

}	
