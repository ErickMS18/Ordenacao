import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        int[] vetor1 = {12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28};
        int[] vetor2 = {5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32};
        int[] vetor3 = {99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6};

        int[][] vetores = {vetor1, vetor2, vetor3};
        String[] nomes = {"Vetor1", "Vetor2", "Vetor3"};

        String[] algoritmos = {"Comb Sort", "Gnome Sort", "Bucket Sort", "Bubble Sort c/ Flag", "Selection Sort", "Cocktail Sort"};

        for (int v = 0; v < vetores.length; v++) {
            System.out.println("===== " + nomes[v] + " =====");
            SortComparacoes.Resultado[] resultados = new SortComparacoes.Resultado[algoritmos.length];

            for (int i = 0; i < algoritmos.length; i++) {
                int[] copia = SortComparacoes.copy(vetores[v]);
                SortComparacoes.SortStats stats = null;

                switch (algoritmos[i]) {
                    case "Comb Sort": stats = SortComparacoes.combSort(copia); break;
                    case "Gnome Sort": stats = SortComparacoes.gnomeSort(copia); break;
                    case "Bucket Sort": stats = SortComparacoes.bucketSort(copia); break;
                    case "Bubble Sort c/ Flag": stats = SortComparacoes.bubbleSortFlag(copia); break;
                    case "Selection Sort": stats = SortComparacoes.selectionSort(copia); break;
                    case "Cocktail Sort": stats = SortComparacoes.cocktailSort(copia); break;
                }

                resultados[i] = new SortComparacoes.Resultado(algoritmos[i], stats.cmp, stats.mov);
                System.out.printf("%-20s -> Comparações: %3d, Movimentos: %3d\n", algoritmos[i], stats.cmp, stats.mov);
            }

            // Ranking por movimentos
            for (int i = 0; i < resultados.length - 1; i++) {
                for (int j = i + 1; j < resultados.length; j++) {
                    if (resultados[i].mov > resultados[j].mov) {
                        SortComparacoes.Resultado tmp = resultados[i];
                        resultados[i] = resultados[j];
                        resultados[j] = tmp;
                    }
                }
            }
            System.out.println("\nRanking por movimentos:");
            for (int i = 0; i < resultados.length; i++)
                System.out.printf("%d. %-20s -> Movimentos: %3d\n", i + 1, resultados[i].nome, resultados[i].mov);

            // Ranking por comparações
            for (int i = 0; i < resultados.length - 1; i++) {
                for (int j = i + 1; j < resultados.length; j++) {
                    if (resultados[i].cmp > resultados[j].cmp) {
                        SortComparacoes.Resultado tmp = resultados[i];
                        resultados[i] = resultados[j];
                        resultados[j] = tmp;
                    }
                }
            }
            System.out.println("\nRanking por comparações:");
            for (int i = 0; i < resultados.length; i++)
                System.out.printf("%d. %-20s -> Comparações: %3d\n", i + 1, resultados[i].nome, resultados[i].cmp);

            System.out.println();
        }
    }
}
