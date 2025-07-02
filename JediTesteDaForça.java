import java.util.ArrayList;
import java.util.Scanner;

public class JediTesteDaForça {
    final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Integer> notas = new ArrayList<>();

        while (sc.hasNext()) {
            int n = sc.nextInt(), k = sc.nextInt();

            lerNotas(notas, n);

            mergeSortRec(notas, 0, notas.size());

            System.out.println(somatorioNotas(notas, k));

            notas.clear();
        }

    }

    public static void lerNotas(ArrayList<Integer> notas, int n) {
        for (int i = 0; i < n; i++) {
            notas.add(sc.nextInt());
        }
    }

    public static int somatorioNotas(ArrayList<Integer> notas, int k) {
        int soma = 0;
        for (int i = 0; i < k; i++) {
            soma += notas.get((notas.size() - 1) - i);
        }
        return soma;
    }

    public static void mergeSortRec(ArrayList<Integer> notas, int inicio, int fim) {
        int meio = 0;
        if (inicio < fim - 1) {
            meio = (inicio + fim) / 2;
            mergeSortRec(notas, inicio, meio);
            mergeSortRec(notas, meio, fim);
            doMerge(notas, inicio, meio, fim);
        }
    }

    public static void doMerge(ArrayList<Integer> notas, int inicio, int meio, int fim) {
        int i = inicio, j = meio, k = 0;
        int[] vetAux = new int[fim - inicio];

        while (i < meio && j < fim) {
            if (notas.get(i) <= notas.get(j)) {
                vetAux[k++] = notas.get(i++);
            } else {
                vetAux[k++] = notas.get(j++);
            }
        }

        while (i < meio) {
            vetAux[k++] = notas.get(i++);
        }

        while (j < fim) {
            vetAux[k++] = notas.get(j++);
        }

        for (i = inicio; i < fim; i++) {
            notas.set(i, vetAux[i - inicio]);
        }
    }
}
