package biblioteka;

import java.time.LocalDate;

public class IznajmljivanjeKnjige {

	protected LocalDate datumIznajmljivanja;
    protected LocalDate datumVracanja;
    protected PrimerakKnjige iznajmljenPrimerak;
    protected Clan clan;
    protected Zaposleni zaposleni;
    
    /*KONSTRUKTORI*/
    public IznajmljivanjeKnjige() {
    	this.datumIznajmljivanja = LocalDate.parse(null);
    	this.datumVracanja = LocalDate.parse(null);
    	this.iznajmljenPrimerak = null;
    	this.clan = null;
    	this.zaposleni = null;
    }

	public IznajmljivanjeKnjige(LocalDate datumIznajmljivanja, LocalDate datumVracanja, PrimerakKnjige iznajmljenPrimerak, Clan clan, Zaposleni zaposleni) {
		this.datumIznajmljivanja = datumIznajmljivanja;
		this.datumVracanja = datumVracanja;
		this.iznajmljenPrimerak = iznajmljenPrimerak;
		this.clan = clan;
		this.zaposleni = zaposleni;
	}  
}
