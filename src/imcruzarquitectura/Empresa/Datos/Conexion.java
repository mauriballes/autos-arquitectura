/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imcruzarquitectura.Empresa.Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mauriballes
 */
public class Conexion {

    private static Conexion _instancia;
    private Connection connection;

    private Conexion() {
    }

    public static Conexion getInstancia() {
        if (_instancia == null) {
            _instancia = new Conexion();
        }
        return _instancia;
    }

    public Connection getConexion() {
        return this.connection;
    }

    public void abrirConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/imcruz", "auto", "auto");
        } catch (SQLException e) {
            System.out.println("Connection Error: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Class Not Found Error: " + ex.getMessage());
        }
    }

    public void cerrarConexion() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            System.out.println("Connection Error: " + e.getMessage());
        }
    }
}
