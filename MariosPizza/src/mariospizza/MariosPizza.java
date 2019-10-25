package mariospizza;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author Albert
 */

public class MariosPizza{

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        String s = "";
        
        
        ArrayList aktiveBestillinger = new ArrayList();
        
        
        while(!s.equals("exit"))
        {kommandoer();
            s = in.nextLine();
            if(s.equals("menu"))
            {
                System.out.println("Du er nu i menuen");
                //print menuen
                seMenu("src/MariosPizza/Pizzaer.csv");
                
            }
            if(s.equals("bestilling"))
            {
                System.out.println("Du er nu i bestilling");
                Bestilling best = new Bestilling();
                best = Bestilling.lavBestilling();
                aktiveBestillinger.add(best);
            }
            if(s.equals("aktive bestillinger"))
            {Scanner on = new Scanner(System.in);
             String o = "";
                System.out.println("Du er nu i aktive bestillinger");
                printArray(aktiveBestillinger);
                System.out.println("Skriv \"rediger\" hvis du vil redigere en bestilling");
                //Lav metode der får en aktiv bestilling flyttet over i historien vha bestillingsID'et
                o = in.nextLine();
                if(o.equals("rediger")){
                    System.out.println("Når en bestilling er betalt for - skriv bestillings id'et");
                    o = in.nextLine();
                editBestInList(o, aktiveBestillinger);
                }
            }
            if(s.equals("historie"))
            { 
                System.out.println("Du er nu i bestillingshistorien");
                
                
            }
        
        
        }
        
    }
    
    
    public static void kommandoer(){
        System.out.println("Tast: \n\"menu\" for at se menuen \n"
                + "\"bestilling\" for at oprette en bestilling \n"
                + "\"aktive bestillinger\" for at se aktive bestillinger \n"
                + "\"historie\" for at se gamle bestillinger og statistikker \n"
                + "\"exit\" for at afslutte programmet");
    }
    
    public static void printArray(ArrayList a){
        for (int i = 0; i < a.size(); i++) {
            Bestilling cbdj = new Bestilling();
            cbdj = (Bestilling)a.get(i);
            System.out.println("***************************");
            System.out.println("BestillingsID: " + cbdj.bestillingsID + "\n" + 
                    "Pizzanr: " + cbdj.pizzaNr+ "\n" + "Telefon: " 
                    + cbdj.kundeTLF + "\n" + "Afhentningstid: " + cbdj.afhentningstid
                    + "\n" + "afhentet?: " + cbdj.afhentet );

        }
    }
    
    public static void editBestInList(String ID, ArrayList c){
        for (int i = 0; i < c.size(); i++) {
            Bestilling cbd = new Bestilling();
            cbd = (Bestilling) c.get(i);
            
        if(ID.equals(cbd.bestillingsID)){ 
            cbd.setAfhentet(true);
            
        }
        break;
        }
    }
    
    
    
    public static void seMenu(String filename) throws FileNotFoundException {
            
            String line = "";
            
            File fh = new File(filename);
            Scanner myScanner = new Scanner(fh);
            while(myScanner.hasNextLine()) {
                    line = myScanner.nextLine();
                    System.out.println(line);
                    
            }
    }
}
