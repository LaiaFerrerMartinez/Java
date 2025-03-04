package personajes;

import armas.ArmaAtaque;
import interfaces.ICombate;

public abstract class WarhammerPersonaje implements ICombate {
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
    public void atacar(WarhammerPersonaje victima) {

    }
    @Override
    public void defender (ArmaAtaque arma) {

    }

    @Override
    public String toString() {
        return "WarhammerPersonaje{" +
                "nombre='" + nombre + '\'' +
                ", energia=" + energia +
                '}';
    }
}
