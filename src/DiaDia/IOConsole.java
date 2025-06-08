package DiaDia;
import java.util.Scanner;

public class IOConsole implements IO{
	Scanner scannerDiLinee;
	
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}
	

	public String leggiRiga() {
		this.scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();
		//scannerDiLinee.close()
		return riga;
	}

	public void chiudiScanner() {
		
		this.scannerDiLinee.close();
	}
}