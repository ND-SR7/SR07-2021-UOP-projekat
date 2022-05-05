package biblioteka;

import java.time.LocalDate;

public abstract class Zaposleni extends Osoba {
    
    protected final int id;
    protected double plata;
    protected String korisnickoIme;
    protected String lozinka;
    
    /*KONSTRUKTORI*/
    public Zaposleni() {
    	super();
    	this.id = 0;
    	this.plata = 0.0;
    	this.korisnickoIme = "";
    	this.lozinka = "";
    }

    public Zaposleni(String ime, String prezime, String JMBG, String adresa, EnumPol pol, double plata, String korisnickoIme, String lozinka) {
		super(ime, prezime, JMBG, adresa, pol);
		this.id = postaviID();
		this.plata = plata;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
	}

    public Zaposleni(Zaposleni zaposleni) {
    	super(zaposleni);
    	this.id = postaviID();
    	this.plata = zaposleni.plata;
		this.korisnickoIme = zaposleni.korisnickoIme;
		this.lozinka = zaposleni.lozinka;
    }
    
    /*GENERATOR JEDINSTVENIH ID-a*/
    private static int idBrojac = 0;

    public static int postaviID()
    {
        return idBrojac++;
    }    

    /*METODE*/
	public Clan dodajClana() {
        Clan noviClan = new Clan();
		
		return noviClan;
    }
	
	public Clan dodajClana(String ime, String prezime, String JMBG, String adresa, EnumPol pol, LocalDate datumPoslednjeUplate, int brMeseciClanarine, 
    		boolean aktivan, EnumClanarina tipClanarine) {
        Clan noviClan = new Clan(ime, prezime, JMBG, adresa, pol, datumPoslednjeUplate, brMeseciClanarine, aktivan, tipClanarine);
		
		return noviClan;
    }
	
	public Clan dodajClana(Clan clan) {
        Clan noviClan = new Clan(clan);
		
		return noviClan;
    }
}
