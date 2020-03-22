import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void menuSelection(ArrayList<Medarbejder> listM) {
        boolean menuFlag = true;
        while (menuFlag) {
            System.out.println("Hvad ønsker du at gøre?\n1. Indskriv data\n2. Opret vagtplan\n" +
                               "3. Opret telefonliste\n4. Venteliste for børnehavepladser\n" +
                               "5. Kontaktpersoners oplysninger");
            switch(getInt()) {
                case 1:
                    indskrivData();
                    break;
                case 2:
                    //TODO opretVagtplan();
                    Medarbejder.menuMedarbejderVagtplan(listM);
                    break;
                case 3:
                    //TODO opretTelefonliste();
                    break;
                case 4:
                    //TODO venteliste();
                    break;
                case 5:
                    //TODO kontaktpersoner();
                    break;
                default:
                    System.out.println("Input var ikke en mulig selektion.");
                    menuSelection(listM);
            }

            //om menuen skal kores igen
            System.out.println("Ønsker du at at gøre andet?\n1. Ja\n2. Nej");
            if (getInt() == 2) {
                menuFlag = false;
            }
        }
    }

    public static void indskrivData() {
        System.out.println("Hvilken data ønsker du at behandle?\n1. Rediger barn\n2. Tilføj barn\n3. Slet barn\n" +
                           "4. Se liste over børn");
        switch(getInt()) {
            case 1:
                System.out.println("Hvilket barn ønsker du at redigere?");
                //TODO print liste over børn til at redigere
                //Barn.redigerBarn(redigeringsValg);
                break;
            case 2:
                Familie nyFamilie = Familie.opretFamilie();
                System.out.println(nyFamilie.toString());
                //gem nyFamilie i familie objekt
                break;
            case 3:
                //TODO sletBarn();
                break;
            case 4:
                //TODO printBarnListe();
                break;
            default:
                System.out.println("Input var ikke en mulig selektion.");
                indskrivData();;
        }
    }

    public static int getInt() {
        Scanner console = new Scanner(System.in);
        System.out.print("Indtast venligst tallet for det ønskede menupunkt: ");
        while(!console.hasNextInt()) {
            System.out.println("Input var ikke et tal.");
            System.out.print("Indtast venligst tallet for det ønskede menupunkt: ");
            console.nextLine();
        }
        return console.nextInt();
    }

    public static void createVagtPlan() {
        System.out.println("Medarbejder/tTidsrum");

    }
}
