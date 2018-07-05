package javasem.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
 
public class Narzedzia {
    
             
    
static public void zapiszStanDoPliku(Object o,String sciezka){
 
        FileOutputStream fout = null;
        ObjectOutputStream oos= null;
        
        try {
            fout = new FileOutputStream(sciezka);
            oos = new ObjectOutputStream(fout);
            oos.writeObject(o);
        } catch (Exception e) {

        } finally {
            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e) {
                }
            }

            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                }
            }

        }
}

static public Object odczytajStanZPliku(String sciezka){
 
        FileInputStream fin = null;
        ObjectInputStream oos= null;
        Object o =null;
        
        try {
            fin = new FileInputStream(sciezka);
            oos = new ObjectInputStream(fin);
            o = oos.readObject();
        } catch (Exception e) {

        } finally {
            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException e) {
                }
            }

            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                }
            }

        }
        return o;
}

}
