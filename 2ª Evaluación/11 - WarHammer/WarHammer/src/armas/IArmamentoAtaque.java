package armas;

import personajes.WarhammerPersonaje;

public interface IArmamentoAtaque {
    void atacar (WarhammerPersonaje victima);
    void atacar (WarhammerPersonaje victima, boolean esAtaqueEmperador);
}
