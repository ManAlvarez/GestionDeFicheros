/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios.parsearsax;

import java.io.IOException;
import java.util.ArrayList;
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

            //Imprimimos os datos leendo o XML.
            ArrayList<Tienda> tiendas = tiendaXML.getTiendas();
            for (Tienda tiendaAux : tiendas) {
                System.out.println("###############################");
                System.out.println("Tienda: " + tiendaAux.getNome());
                ArrayList<Equipo> equipos = new ArrayList<Equipo>();
                equipos = tiendaAux.getEquipos();
                if (!equipos.isEmpty()) {
                    for(Equipo equipoAux: equipos){
                        System.out.println("-----------------------------------");
                        System.out.println("ID : "+equipoAux.getId());
                        System.out.println("Descripción: "+equipoAux.getDescripcion());
                        System.out.println("Prezo: "+equipoAux.getPrezo());
                        System.out.println("Cantidade: "+equipoAux.getCantidade());
                    }
                } else {
                    System.out.println("Sin equipos.");
                }
            }

        } catch (IOException | SAXException e) {
        }
    }

}
