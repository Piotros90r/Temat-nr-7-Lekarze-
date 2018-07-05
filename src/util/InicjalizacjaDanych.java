package javasem.util;

import java.util.ArrayList;
import java.util.List;
import javasem.Lekarz;
import javasem.LekarzOgolny;
import javasem.LekarzSpecjalista;
import javasem.Pacjent;


public class InicjalizacjaDanych {
    
    
    
    
    static public List  initLekarze(){
    
        List<Lekarz> listaLekarzy = new ArrayList<Lekarz>();        
        
        LekarzSpecjalista lekSpec = new  LekarzSpecjalista();
        lekSpec.ustawPesel("679877989");
        lekSpec.setImie("Jan");
        lekSpec.setNazwisko("Kowal");
        lekSpec.setNumerLegitymacji("11");  
        lekSpec.setSpecjalizacja("Laryngolog");
               
        
        LekarzSpecjalista lekSpec2 = new  LekarzSpecjalista();
        lekSpec2.ustawPesel("6464355");
        lekSpec2.setImie("Sylwester");
        lekSpec2.setNazwisko("Nowak");
        lekSpec2.setNumerLegitymacji("22");  
        lekSpec2.setSpecjalizacja("Chirurg");
        
        LekarzOgolny lekOgol = new  LekarzOgolny();
        lekOgol.ustawPesel("34534366");
        lekOgol.setImie("Stanisław");
        lekOgol.setNazwisko("Bonecki");
        lekOgol.setNumerLegitymacji("33");  
        
        LekarzOgolny lekOgol2 = new  LekarzOgolny();
        lekOgol2.ustawPesel("345345344");
        lekOgol2.setImie("Iwona");
        lekOgol2.setNazwisko("Starszak");
        lekOgol2.setNumerLegitymacji("34");   
        
        listaLekarzy.add(lekSpec);
        listaLekarzy.add(lekSpec2);
        listaLekarzy.add(lekOgol);
        listaLekarzy.add(lekOgol2);
                
        return listaLekarzy;
    }
    
    static public List  initPacjenci(){
    
        List<Pacjent> listaPacjenci = new ArrayList<Pacjent>();        
        
        Pacjent pacj1 = new  Pacjent();
        pacj1.ustawPesel("3453");
        pacj1.setImie("Ilona");
        pacj1.setNazwisko("Lubecka");
        
        Pacjent pacj2 = new  Pacjent();
        pacj2.ustawPesel("76766");
        pacj2.setImie("Janusz");
        pacj2.setNazwisko("Klik"); 
        
        Pacjent pacj3 = new  Pacjent();
        pacj3.ustawPesel("76765");
        pacj3.setImie("Jola");
        pacj3.setNazwisko("Glinecka");         
        
        listaPacjenci.add(pacj1);
        listaPacjenci.add(pacj2);
        listaPacjenci.add(pacj3);
        
        return listaPacjenci;
    }
    
}
