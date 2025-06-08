package ambiente;
import attrezzi.Attrezzo;

import java.io.FileNotFoundException;
import java.util.*;

import Personaggi.AbstractPersonaggio;
import Personaggi.Cane;
import Personaggi.Mago;
import Personaggi.Strega;

/* Questa classe modella il Labirinto del gioco
 * @autor Scoderoni,Benedetti 
 * @version 1.0
 */

public class Labirinto {
    private Stanza StanzaIniziale;				
    private Stanza StanzaFinale;
    private Map<String,Stanza> Stanze;				//mappa che dato il nome di una stanza ti restituisce la stanza che hai cercato, tiene traccia di ogni stanza nel labirinto
    private Map<String,AbstractPersonaggio> personaggi;
    private Labirinto() {
    }
    
    /*Metodo inizializzatore del Labinto, crea le stanze e le collega tra loro
     */
 
    
    public static LabirintoBuilder newBuilder() throws FileNotFoundException, FormatoFileNonValidoException {
	    return new LabirintoBuilder();
	}
    
    public static class LabirintoBuilder {
    	private Labirinto labirinto;
    	private Stanza ultima;
    	
    	public LabirintoBuilder() throws FileNotFoundException, FormatoFileNonValidoException {

			this.labirinto = new Labirinto();
			this.labirinto.Stanze= new HashMap<String, Stanza>();
			this.labirinto.personaggi = new HashMap<String, AbstractPersonaggio>();
		}
    	
    	public LabirintoBuilder addStanzaIniziale(String stanzaIniziale) {
    		Stanza a=new Stanza(stanzaIniziale);
    		this.labirinto.setStanzaIniziale(a);
    		this.labirinto.addStanza(a);
    		this.ultima=a;
    		return this;
    	}
    	
    	public LabirintoBuilder addStanzaVincente(String stanzaVincente) {
    		Stanza a=new Stanza(stanzaVincente);
    		this.labirinto.setStanzaFinale(a);
    		this.labirinto.addStanza(a);
    		this.ultima=a;
    		return this;
    	}
    	
    	public LabirintoBuilder addStanzaMagica(String nome, int soglia) {
    		StanzaMagica a=new StanzaMagica(nome,soglia);
    		this.labirinto.addStanza(a);
    		this.ultima=a;
    		return this;
    	}
    	
    	public LabirintoBuilder  addStanzaBloccata(String nome, String dir, String attrezzo) {
    		Direzione d=Direzione.getDirezione(dir);
    		StanzaBloccata a=new StanzaBloccata(nome,d,attrezzo);
    		this.labirinto.addStanza(a);
    		this.ultima=a;
    		return this;
    	}
    	
    	public LabirintoBuilder addStanzaBuia(String nome, String attrezzo) {
    		StanzaBuia a=new StanzaBuia(nome,attrezzo);
    		this.labirinto.addStanza(a);
    		this.ultima=a;
    		return this;
    	}
    	public LabirintoBuilder addStanza(String stanza) {
    		Stanza a=new Stanza(stanza);
    		this.labirinto.addStanza(a);
    		this.ultima=a;
    		return this;
    	}
    	
    	public LabirintoBuilder addAdiacenza(String s1,String s2, String dir) {
    		this.labirinto.getStanza(s1).impostaStanzaAdiacente(dir,this.labirinto.getStanza(s2));
    		
    		//IMPPLEMENTA IMPOSTANZA STANZA DIR OPPOSTA CON ENUM
    		return this;
    	}
    	
    	public LabirintoBuilder addAttrezzo(String string, int i) {
    		Attrezzo b=new Attrezzo(string,i);
    		this.ultima.addAttrezzo(b);
    		return this;
    	}
    	
    	//metodo finale ed unico getter, dopo aver concatenato tutti i comandi grazie a questo metodo si ritorna il labirinto finale
    	public Labirinto getLabirinto() {
    		return this.labirinto;
    	}

    	public Map<String,Stanza> getListaStanze(){
    		return this.labirinto.getMappaStanze();
    	}
    	
    	public Map<Direzione,Stanza> getMapStanzeAdiacenti(){
    		return this.ultima.getMapStanzeAdiacenti();
    	}

		public void addAttrezzo(String nomeAttrezzo, int peso, String nomeStanza) {
			Attrezzo b=new Attrezzo(nomeAttrezzo,peso);
			if(this.labirinto.Stanze.get(nomeStanza)!=null) {
				this.labirinto.Stanze.get(nomeStanza).addAttrezzo(b);
			}
		}

