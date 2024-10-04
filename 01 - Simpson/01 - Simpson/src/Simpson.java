public class Simpson {
    // Visible a nivel de la clase Simpson
    static char[][] tablero = new char[10][10]; // (0 a n-1)
    // Fin
    // Software de gestión de venta ONLINE
    public static void rellenarTablero(char pers) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tablero [i][j] = pers;
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        char personaje = '#';
        rellenarTablero(personaje);
    }
}
