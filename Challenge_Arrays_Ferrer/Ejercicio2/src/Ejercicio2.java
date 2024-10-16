import java.util.Random;

// Rellenar vector de diez cifras con números aleatorios


public class Ejercicio2 {
    private static int MAX_FILA_ARRAY = 10;
    private static int MAX_COLUMNA_ARRAY = 10;
    // Declaro el vector
    private static int arrayNumAleat [][] = new int[MAX_FILA_ARRAY][MAX_COLUMNA_ARRAY];

    private static void rellenarArray () {


        // Para crear números aleatorios:
        Random r = new Random();

        for (int i = 0; i < MAX_FILA_ARRAY; i++) {
            for (int j = 0; j < MAX_COLUMNA_ARRAY; j++) {
                arrayNumAleat [i][j] =  r.nextInt(100);
            }

        }
    }

    private static void imprimirArray () {
        // Imprimo el vector
        for (int i = 0; i < MAX_FILA_ARRAY; i++) {
            for (int j = 0; j < MAX_COLUMNA_ARRAY; j++) {
                System.out.printf(arrayNumAleat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        rellenarArray();
        imprimirArray();

    }
}