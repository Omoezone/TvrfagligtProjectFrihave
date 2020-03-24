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

    public static void kontaktPersonMenu(ArrayList<Familie> listF, ArrayList<Kontaktperson> listKP) {
        Scanner console = new Scanner(System.in);
        System.out.println("1. Rediger kontaktperson /n2. Se liste over kontaktpersoner /n3.Slet en kontaktperson /n4. Afslut operation");
        int menuValg = InputHelper.getOptionFromUser(1,5);
        switch(menuValg) {
            case 1:
                for() {
                    for(int i = 0; i < listF.size(); i++) {
                        System.out.println(i + 1 + "\n" + listF.get(i));
                    }
                System.out.println("--------------------------------");
                System.out.println("Indtast talet på den familie, som skal ændres:");
                int sValg = console.nextInt() - 1;
                System.out.println("Hvilken kontaktperson skal ændre på?");
                    if(listF.get(sValg).getKontakt2() == null) {
                        System.out.println(listF.get(sValg).getKontakt1() + "\n");
                        System.out.println("1. fornavn \n2. efter \n3. telefon \n4. email ");
                        int rValg = InputHelper.getOptionFromUser(1,4);
                        switch(rValg) {
                            case 1:
                                System.out.println("Hvad vil du gerne ændre for navn til?");
                                String newFornavn = InputHelper.getStringFromUser(console.next());
                                System.out.println("Fornavn er ændre til " + newFornavn);
                                listF.get(sValg).getKontakt1().setFornavn(newFornavn);
                                break;
                            case 2:
                                System.out.println("Hvad vil du gerne ændre efternavn til?");
                                String newEfternavn = InputHelper.getStringFromUser(console.next());
                                System.out.println("Efternavn er ændre til " + newEfternavn);
                                listF.get(sValg).getKontakt1().setFornavn(newEfternavn);
                                break;
                            case 3:
                                System.out.println("Hvad vil du gerne ændre telefon-nummer til?");
                                String newTelefon = InputHelper.getStringFromUser(console.next());
                                System.out.println("Telefon er ændre til " + newTelefon);
                                listF.get(sValg).getKontakt1().setFornavn(newTelefon);
                                break;
                            case 4:
                                System.out.println("Hvad vil du gerne ændre email til?");
                                String newEmail = InputHelper.getStringFromUser(console.next());
                                System.out.println("Email er ændre til " + newEmail);
                                listF.get(sValg).getKontakt1().setFornavn(newEmail);
                                break;
                            default:
                                System.out.println("Input er ikke identificerbart \nPrøv venglist igen");
                                break;
                        }
                    }
                }
                break;
            case 2:

                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                break;
        }
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
