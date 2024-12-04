package Atividade11;
public class TernarySort 
{
	 public static void main(String[] args) {
	        int[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
	        int alvo = 11;

	        int resultado = ternarySearch(array, 0, array.length - 1, alvo);

	        if (resultado == -1) {
	            System.out.println("Valor não encontrado no array.");
	        } else {
	            System.out.println("Valor encontrado na posição: " + resultado);
	        }
	    }

	    public static int ternarySearch(int[] array, int left, int right, int alvo) {
	        if (left <= right) {
	            // Divide o intervalo em 3 partes
	            int mid1 = left + (right - left) / 3;
	            int mid2 = right - (right - left) / 3;

	            // Verifica se o alvo está em mid1 ou mid2
	            if (array[mid1] == alvo) {
	                return mid1;
	            }
	            if (array[mid2] == alvo) {
	                return mid2;
	            }

	            // Decide qual intervalo explorar
	            if (alvo < array[mid1]) {
	                return ternarySearch(array, left, mid1 - 1, alvo);
	            } else if (alvo > array[mid2]) {
	                return ternarySearch(array, mid2 + 1, right, alvo);
	            } else {
	                return ternarySearch(array, mid1 + 1, mid2 - 1, alvo);
	            }
	        }

	        // Retorna -1 se o elemento não for encontrado
	        return -1;
	    }
}
