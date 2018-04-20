

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
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
 * @param <ExcelData>
 */
@WebServlet("/poi")

public class POIServlet<ExcelData> extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private POIBeanLocal<ExcelData> poiLocal;  
	
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
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try (PrintWriter write = response.getWriter()) {

            
			HttpSession session = request.getSession();
//			POIBeanLocal<?> poiLocal = (POIBeanLocal<?>) session.getAttribute("stateless");			 
			poiLocal = (POIBeanLocal<ExcelData>) session.getAttribute("stateless");			 

			if (poiLocal == null) {
				try {
					poiLocal = (POIBeanLocal<ExcelData>) new  InitialContext().lookup("java:app/javaEEProject.ejb/POIBean!beans.POIBeanLocal");
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				session.setAttribute("stateless", poiLocal);
			}
						
			List<ExcelData> info = poiLocal.readExcel();
			for(ExcelData data :info ) {
				write.println("ExcelData:" + data.toString() );
			    poiLocal.create(data);
			}
//			write.println("stateless:" + poiLocal.readExcel().toString());
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
