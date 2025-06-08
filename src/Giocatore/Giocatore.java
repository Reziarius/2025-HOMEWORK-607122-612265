package Giocatore;

/*Classe che modella il personaggio del game, ha un riferimento alla borsa e ai cfu attuali
 * @author Scoderoni,Benedetti
 * @version 1.0
 */

public class Giocatore {
	static final private int CFU_INIZIALI = 20;
	private int cfu;
    private Borsa borsa;
   

   public Giocatore() {
       this.borsa = new Borsa(); 			// inizializza Borsa per il giocatore
       this.cfu=CFU_INIZIALI;
   }
   
   //////////FUNZIONI GETTER////////
   public String getDescrizione() {
	   return this.toString();
   }
  
   public int getCfu() {
       return this.cfu;
   }
    
   public Borsa getBorsa() {
       return borsa;
   }
   
   
   
   ///////////FUNZIONI SETTER////////
   
   
   
   public void setCfu(int cfu) {
       this.cfu = cfu;
   }

   

   public void setBorsa(Borsa borsa) {
       this.borsa = borsa;
   }
   
   public String toString() {							//stampa le informazioni relative all giocatore 
	   StringBuilder risultato=new StringBuilder();
	   risultato.append("Numero di cfu attuale : "+ this.cfu + "\n");			//stampa i cfu attuali
	   risultato.append("Peso borsa: "+  this.borsa.getPeso()); 	//stampa le informazioni relative alla borsa					 
	   risultato.append("\n"+this.borsa.toString());				
	   return risultato.toString();
   }
}
