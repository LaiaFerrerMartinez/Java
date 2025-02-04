import pojo.AlmacenMusica;
import pojo.Cancion;

public class Main {
    public static void main(String[] args) {
        //AlmacenMusica almacenMusica1 = new AlmacenMusica ();
        Cancion cancion1 = new Cancion(1, "Canción 1");
        Cancion cancion2 = new Cancion(2, "Canción 2");
        Cancion cancion3 = new Cancion(3, "Canción 3");

        AlmacenMusica.addCancion(cancion1);
        AlmacenMusica.addCancion(cancion2);
        AlmacenMusica.addCancion(cancion3);

        AlmacenMusica.imprimirCancion(cancion1);
        AlmacenMusica.imprimirCancion(cancion2);
        AlmacenMusica.imprimirCancion(cancion3);

        AlmacenMusica.deleteCancion(cancion2);

        AlmacenMusica.imprimirCanciones();
    }
}