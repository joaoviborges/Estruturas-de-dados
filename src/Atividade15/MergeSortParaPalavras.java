package Atividade15;

import java.util.Arrays;

public class MergeSortParaPalavras 
{
	 // Função para ordenar a lista de palavras usando Merge Sort
    public static void mergeSort(String[] arr) {
        if (arr.length < 2) {
            return;
        }

        int mid = arr.length / 2;
        String[] left = Arrays.copyOfRange(arr, 0, mid);
        String[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }

    // Função auxiliar para mesclar dois arrays ordenados
    private static void merge(String[] arr, String[] left, String[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        String[] words = {"banana", "apple", "orange", "grape", "cherry"};
        System.out.println("Before sorting: " + Arrays.toString(words));
        mergeSort(words);
        System.out.println("After sorting: " + Arrays.toString(words));
    }
}
