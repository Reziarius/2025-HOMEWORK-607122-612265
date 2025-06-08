package DiaDia;
import ambiente.CaricatoreLabirinto;
import ambiente.Labirinto;
import java.util.Scanner;

import Comandi.Comando;
import Comandi.FabbricaDiComandiFisarmonica;
import Comandi.FabbricaDiComandiRiflessiva;
import ambiente.Labirinto;

import ambiente.Stanza;
import attrezzi.Attrezzo;
import Comandi.FabbricaDiComandi;
import ambiente.FormatoFileNonValidoException;
import java.io.FileNotFoundException;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il metodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author Scoderoni,Benedetti
 *          
 * @version 1.0
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.\n\n"+
			"Stanza attuale:\n";
	
	//static final private String[] elencoComandi = {"vai", "aiuto","prendi","posa", "fine"};

	private Partita partita;
	
	private IO io;

	
	public DiaDia(Labirinto l,IO io) {
		this.partita = new Partita(l);
		this.io = io;
	}

/*mtodo che cicla finche hai una istruzione da eseguire
 * 
 * 
 */
	public void gioca() {
		this.io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		
		this.io.mostraMessaggio(this.partita.getStanzaCorrente().getDescrizione());
		
		String istruzione;
			
		do		
			istruzione = this.io.leggiRiga();			//memorizzo il comando di scanner in istruzione
		while (!processaIstruzione(istruzione));				//continuo finchè ho comandi validi		

		}  
/*metodo che crea comandi a partire da una istruzione 
 * 
 * 
 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandiRiflessiva();
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita,this.io);
		if (this.partita.vinta()) {
			io.mostraMessaggio("Hai vinto!");
		}
			
		if (!this.partita.giocatoreIsVivo()) {
			io.mostraMessaggio("Hai esaurito i CFU...");
		}
		return this.partita.isFinita();
		}
	
	
	/*main del game
	 * 
	 */
	public static void main(String[] argc) throws FileNotFoundException, FormatoFileNonValidoException { 
		String nomeFile = "resources/labirinto1.txt";
		
		CaricatoreLabirinto caricatore = new CaricatoreLabirinto(nomeFile);
		Labirinto labirinto = caricatore.getLabirinto();
				
		IO io=new IOConsole();
		DiaDia gioco = new DiaDia(labirinto,io);
		gioco.gioca();
		gioco.getIOConsole().chiudiScanner();
	}

	public IOConsole getIOConsole() {
		return (IOConsole) this.io;
	}
}