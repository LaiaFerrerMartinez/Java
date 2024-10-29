//  Tablero 4x4
//  Juego memoriza:
//      8 parejas de números (1, 2, 3,...)
//      Dos tableros (usuario y escondido)
//      Enseñas el tablero escondido durante 5 segundos
//      Le pides al usuario dos coordenadas y compruebas si sus valores son iguales:
//          Si son iguales dejas esos dos números descubiertos
//          Si no son iguales enseñas todo el tablero durante dos segundos

import java.util.Random;
import java.util.Scanner;

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

    private static void imprimirTableroEscondido () {
        for (int i = 0; i < MAX_FILA; i++) {
            for (int j = 0; j < MAX_COLUMNA; j++) {
                System.out.printf(tableroEscondido[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void mostrarTableroEscondido () {
        try {
            imprimirTableroEscondido();
            Thread.sleep(5000);
            for (int i = 0; i < 100; i++) {
                System.out.println();
            }
        } catch (InterruptedException e) {
            System.out.println();
        }
    }

    private static void jugar () {
        System.out.println("Te voy a mostrar las 8 parejas de números y me tienes que decir en que posición están las parejas.");
        System.out.println("¿List@?");
        System.out.println("Ahí va el tablero.");

        boolean encontrado;

        do {
            mostrarTableroEscondido();

            int fila1;
            int columna1;
            int fila2;
            int columna2;
            encontrado = false;

            System.out.println("¿Qué coordenadas tienen el mismo número?");
            Scanner lector = new Scanner(System.in);


            System.out.println("Dime la coordenada (0-3) i del primer número.");
            fila1 = lector.nextInt();
            System.out.println("Dime la coordenada (0-3) j del primer número.");
            columna1 = lector.nextInt();
            tableroUsuario[fila1][columna1] = tableroEscondido[fila1][columna1];
            imprimirTableroUsuario();

            System.out.println("Dime la coordenada i del segundo número (0-3).");
            fila2 = lector.nextInt();
            System.out.println("Dime la coordenada j del segundo número (0-3).");
            columna2 = lector.nextInt();
            tableroUsuario[fila2][columna2] = tableroEscondido[fila2][columna2];
            imprimirTableroUsuario();

            if (tableroEscondido[fila1][columna1] == tableroEscondido[fila2][columna2]) {
                System.out.println("¡MUY BIENNNN!");
            } else {
                System.out.println("NOOOOOO");
                tableroUsuario[fila1][columna1] = 0;
                tableroUsuario[fila2][columna2] = 0;
                System.out.println();
                System.out.println("Te voy a volver a mostrar el tablero.");
                mostrarTableroEscondido();
            }
            System.out.println();
            for (int i = 0; i < MAX_FILA; i++) {
                for (int j = 0; j < MAX_COLUMNA; j++) {
                    if (tableroUsuario[i][j] == 0) {
                        encontrado = true;
                    }
                }
            }
        } while (encontrado);
    }

    public static void main(String[] args) {
        rellenarTableroEscondido();
        jugar();
    }
}