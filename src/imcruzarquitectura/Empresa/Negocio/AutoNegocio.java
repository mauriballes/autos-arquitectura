/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imcruzarquitectura.Empresa.Negocio;

import imcruzarquitectura.Empresa.Datos.Auto;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mauriballes
 */
public class AutoNegocio {

    private Auto m_Auto;

    public AutoNegocio() {
        this.m_Auto = new Auto();
    }

    /**
     *
     * @param id
     * @return 
     */
    public DefaultTableModel obtenerAuto(int id) {
        DefaultTableModel auto = new DefaultTableModel();
        Auto autoDatos = m_Auto.getAuto(id);
        auto.setColumnIdentifiers(new Object[]{"id", "modelo", "ano", "precio", "marca_id"});
        auto.addRow(new Object[]{
            autoDatos.getId(),
            autoDatos.getModelo(),
            autoDatos.getAno(),
            autoDatos.getPrecio(),
            autoDatos.getMarca_id()
        });
        return auto;
    }

    public DefaultTableModel obtenerAutos() {
        DefaultTableModel autos = new DefaultTableModel();
        autos.setColumnIdentifiers(new Object[]{"id", "modelo", "ano", "precio", "marca_id"});
        LinkedList<Auto> autosList = this.m_Auto.getAutos();
        for (Auto auto : autosList) {
            autos.addRow(new Object[]{
                auto.getId(),
                auto.getModelo(),
                auto.getAno(),
                auto.getPrecio(),
                auto.getMarca_id()
            });
        }
        return autos;
    }

    /**
     *
     * @param modelo
     * @param ano
     * @param precio
     * @param marca_id
     * @return
     */
    public int insertarAuto(String modelo, int ano, float precio, int marca_id) {
        this.m_Auto.setAuto(modelo, ano, precio, marca_id);
        return this.m_Auto.insertarAuto();
    }

    /**
     *
     * @param id
     * @param modelo
     * @param ano
     * @param precio
     * @param marca_id
     */
    public void modificarAuto(int id, String modelo, int ano, float precio, int marca_id) {
        this.m_Auto.setAuto(id, modelo, ano, precio, marca_id);
        this.m_Auto.modificarAuto();
    }
}
