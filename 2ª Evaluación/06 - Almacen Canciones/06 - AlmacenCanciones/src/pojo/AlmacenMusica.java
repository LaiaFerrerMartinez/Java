package pojo;

import java.util.ArrayList;

public class AlmacenMusica {
    private static ArrayList<Cancion> lstCanciones = new ArrayList<Cancion>();

    public AlmacenMusica() {
    }

    public static void addCancion(Cancion cancion) {
        lstCanciones.add(cancion);
        System.out.println("Canción añadida: " + cancion);
    }

    public static void deleteCancion(Cancion cancion) {
        lstCanciones.remove(cancion);
        System.out.println("Cancion borrada: " + cancion);
    }

    public static void imprimirCancion(Cancion cancion) {
        System.out.println(cancion.toString());
    }

    public static void imprimirCanciones() {
        for (Cancion canciones:lstCanciones) {
            System.out.println(canciones.toString());
        }
    }
}
