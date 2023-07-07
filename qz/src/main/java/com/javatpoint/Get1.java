package com.javatpoint;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Get1
 */
@WebServlet("/Get1")
public class Get1 extends HttpServlet {
	int count1=0;

	  int total=0; 
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Get1() {
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
		if(session.getAttribute("count")!=null){
		String name=(String)session.getAttribute("name");
		String ans= (String)session.getAttribute("ans");
		Integer count=(Integer)session.getAttribute("count");
		try{
		if(count1==0)
		{
		count1=count-1;

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quize","root","");
		PreparedStatement ps=con.prepareStatement("select answer from quizques where quizname='"+name+"' and qid='"+count1+"' ");
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
		String ans1=rs.getString(1);
		System.out.println("ans1 on c10="+ans1);
		System.out.println("ans on get1="+ans);
		if(ans1.equals(ans)){
		total=total+1;
		System.out.println("total="+total);
		}

		}

		con.close();
		}



		else{
		count1=count-2;
		System.out.print("count at get1:"+count);

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quize","root","");
		PreparedStatement ps=con.prepareStatement("select answer from quizques where quizname='"+name+"' and qid='"+count1+"' ");
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
		String ans1=rs.getString(1);
		System.out.println("ans1="+ans1);
		System.out.println("ans on get1="+ans);
		if(ans1.equals(ans)){
		total=total+1;
		System.out.println("total="+total);

		}

		}
		con.close();
		}
		if(count>(Integer)session.getAttribute("max"))
		{
		Integer max=(Integer)session.getAttribute("max");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quize","root","");
		PreparedStatement ps=con.prepareStatement("select answer from quizques where quizname='"+name+"' and qid='"+max+"' ");
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
		String ans1=rs.getString(1);
		System.out.println("ans1 on c1="+ans1);
		String ans2=(String) session.getAttribute("ans");
		System.out.println("ans on get1="+ans2);
		if(ans1.equals(ans2)){
		total=total+1;
		System.out.println("total="+total);
		}

		}

		con.close();
		request.setAttribute("total",total);
		total=0;
	

		response.sendRedirect("result.jsp");
		

		 
		}

		}catch(Exception e){e.printStackTrace();
		System.out.println(e);
		}

		}
	
		
	}

}
