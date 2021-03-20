/*+------------------------------------------+*\
  | MENU PRINCIPAL                           |
  +------------------------------------------+
  | PROYECTO ESTRUCTURA DE DATOS | IC | 2021 |
\*+------------------------------+----+------+*/
package estructuradatos.p21;

import estructuradatos.p21.Pagos.HandlerPagos;
import estructuradatos.p21.Trabajador.HandlerTrabajador;
import estructuradatos.p21.Trabajador.Trabajador;
import javax.swing.JOptionPane;

public class MenuPrincipal {
    HandlerTrabajador Trabajador = new HandlerTrabajador();
    HandlerPagos Pago = new HandlerPagos();
    
    public void RenderMenuPrincipal(){
        int option = Integer.parseInt(JOptionPane.showInputDialog(
            "          SISTEMA CAFICULTORES     "+"\n"+
            "=========================="+"\n"+
            "1: TRABAJADORES"+"\n"+
            "2: PAGOS"+"\n"+
            "0: FINCAS"+"\n"
        ));
        MenuPrincipalController(option);
    }
    
    public void MenuPrincipalController(int opcion){
        switch (opcion) {
        case 1:
            MenuPrincipalTrabajador();
            break;
        case 2:
            MenuPrincipalPagos();
            break;
        case 3:
            // Perform "decrypt number" case.
            break;
        case 4:
            // Perform "quit" case.
            break;
        default:
            // The user input an unexpected choice.
        }
    }
    
    public void MenuPrincipalTrabajador(){
        int option = Integer.parseInt(JOptionPane.showInputDialog(
            "          OPCIONES MENU TRABAJADOR     "+"\n"+
            "=========================="+"\n"+
            "1: INGRESAR TRABAJADORES"+"\n"+
            "2: VER TRABAJADORES"+"\n"+
            "0: VOLVER AL MENU PRINCIPAL"+"\n"
        ));
        
        switch (option) {
        case 1:
            Trabajador.insertarTrabajador(new Trabajador(1,305300042, 20, 83230353, "Jose Mauricio Granados Muñoz"));
            MenuPrincipalTrabajador();
            break;
        case 2:
            Trabajador.verTrabajadores();
            MenuPrincipalTrabajador();
            break;
        case 0:
            RenderMenuPrincipal();
            break;
        default:
            // The user input an unexpected choice.
        }
    }
    
    public void MenuPrincipalPagos(){
        int option = Integer.parseInt(JOptionPane.showInputDialog(
            "          OPCIONES MENU PAGOS     "+"\n"+
            "=========================="+"\n"+
            "1: AGREGAR PAGO"+"\n"+
            "2: VER PAGOS"+"\n"+
            "0: VOLVER AL MENU PRINCIPAL"+"\n"
        ));
        
        switch (option) {
        case 1:
            Pago.insertarPago(1500000);
            MenuPrincipalPagos();
            break;
        case 2:
            Pago.verPagos();
            MenuPrincipalPagos();
            break;
        case 0:
            RenderMenuPrincipal();
            break;
        default:
            // The user input an unexpected choice.
        }
    }
}
