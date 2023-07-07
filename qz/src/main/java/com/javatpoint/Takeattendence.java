package com.javatpoint;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Takeattendence
 */
@WebServlet("/Takeattendence")
public class Takeattendence extends HttpServlet {
	private static final long serialVersionUID = 1L;
       int count=1;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Takeattendence() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		PrintWriter pw = response.getWriter();
		
		try {
			String name=(String) request.getAttribute("name");
			String sid=(String) request.getAttribute("sid");
			String rn=(String) request.getAttribute("rn");
			String date=(String)request.getParameter("date");
			String ans=(String)request.getParameter("ans");
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

		}
		
			
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();

		try {
			String name=(String) request.getAttribute("name");
			String sid=(String) request.getAttribute("sid");
			String rn=(String) request.getAttribute("rn");
			String date=(String)request.getParameter("date");
			String ans="F";
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
		
		}}
	
