

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.POIBeanLocal;

/**
 * Servlet implementation class POIServlet
 */
@WebServlet("/poi")
public class POIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public POIServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try (PrintWriter write = response.getWriter()) {

            
			HttpSession session = request.getSession();
			POIBeanLocal poiLocal = (POIBeanLocal) session.getAttribute("stateless");			 
			if (poiLocal == null) {
				try {
					poiLocal = (POIBeanLocal) new  InitialContext().lookup("java:app/javaEEProject.ejb/POIBean!beans.POIBeanLocal");
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				session.setAttribute("stateless", poiLocal);
			}
			 
			//counterLocal.setCount(counterLocal.getCounter() + 1);
			write.println("stateless:" + poiLocal.readExcel());
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
