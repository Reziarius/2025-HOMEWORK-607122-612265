package Comandi;

import DiaDia.Partita;
import DiaDia.IO;

public class ComandoGuarda implements Comando{
	
	static final private String nome="guarda";
	/*
	 * esecuzione del comando
	 */
	
	public void esegui(Partita partita, IO io) {
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());			//stampo le informazioni della stanza corrente
		io.mostraMessaggio(partita.getGiocatore().getDescrizione());						//stampo le informazioni relative al giocatore, cfu e borsa
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
