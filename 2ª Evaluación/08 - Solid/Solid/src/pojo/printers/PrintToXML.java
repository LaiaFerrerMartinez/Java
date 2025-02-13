package pojo.printers;

import pojo.herencia.Reporte;

public class PrintToXML extends Reporte {
    private String cadenaEnHTML;
    public PrintToXML (String cadena) {
        super (cadena);
    }

    public void imprimirCadena () {
        System.out.println(super.cadenaATransformar);
    }
}
