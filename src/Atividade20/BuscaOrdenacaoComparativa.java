package Atividade20;
import java.util.*;

public class BuscaOrdenacaoComparativa {

    // Métodos de ordenação
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Métodos de busca
    public static boolean linearSearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    // Menu interativo
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o tamanho da lista:");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(100); // Gerando números aleatórios entre 0 e 100
        }

        System.out.println("Lista original:");
        System.out.println(Arrays.toString(arr));

        System.out.println("\nEscolha um método de ordenação:");
        System.out.println("1 - Bubble Sort");
        System.out.println("2 - Quick Sort");
        int choiceSort = scanner.nextInt();

        long startSort = System.nanoTime();
        if (choiceSort == 1) {
            bubbleSort(arr);
        } else if (choiceSort == 2) {
            quickSort(arr, 0, arr.length - 1);
        }
        long endSort = System.nanoTime();

        System.out.println("\nLista ordenada:");
        System.out.println(Arrays.toString(arr));
        System.out.println("Tempo de ordenação: " + (endSort - startSort) + " nanosegundos");

        System.out.println("\nEscolha um método de busca:");
        System.out.println("1 - Busca Linear");
        System.out.println("2 - Busca Binária");
        int choiceSearch = scanner.nextInt();

        System.out.println("Digite o número que deseja buscar:");
        int target = scanner.nextInt();

        long startSearch = System.nanoTime();
        boolean found = false;
        if (choiceSearch == 1) {
            found = linearSearch(arr, target);
        } else if (choiceSearch == 2) {
            found = binarySearch(arr, target);
        }
        long endSearch = System.nanoTime();

        if (found) {
            System.out.println("Número encontrado!");
        } else {
            System.out.println("Número não encontrado!");
        }

        System.out.println("Tempo de busca: " + (endSearch - startSearch) + " nanosegundos");

        scanner.close();
    }
}
