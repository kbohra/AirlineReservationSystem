1)create table Pnrtable(pnrno varchar2(4),flightName varchar2(25),flightNo varchar2(6),classType varchar2(15),username varchar2(25),mobile varchar2(10),email varchar2(40),idProof varchar2(15),adults number(2),children number(2),source varchar2(25),destination varchar2(25),doj varchar2(8),tym varchar2(8),first number(2),last number(2),price number(10,2));
  
<option value="tata" selected="selected">TATA Airways</option>
<option value="king">KingFisher</option>
<option value="airindia">AirIndia</option>

2)create table Seatavail(doj number(10),
t_fmng number(2),t_emng number(2),t_bmng number(2),t_feng number(2),t_eeng number(2),t_beng number(2),
k_fmng number(2),k_emng number(2),k_bmng number(2),k_feng number(2),k_eeng number(2),k_beng number(2),
a_fmng number(2),a_emng number(2),a_bmng number(2),a_feng number(2),a_eeng number(2),a_beng number(2));


3)insert rows into the table created above where first column is date of journey with out any hypens
insert into seatavail values(2962010,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50);
insert into seatavail values(2862010,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50);
insert into seatavail values(3062010,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50);
insert into seatavail values(3162010,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50);
insert into seatavail values(172010,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50);
insert into seatavail values(272010,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50);
insert into seatavail values(372010,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50);
insert into seatavail values(472010,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50);
insert into seatavail values(572010,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50);
insert into seatavail values(672010,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50);
insert into seatavail values(772010,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50);
insert into seatavail values(872010,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50);
insert into seatavail values(972010,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50);
insert into seatavail values(1072010,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50);
insert into seatavail values(1172010,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50);
insert into seatavail values(1272010,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50);
insert into seatavail values(1372010,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50);
insert into seatavail values(1472010,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50);
insert into seatavail values(1572010,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50);
insert into seatavail values(1672010,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50);
insert into seatavail values(1772010,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50);
insert into seatavail values(1872010,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50);



4)create table customer as follows
SQL> desc customer
 Name                                      Null?    Type
 ----------------------------------------- -------- ---------------------
 USERNAME                                           VARCHAR2(25)
 PASSWORD                                           VARCHAR2(25)
 MOBILENO                                           NUMBER(10)
 EMAILID                                            VARCHAR2(40)

5)create table pnrcounter as follows
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 COUNT                                              NUMBER(6)
 NAME                                               VARCHAR2(5)

