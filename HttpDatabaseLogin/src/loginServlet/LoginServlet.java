package loginServlet;

import java.io.IOException;


import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public String fname,mb;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	try {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("uname"); 
		String pwd=request.getParameter("pwd");
		Class.forName("com.mysql.cj.jdbc.Driver");
	    String mysqlConnUrl = "jdbc:mysql://localhost:3306/y19";
     	String mysqlUserName = "root";
		String mysqlPassword = "Ram@9059";
		java.sql.Connection con = DriverManager.getConnection(mysqlConnUrl, mysqlUserName , mysqlPassword);
	 PreparedStatement stmt=con.prepareStatement("select * from Register  where email=? and pass=?");
	 stmt.setString(1, uname);
	 stmt.setString(2, pwd);
	 ResultSet rs= stmt.executeQuery();
	 
	 
	 if(rs.next()) 
	  {
			 fname = rs.getString("name");
			 mb = rs.getString("mobilenumber");

		
		 Cookie ck=new Cookie("uname",uname);   
         response.addCookie(ck); 
         Cookie ck1=new Cookie("name",fname); 
         response.addCookie(ck1); 
         Cookie ck2=new Cookie("mb",mb); 
         response.addCookie(ck2); 
         response.sendRedirect("index.html");
		 
	  }
	
	  else 
	  {
		 out.println("Invalid user name or password");
		 RequestDispatcher rd = request.getRequestDispatcher("login.html");
		 rd.include(request, response);
	  }
	}
	catch(Exception e) {
	   e.printStackTrace();
	}
	
	
	}
}

