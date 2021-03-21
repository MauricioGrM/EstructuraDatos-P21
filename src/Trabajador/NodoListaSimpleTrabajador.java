/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabajador;

import Trabajador.Trabajador;

/**
 *
 * @author mauricio
 */
public class NodoListaSimpleTrabajador {
    private Trabajador dato;
    private NodoListaSimpleTrabajador siguiente;
    
    public NodoListaSimpleTrabajador(Trabajador dato) {
        this.dato = dato;
    }

    public Trabajador getDato() {
        return dato;
    }

    public void setDato(Trabajador dato) {
        this.dato = dato;
    }

    public NodoListaSimpleTrabajador getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoListaSimpleTrabajador siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "NodoListaSimpleTrabajador{" + "dato=" + dato + ", siguiente=" + siguiente + '}';
    }
}
