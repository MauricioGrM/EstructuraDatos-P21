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

    public HandlerPagos() {
        raiz = null;
        fondo = null;
    }

    public boolean vacia() {
        return raiz == null;
    }

    public void insertarPago(int info) {
        NodoColaPagos nuevo = new NodoColaPagos(info);
        if (vacia()) {
            raiz = nuevo;
            fondo = nuevo;
        } else {
            fondo.setSig(nuevo);
            fondo = nuevo;
        }
    }

    public void verPagos() {
        int Semana = 0;
        Object[][] rowData = {};
        Object[] columnNames = {"SEMANA", "MONTO"};
        DefaultTableModel listTableModel;
        listTableModel = new DefaultTableModel(rowData, columnNames);
        NodoColaPagos temp = raiz;
        while (temp != null) {
            Semana = Semana + 1;
            listTableModel.addRow(new Object[]{
                Semana,
                temp.getInfo(),});
            temp = temp.getSig();
        }
        JTable table = new JTable(listTableModel);
        JOptionPane.showMessageDialog(null, new JScrollPane(table));
    }

    public int cantidad() {
        int contador = 0;
        NodoColaPagos temp = raiz;
        while (temp != null) {
            contador = contador + 1;
            temp = temp.getSig();
        }
        return contador;
    }

    public int ObtieneTotal() {
        int total = 0;
        NodoColaPagos temp = raiz;
        while (temp != null) {
            total = total + temp.getInfo();
            temp = temp.getSig();
        }
        return total;
    }

    public boolean buscarPago(int referencia) {
        int Semana = 0;
        NodoColaPagos temp = raiz;
        boolean encontrado = false;
        while (temp != null && encontrado != true) {
            Semana = Semana + 1;
            if (referencia == Semana) {
                encontrado = true;
            } else {
                temp = temp.getSig();
            }
        }
        return encontrado;
    }

    public void editarPago(int referencia, int NuevoPago) {
        int Semana = 1;
        if (buscarPago(referencia)) {
            NodoColaPagos temp = raiz;
            if (Semana == referencia) {
                temp.setInfo(NuevoPago);
            } else {
                while (Semana != referencia) {
                    Semana = Semana + 1;
                    temp = temp.getSig();
                }
                temp.setInfo(NuevoPago);
            }
        }
    }

    public void eliminarPago(int referencia) {
        int Semana = 1;
        if (buscarPago(referencia)) {
            if (Semana == referencia) {
                raiz = raiz.getSig();
            } else {
                NodoColaPagos temp = raiz;
                while (Semana != referencia - 1) {
                    Semana = Semana + 1;
                    temp = temp.getSig();
                }
                NodoColaPagos siguiente = temp.getSig().getSig();
                temp.setSig(siguiente);
            }
        }
    }
}
