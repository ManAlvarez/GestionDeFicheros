/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaescriturajson.serializacion;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


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

        // Creamos os datos.
        Persoa persoa1 = new Persoa("nome1", 11, "apelidos1");
        Persoa persoa2 = new Persoa("nome2", 22, "apelidos2");
        Persoa persoa3 = new Persoa("nome3", 33, "apelidos3");
        Persoa persoa4 = new Persoa("nome4", 44, "apelidos4");
        Persoa profesor = new Persoa("profNome1", 55, "profApelidos5");

        Aula aula = new Aula("Aula de acceso a datos");
        aula.getAlumnos().add(persoa1);
        aula.getAlumnos().add(persoa2);
        aula.getAlumnos().add(persoa3);
        aula.getAlumnos().add(persoa4);
        aula.setProfesor(profesor);
        
        // Pasamos a nosa clase a JSON utilizando a libreria GSON
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(aula);
        
        // Declaramos el fichero.
        File arquivo = new File("data1.json");
        
        try {
            //Creamos el flujo de salida
            FileWriter flujoSalida = new FileWriter(arquivo);
            BufferedWriter buferSalida = new BufferedWriter(flujoSalida);
            
            buferSalida.write(json);
            
            // Cerramos el archivo.
            buferSalida.close();
            
        } catch (IOException e) {
            
        }
        
    }

}
