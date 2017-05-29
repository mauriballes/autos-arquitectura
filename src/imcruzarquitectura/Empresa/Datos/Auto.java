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
public class Auto {

    private int id;
    private String modelo;
    private int ano;
    private float precio;
    private int marca_id;

    private Conexion m_Conexion;

    public Auto() {
        this.m_Conexion = Conexion.getInstancia();
    }

    /**
     *
     * @param id
     */
    public Auto getAuto(int id) {
        this.m_Conexion.abrirConexion();
        Connection con = this.m_Conexion.getConexion();
        Auto auto = null;
        String sql = "SELECT \n"
                + "imcruz.autos.id,\n"
                + "imcruz.autos.modelo,\n"
                + "imcruz.autos.ano,\n"
                + "imcruz.autos.precio,\n"
                + "imcruz.autos.marca_id\n"
                + "FROM imcruz.autos\n"
                + "WHERE imcruz.autos.id = " + id;
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                auto = new Auto();
                auto.setAuto(
                        rs.getInt("id"),
                        rs.getString("modelo"),
                        rs.getInt("ano"),
                        rs.getFloat("precio"),
                        rs.getInt("marca_id")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(Auto.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.m_Conexion.cerrarConexion();
        return auto;
    }

    public LinkedList<Auto> getAutos() {
        this.m_Conexion.abrirConexion();
        Connection con = this.m_Conexion.getConexion();
        LinkedList<Auto> autos = new LinkedList<>();
        String sql = "SELECT \n"
                + "imcruz.autos.id,\n"
                + "imcruz.autos.modelo,\n"
                + "imcruz.autos.ano,\n"
                + "imcruz.autos.precio,\n"
                + "imcruz.autos.marca_id\n"
                + "FROM imcruz.autos";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Auto auto = new Auto();
                auto.setAuto(
                        rs.getInt("id"),
                        rs.getString("modelo"),
                        rs.getInt("ano"),
                        rs.getFloat("precio"),
                        rs.getInt("marca_id")
                );
                autos.add(auto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Auto.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.m_Conexion.cerrarConexion();
        return autos;
    }

    public int insertarAuto() {
        this.m_Conexion.abrirConexion();
        Connection con = this.m_Conexion.getConexion();
        int generate_Id = 0;
        try {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO imcruz.autos(modelo,ano,precio,marca_id)\n"
                    + "VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, this.modelo);
            ps.setInt(2, this.ano);
            ps.setFloat(3, this.precio);
            ps.setInt(4, this.marca_id);
            int rows = ps.executeUpdate();
            if (rows != 0) {
                ResultSet generateKeys = ps.getGeneratedKeys();
                if (generateKeys.next()) {
                    generate_Id = generateKeys.getInt(1);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Auto.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.m_Conexion.cerrarConexion();
        return generate_Id;
    }

    public void modificarAuto() {
        this.m_Conexion.abrirConexion();
        Connection con = this.m_Conexion.getConexion();
        try {
            String sql = "UPDATE imcruz.autos \n"
                    + "SET imcruz.autos.modelo = ?,\n"
                    + "imcruz.autos.ano = ?,\n"
                    + "imcruz.autos.precio = ?,\n"
                    + "imcruz.autos.marca_id = ?\n"
                    + "WHERE imcruz.autos.id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, this.modelo);
            ps.setInt(2, this.ano);
            ps.setFloat(3, this.precio);
            ps.setInt(4, this.marca_id);
            ps.setInt(5, this.id);
            int rows = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Auto.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.m_Conexion.cerrarConexion();
    }

    /**
     *
     * @param modelo
     * @param ano
     * @param precio
     * @param marca_id
     */
    public void setAuto(String modelo, int ano, float precio, int marca_id) {
        this.modelo = modelo;
        this.ano = ano;
        this.precio = precio;
        this.marca_id = marca_id;
    }

    /**
     *
     * @param id
     * @param modelo
     * @param ano
     * @param precio
     * @param marca_id
     */
    public void setAuto(int id, String modelo, int ano, float precio, int marca_id) {
        this.id = id;
        this.modelo = modelo;
        this.ano = ano;
        this.precio = precio;
        this.marca_id = marca_id;
    }

    public int getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public int getMarca_id() {
        return marca_id;
    }

    public float getPrecio() {
        return precio;
    }

}
