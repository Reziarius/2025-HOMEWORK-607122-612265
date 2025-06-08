package ambiente;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import attrezzi.Attrezzo;

class StanzaBloccataTest {
	private StanzaBloccata PetiteLondo;
	private Stanza abisso;
	private Stanza fireLink;
	private Attrezzo pattoDiArtorias;

	
	@BeforeEach
	public void setUp() {
		PetiteLondo=new StanzaBloccata("PetiteLondo","sud","pattoDiArtorias");
		abisso=new Stanza("abisso");
		fireLink=new Stanza("fireLink");
		abisso.impostaStanzaAdiacente("nord", PetiteLondo);				//Abisso stanza da raggiungere mediante stanzaBloccata
		PetiteLondo.impostaStanzaAdiacente("sud", abisso);
		PetiteLondo.impostaStanzaAdiacente("nord", fireLink);
		fireLink.impostaStanzaAdiacente("sud", PetiteLondo);
	}
	
	@Test
	void testGetStanzaAdiacenteBuona() {
		assertEquals(this.PetiteLondo.getStanzaAdiacente("nord"),fireLink);
	}
	@Test
	void testGetStanzaAdiacenteBloccata() {
		assertEquals(PetiteLondo.getStanzaAdiacente("sud"),PetiteLondo);
	}
	@Test
	void testGetStanzaAdiacenteBloccataSbloccata() {
		pattoDiArtorias=new Attrezzo("pattoDiArtorias",1);
		PetiteLondo.addAttrezzo(pattoDiArtorias);
		assertEquals(this.PetiteLondo.getStanzaAdiacente("sud"),abisso);
	}
	@Test
	void testGetDescrizioneConStanzaBloccata() {
		PetiteLondo.getDescrizione();
	}
	
	@Test
	void testGetDescrizioneDopoSblocco() {
	    PetiteLondo.addAttrezzo(new Attrezzo("pattoDiArtorias", 1));
	    String descrizione = PetiteLondo.getDescrizione();
	    assertFalse(descrizione.contains("è bloccata"));
	    assertTrue(descrizione.contains("PetiteLondo"));
	}
	@Test
	void testSbloccoAttrezzoRimosso() {
	    Attrezzo attrezzo = new Attrezzo("pattoDiArtorias", 1);
	    PetiteLondo.addAttrezzo(attrezzo);
	    assertEquals(PetiteLondo.getStanzaAdiacente("sud"), abisso); // sbloccato

	    PetiteLondo.removeAttrezzo("pattoDiArtorias"); // rimosso
	    assertEquals(PetiteLondo.getStanzaAdiacente("sud"), PetiteLondo); // torna bloccata
	}


}
