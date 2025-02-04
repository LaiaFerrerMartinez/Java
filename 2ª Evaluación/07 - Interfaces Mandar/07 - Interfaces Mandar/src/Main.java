import pojo.AlmacenMusica;
import pojo.Cancion;
import java.util.Scanner;

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

        Scanner lector = new Scanner(System.in);
        System.out.print("Dime el título que le quieres poner a la canción: ");
        String tituloUsuario = lector.nextLine();
        System.out.print("Dime el id de la canción: ");
        int idUsuario = lector.nextInt();
        Cancion cancionUsuario;
        almacenMusica.updateCancion(cancionUsuario = new Cancion (idUsuario, tituloUsuario));

        System.out.println();

        almacenMusica.deleteCancion(cancion3);

        System.out.println();

        almacenMusica.imprimir();
    }
}