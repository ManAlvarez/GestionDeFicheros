/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaescriturajson;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author manuel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Creamos las personas.
        Persoa persona1 = new Persoa("nome1","apelidos1",11);
        Persoa persona2 = new Persoa("nome2","apelidos2",22);
        Persoa persona3 = new Persoa("nome3","apelidos3",33);
        Persoa persona4 = new Persoa("nome4","apelidos4",44);
        Persoa profesor = new Persoa("profNome1","profApelidos1",55);
        
        // Creamos el aula
        Aula aula = new Aula("Aula de acceso a datos");
        
        // Insertamos a las personas en el array de alumnos de la clase Aula.
        aula.getAlumnos().add(persona1);
        aula.getAlumnos().add(persona2);
        aula.getAlumnos().add(persona3);
        aula.getAlumnos().add(persona4);
        
        // Insertamos al profresor en al atributo profresor de la clase Aula.
        aula.setProfesor(profesor);
        
        // Declaramos el fichero.
        File arquivo = new File("data.json");
        
        try {
            // Creamos o flujo de salida.
            FileWriter flujoDatos = new FileWriter(arquivo);
            
            // Cramos el bufer de salida.
            BufferedWriter buferSalida = new BufferedWriter(flujoDatos);
            
            buferSalida.write(aula.toJSON());
            
            // Cerramos el arquivo
            buferSalida.close();
                     
        } catch (Exception e) {
            System.out.println("Non se pode escribir no arquivo");
        }
        
        
    }
    
}
