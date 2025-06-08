package Comandi;

import DiaDia.Partita;
import DiaDia.IO;

public class ComandoNonValido extends AbstractComando implements Comando{
	
	static final private String nome="comando non valido";
	/*
	 * esecuzione del comando
	 */
	
	@Override
	public void esegui(Partita partita, IO io) {
		io.mostraMessaggio("Comando non valido, provane un altro");
	}
}
