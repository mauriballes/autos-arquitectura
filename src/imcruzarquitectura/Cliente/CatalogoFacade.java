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

    /**
     *
     * @param id
     * @return 
     */
    public DefaultTableModel obtenerAuto(int id) {
        return m_AutoNegocio.obtenerAuto(id);
    }

    public DefaultTableModel obtenerAutos() {
        return m_AutoNegocio.obtenerAutos();
    }

    public DefaultTableModel obtenerMarcas() {
        return m_MarcaNegocio.obtenerMarcas();
    }
}
