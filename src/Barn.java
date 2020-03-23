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

    public String toString() {
        return "Fornavn: " + fornavn + "\nEfternavn: " + efternavn + "\nCPR-nummer: " + cprnummer;
    }

    public String toFile() {
        return fornavn + "|" + efternavn + "|" + cprnummer;
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

    public static void createNyBarn(ArrayList<Barn> listB, ArrayList<Barn> listVL) {
        if(listB.size() <= 99) {

        }
    }

    public static Barn opretNytBarn(){
        String fornavn;
        String efternavn;
        String cprnummer;
        Scanner input = new Scanner(System.in);

        System.out.print("Venligst indtast barnest navn: ");
        fornavn = input.nextLine();
        efternavn = fornavn.substring(fornavn.lastIndexOf(" ")+1);
        fornavn = fornavn.substring(0, fornavn.lastIndexOf(" "));

        System.out.println("Hvad er barnets CPR nummer? Skriv uden mellemrum eller tegn");
        cprnummer = input.next();
        Barn barn = new Barn(fornavn, efternavn, cprnummer);
        System.out.println("Oprettet barn: \n" + barn.toString());
        return barn;
    }

    public static void redigerBarn(Barn b){
        System.out.println("Hvad vil du ændre? \n1. Fornavn\n2. Efternavn\n3. CPR nummer\n\n0. Tilbage til hovedmenuen");
        Scanner input = new Scanner(System.in);
        int redigerSelection = input.nextInt();

        switch (redigerSelection){
            case 0:
                break;
            case 1:
                System.out.println("Nuværende fornavn: " + b.getFornavn() + "\nHvad er det nye fornavn?");
                b.setFornavn(input.next());

                System.out.println("Fornavn sat til: " + b.getFornavn() + "\n\nVil du ændre andet? 1. Ja\n0. Nej");
                int redigerMere = input.nextInt();
                if(redigerMere == 1){
                    redigerBarn(b);
                }
                break;

            case 2:
                System.out.println("Nuværnde efternavn: " + b.getEfternavn() + "\nHvad er det nye efternavn?");
                b.setEfternavn(input.next());

                System.out.println("Efternavn sat til: " + b.getEfternavn() + "\n\nVil du ændre andet? 1. Ja\n0. Nej");
                redigerMere = input.nextInt();
                if(redigerMere == 1){
                    redigerBarn(b);
                }
                break;

            case 3:
                System.out.println("Nuværende CPR nummer: "+ b.getCprnummer() + "Hvad er det nye CPR nummer?");
                b.setCprnummer(input.next());

                System.out.println("CPR nummer er sat til: " + b.getCprnummer() + "\n\nVil du ændre andet? 1. Ja\n0. Nej");
                redigerMere = input.nextInt();
                if(redigerMere == 1){
                    redigerBarn(b);
                }
                break;

            default:
                System.out.println("Input var ikke en mulig selektion.");
                redigerBarn(b);
        }
    }

    //Author Michael Berko
    public static void deleteBarn(ArrayList<Barn> listB) {
        Scanner console = new Scanner(System.in);
        System.out.println("Hvilket barn kunne du tænke dig at slette?");
        System.out.println("Liste of eksisterende børn");
            for(int i = 0; i < listB.size(); i++) {
                System.out.println(i + 1 + ". " + listB.get(i).getFornavn() + " " + listB.get(i).getEfternavn());
            }
        int dValg = console.nextInt() - 1;
        System.out.println("Du har valgt at fjerne " + listB.get(dValg).getFornavn() + " " + listB.get(dValg).getEfternavn());
        System.out.println("Er du sikker?");
        String sValg = console.next();
            if(sValg.equalsIgnoreCase("Ja")) {
                listB.remove(dValg);
            }
    }

    public static void printBarnListe(ArrayList<Barn> listB) {
        System.out.printf("Barn Liste");

            for( int i = 0; i < listB.size(); i++) {
                System.out.print(listB.get(i));
            }


    }

    public String getFuldenavn(){
        return fornavn + " " + efternavn;
    }
    /*public String toString() {
        return "Barnets fuldenavn: " + getFuldenavn() + "\nBarnets CPR: " + cprnummer;
    }*/
}
