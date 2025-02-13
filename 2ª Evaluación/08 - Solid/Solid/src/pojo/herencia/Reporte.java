package pojo.herencia;

public class Reporte {
    // ATRIBUTOS
    protected String cadenaATransformar;

    // CONSTRUCTORES
    public Reporte (String cadenaATransformar) {
        this.cadenaATransformar = cadenaATransformar;
    }

    // MÉTODOS
    public void imprimirCadena () {
        System.out.println(this.cadenaATransformar);
    }
        // GETTER/SETTER
}
