/*+------------------------------------------+*\
  | MENU PRINCIPAL                           |
  +------------------------------------------+
  | PROYECTO ESTRUCTURA DE DATOS | IC | 2021 |
\*+------------------------------+----+------+*/
package Principal;

import Pagos.HandlerPagos;
import Trabajador.HandlerTrabajador;
import Trabajador.Trabajador;
import Gastos.HandlerGastosFincas;
import javax.swing.JOptionPane;

public class MenuPrincipal {
    HandlerTrabajador Trabajador = new HandlerTrabajador();
    HandlerPagos Pago = new HandlerPagos();
    HandlerGastosFincas Gasto = new HandlerGastosFincas();
    
    public void RenderMenuPrincipal(){
        String opcion = JOptionPane.showInputDialog(
            "          SISTEMA CAFICULTORES     "+"\n"+
            "=========================="+"\n"+
            "1: TRABAJADORES"+"\n"+
            "2: PAGOS"+"\n"+
            "3: GASTOS"+"\n"+        
            "0: FINCAS"+"\n"
        );
        if (isNumeric(opcion)){
            MenuPrincipalController(Integer.parseInt(opcion));
        } else {
            JOptionPane.showMessageDialog(null,
            "INGRESE UN VALOR NUMERICO DE LA LISTA",
            "VALOR NO NUMERICO",
            JOptionPane.ERROR_MESSAGE);
            RenderMenuPrincipal();
        }
    }
    
    public void MenuPrincipalController(int opcion ){
        switch (opcion) {
        case 1:
            MenuPrincipalTrabajador();
            break;
        case 2:
            MenuPrincipalPagos();
            break;
        case 3:
            MenuPrincipalGastos();
            break;
        case 4:
            System.exit(0);
            break;
        default:
            JOptionPane.showMessageDialog(null,
            "INGRESE UN VALOR DENTRO DE LA LISTA DE OPCIONES",
            "VALOR FUERA DE LISTA",
            JOptionPane.ERROR_MESSAGE);
            RenderMenuPrincipal();
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
    
    public void MenuPrincipalGastos(){
     int option = Integer.parseInt(JOptionPane.showInputDialog(
         "            OPCIONES MENU GASTOS     "+"\n"+
         "=========================="+"\n"+
         "DATOS EN SISTEMA: "+ Gasto.CantidadSistema()+"\n"+
         "=========================="+"\n"+
         "1: AGREGAR GASTO NUEVO"+"\n"+
         "2: VER HISTORICO DE GASTOS"+"\n"+
         "0: VOLVER AL MENU PRINCIPAL"+"\n"
     ));
     switch (option) {
     case 1:
         Gasto.ApilarGastos(1);
         MenuPrincipalGastos();
         break;
     case 2:
         Gasto.VerGastos();
         MenuPrincipalGastos();
         break;
     case 0:
         RenderMenuPrincipal();
         break;
     default:
         // The user input an unexpected choice.
     }
    }
    
    
    
    //VALIDADORES 
    public boolean isNumeric(String cadena){
	try {
            Integer.parseInt(cadena);
            return true;
	} catch (NumberFormatException nfe){
            return false;
	}
    }
}
