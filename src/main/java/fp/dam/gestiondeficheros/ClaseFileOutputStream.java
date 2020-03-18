/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fp.dam.gestiondeficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author manuel
 */
public class ClaseFileOutputStream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //Declaramos el fichero.
        File fichero = new File(File.separator + "home" + File.separator + "manuel" + File.separator + "Documentos" + File.separator + "prueba3.txt");

        try {
            //Creamos el flujo de salida.
            FileOutputStream flujoSalida = new FileOutputStream(fichero);

            //Creo un bucle para escribir byte a byte.
            for (int i = 0; i < 100; i++) {
                flujoSalida.write(i);
            }

            flujoSalida.close();

        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo");
        } catch (IOException e) {
            System.out.println("Error de entrada y salida");
        }

    }

}
