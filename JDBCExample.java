import java.sql.*;
import javax.swing.JOptionPane;

public class JDBCExample {
    public static void main(String[] args) {
        try {
            // Load Driver

            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            String username = "root";
            String password = "@Saini7284";
            String dbName = "javaDB";

            // Create Connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Create Database
            String sql = "CREATE DATABASE " + dbName;
            String use = "USE " + dbName;
            String createTable = "CREATE TABLE IF NOT EXISTS student(rollno INT,name VARCHAR(30), marks INT)";
            String addData = "INSERT INTO student values(1,'Rahul',489),(2,'Saini',480)";

            Statement statement = connection.createStatement();
            statement.executeUpdate(use);
            statement.executeUpdate(createTable);
            statement.executeUpdate(addData);

            JOptionPane.showMessageDialog(null, "Database created successfully!");

            // Close
            statement.close();
            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
