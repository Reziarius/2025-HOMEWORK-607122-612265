package Giocatore;

import attrezzi.Attrezzo;

/* Classe che modella una borsa, contenitore di oggetti raccoglibili nel labirinto, ha un peso massimo stabilito
 * @author Scoderoni,Benedetti
 * @see Borsa
 * @version 1.0
 */

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;				//quanti attrezzi sono presenti in borsa
	private int pesoMax;

	public Borsa() {							
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; // speriamo bastino...
		this.numeroAttrezzi = 0;
	}
	
	
	
	//////////////*FUNZIONI GETTER*//////////
	
	/*@return ritorna il peso massimo della borsa*/
	
	public int getPesoMax() {
		return pesoMax;
	}
	
	/*metodo che cerca e ritorna l'attrezzo cercato per il nome  
	 * @see Borsa
	 * @return ritorna l'attrezzo cercato, null se non è presente in borsa
	 */
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {			//da migliorare 
		Attrezzo a = null;
		for (int i = 0; i < this.numeroAttrezzi; i++)
			if(attrezzi[i]!=null) {
				if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
					a = attrezzi[i];	
			}
		return a;
	}

	public int getPeso() {
		int peso = 0;
		for (int i = 0; i < this.numeroAttrezzi; i++)
			peso += this.attrezzi[i].getPeso();

		return peso;
	}
	
	
/*inserisce un attrezzo in borsa
 * @return ritorna true se è stato inserito con successo, false altrimentri
 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		
		if (attrezzo==null || this.getPeso() + attrezzo.getPeso() > this.pesoMax)
			return false;
		if (this.numeroAttrezzi == 10)
			return false;
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
	}

	

	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo) != null;
	}

/*Metodo che rimuove un attrezzo dall'array attrezzi per nome
 * @return ritorna l'attrezzo rimosso	
 */
	public boolean removeAttrezzo(String nomeAttrezzo) {
		for(int i=0;i<this.numeroAttrezzi;i++) {
			if(attrezzi[i].getNome().equals(nomeAttrezzo)) {
				for(int j=i;j<this.numeroAttrezzi;j++) {
					attrezzi[j]=attrezzi[j+1];
				}
				this.numeroAttrezzi--;
				return true;
			}
		}
		return false;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa (" + this.getPeso() + "kg/" + this.getPesoMax() + "kg): ");
			for (int i = 0; i < this.numeroAttrezzi; i++)
				s.append(attrezzi[i].toString() + " ");
		} else
			s.append("Borsa vuota");
		return s.toString();
	}
}