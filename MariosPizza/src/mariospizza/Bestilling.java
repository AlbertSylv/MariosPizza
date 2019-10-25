
package mariospizza;

import java.util.Scanner;

/**
 * 
 *
 * @author Albert
 */
public class Bestilling {
    String bestillingsID;
    String pizzaNr;
    String kundeTLF;
    String afhentningstid;
    boolean afhentet = false;

    public Bestilling(String bestillingsID, String pizzaNr, String kundeTLF, String afhentningstid) {
        this.bestillingsID = bestillingsID;
        this.pizzaNr = pizzaNr;
        this.kundeTLF = kundeTLF;
        this.afhentningstid = afhentningstid;
        
    }
    public Bestilling(){
        
    }

    public void setAfhentet(boolean afhentet) {
        this.afhentet = afhentet;
    }
    
    

    public static Bestilling lavBestilling(){
        
        Scanner bestil = new Scanner(System.in);
        
        System.out.println("Indtast et unikt bestillingsID for denne bestilling");
        String bestillingsID = "";
        bestillingsID = bestil.nextLine();
        
        System.out.println("Indtast pizzanummer: ");
        String pizzanummer = "";
        pizzanummer = bestil.nextLine();
        
        System.out.println("Indtast kundens telefon nummer");
        String tlf = "";
        tlf = bestil.nextLine();
        
        System.out.println("Indtast afhentningstidspunkt");
        String afht = "";
        afht = bestil.nextLine();
        
        Bestilling bestilling = new Bestilling(bestillingsID, pizzanummer, tlf, afht); 
        
        return bestilling;
    }
    
    
    
    
}
