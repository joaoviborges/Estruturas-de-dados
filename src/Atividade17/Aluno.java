package Atividade17;
import java.util.ArrayList;
import java.util.Arrays;

class Aluno {
    String nome;
    int nota;

    public Aluno(String nome, int nota) {
        this.nome = nome;
        this.nota = nota;
    }

    @Override
    public String toString() {
        return nome + ": " + nota;
    }
}

public class OrdenacaoBusca {

    // Função para realizar o Bucket Sort
    public static void bucketSort(Aluno[] alunos) {
        // Encontrando a maior e a menor nota
        int minNota = 0;
        int maxNota = 100;

        // Criando baldes
        int bucketCount = maxNota - minNota + 1;
        ArrayList<Aluno>[] buckets = new ArrayList[bucketCount];

        // Inicializando os baldes
        for (int i = 0; i < bucketCount; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Distribuindo os alunos nos baldes
        for (Aluno aluno : alunos) {
            int bucketIndex = aluno.nota - minNota;
            buckets[bucketIndex].add(aluno);
        }

        // Ordenando os alunos dentro de cada balde (usaremos o método de ordenação por inserção)
        int index = 0;
        for (ArrayList<Aluno> bucket : buckets) {
            bucket.sort((a, b) -> Integer.compare(a.nota, b.nota));  // Ordenação pelo critério da nota
            for (Aluno aluno : bucket) {
                alunos[index++] = aluno;
            }
        }
    }

    // Função para realizar a Interpolation Search
    public static Aluno interpolationSearch(Aluno[] alunos, int notaBuscada) {
        int low = 0;
        int high = alunos.length - 1;

        while (low <= high && notaBuscada >= alunos[low].nota && notaBuscada <= alunos[high].nota) {
            if (low == high) {
                if (alunos[low].nota == notaBuscada) {
                    return alunos[low];  // Encontrado o aluno com a nota buscada
                }
                break;
            }

            // Cálculo da posição de interpolação
            int pos = low + ((notaBuscada - alunos[low].nota) * (high - low)) / (alunos[high].nota - alunos[low].nota);

            // Verificando se a posição calculada é válida
            if (pos < low || pos > high) {
                break;
            }

            // Comparando a nota na posição calculada
            if (alunos[pos].nota == notaBuscada) {
                return alunos[pos];  // Encontrado o aluno
            } else if (alunos[pos].nota < notaBuscada) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }

        return null;  // Nota não encontrada
    }

    public static void main(String[] args) {
        // Lista de alunos com nomes e notas
        Aluno[] alunos = {
            new Aluno("João", 75),
            new Aluno("Maria", 90),
            new Aluno("Pedro", 50),
            new Aluno("Ana", 85),
            new Aluno("Carlos", 65),
            new Aluno("Juliana", 95),
            new Aluno("Felipe", 80),
            new Aluno("Lucas", 70)
        };

        // Exibindo antes da ordenação
        System.out.println("Antes da ordenação:");
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }

        // Ordenando os alunos usando o Bucket Sort
        bucketSort(alunos);

        // Exibindo após a ordenação
        System.out.println("\nApós a ordenação:");
        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }

        // Procurando um aluno pela nota usando o Interpolation Search
        int notaBuscada = 85;
        Aluno alunoEncontrado = interpolationSearch(alunos, notaBuscada);

        if (alunoEncontrado != null) {
            System.out.println("\nAluno encontrado: " + alunoEncontrado);
        } else {
            System.out.println("\nAluno com a nota " + notaBuscada + " não encontrado.");
        }
    }
}