/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios.lecturaescrituradedatosbinarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author manuel
 */
public class CopiarImagen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Introduce la ruta de una imagen");
        Scanner sc = new Scanner(System.in);
        String ruta = sc.nextLine();
        File imagen = new File(ruta);
        if (imagen.exists()) {
            if (imagen.isFile()) {
                try {
                    //Creamos el flujo de datos de entrada.
                    FileInputStream flujoEntrada = new FileInputStream(imagen);

                    String nome = imagen.getName();
                    char[] caracteres = nome.toCharArray();
                    int posicion = 0;

                    for (char caracter : caracteres) {
                        String caracterAux = String.valueOf(caracter);
                        posicion++;
                        if (caracterAux.equals(".")) {
                            break;
                        }
                    }

                    String prefijo = nome.substring(0, posicion - 1);
                    String sufijo = nome.substring(posicion - 1, nome.length());
                    String nomeNovo = prefijo + "_backup" + sufijo;

                    File archivoNovo = new File(imagen.getParent(), nomeNovo);

                    //Creamos el flujo de datos de salida.
                    FileOutputStream flujoSalida = new FileOutputStream(archivoNovo);

                    //Leemos el archivo linea a linea                 
                    int datoByte;
                    while ((datoByte = flujoEntrada.read()) != -1) {
                        flujoSalida.write(datoByte);
                    }
                    flujoSalida.close();

                } catch (IOException e) {
                    System.out.println("Error de entrada y salida: " + e);
                }
            } else {
                System.out.println("La ruta es un directorio");
            }
        } else {
            System.out.println("La imagen no existe");
        }
    }

}
