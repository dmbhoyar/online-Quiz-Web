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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		String username=request.getParameter("username");
		System.out.print(username);
		String userpass=request.getParameter("userpass");
		String category=request.getParameter("category");
		HttpSession session=request.getSession();
		boolean status=false;
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quize","root","");
		PreparedStatement ps=con.prepareStatement("select * from quizeregister where username=? and userpass=? ");
		ps.setString(1,username);
		ps.setString(2,userpass);
		ResultSet rs=ps.executeQuery();
		status=rs.next();
		if(status){
		System.out.print("hi");
		username=rs.getString(1);
	
		session.setAttribute("username",String.valueOf(username));
		session.setAttribute("islogin","plz sign in first");
		session.setAttribute("category",category);
		response.sendRedirect("home.jsp");
	
		}
		else{
		System.out.print("hi");
		request.setAttribute("Error","Sorry! Username or Password Error. plz Enter Correct Detail or Register");
		session.setAttribute("Loginmsg","plz sign in first");
		response.sendRedirect("index.jsp");
		
		}
		}

		catch(Exception e){
		e.printStackTrace();
		}

	}

}
