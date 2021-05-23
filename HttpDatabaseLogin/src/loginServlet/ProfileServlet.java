package loginServlet;  
  
import java.io.IOException; 
 
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
public class ProfileServlet extends HttpServlet {  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)  
                          throws ServletException, IOException {  
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
       
          
        Cookie ck[]=request.getCookies();  
        Cookie ck1[]=request.getCookies(); 
        Cookie ck2[]=request.getCookies(); 
        Cookie ck3[]=request.getCookies(); 
        Cookie ck4[]=request.getCookies(); 
        if(ck!=null){  
         String uname=ck[0].getValue();  
         String name=ck1[1].getValue();  
         String mb=ck2[2].getValue();  
         String dance=ck3[3].getValue();  
         String teacher=ck4[4].getValue();  
         if(!name.equals("")||name!=null){  
           
            out.print("<br>Name:"+name);
            out.print("<br>Email: "+uname);
            out.print("<br>mobile no:"+mb+"<br>");
            out.print("<br>dance"+dance+"<br>");
            out.print("<br>teacher:"+teacher+"<br>");
   		 RequestDispatcher rd = request.getRequestDispatcher("profile.html");
   		 rd.include(request, response);
        }  
        }else{  
            out.print("Please login first");  
            request.getRequestDispatcher("login.html").include(request, response);  
        }  
        out.close();  
    }  

		
}  
