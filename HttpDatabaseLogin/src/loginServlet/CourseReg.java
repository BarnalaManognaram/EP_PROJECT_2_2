package loginServlet;

import java.io.IOException
;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CourseReg extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	int i=0;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	try {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String full=request.getParameter("full"); 
		String email=request.getParameter("email");
		String mb=request.getParameter("mb");
		String dance=request.getParameter("dance");
		String teacher=request.getParameter("teacher");
	
		Class.forName("com.mysql.cj.jdbc.Driver");
	    String mysqlConnUrl = "jdbc:mysql://localhost:3306/y19";
     	String mysqlUserName = "root";
		String mysqlPassword = "Ram@9059";
		java.sql.Connection con = DriverManager.getConnection(mysqlConnUrl, mysqlUserName , mysqlPassword);
	 PreparedStatement ps=con.prepareStatement("insert into course values(?,?,?,?,?)");
	 ps.setString(1, full);
	 ps.setString(2, email);

	 ps.setString(3, mb);
	 ps.setString(4,dance);
	
	 ps.setString(5,teacher);
		

	ps.executeUpdate();	 
			 out.println("registration successful");
			 Cookie ck3=new Cookie("dance",dance); 
			 response.addCookie(ck3); 
			 Cookie ck4=new Cookie("teacher",teacher);  
			 response.addCookie(ck4); 
			 RequestDispatcher rd = request.getRequestDispatcher("index.html");
			 rd.include(request, response);
	 
	  
	  
	  
	}
	catch(Exception e) {
	   e.printStackTrace();
	}
	
	
	}
}

