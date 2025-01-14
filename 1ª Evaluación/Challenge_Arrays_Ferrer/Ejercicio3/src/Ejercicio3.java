import java.util.Random;
import java.util.Scanner;

// Rellenar vector de diez cifras con números aleatorios


public class Ejercicio3 {
    private static int MAX_FILA_ARRAY = 6;
    // Declaro el vector
    private static String arrayNumAleat [] = new String[MAX_FILA_ARRAY];

    private static void rellenarArray () {

        // Para crear números aleatorios:
        Random r = new Random();

        for (int i = 0; i < MAX_FILA_ARRAY; i++) {
            arrayNumAleat[i] = String.valueOf(r.nextInt(100));
        }
    }

    private static void jugar () {
        Scanner leer = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            boolean encontrado = false;
            System.out.println("Dime número " + (i + 1));
            String num = leer.next();
            for (int j = 0; j < arrayNumAleat.length; j++) {
                if (num.equals(arrayNumAleat[j])) {
                    encontrado = true;
                    arrayNumAleat[j] = "XX";
                    //imprimirArray();
                }
            }
            if (encontrado == false) {
                System.out.println("Eres un paquete.");
            }
        }
    }

    /*private static void imprimirArray () {
        // Imprimo el vector
        for (int i = 0; i < MAX_FILA_ARRAY; i++) {
                System.out.printf(arrayNumAleat[i] + " ");
        }
    }*/

    public static void main(String[] args) {
        rellenarArray();
        //imprimirArray();
        jugar();
    }

}