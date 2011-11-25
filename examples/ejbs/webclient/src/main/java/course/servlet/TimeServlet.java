package course.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import course.common.TimeServiceLocal;

@EJB(name="MyTimer", beanInterface=TimeServiceLocal.class)
public class TimeServlet extends HttpServlet {

	private static final long serialVersionUID = 3131344814095821580L;

	@EJB
	private TimeServiceLocal timeService;

//	@Override
//	public void init() {
//		try {
//			Context ic = new InitialContext();
//			timeService = (TimeServiceLocal) ic.lookup("java:comp/env/MyTimer");
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
//	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("timeService", timeService);
		request.setAttribute("test", "Sonne");
		String url = "TimeService.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
