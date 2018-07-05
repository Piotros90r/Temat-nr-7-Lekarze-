package javasem;

public class Pacjent extends Osoba {

    static private int ileObiektow;

    public Pacjent() {
        ileObiektow++;
    }

    public Pacjent(Pacjent pacj) {
        ustawPesel(pacj.pobierzPesel());
        setImie(pacj.getImie());
        setNazwisko(pacj.getNazwisko());
    }

    @Override
    public int pobierzIleObietow() {
        return ileObiektow;
    }

    static public int pobierzIleObietowPryw(){
        return ileObiektow;
    } 
    
    public String print() {
        return (this.pobierzPesel() + " " + this.getImie() + " " + this.getNazwisko());
    }

}
