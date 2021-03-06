import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
//This Class is a helper class for loading and saving to and from disk.

public class FileHandler {

    public static void saveFamilieToDisk(ArrayList<Familie> listF) throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("src/FamilieData.txt"));
        for (Familie familie : listF) {
            output.println(familie.toFile());
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

        for (String s : read) {
            seperateChildrenFromAdults(s, listF, listB, listKP);
        }
    }

    public static void seperateChildrenFromAdults(String text, ArrayList<Familie> listF, ArrayList<Barn> listB, ArrayList<Kontaktperson> listKP) {
        String[] cut = text.split("/");
        ArrayList<Kontaktperson> kontakt = new ArrayList<>();

        Barn barn = barnToObject(cut[0]);
        listB.add(barn);
        String[] adult = cut[1].split("\"");
        for (String s : adult) {
            Kontaktperson kP = kontaktToObject(s);
            kontakt.add(kP);
            listKP.add(kP);
        }
        if (kontakt.size() == 1) {
            listF.add(new Familie(barn, kontakt.get(0)));
        } else if (kontakt.size() == 2) {
            listF.add(new Familie(barn, kontakt.get(0), kontakt.get(1)));
        } else if (kontakt.size() == 3) {
            listF.add(new Familie(barn, kontakt.get(0), kontakt.get(1), kontakt.get(2)));
        }
    }

    public static Barn barnToObject(String text) {
        String[] barn1 = text.split(",");
        return new Barn(barn1[0], barn1[1], barn1[2]);
    }

    public static Kontaktperson kontaktToObject(String text) {
        String[] kontakt = text.split(",");
        return new Kontaktperson(kontakt[0], kontakt[1], kontakt[2], kontakt[3]);
    }
}
