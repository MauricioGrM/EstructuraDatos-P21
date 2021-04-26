package PagosTrabajadores;

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

    public void verPagosRealizados() {
        Object[][] rowData = {};
        Object[] columnNames = {"ID PAGO", "ID TRABAJADOR", "CAJUELAS", "FINCA"};
        DefaultTableModel listTableModel;
        listTableModel = new DefaultTableModel(rowData, columnNames);
        NodoPagoTrabajador aux = cabeza;
        if (aux != null) {
            listTableModel.addRow(new Object[]{
                aux.getDato().getId(),
                aux.getDato().getTrabajadorId(),
                aux.getDato().getCajuelas(),
                aux.getDato().getFinca()
            });
            aux = aux.getSiguiente();
            while (aux != cabeza) {
                listTableModel.addRow(new Object[]{
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

    public int cantidad() {
        int contador = 0;
        NodoPagoTrabajador aux = cabeza;
        if (aux != null) {
            contador++;
            aux = aux.getSiguiente();
            while (aux != cabeza) {
                contador++;
                aux = aux.getSiguiente();
            }
        }
        return contador;
    }

    public int ObtieneTotal() {
        int total = 0;
        NodoPagoTrabajador aux = cabeza;
        if (aux != null) {
            total = total + aux.getDato().getCajuelas();
            aux = aux.getSiguiente();
            while (aux != cabeza) {
                total = total + aux.getDato().getCajuelas();
                aux = aux.getSiguiente();
            }
        }
        return total;
    }

    public boolean buscarPagoRealiazado(int referencia) {
        NodoPagoTrabajador aux = cabeza;
        boolean encontrado = false;
        while (aux != null && encontrado != true) {
            if (referencia == aux.getDato().getId()) {
                encontrado = true;
            } else {
                aux = aux.getSiguiente();
            }
        }
        return encontrado;
    }

    public void editarPagoRealiazado(int referencia, PagoTrabajador p) {
        if (buscarPagoRealiazado(referencia)) {
            NodoPagoTrabajador aux = cabeza;
            while (aux.getDato().getId() != referencia) {
                aux = aux.getSiguiente();
            }
            aux.setDato(p);
        }
    }

    public void eliminarPagoRealiazado(int referencia) {
        if (buscarPagoRealiazado(referencia)) {
            if (cabeza.getDato().getId() == referencia) {
                cabeza = cabeza.getSiguiente();
            } else {
                NodoPagoTrabajador aux = cabeza;
                while (aux.getSiguiente().getDato().getId() != referencia) {
                    aux = aux.getSiguiente();
                }
                NodoPagoTrabajador siguiente = aux.getSiguiente().getSiguiente();
                aux.setSiguiente(siguiente);
            }
        }
    }
}
