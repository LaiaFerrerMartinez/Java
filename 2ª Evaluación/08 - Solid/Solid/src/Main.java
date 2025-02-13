import pojo.herencia.Reporte;
import pojo.printers.PrintToHTML;
import pojo.printers.PrintToJSON;
import pojo.printers.PrintToXML;

import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Reporte printToHTML = new PrintToHTML("<p>");
        Reporte printToXML = new PrintToXML("{p}");
        Reporte printToJSON = new PrintToJSON("'p'");

        ArrayList<Reporte> lst = new ArrayList<>();
        lst.add(printToHTML);
        lst.add(printToXML);
        lst.add(printToJSON);

        for (Reporte reporte:lst) {
            reporte.imprimirCadena();
        }
    }
}