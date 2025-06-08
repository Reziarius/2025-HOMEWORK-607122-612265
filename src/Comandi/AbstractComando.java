package Comandi;


import DiaDia.IO;
import DiaDia.Partita;

public abstract class AbstractComando implements Comando{
	private String nome;
	private String parametro;
	

	@Override
	abstract public void esegui(Partita partita,IO io);

	@Override
	public final void setParametro(String parametro) {
		
		this.parametro = parametro;
	}
	
	@Override
	public final String getNome() {
		
		return this.nome;
	}
	
	@Override
	public final String getParametro() {
		
		return this.parametro;
	}
}
