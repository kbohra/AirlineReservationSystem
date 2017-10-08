import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Opp
{
	public ArrayList<String> operate(String flightno,String source,String destination,String flight,String classtype,String doj,String tym,String proof,String idno,int adults,int children,int tt,String username,String mobileno,String emailid,int as,double p_a,double p_c)
   {
		boolean flag=false;
		int x=-5;
		try{
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	Connection con=DriverManager.getConnection("jdbc:odbc:StudentDSN","scott","tiger");
	//PreparedStatement pstmt1=con.prepareStatement("select * from pnrtable");
	PreparedStatement pstmt2=con.prepareStatement("select count from pnrcounter");
	PreparedStatement pstmt=con.prepareStatement("insert into pnrtable values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	PreparedStatement pstmt3=con.prepareStatement("update pnrcounter set count=count+1 where name='pct'");
	ResultSet rs2=pstmt2.executeQuery();
	
	       if((as>0)&&(as>=tt))
				{
					rs2.next();
				 	 x=rs2.getInt(1);
					double price=adults*p_a+children*p_c;
					int last=as;
					int first=as-(tt-1);	
					pstmt.setString(1,(x+1)+"");
					pstmt.setString(2,flight);
					pstmt.setString(3,flightno);
					pstmt.setString(4,classtype);
					pstmt.setString(5,username);
					pstmt.setString(6,mobileno);
					pstmt.setString(7,emailid);
					pstmt.setString(8,proof);
					pstmt.setInt(9,adults);
					pstmt.setInt(10,children);
					pstmt.setString(11,source);
					pstmt.setString(12,destination);
					pstmt.setString(13,doj);
					pstmt.setString(14,tym);
					pstmt.setInt(15,first);
					pstmt.setInt(16,last);
					pstmt.setDouble(17,price);
					pstmt.executeUpdate();
					pstmt3.executeUpdate();
					flag=true;
					
			}
	       
		}// try ends here 
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception raised in operate method:"+e);
		}//catch ends here
		ArrayList<String> a=new ArrayList<String>();
		a.add(flag+"");
		a.add(x+"");
		return a;
		}// operate method ends here
	   public void setSeat(String col_name,String doj,int tt)
	   {
		   try{
		   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	       Connection con=DriverManager.getConnection("jdbc:odbc:StudentDSN","scott","tiger");
		   PreparedStatement pstmt4=con.prepareStatement("Update seatAvail set "+col_name+"="+col_name+"-"+tt+" where doj='"+doj+"'");
		   pstmt4.executeUpdate();
		   }//setSeat try ends here
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
			   System.out.println("Exception raised in setSeat method:"+e);
		   }// setSeat catch ends here
	  }// method setSeat ends here 
	  
}//class ends here
		
   

