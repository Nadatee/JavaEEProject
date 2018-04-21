

import java.io.IOException;
import java.io.PrintWriter;
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
		
		try (PrintWriter write = response.getWriter()) {
            
			HttpSession session = request.getSession();
			poiLocal = (POIBeanLocal<ExcelData>) session.getAttribute("stateless");			 

			if (poiLocal == null) {
				try {
					poiLocal = (POIBeanLocal<ExcelData>) new  InitialContext().lookup("java:app/javaEEProject.ejb/POIBean!beans.POIBeanLocal");
				} catch (NamingException e) {					
					e.printStackTrace();
				}
				session.setAttribute("stateless", poiLocal);
			}
						
			List<ExcelData> info = poiLocal.readExcel();
			for(ExcelData data :info ) {
				write.println("ExcelData:" + data.toString());			    
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
