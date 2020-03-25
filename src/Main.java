import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Medarbejder> listM = FileHandler.loadMedarbejderFromDisk();
        ArrayList<Familie> listF = new ArrayList<>();
        ArrayList<Barn> listB = new ArrayList<>();
        ArrayList<Kontaktperson> listKP = new ArrayList<>();
        FileHandler.readFromFamilieData(listF, listB, listKP);
        //ArrayList<Medarbejder> listM = FileHandler.loadMedarbejderFromDisk();
        //ArrayList<Barn> listB = FileHandler.loadBarnFromDisk();
        //ArrayList<Kontaktperson> listKP = FileHandler.loadKontaktPersonFromDisk();
        //Medarbejder.menuMedarbejderVagtplan(listM);
        System.out.println("Velkommen til Roskilde Frie Børnehave\n");
        Menu.menuSelection(listF, listB, listKP, listM);
    }
}
