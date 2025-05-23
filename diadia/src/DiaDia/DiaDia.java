package DiaDia;

import java.util.Scanner;

import Comandi.Comando;
import Comandi.FabbricaDiComandiFisarmonica;
import ambiente.Stanza;
import attrezzi.Attrezzo;
import Comandi.FabbricaDiComandi;

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

	
	
	
	
	public DiaDia(IO io) {
		this.partita = new Partita();
		this.io = io;
	}

	public void gioca() {
		this.io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		
		this.io.mostraMessaggio(this.partita.getStanzaCorrente().getDescrizione());
		
		String istruzione;
			
		do		
			istruzione = this.io.leggiRiga();			//memorizzo il comando di scanner in istruzione
		while (!processaIstruzione(istruzione));				//continuo finchè ho comandi validi		

		}  


	/**
	 * Processa una istruzione
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
  

	/*private boolean processaIstruzione(String istruzione) {
        Comando comandoDaEseguire = new Comando(istruzione);

        if (comandoDaEseguire.getNome().equals("fine")) {
            this.fine(); 
            return true;
        } else if (comandoDaEseguire.getNome().equals("vai"))
            this.vai(comandoDaEseguire.getParametro());
        else if (comandoDaEseguire.getNome().equals("aiuto"))
            this.aiuto();
        else if (comandoDaEseguire.getNome().equals("prendi"))
            this.prendi(comandoDaEseguire.getParametro());
        else if (comandoDaEseguire.getNome().equals("posa"))
            this.posa(comandoDaEseguire.getParametro());
        else
            this.IO.mostraMessaggio("Comando sconosciuto");;
        if (this.partita.vinta()) {
            this.IO.mostraMessaggio("Hai vinto!");
            return true;
        } else
            return false;
    }*/
	
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica();
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
	

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	/*private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			this.io.mostraMessaggio(elencoComandi[i]+" ");
		this.io.mostraMessaggio("\n");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	/*private void vai(String direzione) {
		if(direzione==null)
			this.io.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			this.io.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);	
			int cfu=this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(--cfu);
		}
		this.io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}
	
	/*Metodo prendi, prende un attrezzo dalla stanza e lo mette in borsa.
	 * @param prende la stringa nome dell'attrezzo da posare
	 * @return ritorna void 
	 * 
	 * 
	 */

	/*private void prendi(String nomeAttrezzo) {
        if (nomeAttrezzo == null) {
        	this.io.mostraMessaggio("Quale attrezzo vuoi prendere?");
            return;
        }

        Stanza stanzaCorrente = this.partita.getStanzaCorrente();
        Attrezzo attrezzo = stanzaCorrente.getAttrezzo(nomeAttrezzo);

        if (attrezzo == null) {
        	this.io.mostraMessaggio("Attrezzo non presente nella stanza.");
        } else {
            if (this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo)) {
                stanzaCorrente.removeAttrezzo(nomeAttrezzo);
                this.io.mostraMessaggio("Hai preso: " + nomeAttrezzo);
            } else {
            	this.io.mostraMessaggio("Borsa piena! Non puoi prendere l'attrezzo.");
            }
        }
    }
	
	/*Metodo che posa un attrezzo dalla borsa e lo aggiunge alla classe Stanza
	 * @param prende la stringa nome dell'attrezzo
	 * @return ritorna void 
	 */
	
	/*private void posa(String nomeAttrezzo) {
        if(nomeAttrezzo == null) {
        	this.io.mostraMessaggio("quale attrezzo vuoi prender dalla borsa?");
            return; 				
        }

        Stanza stanzaCorrente = this.partita.getStanzaCorrente();
        Attrezzo attrezzo = this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);

        if(attrezzo == null) {
        	this.io.mostraMessaggio("Attrezzo non presente nella borsa.");
            return;
        }

        if (this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo)) {			//se ho rimosso correttamente dalla borsa l'attrezzo 
        	
        	if (stanzaCorrente.addAttrezzo(attrezzo)) {										//provo a inserirlo in stanza, fallisce se stanza è piena 
        		this.io.mostraMessaggio("Hai posato: " + nomeAttrezzo);
            } else {
                // Se la stanza non può contenere più attrezzi, rimetto l'attrezzo nella borsa
                this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
                this.io.mostraMessaggio("Non puoi posare l'attrezzo: la stanza è piena.");
            }
        }else {
        	this.io.mostraMessaggio("Errore nel posare l'attrezzo.");							//se fallisco a posare 
            }
     }

	/**
	 * Comando "Fine".
	 */
	/*private void fine() {
		this.io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}*/

	public static void main(String[] argc) {
		IO io = new IOConsole();
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
	}
}