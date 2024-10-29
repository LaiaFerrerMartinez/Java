//  Tablero 4x4
//  Juego memoriza:
//      8 parejas de números (1, 2, 3,...)
//      Dos tableros (usuario y escondido)
//      Enseñas el tablero escondido durante 5 segundos
//      Le pides al usuario dos coordenadas y compruebas si sus valores son iguales:
//          Si son iguales dejas esos dos números descubiertos
//          Si no son iguales enseñas todo el tablero durante dos segundos

import java.util.Random;

public class Memoriza {

    private static final int MAX_FILA = 4;

    private static final int MAX_COLUMNA = 4;

    private static int tableroUsuario [][] = new int[MAX_FILA][MAX_COLUMNA];

    private static int tableroEscondido [][] = new int[MAX_FILA][MAX_COLUMNA];


    private static void rellenarTableroEscondido () {

        Random aleatorio = new Random();
        int filaAle;
        int columnaAle;

        for (int i = 1; i < 9; i++) {
            for (int j = 0; j < 2; j++) {
                do {
                    filaAle = aleatorio.nextInt(MAX_FILA);
                    columnaAle = aleatorio.nextInt(MAX_COLUMNA);
                } while (tableroEscondido[filaAle][columnaAle] != 0);
                tableroEscondido[filaAle][columnaAle] = i;
            }
        }
    }

    private static void imprimirTableroUsuario () {
        for (int i = 0; i < MAX_FILA; i++) {
            for (int j = 0; j < MAX_COLUMNA; j++) {
                System.out.printf(tableroUsuario[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void mostrar () {
        long empieza = System.currentTimeMillis();
    }

    private static void imprimirTableroEscondido () {
        for (int i = 0; i < MAX_FILA; i++) {
            for (int j = 0; j < MAX_COLUMNA; j++) {
                System.out.printf(tableroEscondido[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        imprimirTableroUsuario();
        System.out.println();
        rellenarTableroEscondido();
        imprimirTableroEscondido();
    }
}