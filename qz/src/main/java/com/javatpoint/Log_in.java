package com.javatpoint;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
/**
 * Servlet implementation class Log_in
 */
@WebServlet("/Log_in")
public class Log_in extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Log_in() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		    
		 
		PrintWriter out = response.getWriter();
        
 
        String name = request.getParameter("uname");
        String password = request.getParameter("upass");
 
        if (password.equals("saraswati")) {
            out.println(
                "<h1>Welcome " + name
                + ", you have successfully logged in!</h1>");
             Cookie c = new Cookie("username", name);
         
            response.addCookie(c);
        }
        else {
            out.println(
                "Sorry invalid username or password!");
            request.getRequestDispatcher("login.html")
                .include(request, response);
            
        }
    }
 
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
