/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fp.dam.gestiondeficheros.dataoutputstream;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author manuel
 */
public class ClaseDataOutputStream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<Persoa> persoas = new ArrayList<Persoa>();
        
        persoas.add(new Persoa("nome1", 11));
        persoas.add(new Persoa("nome2", 22));
        persoas.add(new Persoa("nome3", 33));
        persoas.add(new Persoa("nome4", 44));
        
        try {
            //Comenzamos declarando el fichero         
            File fichero = new File(File.separator + "home" + File.separator + "manuel" + File.separator + "Documentos" + File.separator + "data.dat");
            
            //Cramos un flujo de datos de saida para el archivo.
            FileOutputStream flujoSalida = new FileOutputStream(fichero);
            DataOutputStream flujoDatos = new DataOutputStream(flujoSalida);
            
            //Vamos a guardar los datos de las personas.
            for(int i=0;i<persoas.size();i++){
                Persoa persoaux = persoas.get(i);
                flujoDatos.writeUTF(persoaux.getNome());
                flujoDatos.writeInt(persoaux.getIdade());
            }
            
            flujoDatos.close();
            
        } catch (IOException e) {
            System.out.println("No se ha podido escribir en el fichero");
        }
    }
    
}
