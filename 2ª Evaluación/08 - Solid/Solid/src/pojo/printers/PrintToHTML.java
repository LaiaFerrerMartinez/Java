package pojo.printers;

import pojo.herencia.Reporte;

public class PrintToHTML extends Reporte {
    private String cadenaEnHTML;
    public PrintToHTML (String cadena) {
        super (cadena);
    }
    public void imprimirCadena () {
        System.out.println(super.cadenaATransformar);
    }
}
