package ambiente;

public class StanzaBuia extends Stanza {
	static final private String descrizione="qui c'è buio pesto";
	private String AttrezzoLuce;
	
	public StanzaBuia(String nome,String attrezzo) {
		super(nome);
		this.AttrezzoLuce=attrezzo;
	}
	public StanzaBuia(String nome) {
		this(null,nome);
	}
	@Override
	public String getDescrizione() {
		if(!super.hasAttrezzo(AttrezzoLuce)) {
			return descrizione;
		}else {
			return super.getDescrizione();
		}
	}
}
