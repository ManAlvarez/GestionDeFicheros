/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios.lecturaEscrituraJson;

import java.util.ArrayList;

/**
 *
 * @author manuel
 */
public class Tienda {

    public String nome;
    public ArrayList<Equipo> equipos;

    public Tienda() {
        this.equipos = new ArrayList<Equipo>();
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
