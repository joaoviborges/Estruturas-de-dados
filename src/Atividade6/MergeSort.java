package Atividade6;
public class MergeSort 
{
	public static void main(String[] args) {
		int[] ints = {1, 2, 3, 5, 7, 8, 9, 12, 15, 17, 19, 21, 23, 25, 26, 28, 29, 31, 34, 36, 37, 39};
		int alvo = 12;
	    
		for(int i=0; i<= ints.length-1; i++) 
		{
			System.out.println(ints[i]);
		}
		
	}
	
	
	 public static void mergeSort(int[] array, int left, int right) {
	        if (left < right) {
	            // Calcula o ponto médio do array
	            int mid = left + (right - left) / 2;

	            // Ordena a metade esquerda
	            mergeSort(array, left, mid);

	            // Ordena a metade direita
	            mergeSort(array, mid + 1, right);

	            // Mescla as duas metades ordenadas
	            merge(array, left, mid, right);
	        }
	    }

	    // Método para mesclar duas partes ordenadas do array
	    public static void merge(int[] array, int left, int mid, int right) {
	        // Tamanhos das duas sublistas
	        int n1 = mid - left + 1;
	        int n2 = right - mid;

	        // Arrays temporários para as sublistas
	        int[] leftArray = new int[n1];
	        int[] rightArray = new int[n2];

	        // Copia os dados para os arrays temporários
	        for (int i = 0; i < n1; i++) {
	            leftArray[i] = array[left + i];
	        }
	        for (int j = 0; j < n2; j++) {
	            rightArray[j] = array[mid + 1 + j];
	        }

	        // Índices iniciais das sublistas e do array principal
	        int i = 0, j = 0, k = left;

	        // Mescla as sublistas de volta ao array principal
	        while (i < n1 && j < n2) {
	            if (leftArray[i] <= rightArray[j]) {
	                array[k] = leftArray[i];
	                i++;
	            } else {
	                array[k] = rightArray[j];
	                j++;
	            }
	            k++;
	        }

	        // Copia os elementos restantes da sublista esquerda, se houver
	        while (i < n1) {
	            array[k] = leftArray[i];
	            i++;
	            k++;
	        }

	        // Copia os elementos restantes da sublista direita, se houver
	        while (j < n2) {
	            array[k] = rightArray[j];
	            j++;
	            k++;
	        }
	    }
}
