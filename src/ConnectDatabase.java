import java.sql.*;

public class ConnectDatabase {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC driver not found");
            return;
        }
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "");
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery("select * from employee;");
            while (res.next()) {
                System.out.println(res.getInt(1) + " " + res.getString(2));
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("Unable to connect to DB " + e);
        }
    }
}
