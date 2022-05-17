package biblioteka;

import java.time.LocalDate;

public class Clan extends Osoba {
	
	protected int id;
    protected String brClanskeKarte;
    protected LocalDate datumPoslednjeUplate;
    protected int brMeseciClanarine;
    protected boolean aktivan;
    protected EnumClanarina tipClanarine;

    /*KONSTRUKTORI*/
    public Clan() {
    	super();
    	this.id = -1;
    	this.datumPoslednjeUplate = null;
    	this.brMeseciClanarine = 0;
    	this.aktivan = false;
    	this.tipClanarine = null;
    }
    
    public Clan(String ime, String prezime, String JMBG, String adresa, EnumPol pol, LocalDate datumPoslednjeUplate, int brMeseciClanarine, 
    		boolean aktivan, EnumClanarina tipClanarine) {
		super(ime, prezime,JMBG, adresa, pol);
		this.id = postaviID();
		this.brClanskeKarte = postaviCK(ime, JMBG);
		this.datumPoslednjeUplate = datumPoslednjeUplate;
		this.brMeseciClanarine = brMeseciClanarine;
		this.aktivan = aktivan;
		this.tipClanarine = tipClanarine;
	}
    
    public Clan(Clan clan) {
    	super(clan);
    	this.id = postaviID();
		this.brClanskeKarte = postaviCK(ime, JMBG);
		this.datumPoslednjeUplate = clan.datumPoslednjeUplate;
		this.brMeseciClanarine = clan.brMeseciClanarine;
		this.aktivan = clan.aktivan;
		this.tipClanarine = clan.tipClanarine;
    }
    
    /*GET SET*/
    public int getId() {
		return id;
	}

	public String getBrClanskeKarte() {
		return brClanskeKarte;
	}

	public LocalDate getDatumPoslednjeUplate() {
		return datumPoslednjeUplate;
	}

	public void setDatumPoslednjeUplate(LocalDate datumPoslednjeUplate) {
		this.datumPoslednjeUplate = datumPoslednjeUplate;
	}

	public int getBrMeseciClanarine() {
		return brMeseciClanarine;
	}

	public void setBrMeseciClanarine(int brMeseciClanarine) {
		this.brMeseciClanarine = brMeseciClanarine;
	}

	public boolean isAktivan() {
		return aktivan;
	}

	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}

	public EnumClanarina getTipClanarine() {
		return tipClanarine;
	}

	public void setTipClanarine(EnumClanarina tipClanarine) {
		this.tipClanarine = tipClanarine;
	}

	/*toString()*/
    @Override
    public String toString() {
    	return "Član: " + this.ime + " " + this.prezime;
    }

	/*GENERATOR JEDINSTVENIH ID-a*/
    private static int idBrojac = 0;

    public static int postaviID()
    {
        return ++idBrojac;
    } 
    
    /*GENERATOR BROJA ČLANSKE KARTE*/
    public static String postaviCK(String ime, String JMBG) {
    	String slovo = ime.substring(0, 1);
    	String broj = JMBG.substring(0, 4) + Integer.toString(idBrojac);
    	
    	return slovo+broj;
    }

}
