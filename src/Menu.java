import java.util.Scanner;

public class Menu {
    public static void menuSelection() {
        boolean menuFlag = true;
        int selection;
        while (menuFlag) {
            System.out.println("Hvad ønsker du at gøre?\n1. Indskriv data\n2. Opret vagtplan\n" +
                               "3. Opret telefonliste\n4. Venteliste for børnehavepladser\n" +
                               "5. Kontaktpersoners oplysninger");
            selection = getInt();
            switch(selection) {
                case 1:
                    indskrivData();
                    break;
                case 2:
                    //TODO opretVagtplan();
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
                    menuSelection();
            }

            //om menuen skal kores igen
            System.out.println("Ønsker du at at gøre andet?\n1. Ja\n2. Nej");
            if (getInt() == 2) {
                menuFlag = false;
            }
        }
    }

    public static void indskrivData() {
        System.out.println("Hvilken data ønsker du at behandle?");
    }

    public static int getInt() {
        Scanner console = new Scanner(System.in);
        System.out.print("Indtast venligst tallet for det ønskede menupunkt: ");
        while(!console.hasNextInt()) {
            System.out.println("Input var ikke et tal.");
            System.out.print("Indtast venligst tallet for det ønskede menupunkt: ");
            console.next();
        }
        return console.nextInt();
    }
}
