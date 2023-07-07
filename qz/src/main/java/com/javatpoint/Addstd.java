package com.javatpoint;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Addstd
 */
@WebServlet("/Addstd")
public class Addstd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addstd() {
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
		PrintWriter pw =new PrintWriter(System.out);
		boolean status=false;

				String username=request.getParameter("sn");
				String userpass=request.getParameter("rn");
				String category=request.getParameter("dn");
			
				try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/attendence","root","");
				PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?,?)");
				ps.setString(1,null);
				ps.setString(2,username);
				ps.setString(3,userpass);
				ps.setString(4,category);

				int s=ps.executeUpdate();
				pw.print("Student added Succesfully");
				status=true;
				if(status) {
					
					response.sendRedirect("home.jsp");
				}
				else {
					
					response.sendRedirect("register.jsp");
			
				}
		
				}catch(Exception e) {
					pw.print("somthing went wrong please try again");
				
					System.out.println(e);
				}
	
	}

}
