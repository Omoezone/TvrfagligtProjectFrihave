import java.util.ArrayList;
import java.util.Scanner;

public class Kontaktperson {
    private String fornavn;
    private String efternavn;
    private String telefon;
    private String email;

    public Kontaktperson(String fornavn, String efternavn, String telefon, String email) {
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.telefon = telefon;
        this.email = email;
    }


    public Kontaktperson(String fornavn, String efternavn, String telefon, String email, ArrayList<Kontaktperson> listKP) {
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.telefon = telefon;
        this.email = email;

        listKP.add(this);
    }

    public static Kontaktperson skabNyKontaktperson(ArrayList<Kontaktperson> listKP) {
        Scanner console = new Scanner(System.in);
        System.out.print("Venligst indtast kontaktpersonens navn: ");
        String navn = console.nextLine();
        //separerer fornavn og efternavn efter sidste mellemrum
        String efternavn = navn.substring(navn.lastIndexOf(" ")+1);
        navn = navn.substring(0, navn.lastIndexOf(" "));

        System.out.print("Venligst indtast "+efternavn+"'s telefonnummer: ");
        String telefon = console.next();
        console.nextLine(); //consume line break input fra ovenstaaende

        System.out.print("Venligst indtast "+efternavn+"'s email: ");
        String email = console.next();
        console.nextLine();

        Kontaktperson temp = new Kontaktperson(navn, efternavn, telefon, email, listKP);
            return temp;
    }

    public String toString() {
        return "Navn: " + fornavn+" "+efternavn+"\nTelefonnummer: "+telefon+"\nEmail: "+email;
    }

    public String toFile() {
        return fornavn + "/n" + efternavn + "/" + telefon + "/n" + email;

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

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
