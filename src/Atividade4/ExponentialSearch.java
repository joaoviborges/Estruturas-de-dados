package Atividade4;
public class ExponentialSearch {
	public static void main(String[] args) 
	{
		int[] ints = {1, 2, 3, 5, 7, 8, 9, 12, 15, 17, 19, 21, 23, 25, 26, 28, 29, 31, 34, 36, 37, 39};
	    int alvo = 12;
	        
	    int resultado = exponentialSearch(ints, alvo);
		if(resultado == -1) 
		{
			System.out.println("valor não presente na lista");
		}else 
		{
			System.out.println("valor encontrado na posicao " + resultado);
		}
	}
	
	
	private static int exponentialSearch(int[] array, int alvo) {
        int n = array.length;

        // Se o elemento alvo estiver na primeira posição
        if (array[0] == alvo) {
            return 0;
        }

        // Encontra o intervalo onde o alvo pode estar
        int i = 1;
        while (i < n && array[i] <= alvo) {
            i *= 2;
        }

        // Chama busca binária no intervalo encontrado
        return binarySearch(array, i / 2, Math.min(i, n - 1), alvo);
    }

    private static int binarySearch(int[] array, int left, int right, int alvo) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Verifica se o alvo está no meio
            if (array[mid] == alvo) 
            {
                return mid;
            }

            // Se o alvo for menor, ele estará à esquerda
            if (array[mid] > alvo) 
            {
                right = mid - 1;
            } else 
            { 
            	// Caso contrário, estará à direita
                left = mid + 1;
            }
        }


        return -1;
    }
	
}
