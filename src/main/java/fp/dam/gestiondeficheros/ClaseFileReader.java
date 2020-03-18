/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fp.dam.gestiondeficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author manuel
 */
public class ClaseFileReader {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // Empezamos declarando el fichero.
        File fichero = new File(File.separator + "home" + File.separator + "manuel" + File.separator + "Documentos" + File.separator + "prueba.txt");

        try {
            //Creamos un flujo de datos para el archivo
            FileReader flujoDatos = new FileReader(fichero);

            //Leer caracter a caracter.
            int caracter;

            while ((caracter = flujoDatos.read()) != -1) {
                System.out.print((char) caracter);
            }

            //Tenemos que cerrar siempre el flujo de datos.
            flujoDatos.close();

        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo");
        } catch (IOException e) {
            System.out.println("Error de entrada y salida");
        }

    }

}
