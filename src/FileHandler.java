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
        System.out.println(cut[0]);
        System.out.println(cut[1]);

        Barn barn = barnToObject(cut[0]);
        listB.add(barn);
        String[] adult = cut[1].split("\"");
        for (int i = 0; i < adult.length; i++) {
            kontakt.add(kontaktToObject(adult[i]));
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
        System.out.println(temp);
            return temp;
    }

    public static Kontaktperson kontaktToObject(String text) {
        String[] kontakt = text.split(",");

        Kontaktperson temp = new Kontaktperson(kontakt[0], kontakt[1], kontakt[2], kontakt[3]);
        System.out.println(temp);
            return temp;
    }
}
