package personajes;

import armas.ArmaAtaque;
import armas.ArmaDefensa;

public abstract class PielVerde extends WarhammerPersonaje{
    // private String nombre;  --> Se hereda del padre (WarhammerPersonaje)
    private String puebloNacimiento;
    protected int nivel;
    private static int contPielesVerdes;

    public PielVerde(String nombre, String puebloNacimiento) {
        super(nombre);
        this.puebloNacimiento = puebloNacimiento;
    }
    public static int getContPielesVerdes() {
        return contPielesVerdes;
    }
    public void addArmaAtaque (ArmaAtaque arma) {

    }
    public void addArmaDefensa (ArmaDefensa arma) {

    }
    public String imprimirArmas () {
        // Recorer HASH MAP, y preparar cadena
        return "";
    }

    @Override
    public void atacar(WarhammerPersonaje victima) {
        super.atacar(victima);
    }

    @Override
    public void defender(ArmaAtaque arma) {
        super.defender(arma);
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "PielVerde{" +
                "puebloNacimiento='" + puebloNacimiento + '\'' +
                ", nivel=" + nivel +
                '}';
    }
}
