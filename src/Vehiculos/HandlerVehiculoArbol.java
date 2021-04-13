/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehiculos;

import Vehiculos.Vehiculo;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author mauricio
 */
public class HandlerVehiculoArbol {

    NodoArbolVehiculo raiz;
    int contador = 1;
    int altura;
    int cant;

    public void inserta(Vehiculo x) {

        if (raiz == null) {
            raiz = new NodoArbolVehiculo(x);
        } else {
            insertaR(raiz, x);
        }
    }

    public void insertaR(NodoArbolVehiculo n, Vehiculo x) {
        if (x.getId() <= n.getDato().getId()) {
            if (n.getHijoizq() == null) {
                n.setHijoizq(new NodoArbolVehiculo(x));
            } else {
                insertaR(n.getHijoizq(), x);
            }
        } else {
            if (n.getHijoder() == null) {
                n.setHijoder(new NodoArbolVehiculo(x));
            } else {
                insertaR(n.getHijoder(), x);
            }
        }

    }

    //PREORDEN
    public void recorridoPreORden() {
        if (raiz != null) {
            PreORdenR(raiz);
        } else {
            System.out.println("Arbol Vacio");
        }
    }

    public void PreORdenR(NodoArbolVehiculo n) {
        if (n != null) {
            JOptionPane.showMessageDialog(null,
                    "DATOS DEL VEHICULO\n"
                    + "ID:" + n.getDato().getId() + "\n"
                    + "PLACA:" + n.getDato().getPlaca() + "\n"
                    + "MARCA:" + n.getDato().getMarca() + "\n"
                    + "MODELO:" + n.getDato().getModelo() + "\n"
                    + "DUENO REGISTRAL:" + n.getDato().getDuenoRegistral(),
                     "Dive", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("assets/Hello.png"));
            PreORdenR(n.getHijoizq());
            PreORdenR(n.getHijoder());
        }
    }

    public int cantidad() {
        cant = 0;
        cantidad(raiz);
        return cant;
    }

    private void cantidad(NodoArbolVehiculo reco) {
        if (reco != null) {
            cant++;
            cantidad(reco.getHijoizq());
            cantidad(reco.getHijoder());
        }
    }
}
