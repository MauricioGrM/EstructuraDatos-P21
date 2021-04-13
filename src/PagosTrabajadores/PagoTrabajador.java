/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PagosTrabajadores;

/**
 *
 * @author mauricio
 */
public class PagoTrabajador {

    private int Id;
    private int TrabajadorId;
    private int Cajuelas;
    private int Finca;

    public PagoTrabajador(int Id, int TrabajadorId, int Cajuelas, int Finca) {
        this.Id = Id;
        this.TrabajadorId = TrabajadorId;
        this.Cajuelas = Cajuelas;
        this.Finca = Finca;
    }

    public PagoTrabajador() {
        this.Id = 0;
        this.TrabajadorId = 0;
        this.Cajuelas = 0;
        this.Finca = 0;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getTrabajadorId() {
        return TrabajadorId;
    }

    public void setTrabajadorId(int TrabajadorId) {
        this.TrabajadorId = TrabajadorId;
    }

    public int getCajuelas() {
        return Cajuelas;
    }

    public void setCajuelas(int Cajuelas) {
        this.Cajuelas = Cajuelas;
    }

    public int getFinca() {
        return Finca;
    }

    public void setFinca(int Finca) {
        this.Finca = Finca;
    }

    @Override
    public String toString() {
        return "PagoTrabajador{" + "Id=" + Id + ", TrabajadorId=" + TrabajadorId + ", Cajuelas=" + Cajuelas + ", Finca=" + Finca + '}';
    }
}
