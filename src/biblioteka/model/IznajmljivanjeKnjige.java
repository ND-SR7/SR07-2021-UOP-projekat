package biblioteka.model;

import java.time.LocalDate;

public class IznajmljivanjeKnjige {

	protected LocalDate datumIznajmljivanja;
    protected LocalDate datumVracanja;
    protected PrimerakKnjige iznajmljenPrimerak;
    protected Clan clan;
    protected Zaposleni zaposleni;
    protected boolean obrisano;
    
    /*KONSTRUKTORI*/
    public IznajmljivanjeKnjige() {
    	this.datumIznajmljivanja = LocalDate.parse(null);
    	this.datumVracanja = LocalDate.parse(null);
    	this.iznajmljenPrimerak = null;
    	this.clan = null;
    	this.zaposleni = null;
    	this.obrisano = false;
    }

	public IznajmljivanjeKnjige(LocalDate datumIznajmljivanja, LocalDate datumVracanja, PrimerakKnjige iznajmljenPrimerak, Clan clan, Zaposleni zaposleni,
								boolean obrisano) {
		this.datumIznajmljivanja = datumIznajmljivanja;
		this.datumVracanja = datumVracanja;
		this.iznajmljenPrimerak = iznajmljenPrimerak;
		this.clan = clan;
		this.zaposleni = zaposleni;
		this.obrisano = obrisano;
	}
	
	/*toString()*/
	@Override
	public String toString() {
		return this.iznajmljenPrimerak + ", sa ID: " + this.iznajmljenPrimerak.getId() + ", je iznajmljen: " + this.datumIznajmljivanja;
	}
	
	/*GET SET*/
	public LocalDate getDatumIznajmljivanja() {
		return datumIznajmljivanja;
	}

	public void setDatumIznajmljivanja(LocalDate datumIznajmljivanja) {
		this.datumIznajmljivanja = datumIznajmljivanja;
	}

	public LocalDate getDatumVracanja() {
		return datumVracanja;
	}

	public void setDatumVracanja(LocalDate datumVracanja) {
		this.datumVracanja = datumVracanja;
	}

	public PrimerakKnjige getIznajmljenPrimerak() {
		return iznajmljenPrimerak;
	}

	public void setIznajmljenPrimerak(PrimerakKnjige iznajmljenPrimerak) {
		this.iznajmljenPrimerak = iznajmljenPrimerak;
	}

	public Clan getClan() {
		return clan;
	}

	public void setClan(Clan clan) {
		this.clan = clan;
	}

	public Zaposleni getZaposleni() {
		return zaposleni;
	}

	public void setZaposleni(Zaposleni zaposleni) {
		this.zaposleni = zaposleni;
	}
	
	public boolean isObrisano() {
		return obrisano;
	}
	
	public void setObrisano(boolean obrisano) {
		this.obrisano = obrisano;
	}
}
