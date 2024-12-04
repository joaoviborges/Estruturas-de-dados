package Atividade9;
import java.util.Arrays;

public class RadixSort 
{
	 public static void main(String[] args) {
	        int[] array = {170, 45, 75, 90, 802, 24, 2, 66};

	        System.out.println("Array original:");
	        System.out.println(Arrays.toString(array));

	        // Ordena o array usando Radix Sort
	        radixSort(array);

	        System.out.println("Array ordenado:");
	        System.out.println(Arrays.toString(array));
	    }

	    public static void radixSort(int[] array) {
	        // Encontra o maior número no array para saber o número de dígitos
	        int max = getMax(array);

	        // Realiza o Counting Sort para cada dígito (1, 10, 100, ...)
	        for (int exp = 1; max / exp > 0; exp *= 10) {
	            countingSortByDigit(array, exp);
	        }
	    }

	    private static void countingSortByDigit(int[] array, int exp) {
	        int n = array.length;
	        int[] output = new int[n]; // Array para armazenar o resultado ordenado
	        int[] count = new int[10]; // Contador para os dígitos (0-9)

	        // Conta a ocorrência de cada dígito no dígito atual
	        for (int i = 0; i < n; i++) {
	            int digit = (array[i] / exp) % 10;
	            count[digit]++;
	        }

	        // Modifica count[] para que ele contenha as posições corretas no output[]
	        for (int i = 1; i < 10; i++) {
	            count[i] += count[i - 1];
	        }

	        // Constrói o array de saída
	        for (int i = n - 1; i >= 0; i--) {
	            int digit = (array[i] / exp) % 10;
	            output[count[digit] - 1] = array[i];
	            count[digit]--;
	        }

	        // Copia o array de saída para o array original
	        for (int i = 0; i < n; i++) {
	            array[i] = output[i];
	        }
	    }

	    private static int getMax(int[] array) {
	        int max = array[0];
	        for (int num : array) {
	            if (num > max) {
	                max = num;
	            }
	        }
	        return max;
	    }
}
