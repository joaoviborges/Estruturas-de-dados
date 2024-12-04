package Atividade15;

import java.util.Arrays;

public class QuickSortParaPalavras {
	 // Função para ordenar a lista de palavras usando Quick Sort
    public static void quickSort(String[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Função para particionar o array
    private static int partition(String[] arr, int low, int high) {
        String pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        String temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        String[] words = {"banana", "apple", "orange", "grape", "cherry"};
        System.out.println("Before sorting: " + Arrays.toString(words));
        quickSort(words, 0, words.length - 1);
        System.out.println("After sorting: " + Arrays.toString(words));
    }
}
