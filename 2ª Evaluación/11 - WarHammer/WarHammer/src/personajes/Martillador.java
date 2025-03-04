package personajes;

import armas.ArmaAtaque;
import armas.ArmaDefensa;

public class Martillador extends Enano{

    public Martillador(String nombre, int riqueza) {
        super(nombre, riqueza);
    }
    @Override
    public void sumarEnergia() {
        super.sumarEnergia();
    }

    @Override
    public String toString() {
        return "Martillador{" +
                "nivel=" + nivel +
                '}';
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
    public void atacar(WarhammerPersonaje victima) {
        super.atacar(victima);
    }
    public void atacar (PielVerde victima) {

    }
    public void defender (ArmaAtaque armaAtacante) {

    }
}
