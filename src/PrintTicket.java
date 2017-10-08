

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class for Servlet: PrintTicket
 *
 */
 public class PrintTicket extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public PrintTicket() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int pnrno=Integer.parseInt(request.getParameter("pnrno"));
		try{
			   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		       Connection con=DriverManager.getConnection("jdbc:odbc:StudentDSN","scott","tiger");
			   Statement stmt5=con.createStatement();
			   ResultSet sr=stmt5.executeQuery("select * from pnrtable where pnrno="+pnrno);
			   if(sr.next())
			   {
			   RequestDispatcher rd=request.getRequestDispatcher("Ticket.jsp");
			   request.setAttribute("pnrno",sr.getString(1));
			   request.setAttribute("flightname",sr.getString(2));
			   request.setAttribute("flightno",sr.getString(3));
			   request.setAttribute("classtype",sr.getString(4));
			   request.setAttribute("username",sr.getString(5));
			   request.setAttribute("mobile",sr.getString(6));
			   request.setAttribute("email",sr.getString(7));
			   request.setAttribute("idproof",sr.getString(8));
			   request.setAttribute("adults",sr.getString(9));
			   request.setAttribute("children",sr.getString(10));
			   request.setAttribute("source",sr.getString(11));
			   request.setAttribute("destination",sr.getString(12));
			   request.setAttribute("doj",sr.getString(13));
			   request.setAttribute("tym",sr.getString(14));
			   request.setAttribute("first",sr.getString(15));
			   request.setAttribute("last",sr.getString(16));
			   request.setAttribute("price",sr.getString(17));
			   rd.forward(request,response);
			   }
			   else
			   {
				   response.sendRedirect("errorpnr.jsp");
			   }
	       }
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		catch(Exception e)
		   {
			   e.printStackTrace();
			   System.out.println("Exception raised in print servlet post:"+e);
		   }
		// TODO Auto-generated method stub
	}   	  	    
}