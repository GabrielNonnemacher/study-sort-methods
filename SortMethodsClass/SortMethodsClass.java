import java.util.Random;

public class SortMethodsClass {

    public static void main(String[] args) {
        int[] vetorA = new int[50000];
        int[] vetorB = new int[100000];
        int[] vetorC = new int[150000];
        int[] vetorD = new int[200000];

        montar(vetorA);
        montar(vetorB);
        montar(vetorC);
        montar(vetorD);

        // BubbleSort
        long tb0, tb1, tb2, tb3, tb4;
        tb0 = System.nanoTime();
        bubbleSort(vetorA);
        tb1 = System.nanoTime();
        bubbleSort(vetorB);
        tb2 = System.nanoTime();
        bubbleSort(vetorC);
        tb3 = System.nanoTime();
        bubbleSort(vetorD);
        tb4 = System.nanoTime();

        // SelectionSort
        long ts0, ts1, ts2, ts3, ts4;
        ts0 = System.nanoTime();
        selectionSort(vetorA);
        ts1 = System.nanoTime();
        selectionSort(vetorB);
        ts2 = System.nanoTime();
        selectionSort(vetorC);
        ts3 = System.nanoTime();
        selectionSort(vetorD);
        ts4 = System.nanoTime();

        // InsertionSort
        long ti0, ti1, ti2, ti3, ti4;
        ti0 = System.nanoTime();
        insertionSort(vetorA);
        ti1 = System.nanoTime();
        insertionSort(vetorB);
        ti2 = System.nanoTime();
        insertionSort(vetorC);
        ti3 = System.nanoTime();
        insertionSort(vetorD);
        ti4 = System.nanoTime();

        System.out.println("Pontos do método BubbleSort: " + (tb1 - tb0) + ", " + (tb2 - tb0) + ", " + (tb3 - tb0) + ", " + (tb4 - tb0));
        System.out.println("Pontos do método SelectionSort: " + (ts1 - ts0) + ", " + (ts2 - ts0) + ", " + (ts3 - ts0) + ", " + (ts4 - ts0));
        System.out.println("Pontos do método InsertionSort: " + (ti1 - ti0) + ", " + (ti2 - ti0) + ", " + (ti3 - ti0) + ", " + (ti4 - ti0));
    }

    public static void montar(int[] vetor) {
        Random aleatorio = new Random();
        aleatorio.setSeed(0);
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = aleatorio.nextInt(300000);
        }
    }

    public static void bubbleSort(int[] vetor) {
        int i, j, aux;

        for (i = 1; i < vetor.length; i++) {
            for (j = 0; j < vetor.length - i; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                }
            }
        }
    }

    public static void selectionSort(int[] vetor) {
        int i, j, menor, aux;

        for (i = 0; i < vetor.length; i++) {
            menor = i;
            for (j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[menor]) {
                    menor = j;
                }
            }
            aux = vetor[menor];
            vetor[menor] = vetor[i];
            vetor[i] = aux;
        }
    }

    public static void insertionSort(int[] vetor) {
        int n = vetor.length;

        for (int i = 1; i < n; i++) {
            int key = vetor[i];
            int j = i - 1;

            while (j >= 0 && vetor[j] > key) {
                vetor[j + 1] = vetor[j];
                j = j - 1;
            }
            vetor[j + 1] = key;
        }
    }
}