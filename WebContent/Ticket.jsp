<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<img src="C:\351073_Kushal\AirlineReservationSystem\WebContent\Header.jpg" alt="Logo" width="950" height="70" /><br/>
<a href="WelcomePage.jsp">HOME</a>&nbsp&nbsp&nbsp&nbsp&nbsp<a href="Flights.jsp">FLIGHTS</a>&nbsp&nbsp&nbsp&nbsp&nbsp<a href="CityGuides.jsp">CITY-GUIDES</a>&nbsp&nbsp&nbsp&nbsp&nbsp<a href="Fares.jsp">FARES</a>&nbsp&nbsp&nbsp&nbsp&nbsp<a href="Contact Us.jsp">CONTACT-US</a>
<h1>Airline Ticket</h1>
<br/>
<table border="1" >
<tr><td>PNR NO</td><td><%= (Integer.parseInt(request.getAttribute("pnrno").toString())) %></td>
<tr><td>FlightName:</td><td><%=(request.getAttribute("flightname").toString()) %></td><td>Flight-Class:</td><td><%=(request.getAttribute("classtype").toString())%></td></tr>
<tr><td>Name:</td><td><%=(request.getAttribute("username").toString())%></td><td>Mobile No:</td><td><%=(request.getAttribute("mobile").toString())%></td></tr>

<tr><td>Source:</td><td><%=(request.getAttribute("source").toString())%></td><td>Destination</td><td><%=(request.getAttribute("destination").toString())%></td></tr>
<tr><td>Date of Journey:</td><td><%=(request.getAttribute("doj").toString())%></td><td>Departure Time:</td><td><%=(request.getAttribute("tym").toString())%></td></tr>
<tr><td>No.of Adults:</td><td><%=(request.getAttribute("adults").toString())%></td><td>No. of Children:</td><td><%=(request.getAttribute("children").toString())%></td></tr>
<tr><td>Seats from:</td><td><%=(request.getAttribute("first").toString())%></td><td>To:</td><td><%=(request.getAttribute("last").toString())%></td></tr>
<tr><td>Email:</td><td><%=(request.getAttribute("email").toString())%></td><td>Total Fare:</td><td><%=(request.getAttribute("price").toString())%></td></tr>
<tr><td></td><td><input type="submit" value="PRINT"></td></tr>		
</table>
<center><h3>Project developed by Kushal,Divya,Tejaswi,Pavan,Swetha</h3></center>
</body>
</html>