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
	<form >
	<a href="attendence.jsp"></a><input type="submit" value="Refresh"></a>
	<br>
	<table>
	<thead><tr><td>Sr. no.</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Student name</td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="date" name="date"></</td></tr></thead>
<% 

try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/attendence","root","");
		
			PreparedStatement ps=con.prepareStatement("select * from student where dpt_name='MCA' ;");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
			String sid=rs.getString(1);
			String name=rs.getString(2);
			String rn=rs.getString(3);
			String dname=rs.getString(4);
			
			
			
			
	
			String ans=null;
			
            if((String)request.getParameter("checkbox")!=null){
            
					 
       			  ans="P";
       			System.out.println("ans on set"+ans);
            }
            else{
            	  ans="A";
            }
            %>
            <tr><td><%= sid %></td><td>&nbsp;&nbsp;&nbsp;<%= name %></td><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="checkbox"></td><td></td></tr>
			
            <% 
			
			 String date=(String)request.getParameter("date");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/attendence","root","");
			
			
			
		
			
			PreparedStatement ps2=con.prepareStatement("insert into presenty values(?,?,?,?,?,?);");
			ps2.setString(1,name);
			ps2.setString(2,rn);
			ps2.setString(3,sid);
			ps2.setString(4,date);
			ps2.setString(5,ans);
			ps2.setString(6,dname);
			ps2.executeUpdate();
			ans=null;
			
}
}
			catch(Exception e) {
				e.getStackTrace();
				System.out.println("catch"+e);
				
				
					
			}

		%>
 
<tr><td></td><td><input type="submit" value="Submit"></td></tr>
</table>
	</form>
</body>
</html>