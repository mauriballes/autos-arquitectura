/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imcruzarquitectura.Cliente.Negocio;

import imcruzarquitectura.Cliente.CatalogoFacade;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mauriballes
 */
public class CatalogoNegocio {

    private CatalogoFacade m_CatalogoFacade;

    public CatalogoNegocio() {
        this.m_CatalogoFacade = new CatalogoFacade();
    }

    public DefaultTableModel listarCatalogo() {
        DefaultTableModel autos = this.m_CatalogoFacade.obtenerAutos();
        DefaultTableModel marcas = this.m_CatalogoFacade.obtenerMarcas();
        DefaultTableModel autosCatalogo = new DefaultTableModel();
        autosCatalogo.setColumnIdentifiers(new Object[]{"id","Marca", "Modelo", "Ano"});
        for (int i = 0; i < marcas.getRowCount(); i++) {
            for (int j = 0; j < autos.getRowCount(); j++) {
                // if marca_id (auto) == id (marca)
                if ((int) autos.getValueAt(j, 4) == (int) marcas.getValueAt(i, 0)) {
                    autosCatalogo.addRow(new Object[]{
                        autos.getValueAt(j, 0), // id
                        marcas.getValueAt(i, 1), // Marca
                        autos.getValueAt(j, 1), // Modelo
                        autos.getValueAt(j, 2) // Ano
                    });
                }
            }
        }
        return autosCatalogo;
    }

    /**
     *
     * @param id
     * @return 
     */
    public float getPrecio(int id) {
        DefaultTableModel auto = this.m_CatalogoFacade.obtenerAuto(id);
        int columnaPrecio = 3; // Precio
        float precio = (float) auto.getValueAt(0, columnaPrecio);
        return precio;
    }
}
