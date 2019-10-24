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
        String fileName = "All Files	C:\\Users\\danie\\OneDrive\\Dokumenter\\NetBeansProjects\\MariosPizza\\MariosPizza\\src\\mariospizza\\Pizzaer.csv";
        
        File pizzaFil = new File(fileName);
        
        Scanner in = new Scanner(pizzaFil);
        
        int value = in.nextInt();
        System.out.println("Read value: "+ value);
        
        while(in.hasNextLine()){
            String line = in.nextLine();
            System.out.println(line);
        }
        
        in.close();
        
    }
}
