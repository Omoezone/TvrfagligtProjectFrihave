import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
//This Class is a helper class for loading and saving to and from disk.

public class FileHandler {
    //This methods is used to load all the Barnobjects to a txt.file.
    //Same goes for all the loadToDisk methods.
    public static void loadBarnToDisk(ArrayList<Barn> listB) throws FileNotFoundException{
        PrintStream output = new PrintStream(new File("src/BarnData.txt"));
        for(int i = 0; i < listB.size(); i++) {
            output.println(listB.get(i).toFile());
        }
    }

    public static void loadFamilieToDisk(ArrayList<Familie> listF) throws FileNotFoundException{
        PrintStream output = new PrintStream(new File("FamilieData.txt"));
        for(int i = 0; i < listF.size(); i++) {
            output.println(i);
        }
    }

    public static void loadKontaktPersonToDisk(ArrayList<Kontaktperson> listKP) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("KontaktPersonData.txt"));
        for(int i = 0; i < listKP.size(); i++) {
            output.println(listKP.get(i).toFile());
        }
    }

    public static ArrayList<Barn> loadBarnFromDisk() throws FileNotFoundException {
        ArrayList<Barn> listB = new ArrayList<>();
        Scanner input = new Scanner(new File("src/BarnData.txt"));
        while(input.hasNextLine()) {
            String fornavn = input.nextLine();
            String efternavn = input.nextLine();
            String cprNummer = input.nextLine();

            Barn temp = new Barn(fornavn, efternavn, cprNummer);
            listB.add(temp);
        }
        return listB;
    }

    public static ArrayList<Kontaktperson> loadKontaktPersonFromDisk()throws FileNotFoundException {
        ArrayList<Kontaktperson> listKP = new ArrayList<>();
        Scanner input = new Scanner(new File("KontaktpersonData.txt"));
        while(input.hasNextLine()) {
            String fornavn = input.nextLine();
            String efternavn = input.nextLine();
            String telefon = input.nextLine();
            String email = input.nextLine();

            Kontaktperson temp = new Kontaktperson(fornavn, efternavn, telefon, email);
            listKP.add(temp);
        }
        return listKP;
    }
}
