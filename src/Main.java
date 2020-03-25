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
        System.out.println("Velkommen til Roskilde Frie Børnehave\n");
        Menu.menuSelection(listF, listB, listKP, listM);
    }
}
