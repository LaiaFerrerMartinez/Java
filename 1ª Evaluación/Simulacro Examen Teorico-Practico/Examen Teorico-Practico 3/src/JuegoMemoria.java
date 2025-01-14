import java.util.Scanner;

public class JuegoMemoria {

    // Lista de palabras a memorizar
    private static String[] palabras = {"sol", "luna", "estrella", "cielo", "mar", "montaña", "río", "nube", "flor", "árbol"};

    private static String[] respuestas = new String[10];

    private static boolean incorrecto;

    private static void pedirPalabras () {
        Scanner scanner = new Scanner(System.in);

        // Mostrar palabras y pedir al usuario que repita las anteriores en orden
        for (int i = 0; i < palabras.length; i++) {
            incorrecto = false;
            System.out.println("Palabra a memorizar: " + palabras[i]);
            respuestas[i] = palabras[i];

            System.out.print("Escribe todas las palabras memorizadas hasta ahora: ");
            String entrada = scanner.nextLine();
            verificarRespuesta(entrada, i);
            if (incorrecto) i = -1;
        }
        System.out.println("¡Felicidades! Has memorizado todas las palabras correctamente.");
        scanner.close();
    }

    private static void verificarRespuesta (String entrada, int i) {
        // Verificar si la respuesta es correcta
        StringBuilder correctas = new StringBuilder(); // El StringBuilder puede ser modificado sin crear otra instancia
        for (int j = 0; j <= i; j++) {
            correctas.append(respuestas[j]).append(" ");
        }

        if (!entrada.equals(correctas.toString().trim())) {
            System.out.println("¡Incorrecto! La secuencia era: " + correctas.toString().trim());
            System.out.println("Intenta de nuevo desde el inicio.");
            incorrecto = true;
        } else {
            System.out.println("¡Correcto! Sigue a la siguiente palabra.\n");
        }
    }

    public static void main(String[] args) {
        pedirPalabras();
    }
}
