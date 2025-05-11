package Comandi;

import DiaDia.Partita;
import ambiente.Stanza;
import attrezzi.Attrezzo;
import DiaDia.IO;

public class ComandoPrendi implements Comando{
	private String nomeAttrezzo;
	static final private String nome="prendi";
	
	/*esegui il comando
	 * 
	 */
	@Override
	public void esegui (Partita partita, IO io) {
		 
		if (nomeAttrezzo == null) {														//controllo se l'attrezzo è null
			io.mostraMessaggio("Quale attrezzo vuoi prendere?");
	            return;
	        }
		Stanza stanzaCorrente = partita.getStanzaCorrente();							//tramite partita prendo la stanza corrente, necessario per prendere l'attrezzo dalla stanza
        Attrezzo attrezzo = stanzaCorrente.getAttrezzo(nomeAttrezzo);
        
        if(attrezzo==null) {															//se l'attrezzo è null significa che non è presente in stanza
        	io.mostraMessaggio("\"Attrezzo non presente nella stanza.\"");
        }else {
        	if(partita.getGiocatore().getBorsa().addAttrezzo(attrezzo)) {				//provo ad aggiugere l'attrezzo in borsa, fallisce se ha 10 elementi o supera il peso
        		partita.getStanzaCorrente().removeAttrezzo(nomeAttrezzo);
        		io.mostraMessaggio("Hai preso: "+ nomeAttrezzo);
        	}else { 
        		io.mostraMessaggio("Borsa piena, non puoi prendere questo oggetto!");
        		}
        }
        
	}
	
	/*
	 * setter paramentro
	 */
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;
	}
	
	@Override
	public String getNome() {
		return this.nome;
	}
	
	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}
}
