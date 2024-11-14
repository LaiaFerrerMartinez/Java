import java.util.Scanner;

public class TelefonoDeMeucci {

    public static void main(String[] args) {
        String[] simbolo = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        Scanner sc = new Scanner(System.in);
        while (true) {
            String prueba = sc.nextLine();
            if (prueba.isEmpty()) continue;

            // Número de formas de interpretar el número
            int[] formas = new int[prueba.length() + 1];
            formas[0] = 1;  // Hay una forma de interpretar una cadena vacía

            for (int i = 0; i < prueba.length(); i++) {
                // Comprobar todas las subcadenas
                for (String num : simbolo) {
                    if (i + num.length() <= prueba.length() && prueba.startsWith(num, i)) {
                        formas[i + num.length()] += formas[i];
                    }
                }
            }
            int resultado = formas[prueba.length()];
            System.out.println(resultado);
        }
    }
}