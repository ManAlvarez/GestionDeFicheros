/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parseararchivosxmlconsax;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author manuel
 */
public class PersoasXML extends DefaultHandler{
    
    //Aqui imos gardar os datos de todalas persoas do XML
    private ArrayList<Persoa> persoas;
    
    //E un atributo auxiliar para ir gardando os datos da Persoa do XML.
    private Persoa persoaAux;
    
    //E un atributo auxiliar po texto que hai entre as etiquetas.
    private String cadeaTexto;
    
    public PersoasXML(){
        super();
    }
    
       /*
    Este metodo executase cando se le unha cadea de texto
     */

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
       //Gardamos todo o texto entre caracteres na cadea de texto auxiliar
        this.cadeaTexto = new String(ch,start,length);
    }
    
    /*
    Este método executase cando se finaliza de ler unha etiqueta
     */

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //Finalizamos de ler a etiqueta Nome, polo que podemos gardar o texto que hai entre as etiquetas
        if(localName == "Nome"){
            this.persoaAux.setNome(cadeaTexto);
        }
        //Finalizamos de ler a etiqueta Idade, polo que podemos gardar o texto que hai entre as etiquetas
        else if(localName == "Idade"){
            int idade = Integer.valueOf(this.cadeaTexto);
            this.persoaAux.setIdade(idade);
        }
        //Finalizamos de ler a etiqueta Persoa, polo que podemos gardar o obxecto ausiliar de Persoa no ArrayList
        else if(localName == "Persoa"){
            this.persoas.add(this.persoaAux);
        }
    }
    
    /*
    Este metodo executase ao comezar a ler unha etiqueta
     */

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
       //Se atopamos a etiqueta Persoas creamos un novo arrayList
        if(localName == "Persoas"){
            this.persoas = new ArrayList<Persoa>();
        }
        //Se atopamos a etiqueta Persoa, creamos o obxecto auxiliar de Persoa onde gardaremos todolos datos
        else if(localName == "Persoa"){
            this.persoaAux = new Persoa();
        }
    }
    
    /*
    Este e o método que se executa ao finalizar o  parseo
    Non o imos utilizar neste caso, poderiase utilizar se fose necesario
     */

    @Override
    public void endDocument() throws SAXException {
        super.endDocument(); //To change body of generated methods, choose Tools | Templates.
    }

     /*
    Este e o metodo que se executa ao comezo, antes de parsear nada
    Non o imos utilizar neste caso, poderiase utilizar se fose necesario
     */
    
    @Override
    public void startDocument() throws SAXException {
        super.startDocument(); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Persoa> getPersoas() {
        return persoas;
    } 
    
}
