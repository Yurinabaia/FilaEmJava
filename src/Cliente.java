import java.time.*;

class Cliente {

	private String nome;                  // nome do cliente.
	private LocalDateTime horarioChegada; // data e hora de chegada do cliente.
	
	// Construtor que inicializa os atributos nome e horarioChegada com os valores passados atrav�s dos par�metros nomeCliente e chegada desse m�todo, respectivamente.
	public Cliente(String nomeCliente, LocalDateTime chegada){
	    nome = nomeCliente;
	    setHorarioChegada(chegada);
	}
	
	public String getNome(){
		return nome;
	}

	public void setNome(String nome){
		this.nome = nome;
	}
	
	public LocalDateTime getHorarioChegada(){
		return horarioChegada;
	}

	public void setHorarioChegada(LocalDateTime horarioChegada){
		this.horarioChegada = horarioChegada;
	}	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getNome();
	}
}
