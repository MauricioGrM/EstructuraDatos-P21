/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PagosTrabajadores;

/**
 *
 * @author mauricio
 */
public class NodoPagoTrabajador {
   private PagoTrabajador dato;
   private NodoPagoTrabajador siguiente;
   private NodoPagoTrabajador atras;
   
    public NodoPagoTrabajador(PagoTrabajador dato) {
        this.dato = dato;
    }

    public PagoTrabajador getDato() {
        return dato;
    }

    public void setDato(PagoTrabajador dato) {
        this.dato = dato;
    }

    public NodoPagoTrabajador getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPagoTrabajador siguiente) {
        this.siguiente = siguiente;
    }

    public NodoPagoTrabajador getAtras() {
        return atras;
    }

    public void setAtras(NodoPagoTrabajador atras) {
        this.atras = atras;
    }

    @Override
    public String toString() {
        return "NodoPagoTrabajador{" + "dato=" + dato + ", siguiente=" + siguiente + ", atras=" + atras + '}';
    }  
}
