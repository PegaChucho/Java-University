package test;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestMySQLJDBC {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTiimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";//cadena de conexión
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, "root", "admin");
            Statement instruccion =conexion.createStatement();
            var sql="SELECT id_persona,nombre,apellido,mail,telefono FROM persona";
            ResultSet resultado=instruccion.executeQuery(sql);
            while(resultado.next()){
                System.out.print("Id Persona: "+resultado.getInt("id_persona"));
                System.out.print(", Nombre: "+resultado.getString("nombre"));
                System.out.print(", Apellido: "+resultado.getString("apellido"));
                System.out.print(", Email: "+resultado.getString("mail"));
                System.out.print(", Teléfono: "+resultado.getString("telefono"));
                System.out.println(" ");
            }
            resultado.close();
            instruccion.close();
            conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
