/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios.lecturaEscrituraJson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import lecturaescriturajson.desserializacion.Aula;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author manuel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        XMLReader procesadorXML = null;
        try {
            //Creamos un parseador de texto e engadimoslle a nosa clase que vai 
            //parsear o texto.
            procesadorXML = XMLReaderFactory.createXMLReader();
            TiendaXML tiendaXML = new TiendaXML();
            procesadorXML.setContentHandler(tiendaXML);

            //Indicamos o texto donde estan gardadas as tiendas.
            InputSource archivo = new InputSource("equipos.xml");
            procesadorXML.parse(archivo);
            ArrayList<Tienda> tiendas = tiendaXML.getTiendas();

            // Pasamos a nosa clase a JSON utilizando a libreria GSON
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(tiendas);

            File arquivo = new File("tiendas.json");

            FileWriter flujoDatos = new FileWriter(arquivo);
            BufferedWriter bufferSalida = new BufferedWriter(flujoDatos);
            bufferSalida.write(json);
            bufferSalida.close();

            // Creamos el flujo de entrada.
            FileReader flujoEntrada = new FileReader(arquivo);

            StringBuilder jsonBuilder;
            // Imos lendo linea a linea
            try (
                    // Creamos el buffer de entrada.
                    BufferedReader bufferEntrada = new BufferedReader(flujoEntrada)) {
                // Imos lendo linea a linea
                jsonBuilder = new StringBuilder();
                String linea;
                while ((linea = bufferEntrada.readLine()) != null) {
                    jsonBuilder.append(linea).append("\n");
                }
                // Cerramos el fichero.
            }

            // Construimos o String con todas as lineas lidas.
            String json1 = jsonBuilder.toString();

            // Pasamos o json a clase ca cal corresponde.
            Gson gson1 = new Gson();
            Tienda tienda = gson1.fromJson(json1, Tienda.class);

            // Comprobamos que se leeran ben os datos.
            System.out.println("Tienda: " + tienda.getNome());
            System.out.println("Equipos: ");
            for (Equipo equipoAux : tienda.getEquipos()) {
                System.out.println("ID : " + equipoAux.getId());
                System.out.println("Descripción : " + equipoAux.getDescripcion());
                System.out.println("Prezo : " + equipoAux.getPrezo());
                System.out.println("Cantidade" + equipoAux.getCantidade());
            }

        } catch (IOException | SAXException e) {
        }

    }

}
