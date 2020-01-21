import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectDatabase {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver"); //Registering the JDBC Driver for MySQL
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC driver not found");
            return;
        }
        try {
            //Establishing Connection with the driver. Add username and password if required
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "");
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery(""); //Insert Query
            while (res.next()) {
                System.out.println(""); //Print result
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("Unable to connect to DB " + e);
        }
    }
}
