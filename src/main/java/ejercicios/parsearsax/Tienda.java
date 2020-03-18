/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios.parsearsax;

import java.util.ArrayList;

/**
 *
 * @author manuel
 */
public class Tienda {
    
    private String nome;
    private ArrayList<Equipo> equipos = new ArrayList<Equipo>();

    public Tienda() {
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    } 
}
