package javasem;

public abstract class Osoba extends Harmonogram {

    private String plec;
    private String imie;
    private String nazwisko;
    private String pesel;    
    
    public void ustawPesel(String pesel) {
        this.pesel= pesel;
    }   
  
    
    public String pobierzPesel() {
        return this.pesel;
    }


    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
    
    
    
}
