package Atividade15;

public class BinarySearchParaPalavra 
{
	// Função para realizar Binary Search em uma lista ordenada
    public static boolean binarySearch(String[] arr, String target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = arr[mid].compareTo(target);
            if (comparison == 0) {
                return true; // Palavra encontrada
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false; // Palavra não encontrada
    }

    public static void main(String[] args) {
        String[] words = {"apple", "banana", "cherry", "grape", "orange"};
        
        String target = "banana";
        boolean isPresent = binarySearch(words, target);

        if (isPresent) {
            System.out.println("A palavra \"" + target + "\" está presente na lista.");
        } else {
            System.out.println("A palavra \"" + target + "\" não foi encontrada.");
        }
    }
}
