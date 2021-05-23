package loginServlet;

import java.io.IOException

;
import java.io.PrintWriter;
import java.sql.*;

import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SignupServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final ServletRequest session = null;
	int i=0;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String full=request.getParameter("full"); 
		String email=request.getParameter("email");
		String mb=request.getParameter("mb");
		String pwd=request.getParameter("pwd");
	try {
		
	
		Class.forName("com.mysql.cj.jdbc.Driver");
	    String mysqlConnUrl = "jdbc:mysql://localhost:3306/y19";
     	String mysqlUserName = "root";
		String mysqlPassword = "Ram@9059";
		java.sql.Connection con = DriverManager.getConnection(mysqlConnUrl, mysqlUserName , mysqlPassword);
	 PreparedStatement ps=con.prepareStatement("insert into Register values(?,?,?,?)");
	 ps.setString(1, full);
	 ps.setString(2, email);
	 ps.setString(3, mb);
	 ps.setString(4,pwd);
	 PreparedStatement stmt=con.prepareStatement("select * from Register  where email=? ");
	 stmt.setString(1, email);
	 
	 ResultSet rs= stmt.executeQuery();
	 if(rs.next()) 
	  {
		 out.println("registration unsuccessful");
		 RequestDispatcher rd = request.getRequestDispatcher("signup.html");
		 rd.include(request, response);
	  }
		 
	 else{
		 ps.executeUpdate();	
		    out.println("Registration successful");
			 RequestDispatcher rd = request.getRequestDispatcher("login.html");
			 rd.include(request, response);
	 }
	  
	  
	  
	}
	catch(Exception e) {
	   e.printStackTrace();
	}
	
	
	}
}

