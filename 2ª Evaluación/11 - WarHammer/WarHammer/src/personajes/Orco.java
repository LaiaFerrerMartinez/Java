package personajes;

import armas.ArmaAtaque;
import armas.ArmaDefensa;

import java.util.ArrayList;

public class Orco extends PielVerde{
    private ArrayList<Goblin> listaGoblin;
    public Orco(String nombre, String puebloNacimiento) {
        super(nombre, puebloNacimiento);
    }

    @Override
    public void sumarEnergia() {
        super.sumarEnergia();
    }

    @Override
    public void addArmaAtaque(ArmaAtaque arma) {
        super.addArmaAtaque(arma);
    }

    @Override
    public void addArmaDefensa(ArmaDefensa arma) {
        super.addArmaDefensa(arma);
    }

    public void addGoblin (Goblin goblin) {

    }

    @Override
    public String toString() {
        return "Goblin{" +
                "nivel=" + nivel +
                '}';
    }
}
