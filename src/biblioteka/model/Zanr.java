package biblioteka.model;

public class Zanr {

    protected String oznaka;
    protected String opis;
    
    /*KONSTRUKTORI*/
    public Zanr() {
    	this.oznaka = "";
    	this.opis = "";
    }

	public Zanr(String oznaka, String opis) {
		this.oznaka = oznaka;
		this.opis = opis;
	}
	
	/*toString()*/
	@Override
	public String toString() {
		return this.opis;
	}
	
	/*GET SET*/
	public String getOznaka() {
		return oznaka;
	}

	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}
}
