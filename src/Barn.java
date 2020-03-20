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

        System.out.println("Hvad er barnets fornavn?");
        fornavn = input.next();

        System.out.println("Hvad er barnets efternavn?");
        efternavn = input.next();

        System.out.println("Hvad er barnets CPR nummer? Skriv uden mellemrum eller tegn");
        cprnummer = input.next();

        return new Barn(fornavn, efternavn, cprnummer);
    }
}
