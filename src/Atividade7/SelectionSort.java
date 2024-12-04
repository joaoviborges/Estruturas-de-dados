package Atividade7;
public class SelectionSort 
{
	public static void main(String[] args) {
		int[] ints = {3, 1, 4, 6, 7, 9, 8, 12, 22, 17, 19, 21, 23, 31, 26, 28, 29, 30, 34, 36, 37, 39};
		int alvo = 12;
	    
		selectionSort(ints);
		
		for(int i=0; i<= ints.length-1; i++) 
		{
			System.out.println(ints[i]);
		}
		
	}
	
	 private static void selectionSort(int[] array) {
	        int n = array.length;

	        // Passa por cada elemento do array
	        for (int i = 0; i < n - 1; i++) {
	            // Encontra o índice do menor elemento na parte não ordenada
	            int minIndex = i;
	            for (int j = i + 1; j < n; j++) {
	                if (array[j] < array[minIndex]) {
	                    minIndex = j;
	                }
	            }

	            // Troca o menor elemento com o primeiro elemento da parte não ordenada
	            int temp = array[minIndex];
	            array[minIndex] = array[i];
	            array[i] = temp;
	        }
	    }
	
}