		public LabirintoBuilder addStanzaMagica(String nomeStanza) {
			StanzaMagica a=new StanzaMagica(nomeStanza);
			this.labirinto.Stanze.put(nomeStanza,a);
			this.ultima=a;
			return this;
		}

		public LabirintoBuilder addCane(String nome, String presentazione, String nomeAttrezzo, String ciboPreferito) {
			Attrezzo a=new Attrezzo(nomeAttrezzo,1);
			Cane c=new Cane(nome,presentazione,a,ciboPreferito);
			this.labirinto.personaggi.put(nome,c);
			return this;
		}

		public LabirintoBuilder addMago(String nome, String presentazione, String attrezzo) {
			Attrezzo a=new Attrezzo(attrezzo,1);
			Mago m=new Mago(nome,presentazione,a);
			this.labirinto.personaggi.put(nome,m);
			return this;
		}

		public LabirintoBuilder addStrega(String nome, String presentazione) {
			Strega s=new Strega(nome,presentazione);
			this.labirinto.personaggi.put(nome,s);
			return this;
		}

		public Map<String,AbstractPersonaggio> getListaPersonaggi() {
			return this.labirinto.personaggi;
		}

		public LabirintoBuilder addPersonaggioInStanza(String nomePersonaggio, String nomeStanza) {
			AbstractPersonaggio personaggio = this.labirinto.personaggi.get(nomePersonaggio);
			if (personaggio == null)
				throw new IllegalArgumentException("Personaggio '" + nomePersonaggio + "' non definito");

			Stanza stanza = this.labirinto.getMappaStanze().get(nomeStanza);
			if (stanza == null)
				throw new IllegalArgumentException("Stanza '" + nomeStanza + "' non definita");

			stanza.setPersonaggio(personaggio);
			return this;
			
		}
    }
    
    
    
    
    
    
    
    private void creaStanze() {

            /* crea gli attrezzi*/ 
            
    	 	Attrezzo lanterna = new Attrezzo("lanterna",3);
            Attrezzo osso = new Attrezzo("osso",1);

            /* crea stanze del labirinto*/ 
            
            Stanza atrio = new Stanza("Atrio");
            Stanza aulaN11 = new Stanza("Aula N11");
            Stanza aulaN10 = new Stanza("Aula N10");
            Stanza laboratorio = new Stanza("Laboratorio Campus");
            Stanza biblioteca = new Stanza("Biblioteca");

            /* collega le stanze*/ 
            
            atrio.impostaStanzaAdiacente("nord", biblioteca);
            atrio.impostaStanzaAdiacente("est", aulaN11);
            atrio.impostaStanzaAdiacente("sud", aulaN10);
            atrio.impostaStanzaAdiacente("ovest", laboratorio);
            aulaN11.impostaStanzaAdiacente("est", laboratorio);
            aulaN11.impostaStanzaAdiacente("ovest", atrio);
            aulaN10.impostaStanzaAdiacente("nord", atrio);
            aulaN10.impostaStanzaAdiacente("est", aulaN11);
            aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
            laboratorio.impostaStanzaAdiacente("est", atrio);
            laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
            biblioteca.impostaStanzaAdiacente("sud", atrio);

            /* pone gli attrezzi nelle stanze*/
            
            aulaN10.addAttrezzo(lanterna);
            atrio.addAttrezzo(osso);

            /* il gioco comincia nell'atrio*/
            
            this.StanzaIniziale = atrio;
            this.StanzaFinale = biblioteca;
        }
    
   //////////////*FUNZIONI GETTER*////////////////
    
    
     /* @return ritorna la stanza iniziale del labirinto*/ 
     
    public Stanza getStanzaIniziale() {
         return this.StanzaIniziale;
     }
    
    /*@return ritorna la stanza finale del gioco (vittoria)*/
     
    public Stanza getStanzaFinale() {
         return this.StanzaFinale;
     }
    
    public Stanza getStanza(String stanza) {
    	return this.Stanze.get(stanza);
    }
    
    public Map<String,Stanza> getMappaStanze(){
    	return this.Stanze;
    }
    
    

//////////////*FUNZIONI SETTER*///////////
/////////////da implementare/////////////
	public void setStanzaIniziale(Stanza StanzaIniziale) {
		this.StanzaIniziale = StanzaIniziale;
	}
	
	public void setStanzaFinale(Stanza StanzaFinale) {			
		this.StanzaFinale=StanzaFinale;
	}
	
	public void addStanza(Stanza stanza) {
		this.Stanze.put(stanza.getNome(), stanza);
	}
}

