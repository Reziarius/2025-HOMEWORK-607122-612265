package ambiente;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import attrezzi.Attrezzo;

class StanzaTest {
	private Stanza atrio;
	private Stanza aulaN11;
	private Stanza biblioteca;
	private Attrezzo lanterna;
    private Attrezzo osso; 
	
	@BeforeEach
	public void setUp() {
		this.atrio = new Stanza("Atrio");
		this.aulaN11 = new Stanza("Aula N11");
        this.biblioteca = new Stanza("Biblioteca");

        this.lanterna = new Attrezzo("lanterna",3);
        this.osso = new Attrezzo("osso",1);
        /* collega le stanze*/ 
        
        this.atrio.impostaStanzaAdiacente("nord", biblioteca);
        this.atrio.impostaStanzaAdiacente("est", aulaN11);
        this.aulaN11.impostaStanzaAdiacente("ovest", atrio);
        this.biblioteca.impostaStanzaAdiacente("sud", atrio);
        
        this.atrio.addAttrezzo(osso);
        
        
	}
	//test stanza adiacente il primo direzione giusta,il secondo sbagliata, il terzo metto direzione null
	
	@Test 
	public void testGetStanzaAdiacenteDirezioneGiusta(){
		assertEquals(biblioteca,this.atrio.getStanzaAdiacente("nord"));
		
	}
	@Test
	public void testGetStanzaAziacenteDirezioneSbagliata(){
		assertNotSame(aulaN11,atrio.getStanzaAdiacente("nord"));
	}
	@Test
	public void testGetStanzaAdiacenteDirezioneNull(){
		assertNull(atrio.getStanzaAdiacente(""));
	}
	
	
	//test get Attrezzo,il primo ritorna l'attrezzo giusto, il secondo no, il terzo cerca uno null
	
	@Test
	public void testGetAttrezzoCorretto() {
		assertEquals(osso,atrio.getAttrezzo("osso"));
	}
	@Test
	public void testGetAttrezzoErrato() {
		assertNotEquals(lanterna,atrio.getAttrezzo("osso"));
	}
	@Test
	public void testGetAttrezzoNull() {
		assertNull(atrio.getAttrezzo(""));
	}
	
	
	//test remove attrezzo, la prima rimuove un attrezzo giusto, il secondo non rimuove, il terzo cerca di rimuovere null

	@Test
	public void testRemoveAttrezzoGiusto() {
		atrio.removeAttrezzo("osso");
		assertFalse(atrio.hasAttrezzo("osso"));
	}
	
	@Test
	public void testRemoveAttrezzoSbagliato() {
		atrio.removeAttrezzo("lanterna");
		assertFalse(atrio.hasAttrezzo("lanterna"));		
		assertTrue(atrio.hasAttrezzo("osso"));
	}
	
	@Test
	public void testRemoveAttrezzoNull() {
		atrio.removeAttrezzo(null);
		assertTrue(atrio.hasAttrezzo("osso"));
	}
	
	//test add attrezzo, ne aggiungo uno con successo, ne aggiungo uno in stanza piena, aggiungo null
	
	@Test
	public void testAddAttrezzoGiusto() {
		assertTrue(atrio.addAttrezzo(this.lanterna));
		assertTrue(atrio.hasAttrezzo("lanterna"));
	}
	

	/*public void testAddAttrezzoFallito() {			//non c'è più il limite sulla capienza della stanza
		atrio.addAttrezzo(this.lanterna);
		atrio.addAttrezzo(this.lanterna);
		atrio.addAttrezzo(this.lanterna);
		atrio.addAttrezzo(this.lanterna);
		atrio.addAttrezzo(this.lanterna);
		atrio.addAttrezzo(this.lanterna);
		atrio.addAttrezzo(this.lanterna);
		atrio.addAttrezzo(this.lanterna);
		atrio.addAttrezzo(this.lanterna);				//ora in stanza ci sono 10 attrezzi
		assertFalse(atrio.addAttrezzo(lanterna));
	}*/
	
	@Test
	public void testAddAttrezzoNull() {
		this.lanterna=null;
		assertFalse(atrio.addAttrezzo(lanterna));
	}
}

