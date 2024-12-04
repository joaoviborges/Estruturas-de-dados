package Atividade8;
import java.util.ArrayList;
import java.util.Collections;

public class BucketSort 
{
	public static void main(String[] args) {
        float[] array = {0.78f, 0.17f, 0.39f, 0.26f, 0.72f, 0.94f, 0.21f, 0.12f, 0.23f, 0.68f};

        System.out.println("Array original:");
        for (float num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Ordena o array usando Bucket Sort
        bucketSort(array);

        System.out.println("Array ordenado:");
        for (float num : array) {
            System.out.print(num + " ");
        }
    }

    public static void bucketSort(float[] array) {
        int n = array.length;

        // Cria n buckets vazios
        ArrayList<Float>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Distribui os elementos nos buckets com base em seu valor
        for (float num : array) {
            int bucketIndex = (int) (num * n); // Calcula o índice do bucket
            buckets[bucketIndex].add(num);
        }

        // Ordena os elementos em cada bucket
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        // Junta os buckets em um array
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (float num : buckets[i]) {
                array[index++] = num;
            }
        }
    }
}
