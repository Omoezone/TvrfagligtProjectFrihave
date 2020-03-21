import java.util.ArrayList;
import java.util.Scanner;

public class Medarbejder {
    private String fornavn;
    private String efternavn;
    private String tidsrum;

    public Medarbejder(String fornavn, String efternavn, String tidsrum, ArrayList<Medarbejder> listM)  {
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.tidsrum = tidsrum;

        listM.add(this);
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

    public static void createMedarbejder(ArrayList<Medarbejder> listM) {
        Scanner console = new Scanner(System.in);
        System.out.println("Indtast medarbejder fornavn");
        String fornavn = console.next();
        System.out.println("Indtast medarbejder efternavn");
        String efternavn = console.next();
        System.out.println("Indtast medarbejders arbejdsperiode \nFormat: starttidspunkt-sluttidspunkt");
        String tidsrum = console.next();

        Medarbejder temp = new Medarbejder(fornavn, efternavn, tidsrum, listM);
        System.out.println("Medarbejders vagtplan er blevet oprettet \n" + temp);
    }

    public static void editMedarbejder(ArrayList<Medarbejder> listM) {
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

    public static void deleteMedarbejder(ArrayList<Medarbejder> listM) {
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
            listM.remove(listM.get(dValg));
        } else {
            Medarbejder.deleteMedarbejder(listM);
        }

    }
}
