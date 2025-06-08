package ambiente;

import attrezzi.Attrezzo;

import java.util.*;

import Personaggi.AbstractPersonaggio;




/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author Scoderoni,Benedetti 
 * @see Attrezzo
 * @version 1.0
*/

public class Stanza {
	private int NUMERO_MASSIMO_ATTREZZI;
	static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	
	
	/*implementa classe baule*/
	
	private String descrizione;					//nome della stanza 			
    private Map<String,Attrezzo> attrezzi;
    private Map<Direzione,Stanza> stanzaAdiacenti;
    private AbstractPersonaggio personaggio;
    
    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
   
	public Stanza(String descrizione) {			//modifica costruttore generico								
        this.descrizione=descrizione;
        this.attrezzi=new HashMap<String,Attrezzo>();
        this.stanzaAdiacenti=new HashMap<Direzione,Stanza>();
        this.NUMERO_MASSIMO_ATTREZZI =10;

    }
    /**
     * Imposta una stanza adiacente.
     *
     * @param direzione direzione in cui sara' posta la stanza adiacente.
     * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
     */
    public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
        if(this.stanzaAdiacenti.size()<NUMERO_MASSIMO_DIREZIONI) {
        	Direzione d=Direzione.getDirezione(direzione);
        	this.stanzaAdiacenti.put(d, stanza);
        }
    }
    public void impostaStanzaAdiacente(Direzione direzione, Stanza stanza) {

		if(direzione == null)
			return;
		else
			this.stanzaAdiacenti.put(direzione, stanza);
	}

    /**
     * Restituisce la stanza adiacente nella direzione specificata
     * @param direzione
     */
	public Stanza getStanzaAdiacente(String direzione) {
        return  this.stanzaAdiacenti.get(direzione);
	}
	
	public Stanza getStanzaAdiacente(Direzione direzione) {
		Stanza stanza = null;

		stanza = this.stanzaAdiacenti.get(direzione);

		return stanza;
	}

	public Map<Direzione,Stanza> getMapStanzeAdiacenti(){
		return this.stanzaAdiacenti;
	}
    /**
     * Restituisce la nome della stanza.
     * @return il nome della stanza
     */
    public String getNome() {
        return this.descrizione;
    }

    /**
     * Restituisce la descrizione della stanza.
     * @return la descrizione della stanza
     */
    public String getDescrizione() {
        return this.toString();
    }

    /**
     * Restituisce la collezione di attrezzi presenti nella stanza.
     * @return la collezione di attrezzi nella stanza.
     */
    public List<Attrezzo> getAttrezzi() {
        List<Attrezzo> lista=new ArrayList<>(this.attrezzi.values());
    	return lista;
    }

    /**
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
        if (attrezzo!=null && this.attrezzi.size() < NUMERO_MASSIMO_ATTREZZI) {
        	this.attrezzi.put(attrezzo.getNome(), attrezzo);
        	return this.attrezzi.containsKey(attrezzo.getNome());
        }
        else {
        	return false;
        }
    }

   /**
	* Restituisce una rappresentazione stringa di questa stanza,
	* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	* @return la rappresentazione stringa
	*/
    public String toString() {
    	StringBuilder risultato = new StringBuilder();
    	risultato.append(this.descrizione);
    	risultato.append("\nUscite:");
    	
    	for (Direzione direzione : this.stanzaAdiacenti.keySet())
    		if (direzione!=null)
    			risultato.append(" " + direzione);
    	
    	risultato.append("\nAttrezzi nella stanza: ");
    	
    	for (Attrezzo attrezzo : this.attrezzi.values()) {
    			if(attrezzo!=null){ 
    				risultato.append(attrezzo.toString()+" ");
    			}	
    		}
    	return risultato.toString();
    }

    /**
	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/
	
    public boolean hasAttrezzo(String nomeAttrezzo) {
    	return this.attrezzi.containsKey(nomeAttrezzo);
	}

	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		if(this.attrezzi.containsKey(nomeAttrezzo)) {
			return this.attrezzi.get(nomeAttrezzo);
		}else return null;
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome). 
	 * 
	 * MODIFICA: inizialmente aveva come parametro un attrezzo, ora una stringa. Ritornava un booleano true se lo aveva rimosso
	 * false altrimenti.
	 * 
	 * @param nomeAttrezzo
	 * @return ritorna l'attrezzo rimosso, null altrimenti
	 */
	
	
	public void removeAttrezzo(String nomeAttrezzo) {
		this.attrezzi.remove(nomeAttrezzo);
	}

	public Collection<Direzione> getDirezioni() {
	    return this.stanzaAdiacenti.keySet();
    }
	
	public void setPersonaggio(AbstractPersonaggio personaggio) {
		this.personaggio = personaggio;
		}
	
	public AbstractPersonaggio getPersonaggio() {
		return this.personaggio;
		}
	
	@Override
	public boolean equals(Object o) {
		
		if(o == null || !(o instanceof Stanza))
			return false;
		
		Stanza that = (Stanza) o;
		
		return this.getNome().equals(that.getNome());
	}
	
	@Override
	public int hashCode() {
		
		return this.getNome().hashCode();
	}
}