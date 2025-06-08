package ambiente;
import attrezzi.Attrezzo;
public class StanzaMagica extends Stanza{
	final static private int SOGLIA_MAGICA_DEFAULT = 3;
	private int contatoreAttrezziPosati;
	private int sogliaMagica;
	
	
	public StanzaMagica(String nome) {				//costruttore con sola stringa del nome
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}
	
	public StanzaMagica(String nome, int soglia) {
		super(nome);									//usa costruttre della superclasse
		this.contatoreAttrezziPosati = 0;
		this.sogliaMagica = soglia;
	}
	
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		this.contatoreAttrezziPosati++;
		
		if (this.contatoreAttrezziPosati>this.sogliaMagica)
			attrezzo = this.modificaAttrezzo(attrezzo);
		
		return super.addAttrezzo(attrezzo);		//stampa in ogni caso
	}
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso() * 2;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		attrezzo = new Attrezzo(nomeInvertito.toString(),
		pesoX2);
		return attrezzo;
	}
	
	public boolean isMagica() {
		return true;
	}
}
