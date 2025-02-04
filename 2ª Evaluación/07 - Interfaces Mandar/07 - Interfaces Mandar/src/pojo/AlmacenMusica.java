package pojo;

import java.util.ArrayList;

public class AlmacenMusica implements IEstanteria{
    ArrayList<Cancion> lstCanciones;

    /* public AlmacenMusica(ArrayLista<Cancion> lstCanciones) {
            this.lstCanciones = lstCanciones;
       }
    */

    public AlmacenMusica () {
        this.lstCanciones = new ArrayList<Cancion>();
    }

    @Override
    public void addCancion(Cancion c) {
        
    }

    @Override
    public void updateCancion(Cancion c) {

    }

    @Override
    public void deleteCancion(Cancion c) {

    }
}
