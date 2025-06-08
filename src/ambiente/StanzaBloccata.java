package ambiente;

import attrezzi.Attrezzo;

public class StanzaBloccata extends Stanza{
	private Direzione direzioneBloccata;
	private String sblocca;
	
	public StanzaBloccata(String nome,Direzione dir, String attrezzo) {
		super(nome);
		this.direzioneBloccata=dir;
		this.sblocca=attrezzo;	
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(this.hasAttrezzo(sblocca) || !direzione.equals(this.direzioneBloccata)) {
			return super.getStanzaAdiacente(direzione);
		}else {
			return this;
		}
	}
	
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(sblocca)) {
			return super.getDescrizione();
		} else {
			StringBuilder risultato = new StringBuilder();
	    	risultato.append(this.getNome());
	    	risultato.append("\nUscite:");
	    	
	    	for (Direzione direzione : this.getDirezioni())
	    		if (direzione!=null && direzione!=this.direzioneBloccata)				//non stampo la direzione bloccata
	    			risultato.append(" " + direzione);
	    	
	    	risultato.append("\nAttrezzi nella stanza: ");
	    	
	    	for (Attrezzo attrezzo : this.getAttrezzi()) {
	    			if(attrezzo!=null){ 
	    				risultato.append(attrezzo.toString()+" ");
	    			}	
	    		}
			risultato.append("Direzione "+ this.direzioneBloccata+" è bloccata\n");			//informo l'utente della direzione bloccata
			risultato.append("Trova "+this.sblocca+" per sbloccare questa direzione");
			return risultato.toString();
		}
	}
}
