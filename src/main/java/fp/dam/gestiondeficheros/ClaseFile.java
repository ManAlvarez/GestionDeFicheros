/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fp.dam.gestiondeficheros;

import java.io.File;

/**
 *
 * @author manuel
 */
public class ClaseFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Ruta do directorio que queremos listar
        String rutaDirectorio = ".";

        //Devuelve un array de String con los nombres de ficheros y 
        //directorios asociados al objeto File.
        File directorio = new File(rutaDirectorio);
        String[] archivos = directorio.list();

        System.out.printf("Ficheros del directorio %s : %d %n", rutaDirectorio, archivos.length);

        //Recorremos todos los ficheros para imprimir su información
        for (int i = 0; i < archivos.length; i++) {
            File archivoAux = new File(rutaDirectorio, archivos[i]);
            if (archivoAux.isFile()) {
                System.out.printf("Archivo: %s %n", archivoAux.getName());
            } else if (archivoAux.isDirectory()) {
                System.out.printf("Directorio: %s %n", archivoAux.getName());
            }
        }

    }

}
