package Atividade5;
public class ShellSort 
{
	public static void main(String[] args) {
		int[] ints = {1, 2, 3, 5, 7, 8, 9, 12, 15, 17, 19, 21, 23, 25, 26, 28, 29, 31, 34, 36, 37, 39};
		int alvo = 12;
	    
		shellSort(ints);
		
		for(int i=0; i<= ints.length-1; i++) 
		{
			System.out.println(ints[i]);
		}
		
	    
	}
	
	 private static void shellSort(int[] array) {
	        int n = array.length;

	        // Inicia com o maior intervalo
	        for (int gap = n / 2; gap > 0; gap /= 2) {
	            // Executa inserção direta para cada gap
	            for (int i = gap; i < n; i++) {
	                int temp = array[i];
	                int j;
	                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
	                    array[j] = array[j - gap];
	                }
	                array[j] = temp;
	            }
	        }
	    }

	    // Implementação da busca binária
	    private static int binarySearch(int[] array, int alvo) {
	        int left = 0, right = array.length - 1;

	        while (left <= right) {
	            int mid = left + (right - left) / 2;

	            // Verifica se o alvo está no meio
	            if (array[mid] == alvo) {
	                return mid;
	            }

	            // Se o alvo é menor, ele está à esquerda
	            if (array[mid] > alvo) {
	                right = mid - 1;
	            } else { // Caso contrário, está à direita
	                left = mid + 1;
	            }
	        }

	        // Retorna -1 se o elemento não for encontrado
	        return -1;
	    }


}