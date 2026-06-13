import java.sql.*;
import java.util.Scanner;

public class Inventario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tienda", "root", "tu_password");

            while(true){
                System.out.println("1. Listar productos");
                System.out.println("2. Agregar producto");
                System.out.println("3. Buscar producto");
                System.out.println("4. Salir");
                int opcion = sc.nextInt();
                sc.nextLine(); // limpiar buffer

                if(opcion == 1){
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM productos");
                    while(rs.next()){
                        System.out.println(rs.getInt("id") + " - " +
                                           rs.getString("nombre") + " - $" +
                                           rs.getDouble("precio"));
                    }
                } else if(opcion == 2){
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();
                    PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO productos(nombre, precio) VALUES (?, ?)");
                    ps.setString(1, nombre);
                    ps.setDouble(2, precio);
                    ps.executeUpdate();
                    System.out.println("Producto agregado!");
                } else if(opcion == 3){
                    System.out.print("Nombre a buscar: ");
                    String nombre = sc.nextLine();
                    PreparedStatement ps = con.prepareStatement(
                        "SELECT * FROM productos WHERE nombre = ?");
                    ps.setString(1, nombre);
                    ResultSet rs = ps.executeQuery();
                    if(rs.next()){
                        System.out.println("Encontrado: " + rs.getString("nombre") +
                                           " - $" + rs.getDouble("precio"));
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                } else {
                    break;
                }
            }
            con.close();
        } catch(Exception e){
            e.printStackTrace();
        }
  sc.close();  }
}
