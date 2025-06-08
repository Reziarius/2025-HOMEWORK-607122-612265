package Comandi;

import DiaDia.Partita;
import DiaDia.IO;

public class ComandoGuarda extends AbstractComando implements Comando{
	private String paramentro;
	static final private String nome="guarda";
	/*
	 * esecuzione del comando
	 */
	
	public void esegui(Partita partita, IO io) {
		if(this.paramentro.equals("stanza")) {
			io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());			//stampo le informazioni della stanza corrente
		}
		if(this.paramentro.equals("borsa")) {
			io.mostraMessaggio(partita.getGiocatore().getDescrizione());
		}
								//stampo le informazioni relative al giocatore, cfu e borsa
	}
}
