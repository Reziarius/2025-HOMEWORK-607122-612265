package Comandi;

import DiaDia.Partita;
import DiaDia.IO;

public class ComandoFine extends AbstractComando implements Comando {
	static final private String nome="fine";
	
	/*
	 * esecuzione del comando
	 */
	
	@Override
	public void esegui(Partita partita, IO io) {
		io.mostraMessaggio("Grazie per aver giocato!");				//ringrazio il giocatore e setto la partita a finita, cosi può terminare
		partita.setFinita();
	}
}
