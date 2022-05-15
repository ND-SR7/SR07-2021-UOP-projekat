package biblioteka;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

public class Main {
	
	public static void main(String args[]) {
		Administrator admin = new Administrator();
		Bibliotekar bibliotekar = new Bibliotekar();
		
		Biblioteka biblioteka = ucitajBiblioteku();
		for(Clan clan: biblioteka.sviClanovi)
			System.out.println(clan.id);
		
		Clan clan1 = admin.dodajClana("Pera", "Peric", "1010001100011", "Perina 13, NS", EnumPol.Muško, LocalDate.now(), 2, true, EnumClanarina.Ostali);
		Clan clan2 = bibliotekar.dodajClana("Ivan", "Ivanovic", "2009005100011", "Perina 13, NS", EnumPol.Muško, LocalDate.now(), 2, true, EnumClanarina.Ostali);
		
		System.out.println(clan1.brClanskeKarte);
		System.out.println(clan2.brClanskeKarte);
	}
	
	public static Biblioteka ucitajBiblioteku() {
		File fajl = new File("data/biblioteka.txt");
		try {
			BufferedReader citac = new BufferedReader(new FileReader(fajl));
			
			String linija;
			
			while((linija = citac.readLine()) != null) {
				System.out.print(linija + ", ");
			}
			System.out.println();
			citac.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Fajl nije pronađen!");
		} catch (IOException e) {
			System.out.println("Greška kod I/O!");
		}
		
		return new Biblioteka();
	}
}
