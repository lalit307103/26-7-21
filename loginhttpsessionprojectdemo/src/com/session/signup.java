package com.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.jdbc.pool.OracleDataSource;

/**
 * Servlet implementation class signup
 */
@WebServlet("/signup")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signup() {
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
		PrintWriter out=response.getWriter();
		//capture the values entered by the user
		
	
		
    String name = request.getParameter("admin_name");
	String pwd = request.getParameter("admin_pwd");
  	Connection con;
		PreparedStatement prp;
		OracleDataSource ods;
			String qry="insert into administrator values(?,?)";
		try {
			//create an object for ODS
			ods=new OracleDataSource();
			//injecting the appropriate values
			ods.setUser("system");
			ods.setPassword("test");
			ods.setPortNumber(1521);
			ods.setDriverType("thin");
			ods.setServerName("localhost");
			ods.setDatabaseName("xe");
			con=ods.getConnection(); //get the connection
			prp=con.prepareStatement(qry);
			//setting the IN parameters
			 
			prp.setString(1, name);
			prp.setString(2, pwd);
			int row=prp.executeUpdate();  //executing query
			     if(row>0)
			     {
			    out.println("   <p> <p style = font-size:25px><b> :Admin Record Save Sucessfully </b></P");
			  //   response.sendRedirect("pages/signin.jsp?type=0");
			    HttpSession session = request.getSession();// create a session object
				session.setAttribute("login", "admin");//setting the attribute
				session.setAttribute("pswd", "pwd");
				response.sendRedirect("pages/signUpSuccess.jsp");//redirecting to home page after successfull authentication
			
			     }
			     else
			     {
			    	 response.sendRedirect("pages/signUpFail.jsp");//redirecting to home page after successfull authentication
					   
			    	 //out.println("<p> <p style = font-size:25px><b>:This UserName is Already Register..Please try again");
			     }
		}
		
		catch(Exception e) {
			//e.printStackTrace();
			// out.println("<p> <p style = font-size:25px><b>:This UserName is Already Register..Please try again");
			//session.setAttribute("login", "admin");//setting the attribute
			//session.setAttribute("pswd", "pwd");
			 response.sendRedirect("pages/signUpFail.jsp");//redirecting to home page after successfull authentication
				
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
