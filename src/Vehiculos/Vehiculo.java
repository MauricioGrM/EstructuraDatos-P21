/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehiculos;

/**
 *
 * @author mauricio
 */
public class Vehiculo {
    private int Id;
    private int Placa;
    private String Marca;
    private String Modelo;
    private String DuenoRegistral;

    public Vehiculo(int Id, int Placa, String Marca, String Modelo, String DuenoRegistral) {
        this.Id = Id;
        this.Placa = Placa;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.DuenoRegistral = DuenoRegistral;
    } 
    
   public Vehiculo() {
        this.Id = 0;
        this.Placa = 0;
        this.Marca = "";
        this.Modelo = "";
        this.DuenoRegistral = "";
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getPlaca() {
        return Placa;
    }

    public void setPlaca(int Placa) {
        this.Placa = Placa;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getDuenoRegistral() {
        return DuenoRegistral;
    }

    public void setDuenoRegistral(String DuenoRegistral) {
        this.DuenoRegistral = DuenoRegistral;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "Id=" + Id + ", Placa=" + Placa + ", Marca=" + Marca + ", Modelo=" + Modelo + ", DuenoRegistral=" + DuenoRegistral + '}';
    }
}
