package biblioteka;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		Administrator admin = new Administrator();
		Bibliotekar bibliotekar = new Bibliotekar();
		
		Clan clan1 = admin.dodajClana("Pera", "Peric", "1010001100011", "Perina 13, NS", EnumPol.Muško, LocalDate.now(), 2, true, EnumClanarina.Ostali);
		Clan clan2 = bibliotekar.dodajClana("Ivan", "Ivanovic", "2009005100011", "Perina 13, NS", EnumPol.Muško, LocalDate.now(), 2, true, EnumClanarina.Ostali);
		
		System.out.println(clan1.brClanskeKarte);
		System.out.println(clan2.brClanskeKarte);
	}
}
