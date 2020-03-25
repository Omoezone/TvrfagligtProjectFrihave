import java.io.FileNotFoundException;
//import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void menuSelection(ArrayList<Familie> listF, ArrayList<Barn> listB, ArrayList<Kontaktperson> listKP, ArrayList<Medarbejder> listM)throws FileNotFoundException {
        boolean menuFlag = true;
        while (menuFlag) {
            System.out.println("Hvad ønsker du at gøre?\n1. Børn\n2. Vagtplan\n" +
                               "3. Telefonliste\n4. Venteliste for børnehavepladser\n" +
                               "5. Kontaktpersoners oplysninger \n6. Afslutte programmet");
            switch(InputHelper.getOptionFromUser(1,6)) {
                case 1:
                    indskrivData(listB, listF, listKP);
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
                    Kontaktperson.kontaktPersonMenu(listF, listKP);
                    break;
                case 6:
                    FileHandler.loadFamilieToDisk(listF);
                    FileHandler.loadMedarbejderToDisk(listM);
                    System.out.println("Programmet lukker og alle ændring er gemt...");
                    menuFlag = false;
                    break;
                default:
                    System.out.println("Input var ikke en mulig selektion.");
                    menuSelection(listF, listB, listKP, listM);
            }

            //om menuen skal køres igen
            System.out.println("Ønsker du at at gøre andet?\n1. Ja\n2. Nej");
            if (getInt() == 2) {
                menuFlag = false;
            }
        }
    }

    public static void indskrivData(ArrayList<Barn> listB, ArrayList<Familie> listF, ArrayList<Kontaktperson> listKP)throws FileNotFoundException {
        System.out.println("Hvilken data ønsker du at behandle?\n1. Rediger barn\n2. Tilføj barn\n3. Slet barn\n" +
                           "4. Se liste over børn");
        switch(InputHelper.getOptionFromUser(1,5)) {
            case 1:
                System.out.println("Hvilket barn ønsker du at redigere?");
                //TODO print liste over børn til at redigere
                int[] index = new int[1];
                Barn.redigerBarn(Barn.selectBarn(listB, index), listF, index);
                break;
            case 2:
                Familie.opretFamilie(listB, listF, listKP);
                break;
            case 3:
                //TODO sletBarn();
                //Barn.deleteBarn(listB);
                break;
            case 4:
                //TODO printBarnListe();
                Barn.printBarnListe(listB);
                break;
            default:
                System.out.println("Input var ikke en mulig selektion.");
                indskrivData(listB, listF, listKP);
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
