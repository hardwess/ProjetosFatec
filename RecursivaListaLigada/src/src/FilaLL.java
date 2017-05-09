/*
 * Fila com alocação dinâmica de memória
 * @author Andrea
 */

public class FilaLL {
	
	public static void Main(String args[]){
	
	/**
   	atributo que indica início da lista
   	*/
	
	
      private No inicio;
   	
   	/**
   	Construtor que inicializa lista vazia
   	*/   
      FilaLL()
      {
         inicio = null;
      }
   
   	/**
   	Método que verifica se a lista está vazia.
   	@return retorna true se a lista estiver vazia, ou false, se possuir ao
   	menos um elemento.
   	*/
      public boolean isVazia() {
         return (inicio == null);
      }
   	
   	/**
   	Método que percorre a lista exibindo o elemento do Nó
   	*/
      public void percorre (){
         No n=inicio;
         while (n != null){
            System.out.print(" "+n.dado.toString());
            n=n.prox;
         }
         System.out.println(" ");
      }
   
   
   	/**
   	Método que adiciona um novo elemento no final da lista
   	@param e novo elemento
   	*/
      public void adiciona(Livro e)	{
         No novoNo = new No(e);
         No aux=inicio;
         if (isVazia())
            inicio = novoNo;
         else{
            while (aux.prox != null)
               aux = aux.prox;
            aux.prox = novoNo;
         }
      }
   
   
   	/**
   	Método que remove inicio elemento
       * @return retorna o objeto, instância da classe Livro
   	*/
      public Livro remove()
      {
         Livro l=null;
         if (!isVazia())	{
            l=inicio.dado;
            inicio = inicio.prox;
         }
         else {
            System.out.println("Lista Vazia");
         } 
         return l;
      }
}
}
