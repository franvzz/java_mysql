/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.ConsultasProducto;
import Models.Producto;
import Views.frmProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author FJ
 */
public class CtrlProducto implements ActionListener {
    
    private Producto mod;
    private ConsultasProducto modC;
    private frmProducto frm;
    
    public CtrlProducto (Producto mod, ConsultasProducto modC, frmProducto frm) {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.btnBuscar.addActionListener(this);
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
        
    }
    
    public void iniciar() {
        frm.setTitle("Productos"); // title pantalla
        frm.setLocationRelativeTo(null); // centrar pantalla
        frm.txtId.setVisible(false); // input id hidden
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        // Guardar
        if(e.getSource() == frm.btnGuardar) {
            mod.setCodigo(frm.txtCodigo.getText());
            mod.setNombre(frm.txtNombre.getText());
            mod.setPrecio(Double.parseDouble(frm.txtPrecio.getText()));
            mod.setCantidad(Integer.parseInt(frm.txtCantidad.getText()));
            
            if(modC.registrar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar registro");
            }
            limpiar();
        }
        
        // modificar
        if(e.getSource() == frm.btnModificar) {
            mod.setId(Integer.parseInt(frm.txtId.getText()));
            mod.setCodigo(frm.txtCodigo.getText());
            mod.setNombre(frm.txtNombre.getText());
            mod.setPrecio(Double.parseDouble(frm.txtPrecio.getText()));
            mod.setCantidad(Integer.parseInt(frm.txtCantidad.getText()));
            
            if(modC.modificar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar registro");
            }
            limpiar();
        }
        
        // eliminar
        if(e.getSource() == frm.btnEliminar) {
            mod.setId(Integer.parseInt(frm.txtId.getText()));
            
            if(modC.eliminar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar registro");
            }
            limpiar();
        }
        
        // buscar
        if(e.getSource() == frm.btnBuscar) {
            mod.setCodigo(frm.txtCodigo.getText());
            
            if(modC.buscar(mod)) {
                
                frm.txtId.setText(String.valueOf(mod.getId()));  // parse int to string
                frm.txtCodigo.setText(mod.getCodigo());
                frm.txtNombre.setText(mod.getNombre());
                frm.txtPrecio.setText(String.valueOf(mod.getPrecio())); // parse double to string
                frm.txtCantidad.setText(String.valueOf(mod.getCantidad())); // parse int to string
                
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró registro");
                limpiar();
            }
            
        }
        
        // limpiar
        if(e.getSource() == frm.btnLimpiar) {
            limpiar();
        }
        
    }
    
    public void limpiar() {
        frm.txtId.setText(null);
        frm.txtCodigo.setText(null);
        frm.txtNombre.setText(null);
        frm.txtPrecio.setText(null);
        frm.txtCantidad.setText(null);

    }
}
