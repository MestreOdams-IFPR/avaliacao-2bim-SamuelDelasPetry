import java.util.Scanner;

public class JediBuscaCristals {
    final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int numCasos = 0, local;
        while (true) {
            numCasos++;
            int n = sc.nextInt(), q = sc.nextInt();

            if (n == 0 && q == 0) {
                break;
            }

            int[] cristais = new int[n];

            lerVet(cristais);

            mergeSortRec(cristais, 0, cristais.length - 1);

            int[] consultas = new int[q];

            lerVet(consultas);

            System.out.println("CASE# " + numCasos);
            for (int i = 0; i < consultas.length; i++) {
                local = binSearchRec(cristais, 0, consultas.length, consultas[i]);
                if (local == -1) {
                    System.out.println(consultas[i] + " not found");
                } else System.out.println(consultas[i] + " found at " + local);
                
            }
        }
    }

    public static void lerVet(int[] cristais) {
        for (int i = 0; i < cristais.length; i++) {
            cristais[i] = sc.nextInt();
        }
    }

    public static void mergeSortRec(int[] vet, int inicio, int fim) {
        int meio = 0;
        if (inicio < fim - 1) {
            meio = (inicio + fim) / 2;
            mergeSortRec(vet, inicio, meio);
            mergeSortRec(vet, meio, fim);
            doMerge(vet, inicio, meio, fim);
        }
    }

    public static void doMerge(int[] vet, int inicio, int meio, int fim) {
        int i = inicio, j = meio, k = 0;
        int[] vetAux = new int[fim - inicio];

        while (i < meio && j < fim) {
            if (vet[i] <= vet[j]) {
                vetAux[k++] = vet[i++];
            } else {
                vetAux[k++] = vet[j++];
            }
        }

        while (i < meio) {
            vetAux[k++] = vet[i++];
        }

        while (j < fim) {
            vetAux[k++] = vet[j++];
        }

        for (i = inicio; i < fim; i++) {
            vet[i] = vetAux[i - inicio];
        }
    }

    public static int binSearchRec(int[] vet, int inf, int sup, int n) {
        int meio;
        if (inf <= sup) {
            meio = (inf + sup) / 2;
            return (vet[meio] == n) ? meio
                    : (n < vet[meio]) ? binSearchRec(vet, inf, meio - 1, n)
                            : binSearchRec(vet, meio + 1, sup, n);
        } else
            return -1;
    }

}
