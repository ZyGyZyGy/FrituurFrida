package be.vdab.entities;
// test
// test2
// test3
public class Adres {

    private String straat, huisNr;
    private Gemeente gemeente;

    public Adres(String straat, String huisNr, Gemeente gemeente) {
	this.straat = straat;
	this.huisNr = huisNr;
	this.gemeente = gemeente;
    }

    public String getStraat() {
	return straat;
    }

    public void setStraat(String straat) {
	this.straat = straat;
    }

    public String getHuisNr() {
	return huisNr;
    }

    public void setHuisNr(String huisNr) {
	this.huisNr = huisNr;
    }

    public Gemeente getGemeente() {
	return gemeente;
    }

    public void setGemeente(Gemeente gemeente) {
	this.gemeente = gemeente;
    }

}
