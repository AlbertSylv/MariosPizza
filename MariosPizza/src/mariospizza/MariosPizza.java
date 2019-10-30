package mariospizza;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author Alle ZuSammen
 */

//vi har ikke kunne finde ud af at lave boolean afhentet false inde i et dokument om til true, så vi har ikke kunne lave en historie af bestillinger.
//vi har ikke nået at lave statistik, hvilket også havde været svært at lave uden en historik.
//når man trykker aktive bestillinger fårn 

public class MariosPizza
{
   
    public static void main(String[] args) throws FileNotFoundException, IOException 
    {
       
        Scanner in = new Scanner(System.in);
        String s = "";
        
        //Definerer arraylist med bestillinger
        ArrayList Bestillinger = new ArrayList();
        
        //While loop der sender dig forskellige steder hen afhængigt af hvad du skriver ind.
        while(!s.equals("exit"))
        {kommandoer();
            s = in.nextLine();
            if(s.equals("menu"))
            {
                System.out.println("Du er nu i menuen");
                //print menuen
                seMenu("Data/Pizzaer.csv");
                
            }
            if(s.equals("bestilling"))
            {
                System.out.println("Du er nu i bestilling");
                Bestilling best = new Bestilling();
                best = Bestilling.lavBestilling();
                best.writeBestToFile(best);
                Bestillinger.add(best);
            }
            if(s.equals("aktive bestillinger"))
            {   Scanner on = new Scanner(System.in);
                    String o = "";
                    System.out.println("Du er nu i aktive bestillinger");
                    printAktiveBest(convertFileToBest("Data/BestillingsDoku.csv"));
                    System.out.println("Skriv \"rediger\" hvis du vil redigere en bestilling");
                    //Lav metode der får en aktiv bestilling flyttet over i historien vha bestillingsID'et
                    o = on.nextLine();
                    if(o.equals("rediger"))
                {
                    System.out.println("Når en bestilling er betalt for - skriv bestillings id'et");
                    o = on.nextLine();
                    editBestInList(o, Bestillinger);
                }
            }
            if(s.equals("historie"))
            { 
                System.out.println("Du er nu i bestillingshistorien");
                
                
            }
        
        }
        
    }
    
    
    public static void kommandoer()
    {
        System.out.println("Tast: \n\"menu\" for at se menuen \n"
                + "\"bestilling\" for at oprette en bestilling \n"
                + "\"aktive bestillinger\" for at se aktive bestillinger \n"
                + "\"historie\" for at se gamle bestillinger og statistikker \n"
                + "\"exit\" for at afslutte programmet");
    }
    
    public static void printAktiveBest(ArrayList<Bestilling> a) throws FileNotFoundException
    {
        for (int i = 0; i < a.size(); i++) 
        {
            if(!a.get(i).afhentet)
                //12d, 131311313, 12:13, false;2@2@2@
            {//mangler finesse(Umiddelbart fixet, tjekt!) :-*
                System.out.println("BestillingsID: "+a.get(i).bestillingsID+"\n" + "Kunde telefon: "+a.get(i).kundeTLF+"\n" + 
                        "Afhentningstidspunkt: "+a.get(i).afhentningstid+"\n" + "Afhentnings status: "+a.get(i).afhentet);
                System.out.println("Her er Pizzaen/pizzaerne");
                for (int j = 0; j < a.get(i).antPizInBest.size(); j++) 
                {
                    
                    ArrayList<Pizza> PizzArr = new ArrayList<Pizza>();
                    PizzArr = convertFileToPizza("Data/Pizzaer.csv");
                    for (int k = 0; k < PizzArr.size(); k++) 
                    {
                        if(PizzArr.get(k).getPizzaNr().equals(a.get(i).antPizInBest.get(j).getPizzaNr()))  
                        {
                            System.out.println(PizzArr.get(k).getNavn());   
                        }   
                    }
                    //System.out.println(a.get(i).antPizInBest.get(j).pizzaNr);
                    
                }
            }
            
        }
    }
    
    
    public static void printHistorik(ArrayList d)
    {
        
    }
    
    public static ArrayList<Bestilling> convertFileToBest(String filename) throws FileNotFoundException
    {
        ArrayList<Bestilling> alleBestillinger = new ArrayList();
        String line = "";
        File fh = new File(filename);
            Scanner myScanner = new Scanner(fh);
            while(myScanner.hasNextLine()) 
            {//addes= Alle Dem Der Er Splittet ved "," i "Pizzaer.csv"
                ArrayList<Pizza> tmpArr = new ArrayList<Pizza>();
                Bestilling tmpBestilling = new Bestilling();
                    line = myScanner.nextLine();
                    String[]addes = line.split(",");
                    tmpBestilling.bestillingsID = addes[0];
                    tmpBestilling.kundeTLF = addes[1];
                    tmpBestilling.afhentningstid = addes[2];
                    
                    if(addes[3].equals("true"))
                    {
                    tmpBestilling.afhentet = true;
                    }
                    
                    else
                    {
                        tmpBestilling.afhentet = false;
                    }
                    
                        System.out.println(line);
                        
                        String[]splitLinje = line.split(";");
                        String[]splitLine = splitLinje[0].split(",");
                        String[]pizzaArr = splitLinje[1].split("@");
                        for (int i = 0; i < pizzaArr.length; i++) 
                    {
                        String pizzaNr = pizzaArr[i];
                        Pizza p = new Pizza(pizzaNr);
                        tmpArr.add(p);
                    }
                    tmpBestilling.antPizInBest = tmpArr;
                    alleBestillinger.add(tmpBestilling);
            }
        return alleBestillinger;
    } 
    
    public static ArrayList<Pizza> convertFileToPizza(String filename) throws FileNotFoundException
    {
        ArrayList<Pizza> allePizzaer = new ArrayList();
        String line = "";
        File fh = new File(filename);
            Scanner myScanner = new Scanner(fh);
            while(myScanner.hasNextLine()) 
            {
                
                    line = myScanner.nextLine();
                    String[]addes = line.split(",");
                    String pizzaNr = addes[0];
                    int pizzaPris = Integer.parseInt(addes[1]);
                    String pizzaNavn = addes[2];
                    String ingredienser = addes[3];//find på bedre navn til addes
                    Pizza tmpPizza = new Pizza(pizzaNr, pizzaNavn, pizzaPris, ingredienser);
                    
                    allePizzaer.add(tmpPizza);
            }
        return allePizzaer;
    }
    
    //har forsøgt at få denne til at virke, men trods hjælp virker den ikke...
    public static void editBestInList(String ID, ArrayList c) throws IOException
    {
        for (int i = 0; i < c.size(); i++) 
        {
            Bestilling cbd = new Bestilling();
            cbd = (Bestilling) c.get(i);

            if(ID.equals(cbd.bestillingsID))
            { 
                cbd.setAfhentet(true);
                Bestilling.editBestInFile(cbd);

            }
            
        break;
        }
        
    }
    
    
        //læser og printer "Pizzaer.csv"
    public static void seMenu(String filename) throws FileNotFoundException 
    {
            
        String line = "";
            
        File fh = new File(filename);
        Scanner myScanner = new Scanner(fh);
        while(myScanner.hasNextLine()) 
        {
            line = myScanner.nextLine();
            System.out.println(line);
        }
    }
}
