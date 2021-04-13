/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehiculos;

import Vehiculos.Vehiculo;

/**
 *
 * @author mauricio
 */
public class NodoArbolVehiculo {

    private Vehiculo dato;
    private NodoArbolVehiculo hijoizq;
    private NodoArbolVehiculo hijoder;

    public NodoArbolVehiculo(Vehiculo dato) {
        this.dato = dato;
    }

    @Override
    public String toString() {
        return "NodoArbolVehiculo{" + "dato=" + dato + '}';
    }

    public Vehiculo getDato() {
        return dato;
    }

    public void setDato(Vehiculo dato) {
        this.dato = dato;
    }

    public NodoArbolVehiculo getHijoizq() {
        return hijoizq;
    }

    public void setHijoizq(NodoArbolVehiculo hijoizq) {
        this.hijoizq = hijoizq;
    }

    public NodoArbolVehiculo getHijoder() {
        return hijoder;
    }

    public void setHijoder(NodoArbolVehiculo hijoder) {
        this.hijoder = hijoder;
    }
}
