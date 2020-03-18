/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fp.dam.gestiondeficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author manuel
 */
public class ClaseFileWriter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //Declaramos el fichero
        File fichero = new File(File.separator + "home" + File.separator + "manuel" + File.separator + "Documentos" + File.separator + "prueba1.txt");

        try {

            //Creamos un flujo de datos.
            FileWriter flujoDeDatos = new FileWriter(fichero);

            //La cadena de texto que vamos a gardar no fichero.
            String datosAGardar = "Hola que tal";

            //Lo transformamos en un array de caracteres
            char[] caracter = datosAGardar.toCharArray();

            //Vamos escribiendo caracter a caracter.
            for (int i = 0; i < caracter.length; i++) {
                flujoDeDatos.write(caracter[i]);
            }

            //Cerramos el flujo de datos.
            flujoDeDatos.close();

        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo");
        } catch (IOException e) {
            System.out.println("Error de entrada y salida");
        }

    }

}
