package DiaDia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Comandi.Comando;
import Comandi.FabbricaDiComandi;
import Comandi.FabbricaDiComandiFisarmonica;
import DiaDia.Partita;
class IoSimulatorTest {
	private IO iosim;
	private Partita partita;
	private String[] comandiAttuali;
	private FabbricaDiComandi factory;
	private Comando comandoDaEseguire;
	
	
	
	
	/*TEST DA RIVEDERE*/
	
	@BeforeEach
	public void setUp() {
		comandiAttuali= {"vai sud","vai nord"};
		iosim=new IoSimulator(comandiAttuali);
		factory=new FabbricaDiComandiFisarmonica();
		partita=new Partita();
	}
		
	@Test
	public void testPartitaFinitiCfu() {
		for(int i=0; i<20;i++) {
			this.comandoDaEseguire=this.factory.costruisciComando(this.iosim.leggiRiga());		//creocomando da comando predefinito
			comandoDaEseguire.esegui(partita, iosim);
			if(this.iosim.getIndComandi==1) {													//resetto il comando a 0 
				this.iosim.setIndComandi=0;
			}
		}
		assertEquals(partita.getGiocatore().getCfu(),0);
	}

}
