package mariospizza;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Daniel
 */
public class MenuKort {
    //TODO: Lav ting som henter pizzaer fra Pizzaer.csv således at de "kan læses på skærmen hele tiden"
    
    public static void MenuKort(String [] args) throws FileNotFoundException{
        String fileName = "src/MariosPizza/Pizzaer.csv";
    
        File pizzaFil = new File(fileName);
        
        Scanner in = new Scanner(pizzaFil);
        
        in.nextLine();              
        int count = 0;
        
        while(in.hasNextLine()){
            String line = in.nextLine();
            System.out.println(line);
            count++;
        }
        
        in.close();
        
    }
}
