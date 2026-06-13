import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestConexion {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tienda",
                "root",        // tu usuario
                "YAELmateos3107" // tu contraseña
            );

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM productos");

            while (rs.next()) {
             System.out.println(rs.getInt("id") + " - " + rs.getString("nombre")+" - "+rs.getDouble("precio"));
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
