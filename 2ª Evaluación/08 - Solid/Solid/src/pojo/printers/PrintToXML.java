package pojo.printers;

import pojo.herencia.Reporte;

public class PrintToXML extends Reporte {
    private String cadenaEnHTML;
    public PrintToXML (String cadena) {
        super (cadena);
    }
    void imprimirCadena () {
        System.out.println(super.cadenaATransformar);
        System.out.println(this.cadenaEnHTML);
    }
}
