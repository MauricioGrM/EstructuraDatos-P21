/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gastos;

/**
 *
 * @author mauricio
 */
public class NodoPilaGastosFincas<T> {

    private T valor;
    private NodoPilaGastosFincas<T> siguiente;

    public NodoPilaGastosFincas(T valor) {
        this.valor = valor;
    }

    public NodoPilaGastosFincas() {
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public NodoPilaGastosFincas<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPilaGastosFincas<T> siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "Nodo{" + "valor=" + valor + '}';
    }
}
