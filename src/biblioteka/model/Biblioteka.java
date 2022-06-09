package biblioteka.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
    
    /*GET SET*/
    public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getBrTelefon() {
		return brTelefon;
	}

	public void setBrTelefon(String brTelefon) {
		this.brTelefon = brTelefon;
	}

	public String getRadnoVreme() {
		return radnoVreme;
	}

	public void setRadnoVreme(String radnoVreme) {
		this.radnoVreme = radnoVreme;
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
    protected ArrayList<IznajmljivanjeKnjige> sveIznajmljivanje = ucitajSveIznajmljivanje();
    
    /*GET*/
    public ArrayList<Clan> getSviClanovi() {
		return sviClanovi;
	}

	public HashMap<String, Zanr> getSviZanrovi() {
		return sviZanrovi;
	}

	public ArrayList<Knjiga> getSveKnjige() {
		return sveKnjige;
	}

	public ArrayList<PrimerakKnjige> getSviPrimerciKnjiga() {
		return sviPrimerciKnjiga;
	}

	public ArrayList<Zaposleni> getSviZaposleni() {
		return sviZaposleni;
	}

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
						Integer.parseInt(temp[7]), Boolean.valueOf(temp[8]), EnumClanarina.values()[Integer.parseInt(temp[9])], Boolean.valueOf(temp[10]));
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
				Zanr zanr = new Zanr(temp[0], temp[1], Boolean.valueOf(temp[2]));
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
				Knjiga knjiga = new Knjiga(temp[1], temp[2], temp[3], Integer.parseInt(temp[4]), temp[5], sviZanrovi.get(temp[6]), EnumJezik.values()[Integer.parseInt(temp[7])], 
										Boolean.valueOf(temp[8]));
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
						Integer.parseInt(temp[3]), Boolean.valueOf(temp[4]), sveKnjige.get(Integer.parseInt(temp[5]) - 1), 
						EnumJezik.values()[Integer.parseInt(temp[6])], Boolean.valueOf(temp[7]));
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
							Double.parseDouble(temp[7]), temp[8], temp[9], Boolean.valueOf(temp[10]));
					break;
				case "B":
					zaposleni = new Bibliotekar(temp[2], temp[3], temp[4], temp[5], EnumPol.values()[Integer.parseInt(temp[6])], 
							Double.parseDouble(temp[7]), temp[8], temp[9], Boolean.valueOf(temp[10]));
					break;
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
	
	//SVE IZNAJMLJIVANJE
	private ArrayList<IznajmljivanjeKnjige> ucitajSveIznajmljivanje(){
		File fajl = new File("data/iznajmljivanje-log.txt");
		ArrayList<IznajmljivanjeKnjige> sveIznajmljivanje = new ArrayList<IznajmljivanjeKnjige>();
		
		try {
			BufferedReader citac = new BufferedReader(new FileReader(fajl));
			
			String linija;
			
			while((linija = citac.readLine()) != null) {
				String[] temp = linija.split(",");
				IznajmljivanjeKnjige iznajmljivanje = new IznajmljivanjeKnjige(LocalDate.parse(temp[0]), LocalDate.parse(temp[1]),
						sviPrimerciKnjiga.get(Integer.parseInt(temp[2]) - 1), sviClanovi.get(Integer.parseInt(temp[3]) - 1),
						sviZaposleni.get(Integer.parseInt(temp[4]) - 1), Boolean.valueOf(temp[5]));
				
				sveIznajmljivanje.add(iznajmljivanje);
			}
			citac.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Fajl " + fajl.toString() + " nije pronađen!");
		} catch (IOException e) {
			System.out.println("Greška kod I/O!");
		}

		return sveIznajmljivanje;
	}
	
	/*FAJLOVI PISANJE*/
	//BIBLIOTEKA
	public void upisiBiblioteku() {
		try {
			File fajl = new File("data/biblioteka.txt");
			BufferedWriter pisac = new BufferedWriter(new FileWriter(fajl));
			
			pisac.write(this.naziv + "\n" + this.adresa + "\n" + this.brTelefon + "\n" + this.radnoVreme + "\n");
			pisac.close();
		} catch (IOException e) {
			System.out.println("Greška prilikom pisanja u biblioteka.txt");
		}
	}
	
	//ČLANOVI
	public void upisiSveClanove() {
		try {
			File fajl = new File("data/clanovi.txt");
			BufferedWriter pisac = new BufferedWriter(new FileWriter(fajl));
			
			for(Clan clan: sviClanovi)
				pisac.write(Integer.toString(clan.getId()) + "," + clan.getIme() + "," + clan.getPrezime() + "," + clan.getJMBG() + "," + 
						clan.getAdresa() + "," + Integer.toString(clan.getPol().ordinal()) + "," + clan.getDatumPoslednjeUplate().toString() + "," + 
						Integer.toString(clan.getBrMeseciClanarine()) + "," + Boolean.toString(clan.isAktivan()) + "," + Integer.toString(clan.getTipClanarine().ordinal()) 
						+ "," + Boolean.toString(clan.isObrisan()) + "\n");
			
			pisac.close();
		} catch (IOException e) {
			System.out.println("Greška prilikom pisanja u clanovi.txt");
		}
	}
	
	//KNJIGE
	public void upisiSveKnjige() {
		try {
			File fajl = new File("data/knjige.txt");
			BufferedWriter pisac = new BufferedWriter(new FileWriter(fajl));
			
			for(Knjiga knjiga: sveKnjige)
				pisac.write(Integer.toString(knjiga.getId()) + "," + knjiga.getNaslov() + "," + knjiga.getOriginalniNaslov() + "," + knjiga.getPisacImePrezime() + ","
						+ Integer.toString(knjiga.getGodinaObjavljivanja()) + "," + knjiga.getOpis() + "," + knjiga.getZanr().getOznaka() + "," + 
						Integer.toString(knjiga.getJezikOriginala().ordinal()) + "," + Boolean.toString(knjiga.isObrisana()) + "\n");
			
			pisac.close();
		} catch (IOException e) {
			System.out.println("Greška prilikom pisanja u knjige.txt");
		}
	}
	
	//PRIMERCI KNJIGE
	public void upisiSvePrimerke() {
		try {
			File fajl = new File("data/knjigePrimerci.txt");
			BufferedWriter pisac = new BufferedWriter(new FileWriter(fajl));
			
			for(PrimerakKnjige primerak: sviPrimerciKnjiga)
				pisac.write(Integer.toString(primerak.getId()) + "," + Integer.toString(primerak.getBrojStrana()) + "," + 
						Integer.toString(primerak.getTipPoveza().ordinal()) + "," + Integer.toString(primerak.getGodinaStampanja()) + "," + 
						Boolean.toString(primerak.isIznajmljen()) + "," + Integer.toString(primerak.getKnjiga().getId()) + "," + 
						Integer.toString(primerak.getJezikStampanja().ordinal()) + "," + Boolean.toString(primerak.isObrisan()) + "\n");
			
			pisac.close();
		} catch (IOException e) {
			System.out.println("Greška prilikom pisanja u knjigePrimerci.txt");
		}
	}
	
	//ŽANROVI
	public void upisiSveZanrove() {
		try {
			File fajl = new File("data/zanrovi.txt");
			BufferedWriter pisac = new BufferedWriter(new FileWriter(fajl));
			
			for(HashMap.Entry<String, Zanr> set: sviZanrovi.entrySet())
				pisac.write(set.getKey() + "," + set.getValue().toString() + "," + Boolean.toString(set.getValue().isObrisan()) + "\n");
			
			pisac.close();
		} catch (IOException e) {
			System.out.println("Greška prilikom pisanja u zanrovi.txt");
		}
	}
	
	//ZAPOSLENI
	public void upisiSveZaposlene() {
		try {
			File fajl = new File("data/zaposleni.txt");
			BufferedWriter pisac = new BufferedWriter(new FileWriter(fajl));
			
			for(Zaposleni zaposleni: sviZaposleni) 
				pisac.write(Integer.toString(zaposleni.getId()) + "," + zaposleni.getUloga() + "," + zaposleni.getIme() + "," + zaposleni.getPrezime() + "," 
						+ zaposleni.getJMBG() + "," + zaposleni.getAdresa() + "," + Integer.toString(zaposleni.getPol().ordinal()) + "," + 
						Double.toString(zaposleni.getPlata()) + "," + zaposleni.getKorisnickoIme() + "," + zaposleni.getLozinka() + "," +
						Boolean.toString(zaposleni.isObrisan())+ "\n");
				
			pisac.close();
		} catch (IOException e) {
			System.out.println("Greška prilikom pisanja u zaposleni.txt");
		}
	}
	
	//IZNAJMLJIVANJE
	public void upisiSveIznajmljivanje() {
		try {
			File fajl = new File("data/iznajmljivanje-log.txt");
			BufferedWriter pisac = new BufferedWriter(new FileWriter(fajl));
			
			for(IznajmljivanjeKnjige iznajmljivanje: sveIznajmljivanje) 
				pisac.write(iznajmljivanje.getDatumIznajmljivanja().toString() + "," + iznajmljivanje.getDatumVracanja().toString() + "," + 
						Integer.toString(iznajmljivanje.getIznajmljenPrimerak().getId()) + "," + Integer.toString(iznajmljivanje.getClan().getId()) + "," + 
						Integer.toString(iznajmljivanje.getZaposleni().getId()) + "," + Boolean.toString(iznajmljivanje.isObrisano()));
				
			pisac.close();
		} catch (IOException e) {
			System.out.println("Greška prilikom pisanja u iznajmljivanje-log.txt");
		}
	}

	/*VALIDACIJA*/
	public Zaposleni proveriLogin(String korisnickoIme, String lozinka) {
		for(Zaposleni zaposleni: sviZaposleni) {
			if(zaposleni.getKorisnickoIme().equals(korisnickoIme) && zaposleni.getLozinka().equals(lozinka))
				return zaposleni;
		}	
		return null;
	}
}
