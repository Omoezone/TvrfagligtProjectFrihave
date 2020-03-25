import java.io.FileNotFoundException;
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


    public String getFullNavn() {
        return fornavn + " " + efternavn;
    }
// En metode, som redigerer kontaktpersonen i henholdsvis listF (liste af familier) og listKP (Liste af kontaktpersoner)
    public static void redigerKontaktperson(ArrayList<Familie> listF, ArrayList<Kontaktperson> listKP) {
        Scanner console = new Scanner(System.in);
        System.out.println("Hvilken kontaktperson vil du gerne ændre?");
            for(int i = 0; i < listKP.size(); i++) {
                System.out.println(1 + i + ". " + listKP.get(i));
            }
            int valg = console.nextInt() - 1;
        System.out.println("Du har valgt at ændre på " + listKP.get(valg) + ", hvad vil du gerne ændre?");
        System.out.println("1. for fornavn \n2. for efternavn \n3. for telefon");
        int rValg = console.nextInt();
            switch(rValg) {
                case 1:
                    System.out.println("fornavn for pågældende er " + listKP.get(valg).getFornavn());
                    System.out.println("Hvad ønsker du at ændre fornavn til?");
                    String newFornavn = console.next();
                    //Her sker der noget smart, ved at vi bruge en if/else if/else if, så er der kun en mulighed, derfor tester vi efter om,
                    //der er noget match i familielisten, hvis der er et match, så bliver fornavnet også redigeret der.
                    for(int i = 0; i < listF.size(); i++) {
                        if(listF.get(i).getKontakt1().equals(listKP.get(valg))) {
                            listF.get(i).getKontakt1().setFornavn(newFornavn);
                        }
                        else if(listF.get(i).getKontakt2().equals(listKP.get(valg))) {
                            listF.get(i).getKontakt2().setFornavn(newFornavn);
                        }
                        else if(listF.get(i).getKontakt3().equals(listKP.get(valg))) {
                            listF.get(i).getKontakt3().setFornavn(newFornavn);
                        }
                    }
                    listKP.get(valg).setFornavn(newFornavn);
                    System.out.println("Fornavn på pågældende er ændret til " + newFornavn);
                    break;

                case 2:
                    System.out.println("Efternavnet for pågældende er " + listKP.get(valg).getEfternavn());
                    System.out.println("Hvad ønsker du at ændre efternavn til?");
                    String newEfternavn = console.next();
                    //Her gør vi det samme som for fornavn, derfor undlader jeg at gentage mig selv.
                    for(int i = 0; i < listF.size();i++) {
                        if(listF.get(i).getKontakt1().equals(listKP.get(valg))) {
                            listF.get(i).getKontakt1().setEfternavn(newEfternavn);
                        }
                        else if(listF.get(i).getKontakt2().equals(listKP.get(valg))) {
                            listF.get(i).getKontakt2().setEfternavn(newEfternavn);
                        }
                        else if(listF.get(i).getKontakt3().equals(listKP.get(valg))) {
                            listF.get(i).getKontakt3().setEfternavn(newEfternavn);
                        }
                    }
                    listKP.get(valg).setEfternavn(newEfternavn);
                    System.out.println("Efternavn for påglædende er ændret til " + newEfternavn);
                    break;

                case 3:
                    System.out.println("Telefon for pågældende er " + listKP.get(valg).getTelefon());
                    System.out.println("Hvad ønsker du at ændre eftternavn til?");
                    String newTelefon = console.next();
                    for(int i = 0; i < listF.size(); i ++) {
                        if(listF.get(i).getKontakt1().equals(listKP.get(valg))) {
                            listF.get(i).getKontakt1().setTelefon(newTelefon);
                        }
                        else if(listF.get(i).getKontakt2().equals(listKP.get(valg))) {
                            listF.get(i).getKontakt2().setTelefon(newTelefon);
                        }
                        else if(listF.get(i).getKontakt3().equals(listKP.get(valg))) {
                            listF.get(i).getKontakt3().setTelefon(newTelefon);
                        }
                    }
                    listKP.get(valg).setTelefon(newTelefon);
                    System.out.println("Efternavn for pågældende er ændret til " + listKP.get(valg).getTelefon());
                    break;
                case 4:
                    System.out.println("Email for pågældende er " + listKP.get(valg).getEmail());
                    System.out.println("Hvad ønsker du at ændre email til?");
                    String newEmail = console.next();
                    for(int i = 0; i < listF.size(); i++) {
                        if(listF.get(i).getKontakt1().equals(listKP.get(valg))) {
                            listF.get(i).getKontakt1().setEmail(newEmail);
                        }
                        else if(listF.get(i).getKontakt2().equals(listKP.get(valg))) {
                            listF.get(i).getKontakt2().setEmail(newEmail);
                        }
                        else if(listF.get(i).getKontakt3().equals(listKP.get(valg))) {
                            listF.get(i).getKontakt3().setEmail(newEmail);
                        }
                    }
                    listKP.get(valg).setEmail(newEmail);
                    System.out.println("Efternavn for pågældende er " + listKP.get(valg).getEmail());
                    break;
                default:
                    System.out.println("Input er ikke identificerbart \nPrøv venligst igen");
                    redigerKontaktperson(listF, listKP);
                    break;
                }

            }

    public static void kontaktPersonMenu(ArrayList<Familie> listF, ArrayList<Kontaktperson> listKP) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        System.out.println("1. Rediger kontaktperson \n2. Se liste over kontaktpersoner \n3. Slet en kontaktperson \n4. Afslut operation");
        int menuValg = InputHelper.getOptionFromUser(1,5);
        switch(menuValg) {
            case 1:
                Kontaktperson.redigerKontaktperson(listF, listKP);
                    break;

            case 2:
                //We do a for loop to loop through each element in the list of families
                //Then we print each contact person out from the family-object.
                System.out.println("Liste over kontaktpersoner");
                    for(int i = 0; i < listF.size(); i++) {
                        System.out.println(1 + i + ".\n" + listF.get(i).getKontakt1() + "\n" + listF.get(i).getKontakt2() + "\n" + listF.get(i).getKontakt3());
                    }
                System.out.println("--------------------------------");
                break;
            case 3:
                System.out.println("Her er en liste over eksisterende familier");
                    for(int i = 0; i < listF.size(); i++) {
                        System.out.println(1 + i + "\n" + listF.get(i));
                    }
                System.out.println("Vælg venligst, hvilken familie som skal have fjernet en kontaktperson.");
                int dValg = console.nextInt() - 1;
                if(listF.get(dValg).getSize() == 2){
                    listF.remove(listF.get(dValg).getKontakt1());
                } if(listF.get(dValg).getSize() == 3) {
                    System.out.println("Hvilken af kontaktpersonerne vil du slette?");
                    System.out.println("1. " + listF.get(dValg).getKontakt1() + "\n2. " + listF.get(dValg).getKontakt2());
                    int sletKP = console.nextInt();
                        if(sletKP == 1) {
                            listF.remove(listF.get(dValg).getKontakt1());
                        }if(sletKP == 2) {
                            listF.remove(listF.get(dValg).getKontakt2());
                        }
                } if(listF.get(dValg).getSize() == 4) {
                    System.out.println("Hvilken af kontaktpersonerne vil du slette?");
                    System.out.println("1. " + listF.get(dValg).getKontakt1() + "\n2. " + listF.get(dValg).getKontakt2() + "\n3. " + listF.get(dValg).getKontakt3());
                    int sletKP2 = console.nextInt();
                        if(sletKP2 == 1) {
                            listF.remove(listF.get(dValg).getKontakt1());
                        } if(sletKP2 == 2) {
                            listF.remove(listF.get(dValg).getKontakt2());
                        } if(sletKP2 == 3) {
                            listF.remove(listF.get(dValg).getKontakt3());
                    }
                }
                System.out.println(listF);
                FileHandler.saveFamilieToDisk(listF);


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
    public String toString() {
        return "Navn: " + fornavn+" "+efternavn+"\nTelefonnummer: "+telefon+"\nEmail: "+email;
    }
    public String toFile() {
        return fornavn + "/n" + efternavn + "/" + telefon + "/n" + email;
    }

}
