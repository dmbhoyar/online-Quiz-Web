<%@page import="java.awt.Dialog"%><jsp:include page="header.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="style.css">
<%
String islogin=(String)session.getAttribute("islogin");
if(islogin==null){
request.setAttribute("notlogin_msg","Sorry,Please do Login first");

%>
<jsp:forward page="index.jsp"></jsp:forward>
<%
}
%>

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
					 	if(request.getAttribute("counter")!=null){
                   Integer i=(Integer)request.getAttribute("counter");
                  		 if(i==2){
   								request.setAttribute("finished","quiz successfully submitted");
   								
   					%>
   				          <jsp:forward page="home.jsp"></jsp:forward>
   							          <% 
   							             
                   }}
                  %>
                  <div class="left_content">
                  
            	<div class="calendar_box2">
            	
                	<div class="calendar_box_content">
              
               
                		<h1>Welcome to QZ</h1>
                		                   		<marquee direction="left" style="color: navy;" onmouseover="stop()" onmouseout="start()"><B>Note: Do not repeat question number</B></marquee>
                		   
                		<form method="post" action=Savequizs>
					<table>
					<tr><td>Question Number<input style="width:20px;" type="text" name="id"></td><td>Question:<textarea rows="3" cols="" name="question" ></textarea></td></tr>
					<tr><td>Option1:</td><td><input type="text" name="option1" /></td></tr>	
					<tr><td>Option2:</td><td><input type="text" name="option2" /></td></tr>
					<tr><td>Option3:</td><td><input type="text" name="option3" /></td></tr>
					<tr><td>Option4:</td><td><input type="text" name="option4" /></td></tr>
					<tr><td>Answer:</td><td><input type="text" name="answer" /></td></tr>	
					<tr><td>Description:</td><td><input type="text" name="description" /></td></tr>			
                    <tr><td></td><td><input type="submit" value="Save"></td></tr>
                    </table>
                    
                     </form>
                     <table>
                   <tr> <marquee direction="left" style="color: navy;" onmouseover="stop()" onmouseout="start()"><B>If you added all your Questions then click on the below button for going to home page</B></marquee>
                		 
                		</tr> 
                		<tr> <a href="home.jsp"><input type="submit" color="orange" value="Submit"></a></tr>
                		 
                  </table>
					

                    
                	</div>
                </div>
                
                
                                
                    
                    
                    
                
                </div>
            
            
          

         


	<div id="footer">
    
    </div>
		</div> <!--end of center box-->
	</div> <!--end of main content-->
</div> <!--end of main container-->
</body></html>

