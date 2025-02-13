import pojo.herencia.Reporte;
import pojo.printers.PrintToHTML;
import pojo.printers.PrintToJSON;
import pojo.printers.PrintToXML;

import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Reporte printToXML = new PrintToXML("FDAS");
        Reporte printToJSON = new PrintToJSON("FDSA");

        ArrayList<Reporte> lst = new ArrayList<>();
        lst.add(printToJSON);
        lst.add(printToXML);
    }
}