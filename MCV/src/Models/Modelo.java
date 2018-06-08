/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author FJ
 */
public class Modelo {
    private int numUno; 
    private int numDos;
    private int resultado;

    public int getNumUno() {
        return numUno;
    }

    public void setNumUno(int numUno) {
        this.numUno = numUno;
    }

    public int getNumDos() {
        return numDos;
    }

    public void setNumDos(int numDos) {
        this.numDos = numDos;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
    
    public int Multiplicar() {
        this.resultado = this.numUno * this.numDos;
        return this.resultado;
    }
}
