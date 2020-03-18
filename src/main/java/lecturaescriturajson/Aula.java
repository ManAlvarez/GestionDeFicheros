/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaescriturajson;

import java.util.ArrayList;

/**
 *
 * @author manuel
 */
public class Aula {
    
    private ArrayList<Persoa> alumnos;
    private Persoa profesor;
    private String nomeAula;

    public Aula(String nomeAula) {
        // Inicializo todos los datos.
        this.alumnos = new ArrayList<Persoa>();
        this.profesor = new Persoa();
        this.nomeAula = nomeAula;
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
    
    //Metodo que pasa a JSON
    public String toJSON(){
        String json = new String();
        json = json + "{ ";
        json = json + "\"nomeAula\" : \"" + this.nomeAula + "\",";
        json = json + "\"profesor\" : " + this.profesor.toJSON() + ",";
        json = json + "\"alumnos\" : [ ";
        for(int i=0;i<this.alumnos.size();i++){
            if(i != 0) json = json +  " , ";
            Persoa alumno = this.alumnos.get(i);
            json = json + alumno.toJSON();
        }
        json = json + " ] }";
        return json;
    }
    
}
