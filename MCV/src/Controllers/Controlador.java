/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.awt.event.ActionListener;

import Models.Modelo;
import Views.Vista;
import java.awt.event.ActionEvent;


/**
 *
 * @author FJ
 */
public class Controlador implements ActionListener {
    
    private Vista view;
    private Modelo model;
    
    public Controlador(Vista view, Modelo model) {
        this.view = view;
        this.model = model;
        
        this.view.btnMultiplicar.addActionListener(this);
    }
    
    public void iniciar() {
        view.setTitle("MVC Multiplicar"); // title de pantalla
        view.setLocationRelativeTo(null); // pantalla centrada
    }
    
    public void actionPerformed(ActionEvent e) {
        model.setNumUno(Integer.parseInt(view.txtUno.getText()));
        model.setNumDos(Integer.parseInt(view.txtDos.getText()));
        model.Multiplicar();
        
        view.txtResultado.setText(String.valueOf(model.getResultado()));
    }
}
