package travisweb;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;

/**
 * Servlet implementation class OrderServlet
 */
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataHelper dh;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        dh = new DataHelper("172.16.232.129", "store");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		
		if (action.equals("user_orders")){
			doUserOrders(request, response); 
		}
		else if (action.equals("vendor")){
			doVendor(request, response); 
		}		
		else if (action.equals("product_users")){
			doProductUsers(request, response); 
		}
		else if (action.equals("time_orders")){
			doTimeOrders(request, response); 
		}
		else if (action.equals("user_time_orders")){
			doUserTimeOrders(request, response); 
		}
		else if (action.equals("recommendation")){
			doRecommendation(request, response); 
		}
		else if (action.equals("moving_average")){
			doMovingAverage(request, response); 
		}
		else {
			response.getWriter().println(action);
			response.getWriter().println("Great work. You broke my servlet.");
		}
	}

	
	private void doUserOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String user_id = request.getParameter("user_id");
		request.setAttribute("user_orders", dh.getUserOrders(user_id));
		request.getRequestDispatcher("user_orders.jsp").forward(request, response);			
	}
	
	private void doVendor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String vendor = request.getParameter("vendor");
		request.setAttribute("vendor_orders", dh.getVendorOrders(vendor));
		request.setAttribute("vendor_users", dh.getVendorUsers(vendor));
		request.getRequestDispatcher("vendor.jsp").forward(request, response);			
	}
	
	
	private void doProductUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String product_id = request.getParameter("product_id");
		request.setAttribute("product_users", dh.getProductUsers(product_id));
		request.setAttribute("product_states", dh.getProductStates(product_id));
		request.getRequestDispatcher("product.jsp").forward(request, response);	
	}
	
	
	private void doTimeOrders(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		Date order_date = new Date(request.getParameter("order_date"));
		int shour = FixDate(request.getParameter("shour"),0);
		int sminute = FixDate(request.getParameter("sminute"),0);
		int ssecond = FixDate(request.getParameter("ssecond"),0);
		int ehour = FixDate(request.getParameter("ehour"),23);
		int eminute = FixDate(request.getParameter("eminute"),59);
		int esecond = FixDate(request.getParameter("esecond"),59);
		
		int start = (shour*3600) + (sminute*60) + ssecond;
		int end = (ehour*3600) + (eminute*60) + esecond;		
		
		request.setAttribute("time_orders", dh.getTimeOrders(order_date, start, end));
		request.setAttribute("start", start);
		request.setAttribute("end", end);
		request.getRequestDispatcher("time_orders.jsp").forward(request, response);			
	}
	
	
	public int FixDate(String datepart, int defaultval){
		if (datepart.equals("")){
			return defaultval;
		}
		return Integer.parseInt(datepart);
	}
	
	
	public DateTime CreateDateTime(Date date, int hour, int minute, int second){
		return new DateTime(date).withHourOfDay(hour).withMinuteOfHour(minute).withSecondOfMinute(second);
	}

	
	private void doUserTimeOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String user_id = request.getParameter("user_id");
		Date order_date = new Date(request.getParameter("order_date"));
		int shour = FixDate(request.getParameter("shour"),0);
		int sminute = FixDate(request.getParameter("sminute"),0);
		int ssecond = FixDate(request.getParameter("ssecond"),0);
		int ehour = FixDate(request.getParameter("ehour"),23);
		int eminute = FixDate(request.getParameter("eminute"),59);
		int esecond = FixDate(request.getParameter("esecond"),59);
		
		int start = (shour*3600) + (sminute*60) + ssecond;
		int end = (ehour*3600) + (eminute*60) + esecond;		
		
		request.setAttribute("time_orders", dh.getUserTimeOrders(user_id, order_date, start, end));
		request.setAttribute("start", start);
		request.setAttribute("end", end);
		request.getRequestDispatcher("time_orders.jsp").forward(request, response);				
	}
	
	private void doRecommendation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("recommendations", dh.getRecommendations());
		request.setAttribute("recommendations_hive", dh.getRecommendationsHive());
		request.setAttribute("vendor_recommendations", dh.getVendorRecommendations());
		request.setAttribute("recommended_products", dh.getRecommendedProducts());
		request.setAttribute("vendor_recommended_products", dh.getVendorRecommendedProducts(request.getParameter("vendor")));
		
		request.getRequestDispatcher("recommendations.jsp").forward(request, response);	
	}
	
	private void doMovingAverage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("moving_average", dh.getMovingAverage());
		request.getRequestDispatcher("moving_average.jsp").forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
