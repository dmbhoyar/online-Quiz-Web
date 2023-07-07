package com.javatpoint;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Savequizs
 */
@WebServlet("/Savequizs")
public class Savequizs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Savequizs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
int counter=0;

counter++;

String id=request.getParameter("id");
 try {
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quize","root","");
String question= request.getParameter("question");
String option1= request.getParameter("option1");
String option2= request.getParameter("option2");
String option3= request.getParameter("option3");
String option4= request.getParameter("option4");
String answer=request.getParameter("answer");
String description=request.getParameter("description");

PreparedStatement ps1=con.prepareStatement("select max(SUBJECT) from quizinfo");
ResultSet rs=ps1.executeQuery();
while(rs.next()){
String quizname= rs.getString(1);

System.out.print("hi"+quizname);

PreparedStatement ps=con.prepareStatement("insert into quizques values(?,?,?,?,?,?,?,?,?)");

ps.setString(1,question);
ps.setString(2,option1);
ps.setString(3,option2);
ps.setString(4,option3);
ps.setString(5,option4);
ps.setString(6,answer);
ps.setString(7,quizname);
ps.setString(8, id);
ps.setString(9,description);
int s= ps.executeUpdate();
out.println("alert('quiz successfully submitted');");

}
}
catch(Exception e){e.printStackTrace();
System.out.println(""+e);

}


request.setAttribute("counter",counter);
response.sendRedirect("createquiz1.jsp");

	}

	
	}


