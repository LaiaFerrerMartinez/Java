package interfaces;

import armas.ArmaAtaque;
import personajes.WarhammerPersonaje;

public interface ICombate {
    void atacar (WarhammerPersonaje victima);
    void defender (ArmaAtaque arma);
}
