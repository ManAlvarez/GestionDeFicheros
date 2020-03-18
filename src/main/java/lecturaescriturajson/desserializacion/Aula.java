/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaescriturajson.desserializacion;
import java.util.ArrayList;

/**
 *
 * @author manuel
 */
public class Aula {
    ArrayList<Persoa> alumnos;
    Persoa profesor;
    String nomeAula;

    public Aula(String nomeAula) {
        this.alumnos = new ArrayList<Persoa>();
        this.profesor = new Persoa();
        this.nomeAula = nomeAula;
    }

    public Aula() {
    }

    public ArrayList<Persoa> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Persoa> alumnos) {
        this.alumnos = alumnos;
    }

    public Persoa getProfesor() {
        return profesor;
    }

    public void setProfesor(Persoa profesor) {
        this.profesor = profesor;
    }

    public String getNomeAula() {
        return nomeAula;
    }

    public void setNomeAula(String nomeAula) {
        this.nomeAula = nomeAula;
    }  
}
