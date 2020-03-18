/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fp.dam.gestiondeficheros.dataoutputstream;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author manuel
 */
public class ClaseDataInputStream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        ArrayList<Persoa> persoas = new ArrayList<Persoa>();

        File fichero = new File(File.separator + "home" + File.separator + "manuel" + File.separator + "Documentos" + File.separator + "data.dat");

        try {
            //Creamos un flujo de entrada para el archivo.
            FileInputStream flujoEntrada = new FileInputStream(fichero);
            DataInputStream flujoDatos = new DataInputStream(flujoEntrada);
            try {
                //Leemos los datos y los vamos guardando en el array.    
                while (true) {
                    String nomeAux = flujoDatos.readUTF();
                    int idadeAux = flujoDatos.readInt();
                    //Creamos el objero persoa
                    Persoa persoaAux = new Persoa(nomeAux, idadeAux);
                    //Lo añadimos al array.
                    persoas.add(persoaAux);
                }
            //Esta excepción salta a ler ao rematar de lelo arquivo              
            } catch (EOFException e) {
                System.out.println("Rematou de ler o ficheiro");
            }
            
            flujoDatos.close();
            
            //Imprimimos por pantalla las personas
            for(Persoa persoa:persoas){
               System.out.println(persoa.getNome() + " " + persoa.getIdade());
            }
            
        } catch (IOException e) {
            System.out.println("Error de entrada y salida");
        }
        
    }

}
