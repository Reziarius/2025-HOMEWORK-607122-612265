package Comandi;

import DiaDia.IO;
import DiaDia.Partita;
import attrezzi.Attrezzo;

public class ComandoRegala extends AbstractComando implements Comando{
	private static final String NESSUN_PERSONAGGIO = "Impossibile regalare, non è presente nessun personaggio nella stanza";
	private static final String NESSUN_ATTREZZO = "Impossibile regalare, non possiedi alcun attrezzo di questo tipo";

	@Override
	public void esegui(Partita partita,IO io) {
		
		if(partita != null)
			if(partita.getStanzaCorrente() != null) 
				if(partita.getStanzaCorrente().getPersonaggio() != null) {

					Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(super.getParametro());

					if(attrezzo != null) {

						if(partita.getStanzaCorrente().getPersonaggio() != null) {

							String msg = partita.getStanzaCorrente().getPersonaggio().riceviRegalo(attrezzo, partita);
							partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo);
							
							io.mostraMessaggio(msg);
						}
						else
							io.mostraMessaggio(NESSUN_PERSONAGGIO);
					}
					else
						io.mostraMessaggio(NESSUN_ATTREZZO);

				}
	}

}
