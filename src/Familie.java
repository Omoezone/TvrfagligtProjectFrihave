import java.io.FileNotFoundException;

public class Familie {
    private Barn barn;
    private Kontaktperson kontakt1;
    private Kontaktperson kontakt2;
    private Kontaktperson kontakt3;

    public Familie(Barn barn, Kontaktperson kontakt1) {
        this.barn = barn;
        this.kontakt1 = kontakt1;
    }

    public Familie(Barn barn, Kontaktperson kontakt1, Kontaktperson kontakt2) {
        this.barn = barn;
        this.kontakt1 = kontakt1;
        this.kontakt2 = kontakt2;
    }

    public Familie(Barn barn, Kontaktperson kontakt1, Kontaktperson kontakt2, Kontaktperson kontakt3) {
        this.barn = barn;
        this.kontakt1 = kontakt1;
        this.kontakt2 = kontakt2;
        this.kontakt3 = kontakt3;
    }

    public static Familie opretFamilie()throws FileNotFoundException {
        Barn nytBarn = Barn.opretNytBarn();
        System.out.println("Der skal nu tilføjes en kontaktperson til "+nytBarn.getFornavn()+" "+nytBarn.getEfternavn()+".");
        Kontaktperson kontakt1 = Kontaktperson.skabNyKontaktperson();
        System.out.println("Skal der tilføjes flere kontaktpersoner til "+nytBarn.getFornavn()+" "+nytBarn.getEfternavn()+"?"+
                           "\n1. Ja\n2. Nej");
        if(Menu.getInt() == 2) {
           Familie temp = new Familie(nytBarn, kontakt1);
           FileHandler.loadFamilieToDisk(temp);
            return temp;
        } else {
            Kontaktperson kontakt2 = Kontaktperson.skabNyKontaktperson();
            System.out.println("Skal der tilføjes flere kontaktpersoner til "+nytBarn.getFornavn()+" "+nytBarn.getEfternavn()+"?"+
                               "\n1. Ja\n2. Nej");
            if(Menu.getInt() == 2) {
                Familie temp = new Familie(nytBarn, kontakt1, kontakt2);
                FileHandler.loadFamilieToDisk(temp);
                    return temp;
            } else {
                Kontaktperson kontakt3 = Kontaktperson.skabNyKontaktperson();
                Familie temp = new Familie(nytBarn, kontakt1, kontakt2, kontakt3);
                FileHandler.loadFamilieToDisk(temp);
                    return temp;
            }
        }

    }

    public String toFile() {
        if(kontakt2 == null) {
            return getBarn().getFornavn() + "|" + getBarn().getEfternavn()+ "|" + getBarn().getCprnummer() + "/" + getKontakt1Info();
        } else if(kontakt3 == null) {
            return getBarn().getFornavn() + "|" + getBarn().getEfternavn()+ "|" + getBarn().getCprnummer() + "/\"" + getKontakt1Info() + "\"" + getKontakt2Info();
        } else {
            return getBarn().getFornavn() + "|" + getBarn().getEfternavn()+ "|" + getBarn().getCprnummer() + "/\"" + getKontakt1Info()+ "\"" + getKontakt2Info() + "\"" + getKontakt3Info();
        }
    }

    public String getKontakt1Info() {
        return getKontakt1().getFornavn() + "|" + getKontakt1().getEfternavn() + "|" + getKontakt1().getTelefon() + "|" + getKontakt1().getAddresse() + "|" + getKontakt1().getEmail();
    }

    public String getKontakt2Info() {
        return getKontakt2().getFornavn() + "|" + getKontakt2().getEfternavn() + "|" + getKontakt2().getTelefon() + "|" + getKontakt2().getAddresse() + "|" + getKontakt2().getEmail();
    }

    public String getKontakt3Info() {
        return getKontakt3().getFornavn() + "|" + getKontakt3().getEfternavn() + "|" + getKontakt3().getTelefon() + "|" + getKontakt3().getAddresse() + "|" + getKontakt3().getEmail();
    }

    public String toString() {
        if(kontakt2 == null) {
            return "Barnets navn: "+barn.getFornavn()+" "+barn.getEfternavn()+"" +
                    "\nKontaktperson 1: "+kontakt1.getFornavn()+" "+kontakt1.getEfternavn();
        } else if (kontakt3 == null) {
            return "Barnets navn: "+barn.getFornavn()+" "+barn.getEfternavn()+"" +
                    "\nKontaktperson 1: "+kontakt1.getFornavn()+" "+kontakt1.getEfternavn()+
                    "\nKontaktperson 2: "+kontakt2.getFornavn()+" "+kontakt2.getEfternavn();
        } else {
            return "Barnets navn: "+barn.getFornavn()+" "+barn.getEfternavn()+"" +
                    "\nKontaktperson 1: "+kontakt1.getFornavn()+" "+kontakt1.getEfternavn()+
                    "\nKontaktperson 2: "+kontakt2.getFornavn()+" "+kontakt2.getEfternavn()+
                    "\nKontaktperson 3: "+kontakt3.getFornavn()+" "+kontakt3.getEfternavn();
        }
    }

    public Barn getBarn() {
        return barn;
    }

    public void setBarn(Barn barn) {
        this.barn = barn;
    }

    public Kontaktperson getKontakt1() {
        return kontakt1;
    }

    public void setKontakt1(Kontaktperson kontakt1) {
        this.kontakt1 = kontakt1;
    }

    public Kontaktperson getKontakt2() {
        return kontakt2;
    }

    public void setKontakt2(Kontaktperson kontakt2) {
        this.kontakt2 = kontakt2;
    }

    public Kontaktperson getKontakt3() {
        return kontakt3;
    }

    public void setKontakt3(Kontaktperson kontakt3) {
        this.kontakt3 = kontakt3;
    }
}
