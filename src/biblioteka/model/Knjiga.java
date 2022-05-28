package biblioteka.model;

public class Knjiga {

    protected int id;
    protected String naslov;
    protected String originalniNaslov;
    protected String pisacImePrezime;
    protected int godinaObjavljivanja;
    protected String opis;
    protected Zanr zanr;
    protected EnumJezik jezikOriginala;
	
    /*KONSTRUKTORI*/
    public Knjiga() {
    	this.id = -1;
    	this.naslov = "";
    	this.originalniNaslov = "";
    	this.pisacImePrezime = "";
    	this.godinaObjavljivanja = 0;
    	this.opis = "";
    	this.zanr = null;
    	this.jezikOriginala = null;
	}

	public Knjiga(String naslov, String originalniNaslov, String pisacImePrezime, int godinaObjavljivanja, String opis, Zanr zanr, EnumJezik jezikOriginala) {
		this.id = postaviID();
		this.naslov = naslov;
		this.originalniNaslov = originalniNaslov;
		this.pisacImePrezime = pisacImePrezime;
		this.godinaObjavljivanja = godinaObjavljivanja;
		this.opis = opis;
		this.zanr = zanr;
		this.jezikOriginala = jezikOriginala;
	}
	
	/*GET SET*/
	public int getId() {
		return id;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getOriginalniNaslov() {
		return originalniNaslov;
	}

	public void setOriginalniNaslov(String originalniNaslov) {
		this.originalniNaslov = originalniNaslov;
	}

	public String getPisacImePrezime() {
		return pisacImePrezime;
	}

	public void setPisacImePrezime(String pisacImePrezime) {
		this.pisacImePrezime = pisacImePrezime;
	}

	public int getGodinaObjavljivanja() {
		return godinaObjavljivanja;
	}

	public void setGodinaObjavljivanja(int godinaObjavljivanja) {
		this.godinaObjavljivanja = godinaObjavljivanja;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Zanr getZanr() {
		return zanr;
	}

	public void setZanr(Zanr zanr) {
		this.zanr = zanr;
	}

	public EnumJezik getJezikOriginala() {
		return jezikOriginala;
	}

	public void setJezikOriginala(EnumJezik jezikOriginala) {
		this.jezikOriginala = jezikOriginala;
	}

	/*toString()*/
    @Override
    public String toString() {
    	return "Knjiga: " + this.naslov;
    }
    
	/*GENERATOR JEDINSTVENIH ID-a*/
    private static int idBrojac = 0;

    public static int postaviID()
    {
        return ++idBrojac;
    }
}
