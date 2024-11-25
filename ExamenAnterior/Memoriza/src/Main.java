import java.util.Random;
import java.util.Scanner;

public class Main {

    private static int tablero[][] = new int[4][4];

    private static int tableroUsuario[][] = new int[4][4];

    private static int intentos = 10;

    private static void rellenarTablero0 (int[][] tablero) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tablero[i][j] = 0;
            }
        }
    }

    private static void rellenarTablero () {
        Random ale = new Random();
        int filaAle;
        int colAle;
        for (int i = 1; i < 9; i++) {
            for (int j = 0; j < 2; j++) {
                do {
                    filaAle = ale.nextInt(4);
                    colAle = ale.nextInt(4);
                } while (tablero[filaAle][colAle] != 0);
                tablero[filaAle][colAle] = i;
            }
        }
    }

    private static void imprimirTablero (int[][] tablero) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void mostrarTableroEscondido () {
        try {
            imprimirTablero(tablero);
            Thread.sleep(5000);
            for (int i = 0; i < 100; i++) {
                System.out.println();
            }
        } catch (InterruptedException e) {

        }
    }

    private static void comprobarNum (int fila1, int col1, int fila2, int col2) {
        if (tablero[fila1][col1] == tablero[fila2][col2]) {
            System.out.println("ACIERTO");
            tableroUsuario[fila1][col1] = tablero[fila1][col1];
            tableroUsuario[fila2][col2] = tablero[fila2][col2];
        } else {
            System.out.println("FALLO");
            intentos--;
            System.out.println("Te quedan " + intentos + " intentos.");
        }
    }

    private static void jugar () {
        Scanner lector = new Scanner(System.in);
        System.out.println("Tienes " + intentos + " intentos.");
        do {
            imprimirTablero(tableroUsuario);
            System.out.println("Dime la fila del primer número.");
            int fila1 = lector.nextInt();
            System.out.println("Dime la columna del primer número.");
            int col1 = lector.nextInt();
            System.out.println("Dime la fila del segundo número.");
            int fila2 = lector.nextInt();
            System.out.println("Dime la columna del segundo número.");
            int col2 = lector.nextInt();
            comprobarNum(fila1, col1, fila2, col2);
        } while (intentos > 0);

    }

    public static void main(String[] args) {
        rellenarTablero0(tableroUsuario);
        rellenarTablero0(tablero);
        rellenarTablero();
        mostrarTableroEscondido();
        jugar();
    }
}