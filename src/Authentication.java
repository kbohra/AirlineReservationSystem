import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.io.*;

/**
 * Servlet implementation class for Servlet: Authentication
 *
 */
 public class Authentication extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Authentication() {
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
		try{
		   String user=request.getParameter("username");
		   String pass=request.getParameter("password");
		   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   Connection con=DriverManager.getConnection("jdbc:odbc:StudentDSN","scott","tiger");
		   Statement stmt=con.createStatement();
		   ResultSet rs=stmt.executeQuery("select * from Customer");
		   PrintWriter p=response.getWriter();
		   boolean flag=false;
		   while(rs.next()&&flag==false)
		   {
			  if((user.equals(rs.getString(1)))&&(pass.equals(rs.getString(2))))
				  {
				    HttpSession session=request.getSession();
				    session.setAttribute("username",user);
				    session.setAttribute("mobileno",rs.getString(3));
				    session.setAttribute("emailid",rs.getString(4));
				    response.sendRedirect("select.jsp");
			        flag=true;
		          }
		  }
		   if(flag==false)
			   response.sendRedirect("error.jsp");
		}
		catch(NullPointerException e)
		{
			System.out.println("Some Exception raised in Authentication Servlet Page :"+e);
		}
		catch(Exception e)
		{
			System.out.println("Some Exception raised in Authentication Servlet Page :"+e);
		}
		}
	}
		
