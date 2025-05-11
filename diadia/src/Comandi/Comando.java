package Comandi;

import DiaDia.Partita;
import DiaDia.IO;

public interface Comando {
	/**
	 * esecuzione del comando
	 */
	
	public void esegui (Partita partita, IO io);
	
	/**
	 * set paramentro del comando
	 */
	
	public void setParametro(String Parametro);
	
	/*
	 * FUNZIONI GETTER
	 */
	
	public String getNome();
	
	public String getParametro();
}
