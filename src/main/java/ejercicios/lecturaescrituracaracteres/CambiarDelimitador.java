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
public class CambiarDelimitador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Inserta la ruta del archivo .csv");
        Scanner sc = new Scanner(System.in);
        String ruta = sc.nextLine();
        File archivo = new File(ruta);
        if (archivo.exists()) {
            if (archivo.isFile()) {
                if (archivo.getName().contains(".csv")) {
                    try {
                        //Creamos el flujo de entrada
                        FileReader flujoEntrada = new FileReader(archivo);
                        //Creamos un buffer para el flujo de entrada;
                        BufferedReader bufferEntrada = new BufferedReader(flujoEntrada);
                        //Leemos el archivo linea a linea.
                        String datosGuardados = "";
                        String linea="";
                        while((linea=bufferEntrada.readLine())!=null){
                            datosGuardados += linea+"\n";
                        }
                        //Cerramos el archivo.
                        bufferEntrada.close();
                        //Remplazamos los ; por ,.
                        datosGuardados = datosGuardados.replace(";", ",");
                        //Creamos un flujo de datos de salida.
                        FileWriter flujoSalida = new FileWriter(archivo);
                        //Creamos un buffer de salida para el flujo de datos de salida
                        BufferedWriter bufferSalida = new BufferedWriter(flujoSalida);
                        
                        //Guardamos los datos en el archivo
                        bufferSalida.write(datosGuardados);
                        
                        //Cerramos el archivo.
                        bufferSalida.close();
                        

                    } catch (IOException e) {
                        System.out.println("Error de entrada y salida: "+e);
                    }
                } else {
                    System.out.println("El archivo no es un .csv");
                }
            } else {
                System.out.println("El archivo es un directorio");
            }
        } else {
            System.out.println("El archivo no existe");
        }

    }

}
