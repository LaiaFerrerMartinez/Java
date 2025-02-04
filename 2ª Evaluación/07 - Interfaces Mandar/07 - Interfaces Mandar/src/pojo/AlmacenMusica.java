package pojo;

import java.util.ArrayList;

import java.util.Scanner;

public class AlmacenMusica implements IEstanteria{
    ArrayList<Cancion> lstCanciones;

    public AlmacenMusica () {
        this.lstCanciones = new ArrayList<Cancion>();
    }

    @Override
    public void addCancion(Cancion c) {
        lstCanciones.add(c);
        System.out.println("Canción añadida: " + c);
    }

    @Override
    public void updateCancion(Cancion c) {
        int index = lstCanciones.indexOf(c);

        if (index != -1) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduce el nuevo título de la canción: ");
            String newTitle = scanner.nextLine();

            lstCanciones.get(index).setTitulo(newTitle);
            System.out.println("Canción actualizada: " + lstCanciones.get(index));
        } else {
            System.out.println("Canción no encontrada en la lista.");
        }
    }

    @Override
    public void deleteCancion(Cancion c) {
        lstCanciones.remove(c);
        System.out.println("Canción borrada: " + c);
    }

    @Override
    public void imprimir() {
        for (Cancion canciones:lstCanciones) {
            System.out.println(canciones.toString());
        }
    }
}
