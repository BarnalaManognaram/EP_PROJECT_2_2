package net.codejava;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterDAO {
    
    final String jdbcURL = "jdbc:mysql://localhost:3306/dancestudio";
  final String dbUser = "root";
  final String dbPassword = "Raghu@2002";

  public Register checklogin(String username, String password) throws SQLException, 
      ClassNotFoundException {

                System.out.println("Before class for name");
    Class.forName("com.mysql.jdbc.Driver");
    Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
    
    System.out.println("After get connection");
    String sql = "SELECT * FROM registers WHERE username = ? and password = ?";
    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setString(1, username);
    statement.setString(2, password);

    ResultSet result = statement.executeQuery();
    System.out.println("After execute query");

    Register user = null;

    if (result.next()) {
      user = new Register();
      user.setUsername(result.getString("username"));
      user.setEmail(username);
    }

    connection.close();
    System.out.println("After connection close");

    return user;
    }
    
    public void signup(String fullname,String email, String username,String mobile, String password,String confirmpassword) throws SQLException, 
      ClassNotFoundException {

                System.out.println("Before class for name");
    Class.forName("com.mysql.jdbc.Driver");
    Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
    
    System.out.println("After get connection");
    String sql = "INSERT INTO registers (email, password, confirmpassword, username) VALUES (?, ?, ?, ?)";
    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setString(1, fullname);
    statement.setString(2, email);
    statement.setString(3, username);
    statement.setString(4, mobile);
    statement.setString(5, password);
    statement.setString(6, confirmpassword);
    

    int row = statement.executeUpdate();
    System.out.println("Number of rows inserted: " + row);

    connection.close();
  }
}