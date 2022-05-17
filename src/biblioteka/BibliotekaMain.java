package biblioteka;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class BibliotekaMain {
	
	public static void main(String args[]) {
		Biblioteka biblioteka = ucitajBiblioteku();
		ispis(biblioteka);
		
		biblioteka.upisiBiblioteku();
		biblioteka.upisiSveClanove();
		biblioteka.upisiSveKnjige();
		biblioteka.upisiSvePrimerke();
		biblioteka.upisiSveZanrove();
		biblioteka.upisiSveZaposlene();
	}
	
	public static Biblioteka ucitajBiblioteku() {
		File fajl = new File("data/biblioteka.txt");
		ArrayList<String> sveLinije = new ArrayList<String>();
		try {
			BufferedReader citac = new BufferedReader(new FileReader(fajl));
			
			String linija;
			
			while((linija = citac.readLine()) != null) {
				sveLinije.add(linija);
			}
			System.out.println();
			citac.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Fajl nije pronađen!");
		} catch (IOException e) {
			System.out.println("Greška kod I/O!");
		}
		
		return new Biblioteka(sveLinije.get(0), sveLinije.get(1), sveLinije.get(2), sveLinije.get(3));
	}
	
	public static void ispis(Biblioteka biblioteka) {
		System.out.println("***BIBLIOTEKA***");
		System.out.println(biblioteka.getNaziv() + ", " + biblioteka.getAdresa() + "\n" + "Kontakt: " + biblioteka.getBrTelefon() + "\n" 
				+ "Radno vreme: " + biblioteka.getRadnoVreme() + "\n");
		
		System.out.println("***ČLANOVI***");
		for(Clan clan: biblioteka.getSviClanovi())
			System.out.println(clan + ", " +  clan.getBrClanskeKarte());
		System.out.println("\n");
		
		System.out.println("***KNJIGE***");
		for(Knjiga knjiga: biblioteka.getSveKnjige())
			System.out.println(knjiga + ", " +  knjiga.getPisacImePrezime());
		System.out.println("\n");
		
		System.out.println("***PRIMERCI KNJIGA***");
		for(PrimerakKnjige primerak: biblioteka.getSviPrimerciKnjiga())
			System.out.println(primerak + ", " + "na jeziku: " +  primerak.getJezikStampanja() + ", štampano: " + Integer.toString(primerak.getGodinaStampanja()));
		System.out.println("\n");
		
		System.out.println("***DOSTUPNI ŽANROVI***");
		for(HashMap.Entry<String, Zanr> set: biblioteka.getSviZanrovi().entrySet())
			System.out.println("-" + set.getValue());
		System.out.println("\n");
		
		System.out.println("***ZAPOSLENI U BIBLIOTECI***");
		for(Zaposleni zaposleni: biblioteka.getSviZaposleni())
			System.out.println(zaposleni);
		System.out.println("\n");
	}
}
