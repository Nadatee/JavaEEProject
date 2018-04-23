
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
import beans.FigiLocal;


/**
 * Servlet implementation class OpenFigiServlet
 */
@WebServlet("/figi")
public class OpenFigiServlet<FigiData> extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private FigiLocal<FigiData> figiLocal;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OpenFigiServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try (PrintWriter write = response.getWriter()) {

			HttpSession session = request.getSession();
			figiLocal = (FigiLocal<FigiData>) session.getAttribute("Figi");

			if (figiLocal == null) {
				try {
					figiLocal = (FigiLocal<FigiData>) new InitialContext()
							.lookup("java:app/javaEEProject.ejb/FigiBean!beans.FigiLocal");
				} catch (NamingException e) {
					e.printStackTrace();
				}
				session.setAttribute("Figi", figiLocal);
			}

			/* TODO: idType, idValue, currency ogmicCode værdier skal hentes fra gui'en
				openFigi(String idType, String idValue, String currency, String micCode ) 
			*/
			List<FigiData> info = figiLocal.openFigi("TICKER", "AAPL", null, null);
			for (FigiData data : info) {
				write.println("FigiData:" + data.toString());
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
