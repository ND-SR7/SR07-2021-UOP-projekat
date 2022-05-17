package biblioteka;

public class Bibliotekar extends Zaposleni {
	
	/*KONSTRUKTORI*/
    public Bibliotekar() {
    	super();
    }
    
    public Bibliotekar(String ime, String prezime, String JMBG, String adresa, EnumPol pol, double plata, String korisnickoIme, String lozinka) {
    	super(ime, prezime, JMBG, adresa, pol, plata, korisnickoIme, lozinka);
    }
    
    public Bibliotekar(Bibliotekar bibliotekar) {
    	super(bibliotekar);
    }
    
    /*GET*/
    public String getUloga() {
    	return "B";
    }
    
    /*toString()*/
    @Override
    public String toString() {
    	return "Bibliotekar: " + this.korisnickoIme;
    }
}
