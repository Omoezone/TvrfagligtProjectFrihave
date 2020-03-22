import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Medarbejder> listM = new ArrayList<>();
        Medarbejder.menuMedarbejderVagtplan(listM);
        System.out.println("hello");
        Kontaktperson test = Kontaktperson.skabNyKontaktperson();
        System.out.println(test);
    }
}
