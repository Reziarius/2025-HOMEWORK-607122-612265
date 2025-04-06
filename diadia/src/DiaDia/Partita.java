package DiaDia;
import ambiente.Stanza;
import ambiente.Labirinto;
import Giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  Scoderoni,Benedetti
 * @see Stanza
 * @version 1.0
 */

public class Partita {

	
	private Labirinto labirinto;			//riferimento a class lab
	
	private Giocatore giocatore;			//riferimento a class giocatore
	
	private Stanza stanzaCorrente;  		
	//private Stanza stanzaVincente;		competenza labirinto 
	private boolean finita;
	//private int cfu;						competenza giocatore
	
	
	public Partita(){
		this.labirinto=new Labirinto();
		this.giocatore=new Giocatore();
		this.finita = false;
		//this.cfu = CFU_INIZIALI;
		this.stanzaCorrente=this.labirinto.getStanzaInziale();
	}

   

	/*public Stanza getStanzaVincente() {
		return stanzaVincente;							//competenza labirinto con this.labirinto.getStanzaFinale()
	}*/
	//aggiorna stanza corrente
	
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}
	//ritorna stanza corrente
	
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()== this.labirinto.getStanzaFinale();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
	
	public Giocatore getGiocatore() {
		return this.giocatore; 		
	}
	public String toString() {
		return this.getStanzaCorrente()+"\nCfu= "+this.giocatore.getCfu();
	}

}
