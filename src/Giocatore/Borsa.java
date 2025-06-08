package Giocatore;



import attrezzi.Attrezzo;
import java.util.*;

/* Classe che modella una borsa, contenitore di oggetti raccoglibili nel labirinto, ha un peso massimo stabilito
 * @author Scoderoni,Benedetti
 * @see Borsa
 * @version 1.0
 */

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Map<String,Attrezzo> attrezzi;
	private int pesoMax;

	public Borsa() {							
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<String,Attrezzo>(); 
	}

	//////////////*FUNZIONI GETTER*//////////
	
	
	/*metodo che restituisce la lista degli attrezzi nella borsa ordinati per peso e quindi per nome
	 * @param nessuno
	 * @return la lista degli attrezzi ordinati per peso e poi per nome
	 * 
	 * */ 

	List<Attrezzo> getContenutoOrdinatoPerPeso(){
		 List<Attrezzo> lista= new ArrayList<Attrezzo>(this.attrezzi.values());
		 class ComparatorePerPesoNome implements Comparator<Attrezzo>{
			 @Override
			 public int compare(Attrezzo a1,Attrezzo a2) {
				 if(a1.getPeso()==a2.getPeso()) {
					 return a1.getNome().compareTo(a2.getNome());
							 
				 }else return a1.getPeso()-a2.getPeso();			 
			}
		 	}
		 lista.sort(new ComparatorePerPesoNome());
		 return lista;
	 }
	
	SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		
		 class ComparatorePerPesoNome implements Comparator<Attrezzo>{
			 @Override
			 public int compare(Attrezzo a1,Attrezzo a2) {
				 if(a1.getPeso()==a2.getPeso()) {
					 return a1.getNome().compareTo(a2.getNome());
							 
				 }else return a1.getPeso()-a2.getPeso();			 
			 }
		 }
		 SortedSet<Attrezzo> lista= new TreeSet<Attrezzo>(new ComparatorePerPesoNome());
		 lista.addAll(this.attrezzi.values());
		 return lista;
	}
	
	/*
	 * metodo per ordinare la lista di attrezzi della borsa per nome 
	 * @param nessuno
	 * @return set di attrezzi ordinati per nome
	 */
	SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		class ComparatorePerNome implements Comparator<Attrezzo>{
			
			@Override
			public int compare(Attrezzo a1,Attrezzo a2) {
				return a1.getNome().compareTo(a2.getNome());
			}
		}
		
		SortedSet<Attrezzo> set=new TreeSet<Attrezzo>(new ComparatorePerNome());
		
		set.addAll(this.attrezzi.values());
		return set;
	}
	
	/*metodo che raggruppa gli attrezzi(VALORE) per il peso(CHIAVE) 
	 * @param nessuno
	 * @return mappa chiave integer valore set Attrezzi
	 */
	
	Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer,Set<Attrezzo>> map=new HashMap<>();
		
		for(Attrezzo a: this.attrezzi.values()) {
			if(map.containsKey(a.getPeso())) {					//controlla se c'è un elemento con quella chiave allora devi solo addare l'attrezzo nel set
				map.get(a.getPeso()).add(a);
			}else {												//se non è presente allora crea il set e adda 
				Set<Attrezzo> set=new HashSet<Attrezzo>();
				set.add(a);
				map.put(a.getPeso(), set);
			}
		}
		return map;
	}
	
	
	/*@return ritorna il peso massimo della borsa*/

	public int getPesoMax() {
		return pesoMax;
	}
	
	/*metodo che cerca e ritorna l'attrezzo cercato per il nome  
	 * @see Borsa
	 * @return ritorna l'attrezzo cercato, null se non è presente in borsa
	 */
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {			
		if(this.attrezzi.containsKey(nomeAttrezzo)) {
			return this.attrezzi.get(nomeAttrezzo);
		}else return null;										//ritorno null se non contiene la chiave giusta
	}

	public int getPeso() {
		int peso = 0;
		for(Attrezzo s : this.attrezzi.values()) {
			peso+=s.getPeso();
		}
		return peso;
	}
	
	
/*inserisce un attrezzo in borsa
 * @return ritorna true se è stato inserito con successo, false altrimentri
 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo!=null && (this.getPeso() + attrezzo.getPeso() )<this.pesoMax) {
			this.attrezzi.put(attrezzo.getNome(),attrezzo);					//faccio la put del nuovo attrezzo
			return this.attrezzi.containsKey(attrezzo.getNome());			//poi controllo se è stato aggiunto
		} else return false;
	}

	public boolean isEmpty() {
		return this.attrezzi.isEmpty();		//uso metodo di map
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);				//containskey per verificare l'esistenza,  CONTROLLARE NULL
	}

/*Metodo che rimuove un attrezzo dall'array attrezzi per nome
 * @return ritorna l'attrezzo rimosso	
 */
	public boolean removeAttrezzo(String nomeAttrezzo) {
		if(this.attrezzi.containsKey(nomeAttrezzo)) {				//POSSIBILE CONTROLLO SU NULL
			this.attrezzi.remove(nomeAttrezzo);						//rimuovo
			return !this.attrezzi.containsKey(nomeAttrezzo);			//controllo che sia presente
		} else return false;										//se non c'è ritorno direttamente false 
	}

	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa (" + this.getPeso() + "kg/" + this.getPesoMax() + "kg): ");
			for(Attrezzo i: this.attrezzi.values()) {
				s.append(i.toString() + " ");
			}
		} else
			s.append("Borsa vuota");
		return s.toString();
	}

	public boolean removeAttrezzo(Attrezzo attrezzo) {				//rimozione per attrezzo
		if(this.attrezzi.containsValue(attrezzo)) {
			this.attrezzi.remove(attrezzo.getNome(), attrezzo);
			return !this.attrezzi.containsValue(attrezzo);
		}else return false;
	}
	
	
	
	
	 
}