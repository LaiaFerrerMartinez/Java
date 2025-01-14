import java.util.Random;

// Rellenar vector de diez cifras con números aleatorios
public class Ejercicio1 {
    public static void main(String[] args) {
        // Declaro el vector
        int arrayNumAleat [] = new int[10];
        // Para crear números aleatorios:
        Random r = new Random();
        // Relleno el vector
        for (int i = 0; i < arrayNumAleat.length; i++) {
            arrayNumAleat [i] =  r.nextInt(100);
        }
        // Imprimo el vector
        for (int i = 0; i < arrayNumAleat.length; i++) {
            System.out.printf(arrayNumAleat[i] + " ");
        }
    }
}