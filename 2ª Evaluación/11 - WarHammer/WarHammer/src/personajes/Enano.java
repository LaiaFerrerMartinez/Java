package personajes;

public abstract class Enano extends WarhammerPersonaje{
    // private String nombre;  --> Se hereda del padre (WarhammerPersonaje)
    private int riqueza;
    protected int nivel;
    private static int contEnanos;

    public Enano(String nombre, int riqueza) {
        super(nombre);
        this.riqueza = riqueza;
    }
    public static int getContEnanos() {
        return contEnanos;
    }
    /* public void addArmaAtaque (ArmaAtaque arma) {

    } */
    /* public void addArmaDefensa (ArmaDefensa arma) {

    } */
    public String imprimirArmas () {
        // Recorer HASH MAP, y preparar cadena
        return "";
    }

    @Override
    public String toString() {
        return "PielVerde{" +
                "puebloNacimiento='" + riqueza + '\'' +
                ", nivel=" + nivel +
                '}';
    }
}
