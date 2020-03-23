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
        while(input.hasNext()) {
            String fornavn = input.next();
            String efternavn = input.next();
            String cprNummer = input.next();

            Barn temp = new Barn(fornavn, efternavn, cprNummer);
            listB.add(temp);
        }
        return listB;
    }

    public static ArrayList<Kontaktperson> loadKontaktPersonFromDisk()throws FileNotFoundException {
        ArrayList<Kontaktperson> listKP = new ArrayList<>();
        Scanner input = new Scanner(new File("src/kontaktpersonData.txt")).useDelimiter("|");
        while(input.hasNextLine()) {
            String fornavn = input.next();
            String efternavn = input.next();
            String telefon = input.next();
            String email = input.next();
            String addresse = input.next();

            Kontaktperson temp = new Kontaktperson(fornavn, efternavn, telefon, email, addresse);
            listKP.add(temp);
        }
        return listKP;
    }

    public static void readFromMedarbejderData() throws IOException {
        BufferedReader buff = new BufferedReader(new FileReader("src/MedarbejderData.txt"));
        ArrayList<String> read = new ArrayList<>();
        String line = buff.readLine();

        while(line != null) {
            read.add(line);
            line = buff.readLine();
        }
        
    }

    public static ArrayList<Medarbejder> loadMedarbejderFromDisk()throws FileNotFoundException {
        ArrayList<Medarbejder> listM = new ArrayList<>();
        Scanner input = new Scanner(new File("src/Medarbejderdata.txt")).useDelimiter("|");
        while(input.hasNextLine()){
            String fornavn = input.next();
            String efternavn = input.next();
            String arbejdsdag = input.next();
            String tidsrum = input.next();

            Medarbejder temp = new Medarbejder(fornavn, efternavn, arbejdsdag, tidsrum, listM);
        }
        return listM;
    }

    public static void loadMedarbejderToDisk(ArrayList<Medarbejder> listM)throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("MedarbejderData.txt"));
            for(int i = 0; i < listM.size(); i++) {
                output.println(listM.get(i).toFile());
            }
    }
}
