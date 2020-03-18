/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios.manejodearquivos;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author manuel
 */
public class ImprimirArquivos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Inserta la ruta del directorio a listar: ");
        Scanner sc = new Scanner(System.in);
        String ruta = sc.nextLine();
        File fichero = new File(ruta);
        if (fichero.exists()) {
            File[] ficheros = fichero.listFiles();
            for (File ficheroAux : ficheros) {
                if (ficheroAux.isFile()) {
                    System.err.println("--------------------------------------------------------------------------------");
                    System.out.println("El nombre es: " + ficheroAux.getName());
                    System.out.println("La ruta es: " + ficheroAux.getAbsolutePath());
                    System.out.println("El tamaño es: " + ficheroAux.length() + " bytes");
                }
            }
        } else {
            System.out.println("La ruta del directorio no existe");
        }

    }

}
