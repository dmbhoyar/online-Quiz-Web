<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@  page import="java.sql.*" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form>
<table>
<thead>
<tr><td>Sr.no.</td><td>Student name</td><td>date</td></tr>
</thead>
<tbody>
<% 

   
try {
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/attendence","root","");
		PreparedStatement ps=con1.prepareStatement("select * from presenty where dname='MCA';");
		ResultSet rs=ps.executeQuery();	
		while(rs.next()){
		String sname=rs.getString(1);
		String rn=rs.getString(2);
		String sid=rs.getString(3);
		String date=rs.getString(4);
		String pr=rs.getString(5);
%>	
<tr><td><%= sid %></td><td><%=sname %></td><td><%= pr %></td><td><%= date %></td><tr>

<%

		}		
%>	


<%
}catch(Exception e){
	e.getStackTrace();
}
	

	
	
	%>


</tbody>
</table>

</form>
</body>
</html>