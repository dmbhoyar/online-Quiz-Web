package com.javatpoint;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registerservlet
 */
@WebServlet("/Registerservlet")
public class Registerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registerservlet() {
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

			String username=request.getParameter("username");
			String userpass=request.getParameter("userpass");
			String category=request.getParameter("category");
			String email=request.getParameter("email");
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quize","root","");
			PreparedStatement ps=con.prepareStatement("insert into quizeregister values(?,?,?,?)");

			ps.setString(1,username);
			ps.setString(2,userpass);
			ps.setString(3,category);
			ps.setString(4,email);
			int s=ps.executeUpdate();
			System.out.print("data base is connected");
			status=true;
			if(status) {
				
				response.sendRedirect("home.jsp");
			}
			else {
				
				response.sendRedirect("register.jsp");
		
			}
	
			}catch(Exception e) {
				System.out.print("data base is not connected"+e);
			
			
}
			
}

	
}