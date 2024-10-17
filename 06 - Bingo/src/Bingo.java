public class Bingo {
    private static final int MAX_FILA_TABLERO = 3;
    private static final int MAX_COLUMNA_TABLERO = 9;
    private static int tablero[][] = new int[MAX_FILA_TABLERO][MAX_COLUMNA_TABLERO];

    private static int numAleatorio(int min, int max) {
        int range = (max - min) + 1;
        int random = (int) ((range * Math.random()) + min);
        return random;
    }

    private static boolean numeroRepetido(int num, int filaActual, int columnaActual) {
        for (int i = 0; i < filaActual; i++) {
            if (tablero[i][columnaActual] == num) {
                return true;
            }
        }
        for (int j = 0; j < columnaActual; j++) {
            if (tablero[filaActual][j] == num) {
                return true;
            }
        }
        return false;
    }

    private static void rellenarBingo() {
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            int k = 0;
            int l = 9;
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                int num;
                do {
                    num = numAleatorio(k, l);
                } while (numeroRepetido(num, i, j));
                tablero[i][j] = num;
                k = k + 10;
                l = l + 10;
            }
        }
    }

    private static void imprimirBingo () {
        for (int i = 0; i < MAX_FILA_TABLERO; i++) {
            for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
                System.out.printf(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void ordenarBingo () {
        int aux;
        for (int j = 0; j < MAX_COLUMNA_TABLERO; j++) {
            if (tablero [0][j] < tablero [1][j]) {
                if (tablero [0][j] < tablero [2][j]) {
                    if (tablero [2][j] < tablero [1][j]) {
                        aux = tablero [1][j];
                        tablero [1][j] = tablero [2][j];
                        tablero [2][j] = aux;
                    }
                } else {
                    aux = tablero [0][j];
                    tablero [0][j] = tablero [2][j];
                    tablero [2][j] = aux;
                    aux = tablero [2][j];
                    tablero [2][j] = tablero [2][j];
                    tablero [2][j] = aux;
                }
            } else {
                if (tablero [0][j] < tablero [2][j]) {
                    aux = tablero[0][j];
                    tablero [0][j] = tablero [1][j];
                    tablero [1][j] = aux;
                } else
                    if (tablero [1][j] < tablero [2][j]) {
                        aux = tablero [0][j];
                        tablero [0][j] = tablero [2][j];
                        tablero [2][j] = aux;
                        aux = tablero [1][j];
                        tablero [1][j] = tablero [0][j];
                        tablero [0][j] = aux;
                    } else {
                        aux = tablero [2][j];
                        tablero [2][j] = tablero [0][j];
                        tablero [0][j] = aux;
                     }
            }
        }
    }

    public static void main(String[] args) {
        rellenarBingo();
        imprimirBingo();
        System.out.println();
        ordenarBingo();
        imprimirBingo();
    }
}


