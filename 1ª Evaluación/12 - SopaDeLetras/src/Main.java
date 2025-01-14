// Tablero 10x10
// Máx. 5 palabras de máx. 5 letras
// Se colocan las palabras aleatoriamente

import java.util.Random;

public class Main {

    private static final int MAX_FILA = 10;

    private static final int MAX_COLUMNA = 10;

    private static char tablero[][] = new char[MAX_FILA][MAX_COLUMNA];

    private static void rellenarTableroX() {
        for (int i = 0; i < MAX_FILA; i++) {
            for (int j = 0; j < MAX_COLUMNA; j++) {
                tablero [i][j] = 'x';
            }
        }
    }

    private static void imprimirTablero() {
        for (int i = 0; i < MAX_FILA; i++) {
            for (int j = 0; j < MAX_COLUMNA; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static final String [] palabras = {"CASA", "SAL", "RATON", "SILLA", "MESA"};

    private static void colocarPalabras() {
        Random aleatorio = new Random();
        int fila;
        int columna;
        boolean horizontal;

        for (int i = 0; i < palabras.length; i++) {
            String palabra = palabras[i];
            System.out.println(palabra);
            horizontal = aleatorio.nextBoolean();
            boolean colocado = false;

            while (!colocado) {
                // Elegir posición inicial aleatoria
                fila = aleatorio.nextInt(MAX_FILA);
                columna = aleatorio.nextInt(MAX_COLUMNA);

                // Verificar si la palabra cabe en la dirección elegida
                boolean espacioLibre = true;

                if (horizontal) {
                    // Verificar que la palabra cabe dentro del límite de columnas
                    if (columna + palabra.length() > MAX_COLUMNA) {
                        espacioLibre = false;
                    } else {
                        // Comprobar que no haya superposición con otras palabras
                        for (int j = 0; j < palabra.length(); j++) {
                            if (tablero[fila][columna + j] != 'x') {
                                espacioLibre = false;
                                break;
                            }
                        }
                    }
                } else {
                    // Verificar que la palabra cabe dentro del límite de filas
                    if (fila + palabra.length() > MAX_FILA) {
                        espacioLibre = false;
                    } else {
                        // Comprobar que no haya superposición con otras palabras
                        for (int j = 0; j < palabra.length(); j++) {
                            if (tablero[fila + j][columna] != 'x') {
                                espacioLibre = false;
                                break;
                            }
                        }
                    }
                }

                // Si hay espacio libre, colocar la palabra y marcar que ya se colocó
                if (espacioLibre) {
                    for (int j = 0; j < palabra.length(); j++) {
                        if (horizontal) {
                            tablero[fila][columna + j] = palabra.charAt(j);  // Colocar la palabra horizontalmente
                        } else {
                            tablero[fila + j][columna] = palabra.charAt(j);  // Colocar la palabra verticalmente
                        }
                    }
                    colocado = true; // La palabra ha sido colocada correctamente
                }
            }
        }
    }

    private static void colocarLetrasAleatorias() {
        Random aleatorio = new Random();
        for (int i = 0; i < MAX_FILA; i++) {
            for (int j = 0; j < MAX_COLUMNA; j++) {
                if (tablero[i][j] == 'x') {
                    tablero[i][j] = (char) ('A' + aleatorio.nextInt(26));
                }
            }
        }
    }

    public static void main(String[] args) {
        rellenarTableroX();
        colocarPalabras();
        colocarLetrasAleatorias();
        imprimirTablero();
    }
}