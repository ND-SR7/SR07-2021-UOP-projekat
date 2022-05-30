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

    /*CRUD*/
    //CREATE
    
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
	
	//DELETE
	
	//ČLAN
	public void obrisiClana(Clan clan) {
		clan.setObrisan(true);
	}
}
