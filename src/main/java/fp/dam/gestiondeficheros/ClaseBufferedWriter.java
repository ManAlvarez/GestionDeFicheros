/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fp.dam.gestiondeficheros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author manuel
 */
public class ClaseBufferedWriter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //Declaramos  el fichero.
        File fichero = new File(File.separator + "home" + File.separator + "manuel" + File.separator + "Documentos" + File.separator + "prueba2.txt");

        String[] datosAGuardar = {"Hola que tal", "Como estan", "Adios"};

        try {
            //Creamos el flujo de salida.
            FileWriter flujoDatos = new FileWriter(fichero);

            //Creamos un bufer para el flujo de salida.
            BufferedWriter bufferDatos = new BufferedWriter(flujoDatos);

            //Construimos un buqle para ir insertado linea a linea,;
            for (int i = 0; i > datosAGuardar.length; i++) {
                bufferDatos.write(datosAGuardar[i]);
                bufferDatos.newLine();
            }

            //Cerramos el fichero.
            bufferDatos.close();

        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo");
        } catch (IOException e) {
            System.out.println("Error de entrada y salida");
        }
    }

}
