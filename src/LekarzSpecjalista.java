package javasem;

public class LekarzSpecjalista extends Lekarz{
    
    static private int ileObiektow;
    private String specjalizacja;
    
    public LekarzSpecjalista (){
        ileObiektow++;         
    }    
    
    public LekarzSpecjalista(LekarzSpecjalista pacj) {
        ustawPesel(pacj.pobierzPesel());
        setImie(pacj.getImie());
        setNazwisko(pacj.getNazwisko());
        this.specjalizacja = (pacj.getSpecjalizacja());
    }    
    
    @Override
    public int pobierzIleObietow(){
        return ileObiektow;
    }
    
    static public int pobierzIleObietowPryw(){
        return ileObiektow;
    }

    public String getSpecjalizacja() {
        return specjalizacja;
    }

    public void setSpecjalizacja(String specjalizacja) {
        this.specjalizacja = specjalizacja;
    }    
    
            public String print(){
            return (getNumerLegitymacji() + " " + this.getImie() + " " + this.getNazwisko()+ " specjalizacja: " + this.specjalizacja);
        }
    
}
