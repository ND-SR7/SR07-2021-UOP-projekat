package biblioteka.model;

public class Administrator extends Zaposleni {
	
    /*KONSTRUKTORI*/
    public Administrator() {
    	super();
    }
    
    public Administrator(String ime, String prezime, String JMBG, String adresa, EnumPol pol, double plata, String korisnickoIme, String lozinka, boolean obrisan) {
    	super(ime, prezime, JMBG, adresa, pol, plata, korisnickoIme, lozinka, obrisan);
    }
    
    public Administrator(Administrator administrator) {
    	super(administrator);
    }
    
    /*GET*/
    public String getUloga() {
    	return "A";
    }
    
    /*toString()*/
    @Override
    public String toString() {
    	return "Administrator: " + this.korisnickoIme;
    }

    /**CRUD**/
    /*CREATE*/
    
    //BIBLIOTEKAR
    public Zaposleni dodajBibliotekara() {
        Zaposleni noviZaposleni = new Bibliotekar();
    	
    	return noviZaposleni;
    }
    
    public Zaposleni dodajBibliotekara(String ime, String prezime, String JMBG, String adresa, EnumPol pol, double plata, String korisnickoIme, String lozinka) {
        Zaposleni noviZaposleni = new Bibliotekar(ime, prezime, JMBG, adresa, pol, plata, korisnickoIme, lozinka, false);
    	
    	return noviZaposleni;
    }
    
    public Zaposleni dodajBibliotekara(Bibliotekar bibliotekar) {
        Zaposleni noviZaposleni = new Bibliotekar(bibliotekar);
    	
    	return noviZaposleni;
    }
    
    //ADMINISTRATOR
    public Zaposleni dodajAdministratora() {
        Zaposleni noviZaposleni = new Administrator();
    	
    	return noviZaposleni;
    }
    
    public Zaposleni dodajAdministratora(String ime, String prezime, String JMBG, String adresa, EnumPol pol, double plata, String korisnickoIme, String lozinka) {
        Zaposleni noviZaposleni = new Administrator(ime, prezime, JMBG, adresa, pol, plata, korisnickoIme, lozinka, false);
    	
    	return noviZaposleni;
    }
    
    public Zaposleni dodajAdministratora(Administrator administrator) {
        Zaposleni noviZaposleni = new Administrator(administrator);
    	
    	return noviZaposleni;
    }
    
    /*DELETE*/
    
    //ADMINISTRATOR i BIBLIOTEKAR
    public void obrisiZaposlenog(Zaposleni zaposleni) {
    	zaposleni.setObrisan(true);
    }
}
