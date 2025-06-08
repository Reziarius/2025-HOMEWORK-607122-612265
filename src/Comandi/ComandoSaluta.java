package Comandi;

import DiaDia.IO;
import DiaDia.Partita;

public class ComandoSaluta extends AbstractComando implements Comando{
	
	@Override
	public void esegui(Partita partita,IO io) {

		if(partita != null)
			if(partita.getStanzaCorrente() != null) 
				if(partita.getStanzaCorrente().getPersonaggio() != null) {
					
					String output = partita.getStanzaCorrente().getPersonaggio().saluta();
					io.mostraMessaggio(output);
				}
	}
}
