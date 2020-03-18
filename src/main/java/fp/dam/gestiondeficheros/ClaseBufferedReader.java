/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fp.dam.gestiondeficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author manuel
 */
public class ClaseBufferedReader {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Comenzamos declarando el fichero.
        File fichero = new File(File.separator + "home" + File.separator + "manuel" + File.separator + "Documentos" + File.separator + "prueba.txt");
        
        try {
            
            //Creamos el flujo de entrada para el archivo.
            FileReader flujoDatos = new FileReader(fichero);
            
            //Creamos un bufer de entrada.
            BufferedReader bufferDatos = new BufferedReader(flujoDatos);
            
            //Vamos leyendo linea a linea
            String linea;
            
            //Bucle para leer linea a linea
            while((linea=bufferDatos.readLine()) != null){
                System.out.println(linea);
            }
                    
            //Cerramos el fichero
            bufferDatos.close();
            
       } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo");
        } catch (IOException e) {
            System.out.println("Error de entrada y salida");
        }

        
    }
    
}
