/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fp.dam.gestiondeficheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author manuel
 */
public class ClaseFileInputSream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //Comenzamos declarando el fichero.
        File fichero = new File(File.separator + "home" + File.separator + "manuel" + File.separator + "Imágenes" + File.separator + "ic_mr-robot-logo.png");

        try {
            //Creamos un flujo de datos de entrada.
            FileInputStream flujoDatos = new FileInputStream(fichero);

            //Vamos leyendo byte a byte.
            int datosByte;

            while ((datosByte = flujoDatos.read()) != -1) {
                System.out.print(datosByte);
            }
            
            flujoDatos.close();

        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo");
        } catch (IOException e) {
            System.out.println("Error de entrada y salida");
        }

    }

}
