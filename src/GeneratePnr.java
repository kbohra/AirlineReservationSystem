

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class for Servlet: GeneratePnr
 *
 */
 public class GeneratePnr extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public GeneratePnr() {
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
		// TODO Auto-generated method stub
		double t_fa=2500.52,t_ea=2000.65,t_ba=2300.25,k_fa=5500.52,k_ea=5000.65,k_ba=5300.25,a_fa=1500.52,a_ea=1000.65,a_ba=1300.25;
		double t_fc=1250.52,t_ec=1000.65,t_bc=1150.25,k_fc=2750.52,k_ec=2500.65,k_bc=2650.25,a_fc=750.52,a_ec=500.65,a_bc=650.25;
		String source=request.getParameter("source");
		String destination=request.getParameter("destination");
		String flight=request.getParameter("flight");
		String classtype=request.getParameter("classtype");
		String dd=request.getParameter("dd");
		String mm=request.getParameter("mm");
		String yyyy=request.getParameter("yyyy");
		String tym=request.getParameter("tym");
		String proof=request.getParameter("proof");
		String idno=request.getParameter("idno");
		String doj=dd+mm+yyyy;
		int adults=Integer.parseInt(request.getParameter("adults"));
		int children=Integer.parseInt(request.getParameter("children"));
		int tt=adults+children;
		HttpSession session=request.getSession();
		String username=(session.getAttribute("username")).toString();
		String mobileno=(session.getAttribute("mobileno")).toString();
        String emailid=(session.getAttribute("emailid")).toString();
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	Connection con=DriverManager.getConnection("jdbc:odbc:StudentDSN","scott","tiger");
    	String qry="select * from seatavail where doj='"+doj+"'";
    	Statement pstmt0=con.createStatement();
    	ResultSet rs0=pstmt0.executeQuery(qry);	
    	Opp ref=new Opp();
    	boolean flag=false;
    	ArrayList<String> a;
    	int pnr_n=-5;
    
    	if(tym.equals("08:00:00"))
        {
    		
        	if((flight.equals("tata"))&&(classtype.equals("first")))
        	{
        		if(rs0.next())
        		{
        		int x=rs0.getInt(2);
        		a=ref.operate("t11",source,destination,flight,classtype,doj,tym,proof,idno,adults,children,tt,username,mobileno,emailid,x,t_fa,t_fc);
        		flag=Boolean.parseBoolean(a.get(0));
        		pnr_n=Integer.parseInt(a.get(1));
        		if(flag)
        			ref.setSeat("t_fmng",doj,tt);
        	    }
        	}
        	else if((flight.equals("tata"))&&(classtype.equals("economy")))
        	{
        		if(rs0.next()){
        		int x=rs0.getInt(3);
        		a=ref.operate("t11",source,destination,flight,classtype,doj,tym,proof,idno,adults,children,tt,username,mobileno,emailid,x,t_ea,t_ec);
        		flag=Boolean.parseBoolean(a.get(0));
        		pnr_n=Integer.parseInt(a.get(1));
        		if(flag)
        		ref.setSeat("t_emng", doj, tt);}
        		        	}
        	else if((flight.equals("tata"))&&(classtype.equals("business")))
        	{
        		if(rs0.next()){
        		int x=rs0.getInt(4);
        		a=ref.operate("t11",source,destination,flight,classtype,doj,tym,proof,idno,adults,children,tt,username,mobileno,emailid,x,t_ea,t_ec);
        		flag=Boolean.parseBoolean(a.get(0));
        		pnr_n=Integer.parseInt(a.get(1));
        		if(flag)
        		ref.setSeat("t_bmng", doj, tt);}
        	}
        	else if((flight.equals("king"))&&(classtype.equals("first")))
        	{
        		if(rs0.next()){
        		int x=rs0.getInt(8);
        		a=ref.operate("k11",source,destination,flight,classtype,doj,tym,proof,idno,adults,children,tt,username,mobileno,emailid,x,t_ea,t_ec);
        		flag=Boolean.parseBoolean(a.get(0));
        		pnr_n=Integer.parseInt(a.get(1));
        		if(flag)
        		ref.setSeat("k_fmng", doj, tt);}
        	}
        	else if((flight.equals("king"))&&(classtype.equals("economy")))
        	{
        		if(rs0.next()){
        		int x=rs0.getInt(9);
        		a=ref.operate("k11",source,destination,flight,classtype,doj,tym,proof,idno,adults,children,tt,username,mobileno,emailid,x,t_ea,t_ec);
        		flag=Boolean.parseBoolean(a.get(0));
        		pnr_n=Integer.parseInt(a.get(1));
        		if(flag)
        		ref.setSeat("k_emng", doj, tt);}
        	}
        	else if((flight.equals("king"))&&(classtype.equals("business")))
        	{
        		if(rs0.next()){
        		int x=rs0.getInt(10);
        		a=ref.operate("k11",source,destination,flight,classtype,doj,tym,proof,idno,adults,children,tt,username,mobileno,emailid,x,t_ea,t_ec);
        		flag=Boolean.parseBoolean(a.get(0));
        		pnr_n=Integer.parseInt(a.get(1));
        		if(flag)
        		ref.setSeat("k_bmng", doj, tt);}
        	}
        	else if((flight.equals("airindia"))&&(classtype.equals("first")))
        	{
        		if(rs0.next()){
        		int x=rs0.getInt(14);
        		a=ref.operate("a11",source,destination,flight,classtype,doj,tym,proof,idno,adults,children,tt,username,mobileno,emailid,x,t_ea,t_ec);
        		flag=Boolean.parseBoolean(a.get(0));
        		pnr_n=Integer.parseInt(a.get(1));
        		if(flag)
        		ref.setSeat("a_fmng", doj, tt);}
        	}
        	else if((flight.equals("airindia"))&&(classtype.equals("economy")))
        	{
        		if(rs0.next()){
        		int x=rs0.getInt(15);
        		a=ref.operate("a11",source,destination,flight,classtype,doj,tym,proof,idno,adults,children,tt,username,mobileno,emailid,x,t_ea,t_ec);
        		flag=Boolean.parseBoolean(a.get(0));
        		pnr_n=Integer.parseInt(a.get(1));
        		if(flag)
        		ref.setSeat("a_emng", doj, tt);}
        	}
        	else if((flight.equals("airindia"))&&(classtype.equals("business")))
        	{
        		if(rs0.next()){
        		int x=rs0.getInt(16);
        		a=ref.operate("a11",source,destination,flight,classtype,doj,tym,proof,idno,adults,children,tt,username,mobileno,emailid,x,t_ea,t_ec);
        		flag=Boolean.parseBoolean(a.get(0));
        		pnr_n=Integer.parseInt(a.get(1));
        		if(flag)
        		ref.setSeat("a_bmng", doj, tt);}
        	}
        	
        	
        	
        }
        else // else for night flights
        {
        	if((flight.equals("tata"))&&(classtype.equals("first")))
        	{
        		if(rs0.next())
        		{
        	    int x=rs0.getInt(5);
        	    a=ref.operate("t11",source,destination,flight,classtype,doj,tym,proof,idno,adults,children,tt,username,mobileno,emailid,x,t_fa,t_fc);
        		flag=Boolean.parseBoolean(a.get(0));
        		pnr_n=Integer.parseInt(a.get(1));
        		if(flag)
        		ref.setSeat("t_feng",doj,tt);
        		}
        	}
        	else if((flight.equals("tata"))&&(classtype.equals("economy")))
        	{
        		if(rs0.next()){
        		int x=rs0.getInt(6);
        		a=ref.operate("t11",source,destination,flight,classtype,doj,tym,proof,idno,adults,children,tt,username,mobileno,emailid,x,t_ea,t_ec);
        		flag=Boolean.parseBoolean(a.get(0));
        		pnr_n=Integer.parseInt(a.get(1));
        		if(flag)
        		ref.setSeat("t_eeng", doj, tt);}
          	}
        	else if((flight.equals("tata"))&&(classtype.equals("business")))
        	{
        		if(rs0.next()){
        		int x=rs0.getInt(7);
        		a=ref.operate("t11",source,destination,flight,classtype,doj,tym,proof,idno,adults,children,tt,username,mobileno,emailid,x,t_ea,t_ec);
        		flag=Boolean.parseBoolean(a.get(0));
        		pnr_n=Integer.parseInt(a.get(1));
        		if(flag)
        		ref.setSeat("t_beng", doj, tt);}
        	}
        	else if((flight.equals("king"))&&(classtype.equals("first")))
        	{
        		if(rs0.next()){
        		int x=rs0.getInt(11);
        		a=ref.operate("k11",source,destination,flight,classtype,doj,tym,proof,idno,adults,children,tt,username,mobileno,emailid,x,t_ea,t_ec);
        		flag=Boolean.parseBoolean(a.get(0));
        		pnr_n=Integer.parseInt(a.get(1));
        		if(flag)
        		ref.setSeat("k_feng", doj, tt);}
        	}
        	else if((flight.equals("king"))&&(classtype.equals("economy")))
        	{
        		if(rs0.next()){
        		int x=rs0.getInt(12);
        		a=ref.operate("k11",source,destination,flight,classtype,doj,tym,proof,idno,adults,children,tt,username,mobileno,emailid,x,t_ea,t_ec);
        		flag=Boolean.parseBoolean(a.get(0));
        		pnr_n=Integer.parseInt(a.get(1));
        		if(flag)
        		ref.setSeat("k_eeng", doj, tt);}
        	}
        	else if((flight.equals("king"))&&(classtype.equals("business")))
        	{
        		if(rs0.next()){
        		int x=rs0.getInt(13);
        		a=ref.operate("k11",source,destination,flight,classtype,doj,tym,proof,idno,adults,children,tt,username,mobileno,emailid,x,t_ea,t_ec);
        		flag=Boolean.parseBoolean(a.get(0));
        		pnr_n=Integer.parseInt(a.get(1));
        		if(flag)
        		ref.setSeat("k_beng", doj, tt);}
        	}
        	else if((flight.equals("airindia"))&&(classtype.equals("first")))
        	{
        		if(rs0.next()){
        		int x=rs0.getInt(17);
        		a=ref.operate("a11",source,destination,flight,classtype,doj,tym,proof,idno,adults,children,tt,username,mobileno,emailid,x,t_ea,t_ec);
        		flag=Boolean.parseBoolean(a.get(0));
        		pnr_n=Integer.parseInt(a.get(1));
        		if(flag)
        		ref.setSeat("a_feng", doj, tt);}
        	}
        	else if((flight.equals("airindia"))&&(classtype.equals("economy")))
        	{
        		if(rs0.next()){
        		int x=rs0.getInt(18);
        		a=ref.operate("a11",source,destination,flight,classtype,doj,tym,proof,idno,adults,children,tt,username,mobileno,emailid,x,t_ea,t_ec);
        		flag=Boolean.parseBoolean(a.get(0));
        		pnr_n=Integer.parseInt(a.get(1));
        		if(flag)
        		ref.setSeat("a_eeng", doj, tt);}
        	}
        	else if((flight.equals("airindia"))&&(classtype.equals("business")))
        	{
        		if(rs0.next()){
        		int x=rs0.getInt(19);
        		a=ref.operate("a11",source,destination,flight,classtype,doj,tym,proof,idno,adults,children,tt,username,mobileno,emailid,x,t_ea,t_ec);
        		flag=Boolean.parseBoolean(a.get(0));
        		pnr_n=Integer.parseInt(a.get(1));
        		if(flag)
        		ref.setSeat("a_beng", doj, tt);}
        	}
         
        }
    	RequestDispatcher rd=request.getRequestDispatcher("Congrats.jsp");
        request.setAttribute("pnr_n",pnr_n);
        rd.include(request,response);
        if(flag)
      		rd.forward(request,response);
      	else
      		response.sendRedirect("NonAvailability.jsp");
     }// post method try ends here
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		catch(NullPointerException e)
		{
			System.out.println("Exception raised in generatePNR"+e);
		}
		catch(Exception e)
		{
			System.out.println("Exception raised in generatePNR"+e);
		}
	}//post method ends here
 }//my servlet class ends here