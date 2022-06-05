package controlador;

import java.sql.DriverManager;
import java.sql.SQLException;
public class conexion
{
   public static void main(String[] args){
       try{
            Class.forName("com.mysql.jdbc.Driver");
            DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "joseojeda");
            System.out.println("Conexión OK");
       }catch (ClassNotFoundException e){
            System.out.println("Error al cargar el controlador");
            e.printStackTrace();
         }catch (SQLException e){
            System.out.println("Error en la conexión");
            e.printStackTrace();
         }
   }
}