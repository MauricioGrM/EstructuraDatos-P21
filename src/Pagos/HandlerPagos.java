/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pagos;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*+------------------------------------------+*\
  | UTILIZACION DE COLAS                     |
  +------------------------------------------+
  | PROYECTO ESTRUCTURA DE DATOS | IC | 2021 |
\*+------------------------------+----+------+*/

public class HandlerPagos {
    NodoColaPagos raiz, fondo;
    
    public HandlerPagos(){
        raiz =  null;
        fondo = null;
    }
    
    public boolean vacia(){
        return raiz == null;
    }
    
    public void insertarPago(int info){
        NodoColaPagos nuevo = new NodoColaPagos(info);
        if(vacia()){
            raiz = nuevo;
            fondo = nuevo;
        }else {
            fondo.setSig(nuevo);
            fondo = nuevo;
        }
    }
    
    public void verPagos(){
        int Semana = 0;
        Object[][] rowData = {};
        Object[] columnNames = { "SEMANA", "MONTO" };
        DefaultTableModel listTableModel;
        listTableModel = new DefaultTableModel(rowData, columnNames);
        NodoColaPagos temp = raiz;
        while (temp != null ){
            Semana = Semana + 1;
            listTableModel.addRow(new Object[] {
                Semana,
                temp.getInfo(),
            });
            temp = temp.getSig();
        }
        JTable table = new JTable(listTableModel);
        JOptionPane.showMessageDialog(null, new JScrollPane(table));
    }
    
    public int cantidad(){
        int contador = 0;
        NodoColaPagos temp = raiz;
        while (temp != null ){
            contador = contador+1;
            temp = temp.getSig();
        }
        return contador;
    }
}
