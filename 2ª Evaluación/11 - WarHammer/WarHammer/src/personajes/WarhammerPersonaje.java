package personajes;

public abstract class WarhammerPersonaje {
    private String nombre;
    private int energia;
    //protected HashMap <String, Arma> armas;
    private static int contPersonajes;
    private final int ENERIA_MAX = 0;   // Luego se cambia

    public WarhammerPersonaje(String nombre) {
        this.nombre = nombre;
    }
    public void sumarEnergia() {

    }
    public static void toNumPersonajes () {
        System.out.println("");
        //return int
    }
    public String imprimirArmas () {

        return "";
    }

    @Override
    public String toString() {
        return "WarhammerPersonaje{" +
                "nombre='" + nombre + '\'' +
                ", energia=" + energia +
                '}';
    }
}
