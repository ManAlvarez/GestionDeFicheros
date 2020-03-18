/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios.lecturaescrituradedatosbinarios.serializable;

import java.io.Serializable;


/**
 *
 * @author manuel
 */
public class Equipo implements Serializable{

    private int identificador;
    private String descripcion;
    private double prezo;
    private int cantidade;

    public Equipo(int identificador, String descripcion, double prezo, int cantidade) {
        this.identificador = identificador;
        this.descripcion = descripcion;
        this.prezo = prezo;
        this.cantidade = cantidade;
    }

    public Equipo() {
    }
    
    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrezo() {
        return prezo;
    }

    public void setPrezo(double prezo) {
        this.prezo = prezo;
    }

    public int getCantidade() {
        return cantidade;
    }

    public void setCantidade(int cantidade) {
        this.cantidade = cantidade;
    }
       
}
