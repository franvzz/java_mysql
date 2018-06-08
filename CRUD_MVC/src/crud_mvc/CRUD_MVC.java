/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud_mvc;

import Controllers.CtrlProducto;
import Models.ConsultasProducto;
import Models.Producto;
import Views.frmProducto;

/**
 *
 * @author FJ
 */
public class CRUD_MVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Producto mod = new Producto(); // Model
        ConsultasProducto modC = new ConsultasProducto(); // Controller
        frmProducto frm = new frmProducto(); // Vista
        
        CtrlProducto ctrl = new CtrlProducto(mod, modC, frm);
        ctrl.iniciar();
        frm.setVisible(true);
        
    }
    
}
