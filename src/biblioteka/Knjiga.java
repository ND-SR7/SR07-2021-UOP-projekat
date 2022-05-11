package biblioteka;

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
    	this.id = 0;
    	this.naslov = "";
    	this.originalniNaslov = "";
    	this.pisacImePrezime = "";
    	this.godinaObjavljivanja = 0;
    	this.opis = "";
    	this.zanr = null;
    	this.jezikOriginala = null;
	}

	public Knjiga(int id, String naslov, String originalniNaslov, String pisacImePrezime, int godinaObjavljivanja, String opis, Zanr zanr, EnumJezik jezikOriginala) {
		this.id = postaviID();
		this.naslov = naslov;
		this.originalniNaslov = originalniNaslov;
		this.pisacImePrezime = pisacImePrezime;
		this.godinaObjavljivanja = godinaObjavljivanja;
		this.opis = opis;
		this.zanr = zanr;
		this.jezikOriginala = jezikOriginala;
	}
    
	/*GENERATOR JEDINSTVENIH ID-a*/
    private static int idBrojac = 0;

    public static int postaviID()
    {
        return idBrojac++;
    }
}
