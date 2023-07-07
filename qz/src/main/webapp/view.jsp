<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<html>


<jsp:include page="header.jsp"></jsp:include>

<%
String islogin=(String)session.getAttribute("islogin");
if(islogin==null){
request.setAttribute("notlogin_msg","Sorry,Please do Login first");

%>
<jsp:forward page="index.jsp"></jsp:forward>
<%
}
%>



<div class="left_content">
             <% 
					if(request.getAttribute("notlogin_msg")!=null){
					out.print("<font size='2' color='red' m>");
					out.print(request.getAttribute("notlogin_msg"));
					out.print("</font>");
					}
					%>
				<% 
					if(request.getAttribute("Error")!=null){
					out.print("<font size='2' color='red' >");
					out.print(request.getAttribute("Error"));
					out.print("</font>");
					}
					%>
					<%
					if(request.getAttribute("finished")!=null){
					   out.print("<font size='2' color='navy'>");
                   out.print("<B>");
					out.print(request.getAttribute("finished"));
					  out.print("<B>");
   						out.print("</font>");
					}
				
					%>
            	<div class="calendar_box2">
            	
                	<div class="calendar_box_content">
               
                		<h1>Welcome to QZ</h1>
                		              		<marquee direction="left" style="color: navy;" onmouseover="stop()" onmouseout="start()"><B>Assess Yourself by taking quizs on various subjects</B></marquee>
				<%
				String name=(String)session.getAttribute("name");
				try{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quize","root","");
					PreparedStatement ps= con.prepareStatement("select * from quizques where quizname='"+name+"'");
					ResultSet rs=ps.executeQuery();
					out.print("<table>");
					while(rs.next()){
					out.print("<tr><td>Question:</td><td>"+rs.getString(1)+"</td></tr>");
					out.print("<tr><td>Answer:</td><td>"+rs.getString(6)+"</td></tr>");
					out.print("<tr><td>Description:</td><td>"+rs.getString(9)+"</td></tr>");
					
					}
					out.print("</table>");
					
				}catch(Exception e){e.printStackTrace();}
				System.out.println(name);
				 %>					


                     
                	</div>
                </div>
                
               
                    <br>
                	             
                    
                    
                    
                
                </div>
            
            
           

	<div id="footer">
    
    </div>


		
</body></html>

