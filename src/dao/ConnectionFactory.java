package dao;
import java.sql.*;

// funcionando
public class ConnectionFactory {
    public Connection getConnection() throws ClassNotFoundException, SQLException{
           Class.forName("com.mysql.cj.jdbc.Driver");
           String urlBD="jdbc:mysql://localhost:3306/test";
           return DriverManager.getConnection(urlBD, "root", "your_password");
    }
}
