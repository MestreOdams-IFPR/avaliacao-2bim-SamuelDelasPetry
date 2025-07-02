import java.util.Scanner;

public class fraseCompleta {
    final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String frase = sc.nextLine();
            System.out.println(calcularTipo(frase));
        }
    }

    public static String calcularTipo(String frase) {
        int qtdLetras = 0;
        char[] alfabeto = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        for (int i = 0; i < frase.length(); i++) {
            frequencia(alfabeto, frase.charAt(i), qtdLetras);
        }
        if (qtdLetras == 26) {
            return "frase completa";
        }
        if (qtdLetras > 13) {
            return "frase quase completa";
        } else
            return "frase mal elaborada";
    }

    public static void frequencia(char[] alfabeto, char letra, int qtdLetras) {
        for (int i = 0; i < alfabeto.length; i++) {
            if (alfabeto[i] == letra) {
                alfabeto[i] = '#';
                qtdLetras++;
            }
        }
    }
}
