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
public class CambiarSufixo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.err.println("Inserta la ruta del directorio que deseas cambiarle el sufijo a sus carpetas");
        Scanner sc = new Scanner(System.in);
        String ruta = sc.nextLine();
        File directorio = new File(ruta);
        if(directorio.exists()){
            File[] archivos = directorio.listFiles();
           for(File dir:archivos){
               if(dir.isDirectory()){
                   File nombreConSufijo = new File(dir+"_backup");
                   dir.renameTo(nombreConSufijo);
               }
           }       
        }else{
            System.err.println("El directorio no existe");
        }
    }
    
}
