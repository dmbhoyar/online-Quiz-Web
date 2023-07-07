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
<%
try {
	String name=(String) request.getAttribute("name");
	String sid=(String) request.getAttribute("sid");
	String rn=(String) request.getAttribute("rn");
	String date=(String)request.getParameter("date");
	String ans="A";
	System.out.println(date);
Class.forName("com.mysql.cj.jdbc.Driver");

Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/attendence","root","");



System.out.println(date);

PreparedStatement ps2=con1.prepareStatement("insert into presenty values(?,?,?,?,?);");
ps2.setString(1,name);
ps2.setString(2,rn);
ps2.setString(3,sid);

ps2.setString(4,date);
ps2.setString(5,ans);

ps2.executeUpdate();


}
	catch(Exception e) {
		e.getStackTrace();
		System.out.println("catch"+e);
	}


%>

</body>
</html>