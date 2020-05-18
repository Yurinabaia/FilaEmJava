import java.time.*;

public class TesteFila {

	public static void main(String[] args) throws InterruptedException 
	{
		Cliente cli;
        FilaCliente filaLanchonete;

        filaLanchonete = new FilaCliente();
        cli = new Cliente("Eveline", LocalDateTime.now());
        filaLanchonete.enfileirar(cli);
        Thread.sleep(1000);

        cli = new Cliente("Jo�o", LocalDateTime.now());
        filaLanchonete.enfileirar(cli);
        Thread.sleep(1000);

        cli = new Cliente("Ana", LocalDateTime.now());
        filaLanchonete.enfileirar(cli);
        Thread.sleep(1000);

        System.out.println("Os	clientes	presentes	na	fila	s�o,	nessa	ordem:");
		filaLanchonete.imprimir();	//	Eveline Jo�o Ana
        
		
		System.out.println("Existem	" +	filaLanchonete.obterNumClientesAFrente("Ana")	+	"	clientes	�	frente	do	cliente	Ana");	//	2	clientes
        
		System.out.println("Existem	" +	filaLanchonete.obterNumClientesAFrente("Jo�o")	+	"	clientes	� frente	do	cliente	Jo�o");	//	1	cliente
        
		System.out.println("Existem	" +	filaLanchonete.obterNumClientesAFrente("Eveline") +  "   clientes	�	frente	do	cliente	Eveline");	//	0	clientes

		FilaCliente	fila2 =	filaLanchonete.copiar();
		System.out.println("Os	clientes	presentes	na	fila	c�pia	s�o,	nessa	ordem:");
		fila2.imprimir();	//	Eveline Jo�o Ana
	}
 
}