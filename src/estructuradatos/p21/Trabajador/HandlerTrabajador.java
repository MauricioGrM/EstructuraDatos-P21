/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuradatos.p21.Trabajador;
import estructuradatos.p21.Trabajador.Trabajador;

/*+------------------------------------------+*\
  | UTILIZACION DE LISTAS SIMPLES            |
  +------------------------------------------+
  | PROYECTO ESTRUCTURA DE DATOS | IC | 2021 |
\*+------------------------------+----+------+*/

public class HandlerTrabajador {
    private NodoListaSimpleTrabajador cabeza;
    
    public void insertarTrabajador(Trabajador p){
        if(cabeza == null){
            cabeza = new NodoListaSimpleTrabajador(p);
        }
        else if(p.getIdTrabajador() < cabeza.getDato().getIdTrabajador()){
            NodoListaSimpleTrabajador aux = new NodoListaSimpleTrabajador(p);
            aux.setSiguiente(cabeza);
            cabeza = aux;
        }
        else if(cabeza.getSiguiente() == null){
            cabeza.setSiguiente(new NodoListaSimpleTrabajador(p));
        }
        else{
            NodoListaSimpleTrabajador aux = cabeza;
            while(aux.getSiguiente()!=null && aux.getDato().getIdTrabajador() < p.getIdTrabajador()){
                aux = aux.getSiguiente();
            }
            NodoListaSimpleTrabajador temp = new NodoListaSimpleTrabajador(p);
            temp.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(temp);
        }  
    }
    
    public void verTrabajadores() {
        NodoListaSimpleTrabajador aux = cabeza;
        String leftAlignFormat = "| %-4s | %-5s | %-28s |  %-4s| %-9s|%n";
        System.out.format("+-------------------------------------------------------------------+%n");
        System.out.format("|                           TRABAJADORES                            |%n");
        System.out.format("+-------------------------------------------------------------------+%n");
        System.out.format("| ID   | CEDULA    | NOMBRE                       | EDAD | TELEFONO |%n");
        System.out.format("+------+-----------+------------------------------+------+----------+%n");
        while (aux != null) {
            System.out.format(leftAlignFormat,
            aux.getDato().getIdTrabajador(),
            aux.getDato().getCedula(),
            aux.getDato().getNombre(),
            aux.getDato().getEdad(),
            aux.getDato().getTelefono());
            aux = aux.getSiguiente();
            System.out.format("+------+-----------+------------------------------+------+----------+%n"); 
        }
    }
}
