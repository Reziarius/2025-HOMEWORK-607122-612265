package ambiente;
import attrezzi.Attrezzo;

/* Questa classe modella il Labirinto del gioco
 * @autor Scoderoni,Benedetti 
 * @version 1.0
 */

public class Labirinto {
    private Stanza StanzaIniziale;				
    private Stanza StanzaFinale;

    public Labirinto() {
        creaStanze();
    }
    
    /*Metodo inizializzatore del Labinto, crea le stanze e le collega tra loro
     */
 
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
     
    public Stanza getStanzaInziale() {
         return this.StanzaIniziale;
     }
    
    /*@return ritorna la stanza finale del gioco (vittoria)*/
     
    public Stanza getStanzaFinale() {
         return this.StanzaFinale;
     }


//////////////*FUNZIONI SETTER*///////////
/////////////da implementare/////////////
	public void setStanzaIniziale(Stanza StanzaIniziale) {
		this.StanzaIniziale = StanzaIniziale;
	}
	
	public void setStanzaFinale(Stanza StanzaFinale) {			this.StanzaFinale = StanzaFinale;
		this.StanzaFinale=StanzaFinale;
	}
}

