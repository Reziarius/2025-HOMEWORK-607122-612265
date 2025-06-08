package Comandi;

import DiaDia.Partita;
import ambiente.Stanza;
import DiaDia.IO;

public class ComandoVai extends AbstractComando implements Comando{
	
	private String direzione;
	static final private String nome="vai";
	
	/**
	* esecuzione del comando
	*/
	
	@Override
	public void esegui (Partita partita, IO io) {
		Stanza stanzaCorrente= partita.getStanzaCorrente();
		Stanza prossimaStanza=null;
		if(direzione==null) {
			io.mostraMessaggio("Dove vuoi andare?"+ "\n"+ "Devi specifiacre una direzione");
			return;
		}
		prossimaStanza= stanzaCorrente.getStanzaAdiacente(this.direzione);
		if(prossimaStanza==null) {
			io.mostraMessaggio("Direzione inesistente");
			return;
		}
		partita.setStanzaCorrente(prossimaStanza);
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
	}
}