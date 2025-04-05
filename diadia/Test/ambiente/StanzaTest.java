package ambiente;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class StanzaTest {
	private Stanza stanzaIniziale;
	private Stanza stanzaNord;
	private Stanza stanzaSud;
	private Stanza stanzaOvest;
	private Stanza stanzaEst;
	private Stanza nuovastanza;
	
	@BeforeEach
	public void setUp() {
		this.stanzaIniziale=new Stanza("stanzaIniziale",2,0);
		//this.stanzaEst=new Stanza("stanzaEst",1,0);
		//this.stanzaOvest=new Stanza("stanzaOvest",1,0);
		this.stanzaSud=new Stanza("stanzaSud",1,0);
		this.stanzaNord=new Stanza("stanzaNord",1,0);
	
	}
	@Test 
	public void testImpostaStanzaAdiacenteSTANZA_ESISTENTE(){
		stanzaIniziale.impostaStanzaAdiacente("ovest",nuovastanza);	//push di nuova stanza
		assertSame(nuovastanza,stanzaIniziale.getStanzaAdiacente("ovest"));			//provo a mettere
	}
}
