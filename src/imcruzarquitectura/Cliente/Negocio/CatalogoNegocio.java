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
        return this.m_CatalogoFacade.listarCatalogo();
    }
}
