import pojo.AlmacenMusica;
import pojo.Cancion;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        AlmacenMusica almacenMusica = new AlmacenMusica();

        Cancion cancion1 = new Cancion (1, "Canción 1");
        Cancion cancion2 = new Cancion (2, "Canción2");
        Cancion cancion3 = new Cancion (3, "Canción 3");

        almacenMusica.addCancion(cancion1);
        almacenMusica.addCancion(cancion2);
        almacenMusica.addCancion(cancion3);

        System.out.println();

        cancion2.setTitulo("Canción 2");
        almacenMusica.updateCancion(cancion2);

        System.out.println();

        almacenMusica.deleteCancion(cancion3);

        System.out.println();

        almacenMusica.imprimir();
    }
}