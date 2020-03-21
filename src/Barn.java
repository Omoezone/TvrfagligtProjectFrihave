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

    public void setCprnummer(String cprnummer) {
        this.cprnummer = cprnummer;
    }

    public Barn(String fornavn, String efternavn, String cprnummer) {
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.cprnummer = cprnummer;
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
}
