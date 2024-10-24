import java.util.Random;
import java.util.Scanner;

public class ControlLaiaFerrerMartinez {
    private static final int MAX_FILA_TABLERO = 10;
    private static final int MAX_COLUMNA_TABLERO = 10;
    private static int tableroNum [][] = new int[MAX_FILA_TABLERO][MAX_COLUMNA_TABLERO];
    private static String tableroX [][] = new String[MAX_FILA_TABLERO][MAX_COLUMNA_TABLERO];
    private static void rellenarTableroNum () {
        //  Relleno el tableroNum
        Random r = new Random();
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                int numAleat = r.nextInt(90) + 9;   // Creo un número aleatorio del 1 al 90, y le sumo 9 para que sea un número del 10 al 99
                tableroNum[i][j] = numAleat;
            }
        }
    }

    private static void rellenarTableroX () {
        //  Relleno el tableroX
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                tableroX[i][j] = "XX";
            }
        }
    }

    private static void imprimirTableroX () {
        //  Imprimo el tableroX
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                System.out.printf(tableroX[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void jugar () {
        //  Pido los números y voy comprobando si están en el tableroNum
        int cont = 0;
        do {
            System.out.println("Dime un número.");
            Scanner lector = new Scanner(System.in);
            boolean encontrado = false;
            int num = lector.nextInt();
            for (int i = 0; i < MAX_FILA_TABLERO; i++) {
                for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                    if (tableroNum[i][j] == num) {
                        encontrado = true;
                        tableroX[i][j] = String.valueOf(num);
                        System.out.println("El número está en la fila " + (i + 1) + " y en la columna " + (j + 1) + ".");
                        System.out.println();
                    }
                }
            }
            if (!encontrado) {
                System.out.println("El número no está en el tablero.");
                System.out.println();
            } else {
                imprimirTableroX();
                System.out.println();
            }
            cont++;
        } while (cont < 10);
    }

    public static void main(String[] args) {
        rellenarTableroNum();
        rellenarTableroX();
        imprimirTableroX();
        jugar();
    }
}