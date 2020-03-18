/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios.lecturaescrituracaracteres;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author manuel
 */
public class LeerContidoCopiarContido {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.err.println("Introduce la ruta del archivo de texto que desea copiar");
        Scanner sc = new Scanner(System.in);
        String ruta = sc.nextLine();
        File archivo = new File(ruta);
        if(archivo.exists()){
            if(archivo.isFile()){
                String nome = archivo.getName();
                if(nome.contains(".txt")){               
                    try {
                        // Creamos el flujo de datos de entrada.
                        FileReader flujoEntrada = new FileReader(archivo);
                        // Creamos un buffer de entrada.
                        BufferedReader bufferEntrada = new BufferedReader(flujoEntrada);
                        String datosGuardados="";
                        String linea;
                        while((linea=bufferEntrada.readLine())!= null){
                            datosGuardados += linea+"\n";                           
                        }
                        System.out.println(datosGuardados);
                        // Cerramos el archivo.
                        bufferEntrada.close();
                        // Creamos el archivo nuevo
                        String nombreArchivoNuevo = nome.replace(".txt","_backup.txt");
                        File nuevoArchivo = new File(archivo.getParent(),nombreArchivoNuevo);
                        // Creamos un flujo de datos de salida.
                        FileWriter flujoSalida = new FileWriter(nuevoArchivo);
                        // Creamos un buffer de datos de salida.
                        BufferedWriter bufferSalida = new BufferedWriter(flujoSalida);
                        // Creamos un array con todas las lineas.
                        String[] lineadatos = datosGuardados.split("\n");
                        for(String lineaAux:lineadatos){
                        bufferSalida.write(lineaAux);
                        bufferSalida.newLine();
                        }
                        //Cerramos el archivo
                        bufferSalida.close();
                        
                    } catch (IOException e) {
                        System.out.println("Error de entrada y salida");
                    }
                    
                    
                }else{
                    System.out.println("No es un txt");
                }
            }else{
                System.out.println("No es un archivo");
            }
        }else{
            System.out.println("El archivo no existe");
        }
    }
    
}
