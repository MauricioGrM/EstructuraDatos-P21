/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PagosTrabajadores;

import Trabajador.NodoListaSimpleTrabajador;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*+------------------------------------------+*\
  | UTILIZACION DE LISTAS CIRCULAR DOBLE     |
  +------------------------------------------+
  | PROYECTO ESTRUCTURA DE DATOS | IC | 2021 |
\*+------------------------------+----+------+*/

public class HandlerPagoTrabajador {
    private NodoPagoTrabajador cabeza;
    private NodoPagoTrabajador ultimo;

    public void insertarPagoTrabajador(PagoTrabajador p) {
        if (cabeza == null) {
            cabeza = new NodoPagoTrabajador(p);
            ultimo = cabeza;
            ultimo.setSiguiente(cabeza);
            cabeza.setAtras(ultimo);

        } else if (p.getId() < cabeza.getDato().getId()) {

            NodoPagoTrabajador aux = new NodoPagoTrabajador(p);
            aux.setSiguiente(cabeza);
            cabeza.setAtras(aux);
            cabeza = aux;
            ultimo.setSiguiente(cabeza);
            cabeza.setAtras(ultimo);

        } else if (ultimo.getDato().getId() <= p.getId()) {
            NodoPagoTrabajador aux = new NodoPagoTrabajador(p);
            ultimo.setSiguiente(aux);
            aux.setAtras(ultimo);
            ultimo = ultimo.getSiguiente();//ultimo = aux;
            ultimo.setSiguiente(cabeza);
            cabeza.setAtras(ultimo);

        } else {
            NodoPagoTrabajador aux = cabeza;
            while (aux.getSiguiente().getDato().getId() < p.getId()) {
                aux = aux.getSiguiente();
            }
            NodoPagoTrabajador temp = new NodoPagoTrabajador(p);
            temp.setSiguiente(aux.getSiguiente());
            temp.setAtras(aux);
            aux.setSiguiente(temp);
            temp.getSiguiente().setAtras(temp);
        }

    }
 
    
    
    public void verPagosRealizados(){
        Object[][] rowData = {};
        Object[] columnNames = { "ID CAJUELA", "ID TRABAJADOR", "CAJUELAS", "FINCA"};
        DefaultTableModel listTableModel;
        listTableModel = new DefaultTableModel(rowData, columnNames);
        NodoPagoTrabajador aux = cabeza;
        if (aux != null) {
            listTableModel.addRow(new Object[] {
                aux.getDato().getId(),
                aux.getDato().getTrabajadorId(),
                aux.getDato().getCajuelas(),
                aux.getDato().getFinca()
            });
            aux = aux.getSiguiente();
            while (aux != cabeza) {
                listTableModel.addRow(new Object[] {
                aux.getDato().getId(),
                aux.getDato().getTrabajadorId(),
                aux.getDato().getCajuelas(),
                aux.getDato().getFinca()
                });
                aux = aux.getSiguiente();
            }
        }   
         JTable table = new JTable(listTableModel);
        JOptionPane.showMessageDialog(null, new JScrollPane(table));
    }
}
