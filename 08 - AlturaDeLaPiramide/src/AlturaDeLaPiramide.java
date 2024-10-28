import java.util.Scanner;

public class AlturaDeLaPiramide {
    private static final int MAX_BLOQUES = 2000000000;
    private static void proceso () {
        Scanner lector = new Scanner(System.in);
        int bloques;
        int lado;
        int num;
        int altura;
        lado = 3;
        num = 1;
        altura = 1;
        do {
            System.out.println("Dime el número de bloques.");
            bloques = lector.nextInt();
        } while (bloques > MAX_BLOQUES);
        if (bloques > 0) {
            if (bloques > 1) {
                while (num + (lado * lado) - (lado-2)*(lado-2)<= bloques) {
                    altura++;
                    num += (lado * lado);
                    lado += 2;
                }
            }
            System.out.println(altura);
        }
    }
    private static void jugar () {
        System.out.println("Dame el número de casos que quieres procesar.");
        Scanner lector = new Scanner(System.in);
        int casos = lector.nextInt();
        for (int i = 0; i < casos; i++) {
            proceso ();
        }
    }

    public static void main(String[] args) {
        jugar();
    }
}