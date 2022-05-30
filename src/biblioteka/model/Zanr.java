package biblioteka.model;

public class Zanr {

    protected String oznaka;
    protected String opis;
    protected boolean obrisan;
    
    /*KONSTRUKTORI*/
    public Zanr() {
    	this.oznaka = "";
    	this.opis = "";
    	this.obrisan = false;
    }

	public Zanr(String oznaka, String opis, boolean obrisan) {
		this.oznaka = oznaka;
		this.opis = opis;
		this.obrisan = obrisan;
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
	
	public boolean isObrisan() {
		return obrisan;
	}
	
	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}
}
