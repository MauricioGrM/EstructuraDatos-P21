/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabajador;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*+------------------------------------------+*\
  | UTILIZACION DE LISTAS SIMPLES            |
  +------------------------------------------+
  | PROYECTO ESTRUCTURA DE DATOS | IC | 2021 |
\*+------------------------------+----+------+*/
public class HandlerTrabajador {

    private NodoListaSimpleTrabajador cabeza;

    public void insertarTrabajador(Trabajador p) {
        if (cabeza == null) {
            cabeza = new NodoListaSimpleTrabajador(p);
        } else if (p.getIdTrabajador() < cabeza.getDato().getIdTrabajador()) {
            NodoListaSimpleTrabajador aux = new NodoListaSimpleTrabajador(p);
            aux.setSiguiente(cabeza);
            cabeza = aux;
        } else if (cabeza.getSiguiente() == null) {
            cabeza.setSiguiente(new NodoListaSimpleTrabajador(p));
        } else {
            NodoListaSimpleTrabajador aux = cabeza;
            while (aux.getSiguiente() != null && aux.getDato().getIdTrabajador() < p.getIdTrabajador()) {
                aux = aux.getSiguiente();
            }
            NodoListaSimpleTrabajador temp = new NodoListaSimpleTrabajador(p);
            temp.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(temp);
        }
    }

    public void verTrabajadores() {
        Object[][] rowData = {};
        Object[] columnNames = {"ID", "CEDULA", "NOMBRE", "EDAD", "TELEFONO"};
        DefaultTableModel listTableModel;
        listTableModel = new DefaultTableModel(rowData, columnNames);
        NodoListaSimpleTrabajador aux = cabeza;
        while (aux != null) {
            listTableModel.addRow(new Object[]{
                aux.getDato().getIdTrabajador(),
                aux.getDato().getCedula(),
                aux.getDato().getNombre(),
                aux.getDato().getEdad(),
                aux.getDato().getTelefono()
            });
            aux = aux.getSiguiente();
        }
        JTable table = new JTable(listTableModel);
        JOptionPane.showMessageDialog(null, new JScrollPane(table));
    }

    public int cantidad() {
        int contador = 0;
        NodoListaSimpleTrabajador aux = cabeza;
        while (aux != null) {
            contador++;
            aux = aux.getSiguiente();
        }
        return contador;
    }
}
