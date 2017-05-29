/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imcruzarquitectura.Cliente;

import imcruzarquitectura.Empresa.Negocio.AutoNegocio;
import imcruzarquitectura.Empresa.Negocio.MarcaNegocio;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mauriballes
 */
public class CatalogoFacade {

    private AutoNegocio m_AutoNegocio;
    private MarcaNegocio m_MarcaNegocio;

    public CatalogoFacade() {
        this.m_AutoNegocio = new AutoNegocio();
        this.m_MarcaNegocio = new MarcaNegocio();
    }

    public DefaultTableModel listarCatalogo() {
        DefaultTableModel autos = this.m_AutoNegocio.obtenerAutos();
        DefaultTableModel marcas = this.m_MarcaNegocio.obtenerMarcas();
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
        return m_AutoNegocio.obtenerAuto(id).getPrecio();
    }
}
