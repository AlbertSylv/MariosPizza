package mariospizza;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
                seMenu("C:\\Users\\Albert\\Documents\\NetBeansProjects\\MariosPizza\\MariosPizza\\src\\MariosPizza\\Pizzaer.csv");
                
            }
            if(s.equals("bestilling"))
            {
                System.out.println("Du er nu i bestilling");
                Bestilling best = new Bestilling();
                best = Bestilling.lavBestilling();
                aktiveBestillinger.add(best);
            }
            if(s.equals("aktive bestillinger"))
            {
                System.out.println("Du er nu i aktive bestillinger");
                printArray(aktiveBestillinger);
                System.out.println("Når en bestilling er betalt for - skriv bestillings id'et");
                //Lav metode der får en aktiv bestilling flyttet over i historien vha bestillingsID'et
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
                + "\""
                + "\"exit\" for at afslutte programmet");
    }
    
    public static void printArray(ArrayList a){
        for (int i = 0; i < a.size(); i++) {
            Bestilling cbdj = new Bestilling();
            cbdj = (Bestilling)a.get(i);
            System.out.println("BestillingsID: " + cbdj.bestillingsID + "\n" + 
                    "Pizzanr: " + cbdj.pizzaNr+ "\n" + "Telefon: " 
                    + cbdj.kundeTLF + "\n" + "Afhentningstid: " + cbdj.afhentningstid);

        }
    }
    
    public static void seMenu(String filename) throws FileNotFoundException {
            // bruge scanner
            String line = "";
            
            File fh = new File(filename);
            Scanner myScanner = new Scanner(fh);
            while(myScanner.hasNextLine()) {
                    line = myScanner.nextLine();
                    System.out.println(line);
                    
            }
    }
    
    /*public static void makeHTML(String line, String destinationFilename) throws IOException 
    {
            // "Data/index.html"
            //2;Acura;RSX Type S 2dr;4;200;24;31;2778;101;1998;12000
            String outString = "";


            File fh = new File(destinationFilename);
            FileWriter fw = new FileWriter(fh,true);
            BufferedWriter bw = new BufferedWriter(fw);
            String[] myArr = line.split(",");
            // fixe doors
            outString += "<li>"+myArr[1]+"</li>";
            outString += "<li>"+myArr[10]+"</li>";
            outString += "<li>" + StringParserHelper.getNumOfDoors(myArr[2]) + "</li>";
            bw.write(outString);
            bw.newLine();
            bw.close();
    } */
	
    
    
}
