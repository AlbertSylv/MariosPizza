package mariospizza;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 *
 * @author Albert
 */
public class Bestilling 
{
    String bestillingsID;
    ArrayList<Pizza> antPizInBest; 
    String kundeTLF;
    String afhentningstid;
    boolean afhentet = false;
    

    public Bestilling(String bestillingsID, ArrayList<Pizza> p, String kundeTLF, String afhentningstid) 
    {
        this.bestillingsID = bestillingsID;
        this.antPizInBest = p;
        this.kundeTLF = kundeTLF;
        this.afhentningstid = afhentningstid;
        
    }
    public Bestilling()
    {
        
    }

    public void setAfhentet(boolean afhentet) 
    {
        this.afhentet = afhentet;
    }
    public void writeBestToFile(Bestilling bestilling) throws IOException
    {
        String fileName = "Data/BestillingsDoku.csv";
        File fh = new File(fileName);
        FileWriter fw = new FileWriter(fh, true);
        BufferedWriter bw = new BufferedWriter(fw);
        System.out.println(bestilling);
        bw.write(bestilling.toString());
        bw.newLine();
        bw.close();

    }
    
    

    public static Bestilling lavBestilling()
    {
        ArrayList<Pizza> antPizInBest = new ArrayList();
        
        Scanner bestil = new Scanner(System.in);
        
        System.out.println("Indtast et unikt bestillingsID for denne bestilling");
        String bestillingsID = "";
        bestillingsID = bestil.nextLine();
        
        System.out.println("Indtast kundens telefon nummer");
        String tlf = "";
        tlf = bestil.nextLine();
        
        System.out.println("Indtast afhentningstidspunkt");
        String afht = "";
        afht = bestil.nextLine();
        String jaNej="";
        //Hvorfor kun .equals()???
        while(!jaNej.equals("nej"))
        {
            System.out.println("Indtast pizzanummer: ");
            String pizzaNr = bestil.nextLine();
            Pizza TMPpizza = new Pizza(pizzaNr);

            System.out.println("Indtast antal af nr " + pizzaNr);
            int antal = 0;
            antal = bestil.nextInt();
            for (int i = 0; i < antal; i++) 
            {
            antPizInBest.add(TMPpizza);
            }
            //fordi nextInt oven over fucker med os.
            bestil.nextLine();
               // }
            System.out.println("skal du have flere pizzaer? ja/nej");
                jaNej=bestil.nextLine();
        }
    
        
       
        
        Bestilling bestilling = new Bestilling(bestillingsID, antPizInBest, tlf, afht); 
        
        return bestilling;
    }

    @Override
    public String toString() 
    {
        String ordrelinie = "";
        for (int i = 0; i < antPizInBest.size(); i++) 
        {
            ordrelinie += "@";
            ordrelinie += antPizInBest.get(i).pizzaNr;
            
            
        }
        return bestillingsID + ", " + kundeTLF + ", " + afhentningstid + ", " +
                afhentet + ";" + ordrelinie;
    }
  
    
}
