package Atividade16;
import java.util.Arrays;

public class Livro 
{
	String ISBN;
    String titulo;

    // Construtor
    public Livro(String ISBN, String titulo) {
        this.ISBN = ISBN;
        this.titulo = titulo;
    }

    // Método para comparar os livros com base no ISBN
    public int compareTo(Livro outroLivro) {
        return this.ISBN.compareTo(outroLivro.ISBN);
    }

    @Override
    public String toString() {
        return "ISBN: " + ISBN + ", Título: " + titulo;
    }
}

public class Biblioteca {

    // Função para realizar Binary Search em uma lista de livros ordenada por ISBN
    public static boolean binarySearch(Livro[] livros, String targetISBN) {
        int low = 0;
        int high = livros.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = livros[mid].ISBN.compareTo(targetISBN);

            if (comparison == 0) {
                System.out.println("Livro encontrado: " + livros[mid]);
                return true; // Livro encontrado
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Livro não encontrado.");
        return false; // Livro não encontrado
    }

    public static void main(String[] args) {
        // Criando uma lista de livros ordenada por ISBN
        Livro[] livros = {
            new Livro("978-3-16-148410-0", "Java Programming"),
            new Livro("978-0-13-468599-1", "Effective Java"),
            new Livro("978-1-61-729223-3", "Clean Code"),
            new Livro("978-0-262-03384-8", "Introduction to Algorithms")
        };

        // Ordenando os livros por ISBN
        Arrays.sort(livros, (livro1, livro2) -> livro1.ISBN.compareTo(livro2.ISBN));

        // ISBN a ser procurado
        String targetISBN = "978-0-13-468599-1";

        // Realizando a busca binária
        binarySearch(livros, targetISBN);
    }
}
