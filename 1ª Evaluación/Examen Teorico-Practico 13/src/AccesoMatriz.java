public class AccesoMatriz {
    public static void main(String[] args) {
        int[][] matriz = {
                {1, 2, 3},
                {4, 5, 6}
        };

        // No hay posicion (2, 2) porque la dimensión de la matriz es [1, 2]
        System.out.println("Elemento en la posición (2,2): " + matriz[2][2]);
    }
}
