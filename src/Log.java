

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class for Servlet: Log
 *
 */
 public class Log extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Log() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		String name=request.getParameter("username");
		String pass=request.getParameter("password");
		String mob=request.getParameter("mobileno");
		String email=request.getParameter("emailId");
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:StudentDSN","scott","tiger");
		PreparedStatement pstmt=con.prepareStatement("Insert into customer values(?,?,?,?)");
		pstmt.setString(1,name);
		pstmt.setString(2,pass);
		pstmt.setString(3,mob);
		pstmt.setString(4,email);
		int n=pstmt.executeUpdate();
		response.sendRedirect("RegistrationConfirmation.jsp");
		
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
			System.out.println("Exception raised in Log.java file:"+e);
		}
		
		// TODO Auto-generated method stub
	}   	  	    
}