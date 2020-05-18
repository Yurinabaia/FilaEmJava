import java.time.*;

public class FilaCliente {

	private CelulaCliente frente; // referência ao cliente que está na frente da fila. Esse cliente é utilizado apenas para controle.
    private CelulaCliente tras;   // referência ao cliente que está na última posição da fila.
    private CelulaCliente RESfrente; // referência ao cliente que está na frente da fila. Esse cliente é utilizado apenas para controle.
    private Cliente Nome;
	
    private int cont = 0, i = 0;
    // Construtor que cria uma fila vazia inicializando o cliente da frente da fila e os atributos de controle da fila (frente e tras).
    public FilaCliente()
    {
        Cliente cli;
        CelulaCliente celula;
        LocalDateTime horaChegada;

        horaChegada = LocalDateTime.now();
        
        cli = new Cliente(" ", horaChegada);
        celula = new CelulaCliente(cli);
        frente = celula;
        tras = celula;
    }
    public void concatenar (FilaCliente fila) 
    {
    	//Fila
    	enfileirar(fila.ImprimirTudo());
        
    }
    @SuppressWarnings("null")
	public FilaCliente copiar() 
    {
    	FilaCliente fila = null;
    	fila.ImprimirTudo();
    	return fila;
    }
    public int obterNumClientesAFrente(String nomeCliente)
    {
    	if(!filaVazia()) 
    	{
    		if(nomeCliente == Nome.getNome()) 
    		{
    			return 0;
    		}
			
    		for (int i = 0; i <= cont; i++) 
    		{
    			Cliente valor = ImprimirTudo();
				if(valor.getNome() == nomeCliente) 
				{
					return i;
				}
			}
    	}
		return -1;
    }
   
    public void imprimir() 
    {
    	if(!filaVazia()) 
    	{
			for (int i = 0; i < cont; i++) 
			{
				System.out.println(ImprimirTudo());
			}
    	}
    	else System.out.println("Fila vazia");
    }
    
    public Cliente obterPrimeiro() 
    {
    	if(filaVazia() == true) 
    	{
    		return Nome;
    	}
    	else
 	    return frente.proximo.item;
    }
    
    public int obterNumeroClientes() 
    {
    	return cont;
    }

    // Verifica se a fila está vazia. Em caso afirmativo, retorna true e em caso negativo retorna false.
    public Boolean filaVazia()
    {
        // Se a fila apresentar apenas o elemento de controle, ela está vazia.
        if (frente == tras)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // Insere o item da fila cli, passado como parâmetro para esse método, no final da fila.
    public void enfileirar(Cliente cli)
    {
    	// inserção do novo cliente no final da fila.
        tras.proximo = new CelulaCliente(cli);
    	
    	// atualização do atributo de controle tras.
        tras = tras.proximo;
    	tras.item = cli;
    	cont++;
    }
    
 
    
    public Cliente ImprimirTudo() 
    {    	
    	CelulaCliente aux = null;


    	Cliente cli;
    	
        if(i == 0)Nome =  obterPrimeiro();
        if (!(filaVazia()))
        {
        	i++;
        	if(i==1)
        	// aux aponta para o cliente da fila que será retornado/desenfileirado, ou seja, o primeiro cliente da fila.
        	aux = frente.proximo;
        	else aux = RESfrente;
             
            // atualização do primeiro cliente da fila.
            RESfrente = aux.proximo;
            
            cli = aux.item;
            
            if (aux == tras)
            	i =0;
                       
            return (cli);
         }
        
        return null;
    }

    // Retira o cliente que ocupa a primeira posição da fila. Se a fila estiver vazia, esse método deve retornar null; caso contrário, esse método deve retornar o cliente retirado da fila.
    public Cliente desenfileirar()
    {
        
    	CelulaCliente aux;
    	Cliente cli;
    	
        if (!(filaVazia()))
        {
        	cont--;
        	i = 0;
        	// aux aponta para o cliente da fila que será retornado/desenfileirado, ou seja, o primeiro cliente da fila.
            aux = frente.proximo;
        	
            // atualização do primeiro cliente da fila.
            frente.proximo = aux.proximo;
            
            cli = aux.item;
            aux.proximo = null;
            
            if (aux == tras)
            	tras = frente;

            return (cli);
         }
        
        return null;
    }
}