/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuradatos.p21;

import estructuradatos.p21.Trabajador.HandlerTrabajador;
import estructuradatos.p21.Trabajador.Trabajador;

/**
 *
 * @author Mauricio
 */
public class EstructuraDatosP21 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HandlerTrabajador Trabajador = new HandlerTrabajador();
        Trabajador.insertarTrabajador(new Trabajador(1,305300042, 20, 83230353, "Jose Mauricio Granados Muñoz"));
        Trabajador.insertarTrabajador(new Trabajador(2,107590043, 51, 89913190, "Guisselle Muñoz Ureña"));
        Trabajador.verTrabajadores();
    }
    
}
