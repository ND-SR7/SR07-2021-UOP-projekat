package biblioteka;

public class Biblioteka {
	
    protected String naziv;
    protected String adresa;
    protected String brTelefon;
    protected String radnoVreme;

    /*KONSTRUKTORI*/
    public Biblioteka() {
    	this.naziv = "";
    	this.adresa = "";
    	this.brTelefon = "";
    	this.radnoVreme = "";
    }
    
    public Biblioteka(String naziv, String adresa, String brTelefon, String radnoVreme) {
    	this.naziv = naziv;
    	this.adresa = adresa;
    	this.brTelefon = brTelefon;
    	this.radnoVreme = radnoVreme;
    }
    
    public Biblioteka(Biblioteka biblioteka) {
    	this.naziv = biblioteka.naziv;
    	this.adresa = biblioteka.adresa;
    	this.brTelefon = biblioteka.brTelefon;
    	this.radnoVreme = biblioteka.radnoVreme;
    }
}
