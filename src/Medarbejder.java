import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

//Author: Michael Berko
public class Medarbejder {
    //Fields
    private String fornavn;
    private String efternavn;
    private String arbejdsdag;
    private String tidsrum;

    //Constructur, that constructs the object.
    public Medarbejder(String fornavn, String efternavn,String arbejdsdag, String tidsrum, ArrayList<Medarbejder> listM)  {
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.arbejdsdag = arbejdsdag;
        this.tidsrum = tidsrum;

        //adds the objects that's just been created to an ArrayList of its type.
        listM.add(this);
    }
    //Mutator and Accessor methods for each field as they are private.
    public String getArbejdsdag() {
        return arbejdsdag;
    }

    public void setArbejdsdag(String arbejdsdag) {
        this.arbejdsdag = arbejdsdag;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEfternavn() {
        return efternavn;
    }

    public void setEfternavn(String efternavn) {
        this.efternavn = efternavn;
    }

    public String getTidsrum() {
        return tidsrum;
    }

    public void setTidsrum(String tidsrum) {
        this.tidsrum = tidsrum;
    }

    public String toString() {
        return String.format("Medarbejder: %s %s - %s", fornavn, efternavn, tidsrum);
    }

    public String toFile() {
        return fornavn + "|" + efternavn + "|" + arbejdsdag + "|" + tidsrum;
    }
    //A method that creates the object by making the user type in the data.
    private static void createMedarbejder(ArrayList<Medarbejder> listM) {
        Scanner console = new Scanner(System.in);
        System.out.println("Indtast medarbejder fornavn");
        String fornavn = console.next();
        System.out.println("Indtast medarbejder efternavn");
        String efternavn = console.next();
        System.out.println("Indtast medarbejderens arbejdsdag");
        String ugedag = console.next();
        System.out.println("Indtast medarbejders arbejdsperiode \nFormat: starttidspunkt-sluttidspunkt");
        String tidsrum = console.next();

        Medarbejder temp = new Medarbejder(fornavn, efternavn, ugedag, tidsrum, listM);
        System.out.println("Medarbejders vagtplan er blevet oprettet \n" + temp);
    }
    //A method to edit each object of Medarbejder Class in listM. (Medarbejder ArrayList)
    private static void editMedarbejder(ArrayList<Medarbejder> listM) {
        Scanner console = new Scanner(System.in);
        System.out.println("Her er listen over medarbejder");
        for(int i = 0; i < listM.size(); i++) {
            System.out.println(listM.get(i));
        }
        System.out.println("Hvilken medarbejer ønsker du at ændre?");
        for(int i = 0; i < listM.size(); i++) {
            System.out.println(1 + i + ". " + listM.get(i));
        }
        int valg = console.nextInt() - 1;
        System.out.println("Du har valgt at ændre i følgende: " + listM.get(valg) + "\nHvad kunne du tænke dig at ændre?");
        System.out.println("1. fornavn \t2. Efternavn \t3. Vagtplan");
        int rValg = console.nextInt();
        switch(rValg) {
            case 1:
                System.out.println("Medarbejder fornavn nu " + listM.get(valg).getFornavn());
                System.out.println("Indtast venligst det ændrede fornavn");
                String newFornavn = console.next();
                listM.get(valg).setFornavn(newFornavn);
                System.out.println("Medarbejders fornavn er ændret til " + listM.get(valg).getFornavn());
                break;
            case 2:
                System.out.println("Medarbejder efternavn nu " + listM.get(valg).getEfternavn());
                System.out.println("Indtast venligst det ændrede efternavn");
                String newEfternavn = console.next();
                listM.get(valg).setEfternavn(newEfternavn);
                System.out.println("Medarbejder efternavn er ændret til " + listM.get(valg).getEfternavn());
                break;
            case 3:
                System.out.println("Medarbejders arbejdsperiode nu " + listM.get(valg).getTidsrum());
                System.out.println("Indtast venligst den nye arbejdstid\nFormat start-sluttidspunkt");
                String newTidsrum = console.next();
                listM.get(valg).setTidsrum(newTidsrum);
                System.out.println("Medarbejderens nye arbejdstid er ændret til " + listM.get(valg).getTidsrum());
                break;
            default:
                System.out.println("Input er ikke identificerbart \nPrøv venligst igen");
                Medarbejder.editMedarbejder(listM);
        }
    }

    private static void deleteMedarbejder(ArrayList<Medarbejder> listM) {
        Scanner console = new Scanner(System.in);
        System.out.println("Her er en liste over eksisterende medarbejdere");
        for(int i = 0; i < listM.size(); i++) {
            System.out.println(1 + i + ". " + listM.get(i));
        }
        System.out.println("Hvilken medarbejder ønsker du at fjerne?");
        int dValg = console.nextInt() - 1;
        System.out.println("Du har valgt at fjerne " + listM.get(dValg) + "\nEr du sikker?");
        String sValg = console.next();
        if(sValg.equalsIgnoreCase("ja")) {
            System.out.println(listM.get(dValg) + "er blevet slettet.");
            listM.remove(listM.get(dValg));
        } else {
            Medarbejder.deleteMedarbejder(listM);
        }

    }

    private static void showMedarbejderList(ArrayList<Medarbejder> listM) {
        System.out.println("Liste over eksisterende medarbejdere. \n");
            for(int i = 0; i < listM.size(); i++) {
                System.out.println(listM.get(i));
            }
    }

    private static void searchForMedarbejder(ArrayList<Medarbejder> listM) {
        Scanner console = new Scanner(System.in);
        System.out.println("Hvad ønsker du at søge udfra");
        System.out.println("1. fornavn \t2. Medarbejder efternavn \t3. Medarbejder arbejdsdag \t4. Medarbejder arbejdsperiode");
        int sfValg = console.nextInt();
        switch(sfValg) {
            case 1:
                System.out.println("Her kan du søge efter medarbejdere udfra fornavn");
                String sFornavn = console.next();
                    for(int i = 0; i < listM.size(); i++) {
                        if(sFornavn.equalsIgnoreCase(listM.get(i).fornavn)) {
                            System.out.println(listM.get(i));
                        } else {
                            System.out.println("Ingen medarbejder med fornavnet " + sFornavn + "eksisterer i systemet.");
                        }
                    }
                    break;
            case 2:
                System.out.println("Her kan du søge efter medarbejdere udfra fornavn");
                String sEfternavn = console.next();
                for(int i = 0; i < listM.size(); i++) {
                    if(sEfternavn.equalsIgnoreCase(listM.get(i).efternavn)) {
                        System.out.println(listM.get(i));
                    }
                }
                break;
            case 3:
                System.out.println("Her kan du søge efter medarbejdere udfra hverdag");
                System.out.println("1. Mandag \t2. Tirsdag \t3.Onsdag \t4. Torsdag \t5. Fredag");
                int dValg = console.nextInt();
                switch(dValg) {
                    case 1:
                        System.out.println("Her er listen for medarbejdere som arbejder mandag");
                        for(int i = 0; i < listM.size(); i++) {
                            if(listM.get(i).getArbejdsdag().equalsIgnoreCase("Mandag")) {
                                System.out.println(listM.get(i));
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Her er listen for medarbejdere som arbejder tirsdag");
                        for(int i = 0; i < listM.size(); i++) {
                            if(listM.get(i).getArbejdsdag().equalsIgnoreCase("Tirsdag")) {
                                System.out.println(listM.get(i));
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Her er listen for medarbejdere som arbejder onsdag");
                        for(int i = 0; i < listM.size(); i++) {
                            if(listM.get(i).getArbejdsdag().equalsIgnoreCase("onsdag")) {
                                System.out.println(listM.get(i));
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Her er listen for medarbejdere som arbejder torsdag");
                        for(int i = 0; i < listM.size(); i++) {
                            if(listM.get(i).getArbejdsdag().equalsIgnoreCase("torsdag")) {
                                System.out.println(listM.get(i));
                            }
                        }
                        break;

                    case 5:
                        System.out.println("Her er listen for medarbejdere som arbejder fredag");
                        for(int i =0; i < listM.size(); i++) {
                            if(listM.get(i).getArbejdsdag().equalsIgnoreCase("Fredag")) {
                                System.out.println(listM.get(i));
                            }
                        }
                        break;
                    default:
                        System.out.println("Input er ikke idenficerbar \nDu bliver nu sendt tilbage til søgemenuen");
                        Medarbejder.searchForMedarbejder(listM);
                        break;


                }
            case 4:
                System.out.println("Her kan du søge efter medarbejder udfra deres arbejdsperiode");
                String arbejdsperiode = Medarbejder.getStringFromUser(console.next());
                for(int i = 0; i < listM.size(); i++) {
                    if(arbejdsperiode.equalsIgnoreCase(listM.get(i).tidsrum)) {
                        System.out.println(listM.get(i));
                    }
                }
                break;
            default:
                System.out.println("Input er ikke idenficerbart\nPrøv venligst igen");
                searchForMedarbejder(listM);
                break;

        }

    }

    private static void viewVagtPlan(ArrayList<Medarbejder> listM) {
        System.out.println("- Mandag");
            for(int i = 0; i < listM.size(); i++) {
                if(listM.get(i).getArbejdsdag().equalsIgnoreCase("Mandag")) {
                    System.out.println(listM.get(i));
                }
            }
        System.out.println("- Tirsdag");
            for(int i = 0; i < listM.size(); i++) {
                if(listM.get(i).getArbejdsdag().equalsIgnoreCase("Tirsdag")) {
                    System.out.println(listM.get(i));
                }
            }
        System.out.println("- Onsdag");
            for(int i = 0; i < listM.size(); i++) {
                if(listM.get(i).getArbejdsdag().equalsIgnoreCase("Onsdag")) {
                    System.out.println(listM.get(i));
                }
            }
        System.out.println("- Torsdag");
            for(int i = 0; i < listM.size(); i++) {
                if(listM.get(i).getArbejdsdag().equalsIgnoreCase("Torsdag")) {
                    System.out.println(listM.get(i));
                }
            }
        System.out.println("- Fredag");
            for(int i = 0; i < listM.size(); i++) {
                if(listM.get(i).getArbejdsdag().equalsIgnoreCase("Fredag")) {
                    System.out.println("\t" + listM.get(i));
                }
            }
        System.out.println();
    }

    public static void menuMedarbejderVagtplan(ArrayList<Medarbejder> listM) {
        Scanner console = new Scanner(System.in);
        boolean flag = true;
        while(flag) {
            System.out.println("1. Opret en medarbejder \n2. Redigere en medarbejder \n3. Slette en medarbejder \t4. Se medarbejdersliste \n5. Se medarbejdervagtplan \n6.for afslutte medarbejdermenuen");
            int valg = console.nextInt();
            switch (valg) {
                case 1:
                    Medarbejder.createMedarbejder(listM);
                    break;
                case 2:
                    Medarbejder.editMedarbejder(listM);
                    break;
                case 3:
                    Medarbejder.deleteMedarbejder(listM);
                    break;
                case 4:
                    Medarbejder.showMedarbejderList(listM);
                    break;
                case 5:
                    Medarbejder.viewVagtPlan(listM);
                    break;
                case 6:
                    System.out.println("Forlader medarbejdermenu...");
                    flag = false;
                    break;
                default:
                    System.out.println("Input er ikke idenficerbart \nPrøv venligst igen");
                    Medarbejder.menuMedarbejderVagtplan(listM);
                    break;
            }
        }
    }
    public static String getStringFromUser(String title) {
        Scanner scanInput = new Scanner(System.in);

        System.out.printf("Please enter the " + title + " of the person%n");
        String name = scanInput.next();
        while (name.matches(".*\\d.*")) {
            System.out.printf("A " + title + " cannot contain a number! Please try again%n");
            name = scanInput.next();
        }
        return name;
    }
}

