package armas;

import personajes.WarhammerPersonaje;

public class Arco extends ArmaAtaque{
    private final int VIDA_CONSUMIDA = 3;

    public Arco(String nombre) {
        super(nombre);
    }

    public int getVIDA_CONSUMIDA() {
        return VIDA_CONSUMIDA;
    }

    @Override
    public void atacar(WarhammerPersonaje victima, boolean esAtaqueEmperador) {
        super.atacar(victima, esAtaqueEmperador);
    }

    @Override
    public void atacar(WarhammerPersonaje victima) {
        super.atacar(victima);
    }
}
