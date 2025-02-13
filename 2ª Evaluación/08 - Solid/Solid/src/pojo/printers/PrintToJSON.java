package pojo.printers;

import pojo.herencia.Reporte;

public class PrintToJSON extends Reporte {
    private String cadenaEnHTML;
    public PrintToJSON (String cadena) {
        super (cadena);
    }
    void imprimirCadena () {
        System.out.println(super.cadenaATransformar);
        System.out.println(this.cadenaEnHTML);
    }
}
