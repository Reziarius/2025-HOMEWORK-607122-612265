package Comandi;

import DiaDia.Partita;
import ambiente.Stanza;
import attrezzi.Attrezzo;
import DiaDia.IO;

public class ComandoPosa implements Comando {
	 private String nomeAttrezzo;
	 static final private String nome="posa";
	 
	 /*
	  * esecuzione del comando
	  */

	 @Override
	 public void esegui(Partita partita, IO io) {
		 if(nomeAttrezzo==null) {
			 io.mostraMessaggio("Quale attrezzo vuoi prendere?");
			 return;
		 }
		 
		 Stanza stanzaCorrente=partita.getStanzaCorrente();
		 Attrezzo attrezzoDaPosare=partita.getGiocatore().getBorsa().getAttrezzo(this.nomeAttrezzo);
		 
		 if(attrezzoDaPosare==null) {				//l'attrezzo da posare non esiste in borsa 
			 io.mostraMessaggio("Attrezzo non presente in borsa, quale vuoi posare?");
			 return;
		 }
		 
		 if(partita.getGiocatore().getBorsa().removeAttrezzo(this.nomeAttrezzo)) {			//se ho rimosso con successo l'attrezzo dalla borsa lo metto nella stanza
			 if(stanzaCorrente.addAttrezzo(attrezzoDaPosare)) {
				 io.mostraMessaggio("Hai posato: "+ this.nomeAttrezzo);
			 } else {
				 io.mostraMessaggio("Stanza piena non puoi posare "+ this.nomeAttrezzo);		//la stanza è piena no posso posare quindi rimetto l'attrezzo in borsa
				 partita.getGiocatore().getBorsa().addAttrezzo(attrezzoDaPosare);					
			 }
		 } else {
			 io.mostraMessaggio("Errore nel posare l'atrezzo");
		 }
	 }
	 
	 
	 /*
	  * setter parametro
	  */
	 @Override
	 public void setParametro(String nomeAttrezzo) {
		 this.nomeAttrezzo=nomeAttrezzo;
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
