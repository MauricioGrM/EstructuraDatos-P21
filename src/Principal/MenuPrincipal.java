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
import Vehiculos.HandlerVehiculoArbol;
import Vehiculos.Vehiculo;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MenuPrincipal {

    HandlerTrabajador Trabajador = new HandlerTrabajador();
    HandlerPagos Pago = new HandlerPagos();
    HandlerGastosFincas Gasto = new HandlerGastosFincas();
    HandlerPagoTrabajador Lista = new HandlerPagoTrabajador();
    HandlerVehiculoArbol Vehiculo = new HandlerVehiculoArbol();

    int PrecioCajuela = 1000;

    public void RenderMenuPrincipal() {
        String opcion = JOptionPane.showInputDialog(
                "          SISTEMA CAFICULTORES     " + "\n"
                + "==========================" + "\n"
                + Saludo() + "\n"
                + "PRECIO CAJUELA: " + PrecioCajuela + "\n"
                + "==========================" + "\n"
                + "OPCIONES DE MENU" + "\n"
                + "==========================" + "\n"
                + "1: TRABAJADORES" + "\n"
                + "2: PAGOS POR COOPERATIVA" + "\n"
                + "3: GASTOS POR COMBUSTIBLE" + "\n"
                + "4: PAGOS TRABAJADORES" + "\n"
                + "5: VEHICULOS" + "\n"
                + "6: ESTADISTICAS" + "\n"
                + "7: CAMBIAR PRECIO CAJUELA" + "\n"
                + "0: SALIR DEL SISTEMA" + "\n"
        );
        if (isNumeric(opcion)) {
            MenuPrincipalController(Integer.parseInt(opcion));
        } else {
            JOptionPane.showMessageDialog(null,
                    "INGRESE UN VALOR NUMERICO DE LA LISTA",
                    "VALOR NO NUMERICO",
                    JOptionPane.ERROR_MESSAGE);
            RenderMenuPrincipal();
        }
    }

    public void Estadisticas() {
        int PagoTrabajadores = Lista.ObtieneTotal() * PrecioCajuela;
        String opcion = JOptionPane.showInputDialog(null,
                "          SISTEMA CAFICULTORES| ESTADISTICAS    " + "\n"
                + "==========================" + "\n"
                + "PRECIO CAJUELA: " + PrecioCajuela + "\n"
                + "==========================" + "\n"
                + "- GASTOS POR COMBUSTIBLE: " + Gasto.ObtieneTotal() + "\n"
                + "- PAGOS SALARIOS TRABAJADORES: " + PagoTrabajadores + "\n"
                + "- TOTAL GASTOS REALIZADOS: " + (Gasto.ObtieneTotal() + PagoTrabajadores) + "\n"
                + "- TOTAL ENTRADAS COOPERATIVA: " + Pago.ObtieneTotal() + "\n"
                + "- GANANCIAS TOTALES: " + (Pago.ObtieneTotal() - (Gasto.ObtieneTotal() + PagoTrabajadores)) + "\n"
                + "- VEHICULOS EN STOCK: " + Vehiculo.cantidad() + "\n"
                + "- TOTAL TRABAJADORES: " + Trabajador.cantidad() + "\n"
                + "0: SALIR DEL SISTEMA" + "\n"
        );
        if (isNumeric(opcion)) {
            switch (Integer.parseInt(opcion)) {
                case 0:
                    RenderMenuPrincipal();
                    break;
                default:
                    JOptionPane.showMessageDialog(null,
                            "INGRESE UN VALOR DENTRO DE LA LISTA DE OPCIONES",
                            "VALOR FUERA DE LISTA",
                            JOptionPane.ERROR_MESSAGE);
                    MenuPrincipalTrabajador();
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "INGRESE UN VALOR NUMERICO DE LA LISTA",
                    "VALOR NO NUMERICO",
                    JOptionPane.ERROR_MESSAGE);
            MenuPrincipalTrabajador();
        }
    }

    public void MenuPrincipalController(int opcion) {
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
                MenuPrincipalVehiculos();
                break;
            case 6:
                Estadisticas();
                break;
            case 7:
                PrecioCajuela = IngresaEntero("PRECIO CAJUELA");
                RenderMenuPrincipal();
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

    public void MenuPrincipalTrabajador() {
        int TrabajadorBuscarID;
        String option = JOptionPane.showInputDialog(
                "          OPCIONES MENU TRABAJADOR     " + "\n"
                + "==========================" + "\n"
                + "DATOS EN SISTEMA: " + Trabajador.cantidad() + "\n"
                + "==========================" + "\n"
                + "1: INGRESAR TRABAJADOR" + "\n"
                + "2: VER TRABAJADORES" + "\n"
                + "3: EDITAR TRABAJADOR" + "\n"
                + "4: ELIMINAR TRABAJADOR" + "\n"
                + "0: VOLVER AL MENU PRINCIPAL" + "\n"
        );

        if (isNumeric(option)) {
            switch (Integer.parseInt(option)) {
                case 1:
                    Trabajador.insertarTrabajador(new Trabajador(Trabajador.cantidad() + 1, IngresaEntero("CEDULA"), IngresaEntero("EDAD"), IngresaEntero("NUMERO DE TELEFONO"), IngresaCadena("NOMBRE")));
                    MenuPrincipalTrabajador();
                    break;
                case 2:
                    Trabajador.verTrabajadores();
                    MenuPrincipalTrabajador();
                    break;
                case 3:
                    if (Trabajador.cantidad() > 0) {
                        TrabajadorBuscarID = IngresaEntero("ID TRABAJADOR");
                        if (Trabajador.buscarTrabajador(TrabajadorBuscarID)) {
                            Trabajador.editarTrabajador(TrabajadorBuscarID, new Trabajador(TrabajadorBuscarID, IngresaEntero("CEDULA"), IngresaEntero("EDAD"), IngresaEntero("NUMERO DE TELEFONO"), IngresaCadena("NOMBRE")));
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "INGRESE UN ID CORRECTO",
                                    "DATO NO ENCONTRADO",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "INGRESE UN DATO PARA REALIZAR ESTA OPERACION",
                                "NO HAY DATOS ALMACENADOS",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    MenuPrincipalTrabajador();
                    break;
                case 4:
                    if (Trabajador.cantidad() > 0) {
                        TrabajadorBuscarID = IngresaEntero("ID TRABAJADOR");
                        if (Trabajador.buscarTrabajador(TrabajadorBuscarID)) {
                            Trabajador.eliminarTrabajador(TrabajadorBuscarID);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "INGRESE UN ID CORRECTO",
                                    "DATO NO ENCONTRADO",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "INGRESE UN DATO PARA REALIZAR ESTA OPERACION",
                                "NO HAY DATOS ALMACENADOS",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    MenuPrincipalTrabajador();
                    break;
                case 0:
                    RenderMenuPrincipal();
                    break;
                default:
                    JOptionPane.showMessageDialog(null,
                            "INGRESE UN VALOR DENTRO DE LA LISTA DE OPCIONES",
                            "VALOR FUERA DE LISTA",
                            JOptionPane.ERROR_MESSAGE);
                    MenuPrincipalTrabajador();
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "INGRESE UN VALOR NUMERICO DE LA LISTA",
                    "VALOR NO NUMERICO",
                    JOptionPane.ERROR_MESSAGE);
            MenuPrincipalTrabajador();
        }
    }

    public void MenuPrincipalPagos() {
        int PagoIDBuscar;
        String option = JOptionPane.showInputDialog(
                "          OPCIONES MENU PAGOS COOPERATIVA     " + "\n"
                + "==========================" + "\n"
                + "DATOS EN SISTEMA: " + Pago.cantidad() + "\n"
                + "==========================" + "\n"
                + "1: AGREGAR PAGO" + "\n"
                + "2: VER PAGOS" + "\n"
                + "3: EDITAR PAGO" + "\n"
                + "4: ELIMINAR PAGO" + "\n"
                + "0: VOLVER AL MENU PRINCIPAL" + "\n"
        );

        if (isNumeric(option)) {
            switch (Integer.parseInt(option)) {
                case 1:
                    Pago.insertarPago(IngresaEntero("PAGO"));
                    MenuPrincipalPagos();
                    break;
                case 2:
                    Pago.verPagos();
                    MenuPrincipalPagos();
                    break;
                case 3:
                    if (Pago.cantidad() > 0) {
                        PagoIDBuscar = IngresaEntero("SEMANA PAGADA");
                        if (Pago.buscarPago(PagoIDBuscar)) {
                            Pago.editarPago(PagoIDBuscar, IngresaEntero("NUEVO VALOR PAGADO"));
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "INGRESE UN ID CORRECTO",
                                    "DATO NO ENCONTRADO",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "INGRESE UN DATO PARA REALIZAR ESTA OPERACION",
                                "NO HAY DATOS ALMACENADOS",
                                JOptionPane.ERROR_MESSAGE);
                    }

                    MenuPrincipalPagos();
                    break;
                case 4:
                    Pago.eliminarPago(IngresaEntero("ID"));
                    MenuPrincipalPagos();
                    break;
                case 0:
                    RenderMenuPrincipal();
                    break;
                default:
                    JOptionPane.showMessageDialog(null,
                            "INGRESE UN VALOR DENTRO DE LA LISTA DE OPCIONES",
                            "VALOR FUERA DE LISTA",
                            JOptionPane.ERROR_MESSAGE);
                    MenuPrincipalPagos();
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "INGRESE UN VALOR NUMERICO DE LA LISTA",
                    "VALOR NO NUMERICO",
                    JOptionPane.ERROR_MESSAGE);
            MenuPrincipalPagos();
        }
    }

    public void MenuPrincipalGastos() {
        int GastoIDBuscar;
        String option = JOptionPane.showInputDialog(
                "            OPCIONES MENU GASTOS POR COMBUSTIBLE     " + "\n"
                + "==========================" + "\n"
                + "DATOS EN SISTEMA: " + Gasto.CantidadSistema() + "\n"
                + "==========================" + "\n"
                + "1: AGREGAR GASTO NUEVO" + "\n"
                + "2: VER HISTORICO DE GASTOS" + "\n"
                + "3: EDITAR COMBUSTIBLE" + "\n"
                + "4: ELIMINAR PAGO" + "\n"
                + "0: VOLVER AL MENU PRINCIPAL" + "\n"
        );
        if (isNumeric(option)) {
            switch (Integer.parseInt(option)) {
                case 1:
                    Gasto.ApilarGastos(IngresaEntero("GASTO"));
                    MenuPrincipalGastos();
                    break;
                case 2:
                    Gasto.VerGastos();
                    MenuPrincipalGastos();
                    break;
                case 3:
                    if (Gasto.ObtieneTotal() > 0) {
                        GastoIDBuscar = IngresaEntero("SEMANA PAGADA");
                        if (Gasto.buscarGasto(GastoIDBuscar)) {
                            Gasto.editarGasto(GastoIDBuscar, IngresaEntero("NUEVO VALOR GASTADO"));
                        } else {
                            Alerts(1);
                        }
                    } else {
                        Alerts(2);
                    }
                    MenuPrincipalGastos();
                    break;
                case 4:
                    if (Gasto.ObtieneTotal() > 0) {
                        GastoIDBuscar = IngresaEntero("SEMANA PAGADA");
                        if (Gasto.buscarGasto(GastoIDBuscar)) {
                            Gasto.eliminarGasto(GastoIDBuscar);
                        } else {
                            Alerts(1);
                        }
                    } else {
                        Alerts(2);
                    }
                    MenuPrincipalPagos();
                    break;
                case 0:
                    RenderMenuPrincipal();
                    break;
                default:
                    JOptionPane.showMessageDialog(null,
                            "INGRESE UN VALOR DENTRO DE LA LISTA DE OPCIONES",
                            "VALOR FUERA DE LISTA",
                            JOptionPane.ERROR_MESSAGE);
                    MenuPrincipalGastos();
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "INGRESE UN VALOR NUMERICO DE LA LISTA",
                    "VALOR NO NUMERICO",
                    JOptionPane.ERROR_MESSAGE);
            MenuPrincipalGastos();
        }
    }

    public void MenuPrincipalPagosTrabajador() {
        int PagoIDBuscar;
        String option = JOptionPane.showInputDialog(
                "          OPCIONES MENU PAGOS TRABAJADORES     " + "\n"
                + "==========================" + "\n"
                + "DATOS EN SISTEMA: " + Lista.cantidad() + "\n"
                + "==========================" + "\n"
                + "1: INGRESAR NUEVO PAGO" + "\n"
                + "2: VER PAGOS REALIZADOS" + "\n"
                + "3: EDITAR PAGO REALIZADO" + "\n"
                + "4: ELIMINAR PAGO REALIZADO" + "\n"
                + "0: VOLVER AL MENU PRINCIPAL" + "\n"
        );

        if (isNumeric(option)) {
            switch (Integer.parseInt(option)) {
                case 1:
                    Lista.insertarPagoTrabajador(new PagoTrabajador((Lista.cantidad() + 1), IngresaEntero("ID TRABAJADOR"), IngresaEntero(" CANTIDAD DE CAJUELAS"), IngresaEntero("NUMERO DE FINCA")));
                    MenuPrincipalPagosTrabajador();
                    break;
                case 2:
                    Lista.verPagosRealizados();
                    MenuPrincipalPagosTrabajador();
                    break;
                case 3:
                    if (Lista.cantidad() > 0) {
                        PagoIDBuscar = IngresaEntero("ID DEL PAGO REALIZADO");
                        if (Lista.buscarPagoRealiazado(PagoIDBuscar)) {
                            Lista.editarPagoRealiazado(PagoIDBuscar, new PagoTrabajador(PagoIDBuscar, IngresaEntero("ID TRABAJADOR"), IngresaEntero("CAJUELAS"), IngresaEntero("NUMERO DE FINCA")));
                        } else {
                            Alerts(1);
                        }
                    } else {
                        Alerts(2);
                    }
                    MenuPrincipalPagosTrabajador();
                    break;
                case 4:
                    if (Lista.cantidad() > 0) {
                        PagoIDBuscar = IngresaEntero("ID DEL PAGO REALIZADO");
                        if (Lista.buscarPagoRealiazado(PagoIDBuscar)) {
                            Lista.eliminarPagoRealiazado(PagoIDBuscar);
                        } else {
                            Alerts(1);
                        }
                    } else {
                        Alerts(2);
                    }
                    MenuPrincipalPagosTrabajador();
                    break;
                case 0:
                    RenderMenuPrincipal();
                    break;
                default:
                    JOptionPane.showMessageDialog(null,
                            "INGRESE UN VALOR DENTRO DE LA LISTA DE OPCIONES",
                            "VALOR FUERA DE LISTA",
                            JOptionPane.ERROR_MESSAGE);
                    MenuPrincipalPagosTrabajador();
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "INGRESE UN VALOR NUMERICO DE LA LISTA",
                    "VALOR NO NUMERICO",
                    JOptionPane.ERROR_MESSAGE);
            MenuPrincipalPagosTrabajador();
        }
    }

    public void MenuPrincipalVehiculos() {
        String option = JOptionPane.showInputDialog(
                "          OPCIONES MENU VEHICULOS     " + "\n"
                + "==========================" + "\n"
                + "DATOS EN SISTEMA: " + Vehiculo.cantidad() + "\n"
                + "==========================" + "\n"
                + "1: AGREGAR VEHICULO" + "\n"
                + "2: VER VEHICULOS REGISTRADOS" + "\n"
                + "0: VOLVER AL MENU PRINCIPAL" + "\n"
        );

        if (isNumeric(option)) {
            switch (Integer.parseInt(option)) {
                case 1:
                    Vehiculo.inserta(new Vehiculo((Vehiculo.cantidad() + 1), IngresaEntero("PLACA"), IngresaCadena("MARCA"), IngresaCadena("MODELO"), IngresaCadena("DUENO REGISTRAL")));
                    MenuPrincipalVehiculos();
                    break;
                case 2:
                    Vehiculo.recorridoPreORden();
                    MenuPrincipalVehiculos();
                    break;
                case 0:
                    RenderMenuPrincipal();
                    break;
                default:
                    JOptionPane.showMessageDialog(null,
                            "INGRESE UN VALOR DENTRO DE LA LISTA DE OPCIONES",
                            "VALOR FUERA DE LISTA",
                            JOptionPane.ERROR_MESSAGE);
                    MenuPrincipalPagos();
            }
        } else {
            JOptionPane.showMessageDialog(null,
                    "INGRESE UN VALOR NUMERICO DE LA LISTA",
                    "VALOR NO NUMERICO",
                    JOptionPane.ERROR_MESSAGE);
            MenuPrincipalPagos();
        }
    }

    //VALIDADORES 
    public boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public String IngresaCadena(String Dato) {
        String option = JOptionPane.showInputDialog("INGRESE VALOR DE " + Dato);
        if (!option.isEmpty()) {
            return option;
        } else {
            do {
                option = JOptionPane.showInputDialog(null,
                        "INGRESE UN VALOR CORRECTO PARA " + Dato,
                        "VALOR VACIO",
                        JOptionPane.ERROR_MESSAGE);
            } while (option.isEmpty());
            return option;
        }
    }

    public int IngresaEntero(String Dato) {
        String option = JOptionPane.showInputDialog("INGRESE VALOR DE " + Dato);
        if (isNumeric(option)) {
            return Integer.parseInt(option);
        } else {
            do {
                option = JOptionPane.showInputDialog(null,
                        "INGRESE UN VALOR CORRECTO PARA " + Dato,
                        "VALOR VACIO",
                        JOptionPane.ERROR_MESSAGE);
            } while (!isNumeric(option));
            return Integer.parseInt(option);
        }
    }

    public String Saludo() {
        GregorianCalendar currTime = new GregorianCalendar();
        int hora = currTime.get(Calendar.HOUR_OF_DAY);
        if ((hora > 5) && (hora <= 12)) {
            return "MUY BUENOS DIAS";
        } else if ((hora > 12) && (hora <= 18)) {
            return "MUY BUENAS TARDES";
        } else {
            return "MUY BUENAS NOCHES";
        }
    }

    public void Alerts(int AlertNum) {
        switch (AlertNum) {
            case 1:
                JOptionPane.showMessageDialog(null,
                        "INGRESE UN ID CORRECTO",
                        "DATO NO ENCONTRADO",
                        JOptionPane.ERROR_MESSAGE);
                break;
            case 2:
                JOptionPane.showMessageDialog(null,
                        "INGRESE UN DATO PARA REALIZAR ESTA OPERACION",
                        "NO HAY DATOS ALMACENADOS",
                        JOptionPane.ERROR_MESSAGE);
                break;
            default:
            // code block
        }
    }

}
