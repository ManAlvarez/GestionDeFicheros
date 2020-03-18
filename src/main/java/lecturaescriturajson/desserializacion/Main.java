/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaescriturajson.desserializacion;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

        // Declaramos el fichero.
        File fichero = new File("data1.json");

        try {
            // Creamos el flujo de entrada.
            FileReader flujoEntrada = new FileReader(fichero);

            StringBuilder jsonBuilder;
            // Imos lendo linea a linea
            try ( // Creamos el buffer de entrada.
                    BufferedReader bufferEntrada = new BufferedReader(flujoEntrada)) {
                // Imos lendo linea a linea
                jsonBuilder = new StringBuilder();
                String linea;
                while ((linea = bufferEntrada.readLine()) != null) {
                    jsonBuilder.append(linea).append("\n");
                }
                // Cerramos el fichero.
            }
            
            // Construimos o String con todas as lineas lidas.
            String json = jsonBuilder.toString();
            
            // Pasamos o json a clase ca cal corresponde.
            Gson gson = new Gson();
            Aula aula = gson.fromJson(json,Aula.class);
            
            // Comprobamos que se leeran ben os datos.
            System.out.println("Nome aula: "+aula.getNomeAula());
            System.out.println("Alumnos: ");
            aula.alumnos.forEach((alumno) -> {
                System.out.println(alumno.getNome()+" "+alumno.getApelidos()+" "+alumno.getIdade());
            });
               
        } catch (FileNotFoundException e) {
            System.out.println("Non se encontra o arquivo");
        } catch (IOException e) {
            System.out.println("Erro de entrada saída");
        }
    }

}
