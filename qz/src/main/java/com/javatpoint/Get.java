package com.javatpoint;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Get
 */
@WebServlet("/Get")
public class Get extends HttpServlet {
	
	int count=0; 
	 int count1=0;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Get() {
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
		
		HttpSession session=request.getSession();
		
		String name=(String)session.getAttribute("name");
		
		
		try{


			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quize","root","");
		if(count==0){
		PreparedStatement ps1= con.prepareStatement("select min(qid) from quizques where quizname='"+name+"'");
		PreparedStatement ps2= con.prepareStatement("select max(qid) from quizques where quizname='"+name+"'");
		ResultSet rs1= ps1.executeQuery();
		ResultSet rs2=ps2.executeQuery();
		if(rs2.next()){
		count1=rs2.getInt(1);
		session.setAttribute("max",count1);
		}
		if(rs1.next()){
		count=rs1.getInt(1);
		session.setAttribute("min",count);

		}
		}
		if(count>0){
		PreparedStatement ps=con.prepareStatement("select * from quizques where quizname='"+name+"' and qid='"+count+"' ");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
		String question=rs.getString(1);
		String option1= rs.getString(2);
		String option2= rs.getString(3);
		String option3= rs.getString(4);
		String option4= rs.getString(5);
		session.setAttribute("question",question);
		session.setAttribute("option1",option1);
		session.setAttribute("option2",option2);
		session.setAttribute("option3",option3);
		session.setAttribute("option4",option4);
		}

		}
		System.out.println("counter"+count);
		count++;
		session.setAttribute("count",count);
		if(count<=4) {
			
			response.sendRedirect("start.jsp");
		}
		else
		{
			RequestDispatcher dispatcher =
				       getServletContext().getRequestDispatcher("/Get1");
				    dispatcher.forward(request, response);

			
		}
		
		if(count>(Integer)session.getAttribute("max")){
		    count=0;
		  session.setAttribute("ans",null);
		
		}
		con.close();

		}catch(Exception e){
			e.printStackTrace();
		System.out.println(""+e);
		}
	
		
	}

}
