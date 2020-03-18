package parseararchivosxmlconsax;

import java.io.File;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.ArrayList;
import parseararchivosxmlconsax.Persoa;
import parseararchivosxmlconsax.PersoasXML;

public class Main
{
    public static void main(String [] args)
    {
        XMLReader procesadorXML = null;
        try {

            //Creamos un parseador de texto e engadimoslle a nosa clase que vai parsear o texto
            procesadorXML = XMLReaderFactory.createXMLReader();
            PersoasXML persoasXML = new PersoasXML();
            procesadorXML.setContentHandler(persoasXML);

            //Indicamos o texto donde estan gardadas as persoas
            InputSource arquivo = new InputSource(File.separator + "home" + File.separator + "manuel" + File.separator + "Documentos" + File.separator + "persoa.xml");
            procesadorXML.parse(arquivo);

            //Imprimimos os datos lidos no XML
            ArrayList<Persoa> persoas = persoasXML.getPersoas();
            for(int i=0;i<persoas.size();i++){
                Persoa persoaAux = persoas.get(i);
                System.out.println("Nome: " + persoaAux.getNome() + ", Idade: " + persoaAux.getIdade());
            }

        } catch (SAXException e) {
            System.out.println("Ocurriu un erro ao ler o arquivo XML");
        } catch (IOException e) {
            System.out.println("Ocurriu un erro ao ler o arquivo XML");
        }


    }
}