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
import PagosTrabajadores.HandlerPagoTrabajador;
import PagosTrabajadores.PagoTrabajador;
import javax.swing.JOptionPane;

public class MenuPrincipal {
    HandlerTrabajador Trabajador = new HandlerTrabajador();
    HandlerPagos Pago = new HandlerPagos();
    HandlerGastosFincas Gasto = new HandlerGastosFincas();
    HandlerPagoTrabajador Lista = new HandlerPagoTrabajador();
    
    public void RenderMenuPrincipal(){
        String opcion = JOptionPane.showInputDialog(
            "          SISTEMA CAFICULTORES     "+"\n"+
            "=========================="+"\n"+
            "1: TRABAJADORES"+"\n"+
            "2: PAGOS"+"\n"+
            "3: GASTOS"+"\n"+
            "4: PAGOS TRABAJADORES"+"\n"+
            "5: FINCAS"+"\n"+
            "0: SALIR DEL SISTEMA"+"\n"
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
            MenuPrincipalPagosTrabajador();
            break;
        case 5:
            System.exit(0);
            break;
        case 0:
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
    
    public void MenuPrincipalPagosTrabajador(){
        int option = Integer.parseInt(JOptionPane.showInputDialog(
            "          OPCIONES MENU PAGOS TRABAJADORES     "+"\n"+
            "=========================="+"\n"+
            "1: INGRESAR NUEVO PAGO"+"\n"+
            "2: VER PAGOS REALIZADOS"+"\n"+
            "0: VOLVER AL MENU PRINCIPAL"+"\n"
        ));
        
        switch (option) {
        case 1:
            Lista.insertarPagoTrabajador(new PagoTrabajador(1,1400,12,1));
            MenuPrincipalPagosTrabajador();
            break;
        case 2:
            Lista.verPagosRealizados();
            MenuPrincipalPagosTrabajador();
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
