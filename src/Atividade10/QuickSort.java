package Atividade10;
import java.util.Arrays;

public class QuickSort 
{
	public static void main(String[] args) {
        int[] array = {10, 7, 8, 9, 1, 5};

        System.out.println("Array original:");
        System.out.println(Arrays.toString(array));

        // Aplica Quick Sort
        quickSort(array, 0, array.length - 1);

        System.out.println("Array ordenado:");
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Encontra o índice da partição
            int pi = partition(array, low, high);

            // Ordena as partições à esquerda e à direita do pivô
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        // Escolhe o último elemento como pivô
        int pivot = array[high];
        int i = low - 1; // Índice do menor elemento

        for (int j = low; j < high; j++) {
            // Se o elemento atual é menor ou igual ao pivô
            if (array[j] <= pivot) {
                i++;
                // Troca array[i] e array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Troca o pivô para sua posição correta
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1; // Retorna o índice do pivô
    }
}
