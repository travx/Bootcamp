package travisweb;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SolrServlet
 */
public class SolrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SolrServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strurl = "http://172.16.232.131:8983/solr/store.user/select?q=*&rows=0&wt=json&indent=true&facet=true&facet.field=full_address&omitHeader=on";		
		request.setAttribute("tokens", new URLReader().getText(strurl));
		request.getRequestDispatcher("solr.jsp").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strurl = "http://172.16.232.131:8983/solr/store.user/select?wt=json&indent=true&omitHeader=on&rows=100&q=last_name%3A" + request.getParameter("search") + "~";
		request.setAttribute("results", new URLReader().getText(strurl));
		request.getRequestDispatcher("search.jsp").forward(request, response);
	}

}
