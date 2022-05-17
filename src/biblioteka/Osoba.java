package biblioteka;

public abstract class Osoba {

    protected String ime;
    protected String prezime;
    protected String JMBG;
    protected String adresa;
    protected EnumPol pol;
    
    /*KONSTRUKTORI*/
    public Osoba() {
    	this.ime = "";
    	this.prezime = "";
    	this.JMBG = "";
    	this.adresa = "";
    	this.pol = null;
    }

	public Osoba(String ime, String prezime, String JMBG, String adresa, EnumPol pol) {
		this.ime = ime;
		this.prezime = prezime;
		this.JMBG = JMBG;
		this.adresa = adresa;
		this.pol = pol;
	}
	
	public Osoba(Osoba osoba) {
		this.ime = osoba.ime;
		this.prezime = osoba.prezime;
		this.JMBG = osoba.JMBG;
		this.adresa =osoba.adresa;
		this.pol = osoba.pol;
	}

	/*GET SET*/
	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getJMBG() {
		return JMBG;
	}

	public void setJMBG(String jMBG) {
		JMBG = jMBG;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public EnumPol getPol() {
		return pol;
	}

	public void setPol(EnumPol pol) {
		this.pol = pol;
	}
}
