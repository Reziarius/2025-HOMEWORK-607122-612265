package Comandi;

import DiaDia.IO;
import DiaDia.Partita;
import Personaggi.AbstractPersonaggio;

public class ComandoInteragisci extends AbstractComando implements Comando {
	private static final String MESSAGGIO_CON_CHI = "Con chi dovrei interagire?...";
	private String messaggio;
	

	@Override
	public void esegui(Partita partita,IO io) {
		
		AbstractPersonaggio personaggio;
		personaggio = partita.getStanzaCorrente().getPersonaggio();
		if (personaggio!=null) {
			this.messaggio = personaggio.agisci(partita);
			io.mostraMessaggio(this.messaggio);

		} else io.mostraMessaggio(MESSAGGIO_CON_CHI);
	}
	
	public String getMessaggio() {
		return this.messaggio;
	}
}
