package attrezzi;
import ambiente.Stanza;

/**
 * Una semplice classe che modella un attrezzo.
 * Gli attrezzi possono trovarsi all'interno delle stanze
 * del labirinto.
 * Ogni attrezzo ha un nome ed un peso.
 *
 * @author  Scoderoni,Benedetti
 * @see Stanza
 * @version 1.0
 */
public class Attrezzo {

	private String nome;
	private int peso;

	/**
	 * Crea un attrezzo
	 * @param nome il nome che identifica l'attrezzo
	 * @param peso il peso dell'attrezzo
	 */
	public Attrezzo(String nome, int peso) {
		this.peso = peso;
		this.nome = nome;
	}

	
	
	//////////*FUNZIONI GETTER*//////////
	
	
	/**
	 * Restituisce il nome identificatore dell'attrezzo
	 * @return il nome identificatore dell'attrezzo
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce il peso dell'attrezzo
	 * @return il peso dell'attrezzo
	 */
	public int getPeso() {
		return this.peso;
	}

	/**
	 * Restituisce una rappresentazione stringa di questo attrezzo
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		String a="Nessun attrezzo\n";
		if(this==null) {
			return a;
		}
		return this.getNome()+" ("+this.getPeso()+"kg)";
	}
	
	
	@Override
	public int hashCode() {
		return this.nome.hashCode()+this.peso*10;
	}
	@Override
	public boolean equals(Object o) {
		Attrezzo that=(Attrezzo)o;
		return this.nome.equals(that.getNome()) && this.peso==that.getPeso();
	}



	public void setPeso(int i) {
		this.peso=i;
	}
}