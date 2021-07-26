package com.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jdbc.oracle.util.GetMyOracleConnection;

import oracle.jdbc.pool.OracleDataSource;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		//to authenticate the id an pwd
		
		/*if(request.getParameter("login").equals("admin")&& request.getParameter("pwd").equals("admin")) {
			
			HttpSession session = request.getSession();// create a session object
			session.setAttribute("login", "admin");//setting the attribute
			response.sendRedirect("pages/home.jsp");//redirecting to home page after successfull authentication
			
		}
		else
		{
			response.sendRedirect("pages/signin.jsp?type=0");//user would be prompted to enter credential again
		}*/
	        response.setContentType("text/html");
			
			PrintWriter out = response.getWriter();
			RequestDispatcher rd;
		    Connection con = GetMyOracleConnection.getMyOracleConn(); 
			OracleDataSource ods;
		    PreparedStatement prp;
		    String qry = "select admin_name from  administrator where admin_name=? AND admin_pwd=?";
			try {
				prp = con.prepareStatement(qry);
				String login=request.getParameter("admin");
				String pswd=request.getParameter("pwd");
				
				prp.setString(1,login);
				prp.setString(2,pswd);
				int row=prp.executeUpdate();  //executing query
				if(row>0)
				{
				//out.println("<p><p>You Are Login sucessfully &nbsp &nbsp"+name);
				 
				//out.println("<h1>welcome to home page");
					
					
					HttpSession session = request.getSession();// create a session object
					session.setAttribute("login", "admin");//setting the attribute
					session.setAttribute("pswd", "pwd");
					response.sendRedirect("pages/home.jsp");//redirecting to home page after successfull authentication
				
				}
				else
			{   
				/*out.println("<p><p>");
				out.println("Please Enter Correct Admin Name");			
				rd = request.getRequestDispatcher("admin.jsp");
				rd.include(request, response);*/
					
		      response.sendRedirect("pages/signin.jsp?type=0");//user would be prompted to enter credential again
					
			}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
