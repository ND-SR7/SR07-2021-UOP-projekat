package biblioteka;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Biblioteka {
	
    protected String naziv;
    protected String adresa;
    protected String brTelefon;
    protected String radnoVreme;

    /*KONSTRUKTORI*/
    public Biblioteka() {
    	this.naziv = "";
    	this.adresa = "";
    	this.brTelefon = "";
    	this.radnoVreme = "";
    }
    
    public Biblioteka(String naziv, String adresa, String brTelefon, String radnoVreme) {
    	this.naziv = naziv;
    	this.adresa = adresa;
    	this.brTelefon = brTelefon;
    	this.radnoVreme = radnoVreme;
    }
    
    public Biblioteka(Biblioteka biblioteka) {
    	this.naziv = biblioteka.naziv;
    	this.adresa = biblioteka.adresa;
    	this.brTelefon = biblioteka.brTelefon;
    	this.radnoVreme = biblioteka.radnoVreme;
    }
    
    /*toString()*/
    @Override
    public String toString() {
    	return "Biblioteka: " + this.naziv;
    }
    
    /*PODACI IZ FAJLOVA*/
    protected ArrayList<Clan> sviClanovi = ucitajSveClanove();
    protected HashMap<String, Zanr> sviZanrovi = ucitajSveZanrove();
    protected ArrayList<Knjiga> sveKnjige = ucitajSveKnjige();
    protected ArrayList<PrimerakKnjige> sviPrimerciKnjiga = ucitajSvePrimerke();
    protected ArrayList<Zaposleni> sviZaposleni = ucitajSveZaposlene();

    /*FAJLOVI UČITAVANJE*/
    //SVI ČLANOVI
	private ArrayList<Clan> ucitajSveClanove() {
		File fajl = new File("data/clanovi.txt");
		ArrayList<Clan> sviClanovi = new ArrayList<Clan>();
		
		try {
			BufferedReader citac = new BufferedReader(new FileReader(fajl));
			
			String linija;
			
			while((linija = citac.readLine()) != null) {
				String[] temp = linija.split(",");
				Clan clan = new Clan(temp[1], temp[2], temp[3], temp[4], EnumPol.values()[Integer.parseInt(temp[5])], LocalDate.parse(temp[6]), 
						Integer.parseInt(temp[7]), Boolean.getBoolean(temp[8]), EnumClanarina.values()[Integer.parseInt(temp[9])]);
				sviClanovi.add(clan);
			}
			citac.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Fajl" + fajl.toString() +  "nije pronađen!");
		} catch (IOException e) {
			System.out.println("Greška kod I/O!");
		}

		return sviClanovi;
	}

	//SVI ŽANROVI
	private HashMap<String, Zanr> ucitajSveZanrove() {
		File fajl = new File("data/zanrovi.txt");
		HashMap<String, Zanr> sviZanrovi = new HashMap<String, Zanr>();
		
		try {
			BufferedReader citac = new BufferedReader(new FileReader(fajl));
			
			String linija;
			
			while((linija = citac.readLine()) != null) {
				String[] temp = linija.split(",");
				Zanr zanr = new Zanr(temp[0], temp[1]);
				sviZanrovi.put(temp[0], zanr);
			}
			citac.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Fajl" + fajl.toString() + "nije pronađen!");
		} catch (IOException e) {
			System.out.println("Greška kod I/O!");
		}
		
		return sviZanrovi;
	}

	//SVE KNJIGE
	private ArrayList<Knjiga> ucitajSveKnjige() {
		File fajl = new File("data/knjige.txt");
		ArrayList<Knjiga> sveKnjige = new ArrayList<Knjiga>();
		
		try {
			BufferedReader citac = new BufferedReader(new FileReader(fajl));
			
			String linija;
			
			while((linija = citac.readLine()) != null) {
				String[] temp = linija.split(",");
				Knjiga knjiga = new Knjiga(temp[1], temp[2], temp[3], Integer.parseInt(temp[4]), temp[5], sviZanrovi.get(temp[6]), EnumJezik.values()[Integer.parseInt(temp[7])]);
				sveKnjige.add(knjiga);
			}
			citac.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Fajl" + fajl.toString() + "nije pronađen!");
		} catch (IOException e) {
			System.out.println("Greška kod I/O!");
		}

		return sveKnjige;
	}
	
	//SVI PRIMERCI KNJIGA
	private ArrayList<PrimerakKnjige> ucitajSvePrimerke() {
		File fajl = new File("data/knjigePrimerci.txt");
		ArrayList<PrimerakKnjige> sviPrimerci = new ArrayList<PrimerakKnjige>();
		
		try {
			BufferedReader citac = new BufferedReader(new FileReader(fajl));
			
			String linija;
			
			while((linija = citac.readLine()) != null) {
				String[] temp = linija.split(",");
				PrimerakKnjige primerak = new PrimerakKnjige(Integer.parseInt(temp[1]), EnumTipPoveza.values()[Integer.parseInt(temp[2])], 
						Integer.parseInt(temp[3]), Boolean.getBoolean(temp[4]), sveKnjige.get(Integer.parseInt(temp[5]) - 1), 
						EnumJezik.values()[Integer.parseInt(temp[6])]);
				sviPrimerci.add(primerak);
			}
			citac.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Fajl" + fajl.toString() + "nije pronađen!");
		} catch (IOException e) {
			System.out.println("Greška kod I/O!");
		}

		return sviPrimerci;
	}
	
	//SVI ZAPOSLENI
	private ArrayList<Zaposleni> ucitajSveZaposlene() {
		File fajl = new File("data/zaposleni.txt");
		ArrayList<Zaposleni> sviZaposleni = new ArrayList<Zaposleni>();
		
		try {
			BufferedReader citac = new BufferedReader(new FileReader(fajl));
			
			String linija;
			Zaposleni zaposleni = null;
			
			while((linija = citac.readLine()) != null) {
				String[] temp = linija.split(",");
				switch(temp[1]) {
				case "A":
					zaposleni = new Administrator(temp[2], temp[3], temp[4], temp[5], EnumPol.values()[Integer.parseInt(temp[6])], 
							Double.parseDouble(temp[7]), temp[8], temp[9]);
				case "B":
					zaposleni = new Bibliotekar(temp[2], temp[3], temp[4], temp[5], EnumPol.values()[Integer.parseInt(temp[6])], 
							Double.parseDouble(temp[7]), temp[8], temp[9]);
				}
				
				sviZaposleni.add(zaposleni);
			}
			citac.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Fajl" + fajl.toString() + "nije pronađen!");
		} catch (IOException e) {
			System.out.println("Greška kod I/O!");
		}

		return sviZaposleni;
	}
}
