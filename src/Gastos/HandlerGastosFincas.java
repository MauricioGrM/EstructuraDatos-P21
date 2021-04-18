/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gastos;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*+------------------------------------------+*\
  | UTILIZACION DE PILAS                     |
  +------------------------------------------+
  | PROYECTO ESTRUCTURA DE DATOS | IC | 2021 |
\*+------------------------------+----+------+*/
public class HandlerGastosFincas {

    private NodoPilaGastosFincas inicio;
    private int tamanio = 0;

    public boolean esVacia() {
        return inicio == null;
    }

    public void ApilarGastos(int valor) {
        NodoPilaGastosFincas nuevo = new NodoPilaGastosFincas();
        nuevo.setValor(valor);

        if (esVacia()) {
            inicio = nuevo;
        } else {
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        }
        tamanio++;
    }

    public int CantidadSistema() {
        return tamanio;
    }

    public void VerGastos() {
        int Gasto = 0;
        Object[][] rowData = {};
        Object[] columnNames = {"SEMANA", "GASTO"};
        DefaultTableModel listTableModel;
        listTableModel = new DefaultTableModel(rowData, columnNames);
        NodoPilaGastosFincas aux = inicio;
        while (aux != null) {
            Gasto = Gasto + 1;
            listTableModel.addRow(new Object[]{
                Gasto,
                aux.getValor(),});
            aux = aux.getSiguiente();
        }
        JTable table = new JTable(listTableModel);
        JOptionPane.showMessageDialog(null, new JScrollPane(table));
    }

    public int ObtieneTotal() {
        int total = 0;
        NodoPilaGastosFincas aux = inicio;
        while (aux != null) {
            total = total + Integer.parseInt(aux.getValor().toString());
            aux = aux.getSiguiente();
        }
        return total;
    }

    public boolean buscarGasto(int referencia) {
        int Gasto = 0;
        NodoPilaGastosFincas temp = inicio;
        boolean encontrado = false;
        while (temp != null && encontrado != true) {
            Gasto = Gasto + 1;
            if (referencia == Gasto) {
                encontrado = true;
            } else {
                temp = temp.getSiguiente();
            }
        }
        return encontrado;
    }

    public void editarGasto(int referencia, int NuevoPago) {
        int Gasto = 1;
        if (buscarGasto(referencia)) {
            NodoPilaGastosFincas temp = inicio;
            if (Gasto == referencia) {
                temp.setValor(NuevoPago);
            } else {
                while (Gasto != referencia) {
                    Gasto = Gasto + 1;
                    temp = temp.getSiguiente();
                }
                temp.setValor(NuevoPago);
            }
        }
    }

    public void eliminarGasto(int referencia) {
        int Gasto = 1;
        if (buscarGasto(referencia)) {
            if (Gasto == referencia) {
                inicio = inicio.getSiguiente();
            } else {
                NodoPilaGastosFincas temp = inicio;
                while (Gasto != referencia - 1) {
                    Gasto = Gasto + 1;
                    temp = temp.getSiguiente();
                }
                NodoPilaGastosFincas siguiente = temp.getSiguiente().getSiguiente();
                temp.setSiguiente(siguiente);
            }
        }
    }
}
