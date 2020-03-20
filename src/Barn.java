import java.util.Scanner;

public class Barn {
    private String fornavn;
    private String efternavn;
    private int cprnummer;

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

    public int getCprnummer() {
        return cprnummer;
    }

    public void setCprnummer(int cprnummer) {
        this.cprnummer = cprnummer;
    }

    public Barn(String fornavn, String efternavn, int cprnummer) {
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.cprnummer = cprnummer;
    }

    public Barn opretNytBarn(){
        String fornavn;
        String efternavn;
        int cprnummer;
        Scanner input = new Scanner(System.in);

        System.out.println("Hvad er barnets fornavn?");
        fornavn = input.next();

        System.out.println("Hvad er barnets efternavn?");
        efternavn = input.next();

        System.out.println("Hvad er barnets CPR nummer? Skriv uden mellemrum eller tegn");
        cprnummer = input.nextInt();

        return new Barn(fornavn, efternavn, cprnummer);
    }
}
