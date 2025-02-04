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
        if (c != null) {
            this.lstCanciones.add(c);
            System.out.println("Canción añadida: " + c);
        }
    }

    @Override
    public void updateCancion(Cancion c) {
        if (c != null) {
            int id = c.getId();
            for (Cancion cancion: this.lstCanciones) {
                if (cancion.getId() == id) {
                    cancion.setTitulo(c.getTitulo());
                    System.out.println("Canción actualizada: " + c);
                }
            }
        }
    }

    @Override
    public void deleteCancion(Cancion c) {
        if (c != null) {
            this.lstCanciones.remove(c);
            System.out.println("Canción borrada: " + c);
        }
    }

    @Override
    public void imprimir() {
        for (Cancion canciones:lstCanciones) {
            System.out.println(canciones.toString());
        }
    }
}
