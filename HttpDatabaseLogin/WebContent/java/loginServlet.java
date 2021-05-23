package net.codejava;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public loginServlet() {
    super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        RegisterDAO userDao = new RegisterDAO();
    
    try {
      Register user = userDao.checklogin(username, password);
      String destPage = "login.jsp";
      
      if (user != null) {
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        destPage = "homepage.jsp";
      } else {
        String message = "Invalid email/password";
        request.setAttribute("message", message);
      }
      
      RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
      dispatcher.forward(request, response);
      
    }  (SQLException catch| ClassNotFoundException ex) {
      throw new ServletException(ex);
    }
  }

}