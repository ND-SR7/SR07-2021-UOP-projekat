package biblioteka.model;

public class PrimerakKnjige {

    protected int id;
    protected int brojStrana;
    protected EnumTipPoveza tipPoveza;
    protected int godinaStampanja;
    protected boolean iznajmljen;
    protected Knjiga knjiga;
    protected EnumJezik jezikStampanja;
    protected boolean obrisan;
    
    /*KONSTRUKTORI*/
    public PrimerakKnjige() {
    	this.id = -1;
    	this.brojStrana = 0;
    	this.tipPoveza = null;
    	this.godinaStampanja = 0;
    	this.iznajmljen = false;
    	this.knjiga = null;
    	this.jezikStampanja = null;
    	this.obrisan = false;
    }
    
    public PrimerakKnjige(int brojStrana, EnumTipPoveza tipPoveza, int godinaStampanja, boolean iznajmljen, Knjiga knjiga, EnumJezik jezikStampanja, boolean obrisan) {
		this.id = postaviID();
		this.brojStrana = brojStrana;
		this.tipPoveza = tipPoveza;
		this.godinaStampanja = godinaStampanja;
		this.iznajmljen = iznajmljen;
		this.knjiga = knjiga;
		this.jezikStampanja = jezikStampanja;
		this.obrisan = obrisan;
	}
    
    /*GET SET*/
    public int getId() {
		return id;
	}

	public int getBrojStrana() {
		return brojStrana;
	}

	public void setBrojStrana(int brojStrana) {
		this.brojStrana = brojStrana;
	}

	public EnumTipPoveza getTipPoveza() {
		return tipPoveza;
	}

	public void setTipPoveza(EnumTipPoveza tipPoveza) {
		this.tipPoveza = tipPoveza;
	}

	public int getGodinaStampanja() {
		return godinaStampanja;
	}

	public void setGodinaStampanja(int godinaStampanja) {
		this.godinaStampanja = godinaStampanja;
	}

	public boolean isIznajmljen() {
		return iznajmljen;
	}

	public void setIznajmljen(boolean iznajmljen) {
		this.iznajmljen = iznajmljen;
	}

	public Knjiga getKnjiga() {
		return knjiga;
	}

	public void setKnjiga(Knjiga knjiga) {
		this.knjiga = knjiga;
	}

	public EnumJezik getJezikStampanja() {
		return jezikStampanja;
	}

	public void setJezikStampanja(EnumJezik jezikStampanja) {
		this.jezikStampanja = jezikStampanja;
	}
	
	public boolean isObrisan() {
		return obrisan;
	}
	
	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}

	/*toString()*/
    @Override
    public String toString() {
    	return "Primerak " + this.knjiga.getNaslov() + ", ID: " + Integer.toString(this.getId());
    }

	/*GENERATOR JEDINSTVENIH ID-a*/
    private static int idBrojac = 0;

    public static int postaviID()
    {
        return ++idBrojac;
    }

}
