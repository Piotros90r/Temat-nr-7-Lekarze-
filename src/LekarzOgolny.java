package javasem;

import java.io.Serializable;

public class LekarzOgolny extends Lekarz {
        
    static private int ileObiektow;
    
    
    public LekarzOgolny (){
        ileObiektow++;       
    }
    
    
    public LekarzOgolny(LekarzOgolny pacj) {
        ustawPesel(pacj.pobierzPesel());
        setImie(pacj.getImie());
        setNazwisko(pacj.getNazwisko());       
    }   
    
    static public int pobierzIleObietowPryw(){
        return ileObiektow;
    } 

    @Override
    public int pobierzIleObietow() {
       return ileObiektow;
    }    
    
      public String print(){
            return (getNumerLegitymacji() + " " + this.getImie() + " " + this.getNazwisko()+ " specjalizacja: ogólny"  );
        }
    
}
