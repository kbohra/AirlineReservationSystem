<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<img src="C:\351073_Kushal\AirlineReservationSystem\WebContent\Header.jpg" alt="Logo" width="950" height="70" /><br/>
<a href="WelcomePage.jsp">HOME</a>&nbsp&nbsp&nbsp&nbsp&nbsp<a href="Flights.jsp">FLIGHTS</a>&nbsp&nbsp&nbsp&nbsp&nbsp<a href="CityGuides.jsp">CITY-GUIDES</a>&nbsp&nbsp&nbsp&nbsp&nbsp<a href="Fares.jsp">FARES</a>&nbsp&nbsp&nbsp&nbsp&nbsp<a href="Contact Us.jsp">CONTACT-US</a>
<br/><br/><br/><br/><br/>
<form action=GeneratePnr method=post>
<h1><b><big><U>Airline Reservation Form</U></big></b></h1>
<b>Source  :<input type=text name=source>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspDestination  :<input type=text name=destination></b><br/>
<br/><b>Select Flight :
<select name="flight">
<option value="tata" selected="selected">TATA Airways</option>
<option value="king">KingFisher</option>
<option value="airindia">AirIndia</option>
</select>&nbsp&nbsp&nbsp&nbsp
<b>Select Class :
<select name="classtype">
<option value="first" selected="selected">First Class</option>
<option value="economy" >Economy Class</option>
<option value="business">Business Class</option>
</select><br/></b></b><br/>
<b>Date of Journey(dd/mm/yyyy) : dd<select name="dd">
<option value="1" selected="selected">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
<option value="6">6</option>
<option value="7">7</option>
<option value="8">8</option>
<option value="9">9</option>
<option value="10">10</option>
<option value="11">11</option>
<option value="12">12</option>
<option value="13">13</option>
<option value="14">14</option>
<option value="15">15</option>
<option value="16">16</option>
<option value="17">17</option>
<option value="18">18</option>
<option value="19">19</option>
<option value="20">20</option>
<option value="21">21</option>
<option value="22">22</option>
<option value="23">23</option>
<option value="24">24</option>
<option value="25">25</option>
<option value="26">26</option>
<option value="27">27</option>
<option value="28">28</option>
<option value="29">29</option>
<option value="30">30</option>
<option value="31">31</option>
</select>
mm<select name="mm">
<option value="1" selected="selected">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
<option value="6">6</option>
<option value="7">7</option>
<option value="8">8</option>
<option value="9">9</option>
<option value="10">10</option>
<option value="11">11</option>
<option value="12">12</option>
</select>
yyyy
<select name="yyyy">
<option value="2010" selected="selected">2010</option></select><br/><br/>
<b>Select Time :
<select name="tym">
<option value="08:00:00" selected="selected">08:00:00</option>
<option value="20:00:00">20:00:00</option>
</select><br/><br/>
<b>Proof of Identity :
<select name="proof">
<option value="pan" selected="selected">PAN CARD</option>
<option value="pass">PASSPORT</option>
<option value="pass">VOTER ID</option>
</select>
<input type=text name=idno>
<br/><br/>
<b>No.of Adults :</b><input type=text name=adults><b>No.of Children :</b><input type=text name=children>
<br/><b>Enter Credit Card No.<input type=text name=credit></b><br/>Enter CVV no: <input type=text name=cvv></b>
<br/><br/><input type=submit value="Book Now">
</form>
</center>
<form>
<h5 align="center" >Note:For security reasons we are not logging  your credit card details and the amount will be deducted only if the tickets are successfully booked</h5>
</form>
<center><h3>Project developed by Kushal,Divya,Tejaswi,Pavan,Swetha</h3></center>
</body>
</html>