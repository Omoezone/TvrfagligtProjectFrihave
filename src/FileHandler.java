import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
//This Class is a helper class for loading and saving to and from disk.

public class FileHandler {

    public static void loadFamilieToDisk(ArrayList<Familie> listF) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("src/FamilieData.txt"));
        for (int i = 0; i < listF.size(); i++) {
            output.println(listF.get(i).toFile());
        }
    }


    /*public static void loadKontaktPersonToDisk(ArrayList<Kontaktperson> listKP) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("KontaktPersonData.txt"));
        for(int i = 0; i < listKP.size(); i++) {
            output.println(listKP.get(i).toFile());
        }
    }*/


    /*public static void loadBarnData() throws IOException {
        BufferedReader buff = new BufferedReader(new FileReader("src/BarnData.txt"));
        ArrayList<String> read = new ArrayList<>();
        Scanner input = new Scanner(new File("src/BarnData.txt"));
        while(input.hasNext()) {
            String fornavn = input.next();
            String efternavn = input.next();
            String cprNummer = input.next();

            Barn temp = new Barn(fornavn, efternavn, cprNummer);
            listB.add(temp);
        }
    }*/

    /*public static ArrayList<Kontaktperson> loadKontaktPersonFromDisk()throws FileNotFoundException {
        ArrayList<Kontaktperson> listKP = new ArrayList<>();
        Scanner input = new Scanner(new File("src/kontaktpersonData.txt")).useDelimiter("|");
        while(input.hasNextLine()) {
            String fornavn = input.next();
            String efternavn = input.next();
            String telefon = input.next();
            String email = input.next();

            Kontaktperson temp = new Kontaktperson(fornavn, efternavn, telefon, email);
            listKP.add(temp);
        }
        return listKP;
    }*/

    /*public static void readFromMedarbejderData() throws IOException {
        BufferedReader buff = new BufferedReader(new FileReader("src/MedarbejderData.txt"));
        ArrayList<String> read = new ArrayList<>();
        String line = buff.readLine();

        while(line != null) {
            read.add(line);
            line = buff.readLine();
        }

    }*/

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

    public static void readFromFamilieData(ArrayList<Familie> listF, ArrayList<Barn> listB, ArrayList<Kontaktperson> listKP) throws IOException {
        BufferedReader buff = new BufferedReader(new FileReader("src/FamilieData.txt"));
        ArrayList<String> read = new ArrayList<>();
        String line = buff.readLine();

        while (line != null) {
            read.add(line);
            line = buff.readLine();
        }

        for (int i = 0; i < read.size(); i++) {
            seperateChildrenFromAdults(read.get(i), listF, listB, listKP);
        }
    }

    public static void seperateChildrenFromAdults(String text, ArrayList<Familie> listF, ArrayList<Barn> listB, ArrayList<Kontaktperson> listKP) {
        String[] cut = text.split("/");
        ArrayList<Kontaktperson> kontakt = new ArrayList<>();

        Barn barn = barnToObject(cut[0]);
        listB.add(barn);
        String[] adult = cut[1].split("\"");
        for (int i = 0; i < adult.length; i++) {
             Kontaktperson kP = kontaktToObject(adult[i]);
             kontakt.add(kP);
             listKP.add(kP);
        }
        if (kontakt.size() == 1) {
            Familie temp = new Familie(barn, kontakt.get(0));
            listF.add(temp);
        } else if (kontakt.size() == 2) {
            Familie temp = new Familie(barn, kontakt.get(0), kontakt.get(1));
            listF.add(temp);
        } else if (kontakt.size() == 3) {
            Familie temp = new Familie(barn, kontakt.get(0), kontakt.get(1), kontakt.get(2));
            listF.add(temp);
        }

    }

    public static Barn barnToObject(String text) {
        String[] barn1 = text.split(",");

        Barn temp = new Barn(barn1[0], barn1[1], barn1[2]);

            return temp;
    }

    public static Kontaktperson kontaktToObject(String text) {
        String[] kontakt = text.split(",");

        Kontaktperson temp = new Kontaktperson(kontakt[0], kontakt[1], kontakt[2], kontakt[3]);
            return temp;
    }
}
