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
}
