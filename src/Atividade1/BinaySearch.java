package Atividade1;

public class BinaySearch 
{
	
	public static void main(String[] args) 
	{
		int[] ints = {1, 2, 3, 5, 7, 8, 9, 12, 15, 17, 19, 21, 23, 25, 26, 28, 29, 31, 34, 36, 37, 39};
		
		System.out.println(binaySearch(ints, 5));
	}
	
	private static int binaySearch(int[] quantidadeDeNumeros, int numeroQueDeveSerEncontrado) 
	{
		int menor = 0;
		int maior = quantidadeDeNumeros.length - 1;
		
		while(menor <= maior) 
		{
			int posicaoDoMeio = (menor + maior) / 2;
			int numeroDoMeio = quantidadeDeNumeros[posicaoDoMeio];
			
			if(numeroQueDeveSerEncontrado == numeroDoMeio) 
			{
				return posicaoDoMeio;
			}
			if(numeroQueDeveSerEncontrado <= numeroDoMeio) 
			{
				maior = posicaoDoMeio-1;
				
			}
			if(numeroQueDeveSerEncontrado >= numeroDoMeio) 
			{
				menor = posicaoDoMeio+1;
				
			}
		}
		
		return -1;
		
	}
}
