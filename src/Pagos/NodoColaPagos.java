/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pagos;

/**
 *
 * @author mauricio
 */
public class NodoColaPagos {
    private int info;
    private NodoColaPagos sig;

    public NodoColaPagos() {
    }

    public NodoColaPagos(int info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "NodoColaPagos{" + "info=" + info + '}';
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public NodoColaPagos getSig() {
        return sig;
    }

    public void setSig(NodoColaPagos sig) {
        this.sig = sig;
    }
}
