package javasem;

public abstract class Lekarz extends Osoba{     
        static final int ileMaksymalnaKolejka = 16;
        private String numerLegitymacji = "";

        public String getNumerLegitymacji() {
            return numerLegitymacji;
        }

        public void setNumerLegitymacji(String numerLegitymacji) {
            this.numerLegitymacji = numerLegitymacji;
        }      
        
        public String print(){
            return (this.numerLegitymacji + " " + this.getImie() + " " + this.getNazwisko());
        }
        
        static public int maks(){
            return ileMaksymalnaKolejka;
        }
        
}
