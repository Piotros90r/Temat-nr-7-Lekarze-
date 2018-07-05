package javasem.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javasem.Harmonogram;
import javasem.Lekarz;
import javasem.LekarzOgolny;
import javasem.LekarzSpecjalista;
import javasem.Pacjent;
import javasem.Wizyty;


public class Parametry {
    
        static private String sciezkaDoZapisu= "";
        static private Wizyty wizyty = new Wizyty();        
        static private List<Lekarz> listaLekarzy = new ArrayList<Lekarz> ();     
        static private List<Pacjent> listaPacjenci = new ArrayList<Pacjent> ();
        static private List<Harmonogram> listaO =  new ArrayList<Harmonogram> ();
        static private Map<String,Lekarz> mapLekarzy = new HashMap<String,Lekarz>();
        static private Map<String,Pacjent> mapPacjenci = new HashMap<String,Pacjent>();
    
        static public void reset(){
            wizyty = new Wizyty();        
            listaLekarzy = new ArrayList<Lekarz> ();        
            listaPacjenci = new ArrayList<Pacjent> ();
             mapLekarzy = new HashMap<String,Lekarz>();
            mapPacjenci = new HashMap<String,Pacjent>();           
        } 
        
        
        static public void init(){
            wizyty = new Wizyty();        
            listaLekarzy = InicjalizacjaDanych.initLekarze();      
            listaPacjenci = InicjalizacjaDanych.initPacjenci();
            initMap();
        }   
        
        static public void initMap(){
            for(Lekarz l:listaLekarzy){
                mapLekarzy.put(l.getNumerLegitymacji(), l);
            }
            for(Pacjent l:listaPacjenci){
                mapPacjenci.put(l.pobierzPesel(), l);
            }            
        }    
        
    static public List<Harmonogram> przygotujDoZapisania() {
        List<Harmonogram> listaO = new ArrayList<Harmonogram>();
        listaO.addAll(listaLekarzy);
        listaO.addAll(listaPacjenci);
        listaO.add(wizyty);
       
        return listaO;
    }
    
    static public List<Harmonogram> odczytaj(Object o ) {
        List<Harmonogram> listaO = (ArrayList<Harmonogram>)o;
        reset();
        for(Harmonogram f:listaO){
            if(f.getClass().equals(LekarzSpecjalista.class) || f.getClass().equals(LekarzOgolny.class)){
                listaLekarzy.add((Lekarz)f);
            }
            if(f.getClass().equals(Pacjent.class)){
                listaPacjenci.add((Pacjent)f);
            }
            if(f.getClass().equals(Wizyty.class)){
                wizyty = ((Wizyty)f);
            }            
        }
        initMap();        
        return listaO;
    }
    
    

    public static Wizyty getWizyty() {
        return wizyty;
    }

    public static void setWizyty(Wizyty wizyty) {
        Parametry.wizyty = wizyty;
    }

    public static List<Lekarz> getListaLekarzy() {
        return listaLekarzy;
    }

    public static void setListaLekarzy(List<Lekarz> listaLekarzy) {
        Parametry.listaLekarzy = listaLekarzy;
    }

    public static List<Pacjent> getListaPacjenci() {
        return listaPacjenci;
    }

    public static void setListaPacjenci(List<Pacjent> listaPacjenci) {
        Parametry.listaPacjenci = listaPacjenci;
    }

    public static List<Harmonogram> getListaO() {
        return listaO;
    }

    public static void setListaO(List<Harmonogram> listaO) {
        Parametry.listaO = listaO;
    }

    public static Map<String, Lekarz> getMapLekarzy() {
        return mapLekarzy;
    }

    public static void setMapLekarzy(Map<String, Lekarz> mapLekarzy) {
        Parametry.mapLekarzy = mapLekarzy;
    }

    public static Map<String, Pacjent> getMapPacjenci() {
        return mapPacjenci;
    }

    public static void setMapPacjenci(Map<String, Pacjent> mapPacjenci) {
        Parametry.mapPacjenci = mapPacjenci;
    }

    public static String getSciezkaDoZapisu() {
        return sciezkaDoZapisu;
    }

    public static void setSciezkaDoZapisu(String sciezkaDoZapisu) {
        Parametry.sciezkaDoZapisu = sciezkaDoZapisu;
    }
        
        
}
