/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imcruzarquitectura.Empresa.Negocio;

import imcruzarquitectura.Empresa.Datos.Marca;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mauriballes
 */
public class MarcaNegocio {

    private Marca m_Marca;

    public MarcaNegocio() {
        this.m_Marca = new Marca();
    }

    public DefaultTableModel obtenerMarcas() {
        DefaultTableModel marcas = new DefaultTableModel();
        marcas.setColumnIdentifiers(new Object[]{"id", "nombre"});
        LinkedList<Marca> marcasList = this.m_Marca.getMarcas();
        for (Marca marca : marcasList) {
            marcas.addRow(new Object[]{
                marca.getId(),
                marca.getNombre()
            });
        }
        return marcas;
    }

    /**
     *
     * @param nombre
     */
    public int insertarMarca(String nombre) {
        this.m_Marca.setMarca(nombre);
        return this.m_Marca.insertarMarca();
    }

    /**
     *
     * @param id
     * @param nombre
     */
    public void modificarMarca(int id, String nombre) {
        this.m_Marca.setMarca(id, nombre);
        this.m_Marca.modificarMarca();
    }
}
