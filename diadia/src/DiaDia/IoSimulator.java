package DiaDia;

public class IoSimulator implements IO{
	private String[] comandi;
	private String[] messaggi;
	private int indComandi;
	private int indMessaggi;
	private static final int MAX_COMANDI=50;
	
	
	public IoSimulator(String[] comandiDaLeggere) {
		this.comandi=comandiDaLeggere;
		this.messaggi=new String[MAX_COMANDI];
		this.indComandi=0;
		this.indMessaggi=0;
	}
	@Override
	public void mostraMessaggio(String messaggio) {
		if(indMessaggi<MAX_COMANDI) {
			this.messaggi[indMessaggi++]=messaggio;
		}
		
	}
	@Override
	public String leggiRiga() {										//ritorna il comando al prossimo indice
		if(indComandi<this.comandi.length) {
			return this.comandi[indComandi++];
		} else return null;
	}
	public int getIndComandi() {
		return this.indComandi;
	}
	public int getIndMessaggi() {
		return this.indMessaggi;
	}
	public void setIndComandi(int x) {
		this.indComandi=x;
	}
	public void setIndMessaggi(int x) {
		this.indMessaggi=x;
	}
}
