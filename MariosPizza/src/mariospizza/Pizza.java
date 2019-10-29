package mariospizza;

/**
* @author danie
 */
public class Pizza {
    public String pizzaNr;
    public String navn;
    public int pris;
    public String ingredienser;

    public Pizza(String navn, int pris) {
       // this.pizzaNr= pizzaNr;
        this.navn = navn;
        this.pris = pris;
    }
        public Pizza(String pizzaNr) {
        this.pizzaNr= pizzaNr;
        if(this.pizzaNr.equals("1")){
            this.navn = "margarita";
            this.pris = 40;
        }
        if(this.pizzaNr.equals("2")){
            this.navn = "americano";
            this.pris = 50;
        }
    }

    public Pizza() {
    }
    
    
}
