package javasem;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import javasem.util.Drukuj;
import javasem.util.Narzedzia;
import javasem.util.Parametry;




public class StartApp {


    public static void main(String[] args) throws IOException, ParseException   {

        System.out.println("Aplikacja Harmonogram pacjenta / lekarza");        
        Drukuj.helpP();
        
        Parametry.init();
        Parametry.setSciezkaDoZapisu("src/lekspec.ser");

        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
                
        String wybor="";
        boolean czyKoniec = false;
        while(true){            
            Scanner key = new Scanner(System.in);           
            wybor = key.nextLine();
            String in="";
            String[] inTab;
            Lekarz lek;
            Pacjent pacj;
            switch (wybor) {
                case "l":
                    System.out.println("Lista lekarzy: ogólni: " + LekarzOgolny.pobierzIleObietowPryw() + ", specjalisci: " + LekarzSpecjalista.pobierzIleObietowPryw() );
                    for (Lekarz l : Parametry.getListaLekarzy()) {
                        System.out.println("- " +  l.print());
                    }
                    break;
                case "p":
                    System.out.println("Lista pacjentów: " + LekarzOgolny.pobierzIleObietowPryw());
                    for (Pacjent l : Parametry.getListaPacjenci()) {
                        System.out.println("- " +  l.print());
                    }
                    break;
                case "q":
                    System.out.println("Wyjście z programu");
                    czyKoniec = true;
                    break;
                    
                case "d":
                    System.out.println("Podaj po przecinku datę(RRRR-MM-DD), nr leg. lekarza i pesel klienta ");
                    in = key.nextLine();           
                    inTab = in.split(",");                                         
                    lek =  Parametry.getMapLekarzy().get(inTab[1]);
                    pacj =  Parametry.getMapPacjenci().get(inTab[2]);
                    Parametry.getWizyty().dodajWizyte(sdf.parse(inTab[0]), lek, pacj); 
                    
                    break;
                case "u":
                    System.out.println("Usuwanie rejestracji. Podaj po przecinku datę(RRRR-MM-DD), nr leg. lekarza i pesel klienta ");
                    in = key.nextLine();  
                    inTab = in.split(",");                                                        
                    lek =  Parametry.getMapLekarzy().get(inTab[1]);
                    pacj =  Parametry.getMapPacjenci().get(inTab[2]);
                    Parametry.getWizyty().usunWizyte(sdf.parse(inTab[0]), lek, pacj);
                    
                    break;
                case "w":
                    System.out.println("Lista wizyt:");
                    Parametry.getWizyty().listaWizyt();
                    break;
                    
                case "z":
                    System.out.println("Zapisywanie do pliku:");
                    Narzedzia.zapiszStanDoPliku(Parametry.przygotujDoZapisania(), Parametry.getSciezkaDoZapisu());
                    System.out.println("zapisano");
                    break; 
                    
                case "o":
                    System.out.println("Odczytywanie z pliku:");
                    Object o = Narzedzia.odczytajStanZPliku( Parametry.getSciezkaDoZapisu());
                    Parametry.odczytaj(o);
                    System.out.println("odczytano" );
                    break;                     
                    
                case "?":
                    Drukuj.helpP();
                    break;                    
                    
                    
                    
                    
                default:
                    System.out.println("Nieprawidłowa opcja");
            }
            //Czy koniec
            if(czyKoniec) break;
            
        }
        
        
        

        
    }
    
}
