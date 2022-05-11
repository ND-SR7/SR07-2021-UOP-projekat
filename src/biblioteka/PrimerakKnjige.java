package biblioteka;

public class PrimerakKnjige {

    protected int id;
    protected int brojStrana;
    protected EnumTipPoveza tipPoveza;
    protected int godinaStampanja;
    protected boolean iznajmljen;
    protected Knjiga knjiga;
    protected EnumJezik jezikStampanja;
    
    /*KONSTRUKTORI*/
    public PrimerakKnjige() {
    	this.id = 0;
    	this.brojStrana = 0;
    	this.tipPoveza = null;
    	this.godinaStampanja = 0;
    	this.iznajmljen = false;
    	this.knjiga = null;
    	this.jezikStampanja = null;
    }
    
    public PrimerakKnjige(int id, int brojStrana, EnumTipPoveza tipPoveza, int godinaStampanja, boolean iznajmljen, Knjiga knjiga, EnumJezik jezikStampanja) {
		this.id = id;
		this.brojStrana = brojStrana;
		this.tipPoveza = tipPoveza;
		this.godinaStampanja = godinaStampanja;
		this.iznajmljen = iznajmljen;
		this.knjiga = knjiga;
		this.jezikStampanja = jezikStampanja;
	}

	/*GENERATOR JEDINSTVENIH ID-a*/
    private static int idBrojac = 0;

    public static int postaviID()
    {
        return idBrojac++;
    }

}
