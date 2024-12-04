package Atividade3;
public class JumpSearch {
	
	public static void main(String[] args) 
	{
        int[] ints = {1, 2, 3, 5, 7, 8, 9, 12, 15, 17, 19, 21, 23, 25, 26, 28, 29, 31, 34, 36, 37, 39};
		int alvo = 12;
        
        int resultado = jumpSearch(ints, alvo);
		if(resultado == -1) 
		{
			System.out.println("valor não presente na lista");
		}else 
		{
			System.out.println("valor encontrado na posicao " + resultado);
		}
	}

	
	private static int jumpSearch(int[] Array, int alvo) 
	{
		int tamanhoDoArray = Array.length;
		
		int blocoASerPulado = (int) Math.floor(Math.sqrt(tamanhoDoArray));
		int anterior = 0;
		
		while(Array[Math.min(blocoASerPulado, tamanhoDoArray) - 1] < alvo)
		{
			anterior = blocoASerPulado;
			blocoASerPulado += (int) Math.floor(Math.sqrt(tamanhoDoArray));
			if(anterior >= tamanhoDoArray) 
			{
				return -1;
			}
		}
		
		while(Array[anterior] < alvo) 
		{
			anterior++;
			if(anterior == Math.min(blocoASerPulado, tamanhoDoArray)) 
			{
				return -1;
			}
		}
		
		if(Array[anterior] == alvo) 
		{
			return anterior;
		}
		
		return -1;
	}
}
