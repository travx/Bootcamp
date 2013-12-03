package travisweb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PerformanceServlet
 */
public class PerformanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NodeTool nodetool;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PerformanceServlet() {
        super();
        // TODO Auto-generated constructor stub
        nodetool = new NodeTool();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String keyspace = request.getParameter("ks");
		String table = request.getParameter("cf");
		request.setAttribute("cfhistograms", nodetool.cfHistogram(keyspace, table));
		request.setAttribute("tppool", nodetool.tpPool());
		request.getRequestDispatcher("nodetool.jsp").forward(request, response);			
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
