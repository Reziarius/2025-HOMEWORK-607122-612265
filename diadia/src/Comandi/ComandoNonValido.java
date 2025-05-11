package Comandi;

import DiaDia.Partita;
import DiaDia.IO;

public class ComandoNonValido implements Comando{
	
	static final private String nome="comando non valido";
	/*
	 * esecuzione del comando
	 */
	
	@Override
	public void esegui(Partita partita, IO io) {
		io.mostraMessaggio("Comando non valido, provane un altro");
	}
	
	@Override 
	public void setParametro(String parametro) {
		return;
	}
	
	@Override
	public String getNome() {
		return this.nome;
	}
	
	@Override
	public String getParametro() {
		return null;
	}
}
