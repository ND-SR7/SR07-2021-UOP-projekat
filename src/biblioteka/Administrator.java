package biblioteka;

public class Administrator extends Zaposleni {

    /*KONSTRUKTORI*/
    public Administrator() {
    	super();
    }
    
    public Administrator(String ime, String prezime, String JMBG, String adresa, EnumPol pol, double plata, String korisnickoIme, String lozinka) {
    	super(ime, prezime, JMBG, adresa, pol, plata, korisnickoIme, lozinka);
    }
    
    public Administrator(Administrator administrator) {
    	super(administrator);
    }
    
    /*toString()*/
    @Override
    public String toString() {
    	return "Administrator: " + this.korisnickoIme;
    }

    /*METODE*/
    
    //NOVI BIBLIOTEKAR
    public Zaposleni dodajBibliotekara() {
        Zaposleni noviZaposleni = new Bibliotekar();
    	
    	return noviZaposleni;
    }
    
    public Zaposleni dodajBibliotekara(String ime, String prezime, String JMBG, String adresa, EnumPol pol, double plata, String korisnickoIme, String lozinka) {
        Zaposleni noviZaposleni = new Bibliotekar(ime, prezime, JMBG, adresa, pol, plata, korisnickoIme, lozinka);
    	
    	return noviZaposleni;
    }
    
    public Zaposleni dodajBibliotekara(Bibliotekar bibliotekar) {
        Zaposleni noviZaposleni = new Bibliotekar(bibliotekar);
    	
    	return noviZaposleni;
    }
    
    //NOVI ADMINISTRATOR
    public Zaposleni dodajAdministratora() {
        Zaposleni noviZaposleni = new Administrator();
    	
    	return noviZaposleni;
    }
    
    public Zaposleni dodajAdministratora(String ime, String prezime, String JMBG, String adresa, EnumPol pol, double plata, String korisnickoIme, String lozinka) {
        Zaposleni noviZaposleni = new Administrator(ime, prezime, JMBG, adresa, pol, plata, korisnickoIme, lozinka);
    	
    	return noviZaposleni;
    }
    
    public Zaposleni dodajAdministratora(Administrator administrator) {
        Zaposleni noviZaposleni = new Administrator(administrator);
    	
    	return noviZaposleni;
    }
}
