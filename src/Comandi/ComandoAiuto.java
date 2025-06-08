package Comandi;

import DiaDia.Partita;
import DiaDia.IO;

public class ComandoAiuto extends AbstractComando implements Comando{
	static final private String[] elencoComandi = {"vai", "aiuto","prendi","posa", "fine","guarda","saluta","interagisci","regala"};
	static final private String nome="aiuto";
	
	/*
	 * esegui il comando aiuto
	 */
	@Override
	public void esegui(Partita partita, IO io) {													//stampo tutti i possibili comandi
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
		io.mostraMessaggio("\n");
	}
}
