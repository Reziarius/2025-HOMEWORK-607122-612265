package Giocatore;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import attrezzi.Attrezzo;
import java.util.*;

class BorsaTest {
	private Attrezzo lanterna;
	private Attrezzo osso;
	private Borsa borsa;
	private List<Attrezzo> lista;
	private Set<Attrezzo> set;
	
	@BeforeEach
	public void setUp() {
		borsa = new Borsa();
		lanterna = new Attrezzo("lanterna",2);
        osso = new Attrezzo("osso",1);
        this.borsa.addAttrezzo(lanterna);
        this.borsa.addAttrezzo(osso);
        this.lista=new ArrayList<>();
        this.set=new TreeSet<>();
	}
	
	//test case di get peso
	
	@Test
	public void testGetPeso() {
		assertEquals(3,borsa.getPeso());
	}

	//test case get attrezzo,primo caso ottengo quello giusto, il secondo cerco uno che non c'è, terzo cerco il null
	
	@Test
	public void testGetAttrezzoGiusto() {
		assertEquals(osso,borsa.getAttrezzo("osso"));
	}
	
	@Test
	public void testGetAttrezzoSbagliato() {
		assertNull(borsa.getAttrezzo("Lama del caos"));
	}
	
	@Test
	public void testGetAttrezzoNull() {
		assertNull(borsa.getAttrezzo(null));
	}
	
	//test case add attrezzo, primo aggiungo con successo, secondo fallisco, terzo inserisco null
	
	@Test
	public void testAddAttrezzoSuccesso() {
		Attrezzo LamaDiEleonora= new Attrezzo("Lama di Eleonora",6);
		assertTrue(borsa.addAttrezzo(LamaDiEleonora));
		assertTrue(borsa.hasAttrezzo("Lama di Eleonora"));
		assertEquals(9,borsa.getPeso());
	}
	
	@Test
	public void testAddAttrezzoFallito() {
		Attrezzo MoonBlade= new Attrezzo("MoonBlade",10);
		assertFalse(borsa.addAttrezzo(MoonBlade));
		assertFalse(borsa.hasAttrezzo("MoonBlade"));
		assertEquals(3,borsa.getPeso());
	}
	
	@Test
	public void testAddAttrezzoNull(){
		assertFalse(borsa.addAttrezzo(null));
	}	

	//test case remove attrezzo, uno lo rimuove con successo, uno rimuove un elemento non presente uno cerca di levare null

	@Test
	public void testRemoveAttrezzoSuccesso() {
		assertTrue(borsa.removeAttrezzo("osso"));
		assertFalse(borsa.hasAttrezzo("osso"));
		assertEquals(2,borsa.getPeso());
	}
	
	@Test
	public void testRemoveAttrezzoNonPresente() {
		assertFalse(borsa.removeAttrezzo("Uchigatana"));
	}

	@Test
	public void testRemoveAttrezzoNull() {
		assertFalse(borsa.removeAttrezzo(null));
	}
	
	@Test
	public void testOrdinaPerPesoLista() {
		Attrezzo pugnale=new Attrezzo("pugnale",2);
		borsa.addAttrezzo(pugnale);
		lista=borsa.getContenutoOrdinatoPerPeso();
		assertEquals(osso,lista.get(0));
		assertEquals(lanterna,lista.get(1));
		assertEquals(pugnale,lista.get(2));
	}
	
	@Test
	public void testOrdinaPerPesoSet() {
		Attrezzo pugnale=new Attrezzo("pugnale",2);
		borsa.addAttrezzo(pugnale);
		set=borsa.getSortedSetOrdinatoPerPeso();
		Iterator<Attrezzo> iter=set.iterator();
		assertEquals(osso,iter.next());
		assertEquals(lanterna,iter.next());
		assertEquals(pugnale,iter.next());
		
	}
	@Test
	public void testOrdinaPerNome() {
		Attrezzo a=new Attrezzo("Claymore",6);
		borsa.addAttrezzo(a);
		set=borsa.getContenutoOrdinatoPerNome();
		Iterator<Attrezzo> iter=set.iterator();
		assertEquals(a,iter.next());
		assertEquals(lanterna,iter.next());
		assertEquals(osso,iter.next());
	}
	
	@Test
	public void testRaggruppaAttrezziPerPeso() {
		Attrezzo pugnale=new Attrezzo("pugnale",2);
		borsa.addAttrezzo(pugnale);
		Map<Integer,Set<Attrezzo>> map=new HashMap<>();
		map=borsa.getContenutoRaggruppatoPerPeso();
		Iterator<Attrezzo> i=map.get(1).iterator();
		assertEquals(osso,i.next());
		assertTrue(map.get(2).contains(pugnale));
		assertTrue(map.get(2).contains(lanterna));
	}
}
