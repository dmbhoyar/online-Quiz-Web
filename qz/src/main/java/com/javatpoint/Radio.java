package com.javatpoint;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Radio
 */
@WebServlet("/Radio")
public class Radio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Radio() {
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
	 * @param session 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response, ServletRequest session) throws ServletException, IOException {
		
         if((String)request.getParameter("radio")!=null){
    			  String ans=(String)request.getParameter("radio");
					System.out.println("ans on set"+ans);
    			  session.setAttribute("ans",ans);
         	
         } 
         else {
         	System.out.println("else part"+request.getParameter("radio"));
         
				
	}
         
         RequestDispatcher dispatcher =
			       getServletContext().getRequestDispatcher("/Get");
			    dispatcher.forward(request, response);
}
}
