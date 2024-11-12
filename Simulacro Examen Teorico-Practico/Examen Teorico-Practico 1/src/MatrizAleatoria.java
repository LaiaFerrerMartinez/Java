import java.util.Random;

public class MatrizAleatoria {

    private static int[][] matriz = new int[3][9];

    private static void rellenarMatriz () {

        Random random = new Random();

        // Llenar la matriz de acuerdo al rango en cada columna
        for (int col = 0; col < matriz[0].length; col++) {
            int min = 10 + (col * 10); // valor mínimo para la columna actual
            int max = min + 9;     	// valor máximo para la columna actual

            for (int row = 0; row < matriz.length; row++) {
                matriz[row][col] = random.nextInt(max - min + 1) + min;
            }
        }
    }

    private static void imprimirMatriz () {
        // Imprimir la matriz
        for (int row = 0; row < matriz.length; row++) {
            for (int col = 0; col < matriz[0].length; col++) {
                System.out.print(matriz[row][col] + "\t");
            }
            System.out.println();
        }
    }

    private static void ordenarNum () {
        // Ordenar números por columnas de menor a mayor
        int aux;
        int cont = 0;
        do {
            for (int i = 0; i < matriz.length - 1; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    do {
                        aux = matriz [i][j];
                        matriz [i][j] = matriz [i+1][j];
                        matriz [i+1][j] = aux;
                    } while (matriz [i][j] > matriz [i+1][j]);
                }
            }
            cont++;
        } while (cont < matriz.length);
    }
    public static void main(String[] args) {
        rellenarMatriz();
        imprimirMatriz();
        System.out.println();
        ordenarNum();
        imprimirMatriz();
    }
}
