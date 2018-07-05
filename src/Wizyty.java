package javasem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wizyty extends Harmonogram {

    static private int ileObiektow;
    Map<String, Object> wizyta = new HashMap<String, Object>();
    List<Map> listaWizyt = new ArrayList<Map>();
    SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");

    public void dodajWizyte(Date data, Lekarz lekarz, Pacjent pacjent) {
        wizyta = new HashMap<String, Object>();
        wizyta.put("lekarz", lekarz);
        wizyta.put("pacjent", pacjent);
        wizyta.put("data", data);
        if (czyWizytaMozliwa(data, lekarz)) {
            listaWizyt.add(wizyta);
            System.out.println("Dodano rezerwacje");
        } else {
            System.out.println("Rezerwacja niemożliwa. Maksymalnie możliwe " + Lekarz.maks() + " wizyt na dzień dla jednego lekarza");
        }
    }

    public void listaWizyt() {
        for (Map<String, Object> ent : listaWizyt) {
            System.out.print("" + sdf.format((Date) ent.get("data")) + " | Lekarz: " + ((Lekarz) ent.get("lekarz")).print());
            System.out.println(" | Pacjent: " + ((Pacjent) ent.get("pacjent")).print());

        }
    }

    public void usunWizyte(Date data, Lekarz lekarz, Pacjent pacjent) {
        wizyta = new HashMap<String, Object>();
        wizyta.put("lekarz", lekarz);
        wizyta.put("pacjent", pacjent);
        wizyta.put("data", data);
        listaWizyt.remove(wizyta);
        System.out.println("Usunięto rezerwacje");
    }

    public boolean czyWizytaMozliwa(Date data, Lekarz lekarz) {
        int ileWizytPerDzien = 0;
        for (Map<String, Object> ent : listaWizyt) {
            if ((((Date) ent.get("data")).equals(data)) && ((Lekarz) ent.get("lekarz")).equals(lekarz)) {
                ileWizytPerDzien++;
            }

        }
        if (ileWizytPerDzien <= Lekarz.maks() - 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int pobierzIleObietow() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
