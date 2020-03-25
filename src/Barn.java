import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Barn {
    private String fornavn;
    private String efternavn;
    private String cprnummer;

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

    public String getCprnummer() {
        return cprnummer;
    }

    public void setCprnummer(String cprnummer) {
        this.cprnummer = cprnummer;
    }

    public Barn(String fornavn, String efternavn, String cprnummer) {
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.cprnummer = cprnummer;
    }

    //This way of constructing an object makes it smoother and reduces the amount of line coding.
    public Barn(String fornavn, String efternavn, String cprnummer, ArrayList<Barn> listB) {
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.cprnummer = cprnummer;

        listB.add(this);
    }

    public static Barn opretNytBarn(ArrayList<Barn> listB){
        String fornavn;
        String efternavn;
        String cprnummer;
        Scanner input = new Scanner(System.in);

        System.out.print("Venligst indtast barnets fulde navn (Fornavn + Efternavn): ");
        fornavn = input.nextLine();
        efternavn = fornavn.substring(fornavn.lastIndexOf(" ")+1);
        fornavn = fornavn.substring(0, fornavn.lastIndexOf(" "));

        System.out.println("Hvad er barnets CPR nummer? Skriv uden mellemrum eller tegn");
        cprnummer = input.next();
        Barn barn = new Barn(fornavn, efternavn, cprnummer, listB);
        System.out.println("Oprettet barn: \n" + barn.toString());
            return barn;
    }

    public static void redigerBarn(Barn b, ArrayList<Familie> listF, ArrayList<Barn> listB, ArrayList<Kontaktperson> listKP, ArrayList<Medarbejder> listM, int[] index) throws FileNotFoundException {
        System.out.println("Hvad vil du ændre? \n1. Fornavn\n2. Efternavn\n3. CPR nummer\n4. Tilbage til hovedmenuen");
        Scanner input = new Scanner(System.in);

        int redigerSelection = InputHelper.getOptionFromUser(1,4);

        switch (redigerSelection){

            case 1:
                System.out.println("Nuværende fornavn: " + b.getFornavn() + "\nHvad er det nye fornavn?");
                b.setFornavn(input.next());

                System.out.println("Fornavn sat til: " + b.getFornavn() + "\n\nVil du ændre andet? \n1. Ja\n2. Nej");
                int redigerMere = input.nextInt();
                if(redigerMere == 1){
                    redigerBarn(b,listF, listB, listKP,listM, index);
                }
                break;

            case 2:
                System.out.println("Nuværnde efternavn: " + b.getEfternavn() + "\nHvad er det nye efternavn?");
                b.setEfternavn(input.next());

                System.out.println("Efternavn sat til: " + b.getEfternavn() + "\n\nVil du ændre andet? \n1. Ja\n2. Nej");
                redigerMere = input.nextInt();
                if(redigerMere == 1){
                    redigerBarn(b,listF, listB, listKP,listM, index);
                }
                break;

            case 3:
                System.out.println("Nuværende CPR nummer: "+ b.getCprnummer() + "Hvad er det nye CPR nummer?");
                b.setCprnummer(input.next());

                System.out.println("CPR nummer er sat til: " + b.getCprnummer() + "\n\nVil du ændre andet? \n1. Ja\n2. Nej");
                redigerMere = input.nextInt();
                if(redigerMere == 1){
                    redigerBarn(b,listF, listB, listKP,listM, index);
                }
                break;
            case 4:
                Menu.menuSelection(listF, listB, listKP, listM);
            default:
                System.out.println("Input var ikke en mulig selektion.");
                redigerBarn(b,listF, listB, listKP,listM, index);
        }
        listF.get(index[0]).setBarn(b);
    }
    //Select children to editmethod
    public static Barn selectBarn(ArrayList<Barn> listB, int[] index) {
        Scanner console = new Scanner(System.in);
        System.out.println("Vælg det barn, som skal behandles.");
        for(int i = 0; i < listB.size(); i++) {
            System.out.println(i +1 + ". "+ listB.get(i).getFornavn() + " " + listB.get(i).getEfternavn());
        }
        int sValg = InputHelper.getOptionFromUser(1,listB.size()) -1;
        index[0] = sValg;
        System.out.println("Du har valgt at tage fat i " + listB.get(sValg).getFornavn() + " " + listB.get(sValg).getEfternavn());

            return listB.get(sValg);
    }


    public static void deleteBarn(ArrayList<Barn> listB, ArrayList<Familie> listF) {
        Scanner console = new Scanner(System.in);
        System.out.println("Hvilket barn kunne du tænke dig at slette?");
        System.out.println("Liste af eksisterende børn");
            for(int i = 0; i < listB.size(); i++) {
                System.out.println(i + 1 + ". " + listB.get(i).getFornavn() + " " + listB.get(i).getEfternavn());
            }
        int dValg = console.nextInt() - 1;
        System.out.println("Du har valgt at fjerne " + listB.get(dValg).getFornavn() + " " + listB.get(dValg).getEfternavn());
        System.out.println("Ved at foretage denne operation vil du fjerne familien for barnet også");
        System.out.println("Er du sikker? (Ja / Nej)");
        String sValg = console.next();
            if(sValg.equalsIgnoreCase("Ja")) {
                listB.remove(dValg);
                listF.remove(dValg);
            }
    }

    public static void printBarnListe(ArrayList<Barn> listB) {
        System.out.printf("Barn Liste %n");

            for( int i = 0; i < listB.size(); i++) {
                System.out.println(listB.get(i)+"\n");
            }


    }
    public String toString() {
        return "Fornavn: " + fornavn + "\nEfternavn: " + efternavn + "\nCPR-nummer: " + cprnummer;
    }

    public String toFile() {
        return fornavn + "," + efternavn + "," + cprnummer;
    }
    /*public String getFuldenavn(){
        return fornavn + " " + efternavn;
    }*/

    /*public String toString() {
        return "Barnets fuldenavn: " + getFuldenavn() + "\nBarnets CPR: " + cprnummer;
    }*/
}
