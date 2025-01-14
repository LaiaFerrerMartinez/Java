import java.util.Scanner;

public class ConjugarVerbos {
    public static void main(String[] args) {
        int i = -1;
        for (int cont = 0; cont < 6; cont++) {
            String[] personas = {"yo ", "tu ", "el ", "nosotros ", "vosotros ", "ellos "};
            int MAX_PERSONAS = 6;
            String[][] ar = {
                    {"o", "as", "a", "amos", "ais", "an"},
                    {"e", "aste", "o", "amos", "asteis", "aron"},
                    {"are", "ara", "aremos", "areis", "aran"}
            };
            String[][] er = {
                    {"o", "es", "e", "emos", "eis", "en"},
                    {"i", "iste", "io", "imos", "isteis", "ieron"},
                    {"ere", "eras", "era", "eremos", "ereis", "eran"}
            };
            String[][] ir = {
                    {"o", "es", "e", "imos", "is", "en"},
                    {"i", "iste", "io", "imos", "isteis", "ieron"},
                    {"ire", "iras", "ira", "iremos", "ireis", "iran"}
            };
            Scanner lector = new Scanner(System.in);
            String verbo = lector.nextLine();
            String tiempo = lector.nextLine();
            switch (tiempo) {
                case "A":
                    i = 0;
                    break;
                case "P":
                    i = 1;
                    break;
                case "F":
                    i = 2;
                    break;
                case "T":
                    cont = 6;
            }
            if (cont != 6) {
                String terminacion;
                String raiz = verbo.substring(0, (verbo.length() - 2));
                if (verbo.endsWith("ar")) {
                    for (int j = 0; j < MAX_PERSONAS; j++) {
                        System.out.println(personas[j] + raiz + ar[i][j]);
                    }
                } else if (verbo.endsWith("er")) {
                    for (int j = 0; j < MAX_PERSONAS; j++) {
                        System.out.println(personas[j] + raiz + er[i][j]);
                    }
                } else if (verbo.endsWith("ir")) {
                    for (int j = 0; j < MAX_PERSONAS; j++) {
                        System.out.println(personas[j] + raiz + ir[i][j]);
                    }
                }
            }
            if (cont == 5) cont = 0;
        }
    }
}