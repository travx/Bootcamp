package travisweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TravServlet
 */
public class TravServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FileManager fm;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TravServlet() {
        super();
        fm = new FileManager();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		out.print(generatePage());
	}
	
	public String generatePage(){
		StringBuilder strHTML = new StringBuilder();
		strHTML.append(fm.getHeader());
		strHTML.append(fm.getFooter());
		return strHTML.toString();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
