/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imcruzarquitectura.Empresa.Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mauriballes
 */
public class Marca {

    private int id;
    private String nombre;

    private Conexion m_Conexion;

    public Marca() {
        this.m_Conexion = Conexion.getInstancia();
    }

    public LinkedList<Marca> getMarcas() {
        this.m_Conexion.abrirConexion();
        Connection con = this.m_Conexion.getConexion();
        LinkedList<Marca> marcas = new LinkedList<>();
        String sql = "SELECT \n"
                + "imcruz.marcas.id,\n"
                + "imcruz.marcas.nombre\n"
                + "FROM imcruz.marcas";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Marca marca = new Marca();
                marca.setMarca(
                        rs.getInt("id"),
                        rs.getString("nombre")
                );
                marcas.add(marca);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Marca.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.m_Conexion.cerrarConexion();
        return marcas;
    }

    public int insertarMarca() {
        this.m_Conexion.abrirConexion();
        Connection con = this.m_Conexion.getConexion();
        int generate_Id = 0;
        try {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO imcruz.marcas(nombre)\n"
                    + "VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, this.nombre);
            int rows = ps.executeUpdate();
            if (rows != 0) {
                ResultSet generateKeys = ps.getGeneratedKeys();
                if (generateKeys.next()) {
                    generate_Id = generateKeys.getInt(1);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Marca.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.m_Conexion.cerrarConexion();
        return generate_Id;
    }

    public void modificarMarca() {
        this.m_Conexion.abrirConexion();
        Connection con = this.m_Conexion.getConexion();
        try {
            String sql = "UPDATE imcruz.marcas \n"
                    + "SET imcruz.marcas.nombre = ?\n"
                    + "WHERE imcruz.marcas.id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, this.nombre);
            ps.setInt(2, this.id);
            int rows = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Marca.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.m_Conexion.cerrarConexion();
    }

    /**
     *
     * @param nombre
     */
    public void setMarca(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @param id
     * @param nombre
     */
    public void setMarca(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

}
