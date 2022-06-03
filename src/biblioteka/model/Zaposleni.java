package biblioteka.model;

import java.time.LocalDate;

public abstract class Zaposleni extends Osoba {
    
    protected final int id;
    protected double plata;
    protected String korisnickoIme;
    protected String lozinka;
    protected boolean obrisan;
    
    /*KONSTRUKTORI*/
    public Zaposleni() {
    	super();
    	this.id = -1;
    	this.plata = 0.0;
    	this.korisnickoIme = "";
    	this.lozinka = "";
    	this.obrisan = false;
    }

    public Zaposleni(String ime, String prezime, String JMBG, String adresa, EnumPol pol, double plata, String korisnickoIme, String lozinka, boolean obrisan) {
		super(ime, prezime, JMBG, adresa, pol);
		this.id = postaviID();
		this.plata = plata;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.obrisan = obrisan;
	}

    public Zaposleni(Zaposleni zaposleni) {
    	super(zaposleni);
    	this.id = postaviID();
    	this.plata = zaposleni.plata;
		this.korisnickoIme = zaposleni.korisnickoIme;
		this.lozinka = zaposleni.lozinka;
		this.obrisan = zaposleni.obrisan;
    }
    
    /*GET SET*/
    public double getPlata() {
		return plata;
	}

	public void setPlata(double plata) {
		this.plata = plata;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public int getId() {
		return id;
	}
	
	public boolean isObrisan() {
		return obrisan;
	}
	
	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}

	public abstract String getUloga();

	/*GENERATOR JEDINSTVENIH ID-a*/
    private static int idBrojac = 0;

    public static int postaviID()
    {
        return ++idBrojac;
    }

    /**CRUD**/
    /*CREATE*/
    
    //ČLAN
	public Clan dodajClana() {
        Clan noviClan = new Clan();
		
		return noviClan;
    }
	
	public Clan dodajClana(String ime, String prezime, String JMBG, String adresa, EnumPol pol, LocalDate datumPoslednjeUplate, int brMeseciClanarine, 
    		boolean aktivan, EnumClanarina tipClanarine) {
        Clan noviClan = new Clan(ime, prezime, JMBG, adresa, pol, datumPoslednjeUplate, brMeseciClanarine, aktivan, tipClanarine, false);
		
		return noviClan;
    }
	
	public Clan dodajClana(Clan clan) {
        Clan noviClan = new Clan(clan);
		
		return noviClan;
    }
	
	//IZNAJMLJIVANJE
	public IznajmljivanjeKnjige dodajIznajmljivanje() {
		IznajmljivanjeKnjige novoIznajmljivanje = new IznajmljivanjeKnjige();
		
		return novoIznajmljivanje;
	}
	
	public IznajmljivanjeKnjige dodajIznajmljivanje(LocalDate datumIznajmljivanja, LocalDate datumVracanja, PrimerakKnjige iznajmljenPrimerak, Clan clan, Zaposleni zaposleni,
												boolean obrisano) {
		IznajmljivanjeKnjige novoIznajmljivanje = new IznajmljivanjeKnjige(datumIznajmljivanja, datumVracanja, iznajmljenPrimerak, clan, zaposleni, obrisano);
		
		return novoIznajmljivanje;
	}
	
	//KNJIGA
	public Knjiga dodajKnjigu() {
		Knjiga novaKnjiga = new Knjiga();
		
		return novaKnjiga;
	}
	
	public Knjiga dodajKnjigu(String naslov, String originalniNaslov, String pisacImePrezime, int godinaObjavljivanja, String opis, Zanr zanr, EnumJezik jezikOriginala, 
							boolean obrisana) {
		Knjiga novaKnjiga = new Knjiga(naslov, originalniNaslov, pisacImePrezime, godinaObjavljivanja, opis, zanr, jezikOriginala, obrisana);
		
		return novaKnjiga;
	}
	
	//PRIMERAK KNJIGE
	public PrimerakKnjige dodajPrimerak() {
		PrimerakKnjige noviPrimerak = new PrimerakKnjige();
		
		return noviPrimerak;
	}
	
	public PrimerakKnjige dodajPrimerak(int brojStrana, EnumTipPoveza tipPoveza, int godinaStampanja, boolean iznajmljen, Knjiga knjiga, EnumJezik jezikStampanja, boolean obrisan) {
		PrimerakKnjige noviPrimerak = new PrimerakKnjige(brojStrana, tipPoveza, godinaStampanja, iznajmljen, knjiga, jezikStampanja, obrisan);
		
		return noviPrimerak;
	}
	
	//ŽANR
	public Zanr dodajZanr() {
		Zanr noviZanr = new Zanr();
		
		return noviZanr;
	}
	
	public Zanr dodajZanr(String oznaka, String opis, boolean obrisan) {
		Zanr noviZanr = new Zanr(oznaka, opis, obrisan);
		
		return noviZanr;
	}
	
	/*DELETE*/
	
	//ČLAN
	public void obrisiClana(Clan clan) {
		clan.setObrisan(true);
	}
	
	//IZNAJMLJIVANJE
	public void obrisiIznajmljivanje(IznajmljivanjeKnjige iznajmljivanje) {
		iznajmljivanje.setObrisano(true);
	}
	
	//KNJIGA
	public void obrisiKnjigu(Knjiga knjiga) {
		knjiga.setObrisana(true);
	}
	
	//PRIMERAK KNJIGE
	public void obrisiPrimerak(PrimerakKnjige primerak) {
		primerak.setObrisan(true);
	}
	
	//ŽANR
	public void obrisiZanr(Zanr zanr) {
		zanr.setObrisan(true);
	}
}
