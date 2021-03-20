/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuradatos.p21.Trabajador;

/**
 *
 * @author mauricio
 */
public class Trabajador {
    private int idTrabajador;
    private int Cedula;
    private int Edad;
    private int Telefono;
    private String Nombre;

    public Trabajador(int idTrabajador, int Cedula, int Edad, int Telefono, String Nombre) {
        this.idTrabajador = idTrabajador;
        this.Cedula = Cedula;
        this.Edad = Edad;
        this.Telefono = Telefono;
        this.Nombre = Nombre;
    }

    public Trabajador() {
        this.idTrabajador = 0;
        this.Cedula = 0;
        this.Edad = 0;
        this.Telefono = 0;
        this.Nombre = "";
    }

    public int getCedula() {
        return Cedula;
    }

    public void setCedula(int Cedula) {
        this.Cedula = Cedula;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    @Override
    public String toString() {
        return "Trabajador{" + "idTrabajador=" + idTrabajador + ", Cedula=" + Cedula + ", Edad=" + Edad + ", Telefono=" + Telefono + ", Nombre=" + Nombre + '}';
    }
}
