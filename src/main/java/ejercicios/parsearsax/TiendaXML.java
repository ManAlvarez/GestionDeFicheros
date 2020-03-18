/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios.parsearsax;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author manuel
 */
public class TiendaXML extends DefaultHandler {

    //Aqui vamos a gardar as tiendas.
    private ArrayList<Tienda> tiendas;

    //Aqui vamos a gardar os datos da tenda.
    private Tienda tiendaAux;

    //Aqui vamos a gardar os equipos de cada tienda.
    private ArrayList<Equipo> equipos;  

    //Aqui vamos a gardar os datos do equipo.
    private Equipo equipoAux;

    //Aqui camos a gardar o texto que hay entre as etiquetas,
    private String cadenaTexto;

    public TiendaXML() {
        super();
    }

    public ArrayList<Tienda> getTiendas() {
        return tiendas;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        this.cadenaTexto = new String(ch, start, length);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (localName == "tendas") {
            this.tiendas = new ArrayList<Tienda>();
        } else if (localName == "tenda") {
            this.tiendaAux = new Tienda();
        } else if (localName == "equipos") {
            this.equipos = new ArrayList<Equipo>();
        } else if (localName == "equipo") {
            this.equipoAux = new Equipo();
            this.tiendaAux.setEquipos(this.equipos);
            
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (localName == "nome") {
            this.tiendaAux.setNome(cadenaTexto);
        } else if (localName == "tenda") {
            this.tiendas.add(tiendaAux);
        } else if (localName == "id") {
            int id = Integer.valueOf(cadenaTexto);
            this.equipoAux.setId(id);
        } else if (localName == "descripcion") {
            this.equipoAux.setDescripcion(cadenaTexto);
        } else if (localName == "prezo"){
            double prezo = Double.valueOf(cadenaTexto);
            this.equipoAux.setPrezo(prezo);
        } else if (localName == "cantidade"){
            int cantidade = Integer.valueOf(cadenaTexto);
            this.equipoAux.setCantidade(cantidade);
        } else if (localName == "equipo"){
            this.equipos.add(this.equipoAux);
        }
    }
}
