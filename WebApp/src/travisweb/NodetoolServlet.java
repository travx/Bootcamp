package travisweb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NodetoolServlet
 */
public class NodetoolServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NodeTool nodetool;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NodetoolServlet() {
        super();
        // TODO Auto-generated constructor stub
        nodetool = new NodeTool();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String stat = request.getParameter("stat");
		String output = "";
		if (stat.equalsIgnoreCase("tpPool")){
			output = nodetool.tpPool();
		}
		else if (stat.equalsIgnoreCase("tpMessage")){
			output = nodetool.tpMessage();
		}
		else if (stat.equalsIgnoreCase("IOStatCPU")){
			output = nodetool.iostatCPU();
		}
		else if (stat.equalsIgnoreCase("IOStatDevice")){
			output = nodetool.iostatDevice();
		}
		response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
