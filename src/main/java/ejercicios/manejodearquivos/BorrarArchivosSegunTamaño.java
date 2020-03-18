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
public class BorrarArchivosSegunTamaño {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Introduce el directorio donde quieres borrar los archivos con mas de 1MB");
        Scanner sc = new Scanner(System.in);
        String ruta = sc.nextLine();
        File directorio = new File(ruta);
        if(directorio.exists()){
            File[] ficheros = directorio.listFiles();
            for(File fichero:ficheros){
                if(fichero.isFile()){
                    if(fichero.length()>10){
                        fichero.delete();
                    }
                }
            }
        }else{
            System.err.println("El directorio no existe");
        }
    }
    
}
