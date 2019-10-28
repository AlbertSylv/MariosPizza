package mariospizza;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
    public void writeBestToFile(Bestilling bestilling) throws IOException{
        String fileName = "Data/BestillingsDoku.csv";
        File fh = new File(fileName);
        FileWriter fw = new FileWriter(fh, true);
        BufferedWriter bw = new BufferedWriter(fw);
        System.out.println(bestilling);
        bw.write(bestilling.toString());
        bw.newLine();
        bw.close();

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

    @Override
    public String toString() {
        return "Bestilling{" + "bestillingsID=" + bestillingsID + ", pizzaNr=" + pizzaNr + ", kundeTLF=" + kundeTLF + ", afhentningstid=" + afhentningstid + ", afhentet=" + afhentet + '}';
    }
    
    
    
    
    
}
