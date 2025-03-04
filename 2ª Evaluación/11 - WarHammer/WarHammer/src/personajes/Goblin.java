package personajes;

import armas.ArmaAtaque;
import armas.ArmaDefensa;

public class Goblin extends PielVerde{
    public Goblin(String nombre, String puebloNacimiento) {
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


    @Override
    public String toString() {
        return "Goblin{" +
                "nivel=" + nivel +
                '}';
    }
}
