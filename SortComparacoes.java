public class SortComparacoes {

    public static class SortStats {
        public int cmp = 0;
        public int mov = 0;
    }

    public static class Resultado {
        public String nome;
        public int cmp;
        public int mov;

        public Resultado(String nome, int cmp, int mov) {
            this.nome = nome;
            this.cmp = cmp;
            this.mov = mov;
        }
    }

    // ------------------- Função auxiliar para obter tamanho do vetor -------------------
    public static int size(int[] arr) {
        int i = 0;
        try {
            while (true) {
                int tmp = arr[i];
                i++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return i;
        }
    }

    // ------------------- Função para copiar vetor -------------------
    public static int[] copy(int[] arr) {
        int n = size(arr);
        int[] copia = new int[n];
        for (int i = 0; i < n; i++) {
            copia[i] = arr[i];
        }
        return copia;
    }

    // ------------------- Funções auxiliares para bucketSort -------------------
    private static int min(int[] arr) {
        int n = size(arr);
        int minimo = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < minimo) minimo = arr[i];
        }
        return minimo;
    }

    private static int max(int[] arr) {
        int n = size(arr);
        int maximo = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > maximo) maximo = arr[i];
        }
        return maximo;
    }

    private static int sqrtInt(int n) {
        int i = 1;
        while (i * i <= n) i++;
        return i - 1;
    }

    // ------------------- Comb Sort -------------------
    public static SortStats combSort(int[] A) {
        int n = size(A);
        int gap = n;
        boolean sorted = false;
        SortStats stats = new SortStats();

        while (!sorted) {
            gap = gap * 10 / 13;
            if (gap <= 1) {
                gap = 1;
                sorted = true;
            }
            for (int i = 0; i + gap < n; i++) {
                stats.cmp++;
                if (A[i] > A[i + gap]) {
                    int aux = A[i + gap];
                    A[i + gap] = A[i];
                    A[i] = aux;
                    stats.mov += 3;
                    sorted = false;
                }
            }
        }
        return stats;
    }

    // ------------------- Gnome Sort -------------------
    public static SortStats gnomeSort(int[] A) {
        int n = size(A);
        int i = 0;
        SortStats stats = new SortStats();

        while (i < n) {
            if (i == 0) i++;
            else {
                stats.cmp++;
                if (A[i - 1] <= A[i]) i++;
                else {
                    int tmp = A[i];
                    A[i] = A[i - 1];
                    A[i - 1] = tmp;
                    stats.mov += 3;
                    i--;
                }
            }
        }
        return stats;
    }

    // ------------------- Bucket Sort -------------------
    public static SortStats bucketSort(int[] arr) {
        int n = size(arr);
        SortStats stats = new SortStats();

        int M = sqrtInt(n) + 1;
        int min = min(arr);
        int max = max(arr);
        int div = (max - min) / M + 1;

        int[][] buckets = new int[M][n];
        int[] bucketSizes = new int[M];

        for (int i = 0; i < n; i++) {
            int x = arr[i];
            int idx = (x - min) / div;
            if (idx >= M) idx = M - 1;
            buckets[idx][bucketSizes[idx]] = x;
            bucketSizes[idx]++;
            stats.mov++;
        }

        int index = 0;
        for (int i = 0; i < M; i++) {
            int bi = bucketSizes[i];
            for (int j = 1; j < bi; j++) {
                int key = buckets[i][j];
                int k = j - 1;
                while (k >= 0) {
                    stats.cmp++;
                    if (buckets[i][k] > key) {
                        buckets[i][k + 1] = buckets[i][k];
                        stats.mov++;
                        k--;
                    } else break;
                }
                buckets[i][k + 1] = key;
                stats.mov++;
            }
            for (int j = 0; j < bi; j++) {
                arr[index++] = buckets[i][j];
                stats.mov++;
            }
        }
        return stats;
    }

    // ------------------- Bubble Sort com flag -------------------
    public static SortStats bubbleSortFlag(int[] arr) {
        int n = size(arr);
        boolean trocou;
        SortStats stats = new SortStats();

        for (int i = 0; i < n - 1; i++) {
            trocou = false;
            for (int j = 0; j < n - i - 1; j++) {
                stats.cmp++;
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    stats.mov += 3;
                    trocou = true;
                }
            }
            if (!trocou) break;
        }
        return stats;
    }

    // ------------------- Selection Sort -------------------
    public static SortStats selectionSort(int[] arr) {
        int n = size(arr);
        SortStats stats = new SortStats();

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                stats.cmp++;
                if (arr[j] < arr[minIdx]) minIdx = j;
            }
            if (minIdx != i) {
                int tmp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = tmp;
                stats.mov += 3;
            }
        }
        return stats;
    }

    // ------------------- Cocktail Sort -------------------
    public static SortStats cocktailSort(int[] arr) {
        int n = size(arr);
        boolean swapped = true;
        int start = 0, end = n - 1;
        SortStats stats = new SortStats();

        while (swapped) {
            swapped = false;

            for (int i = start; i < end; i++) {
                stats.cmp++;
                if (arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    stats.mov += 3;
                    swapped = true;
                }
            }

            if (!swapped) break;
            swapped = false;
            end--;

            for (int i = end - 1; i >= start; i--) {
                stats.cmp++;
                if (arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    stats.mov += 3;
                    swapped = true;
                }
            }
            start++;
        }
        return stats;
    }
}