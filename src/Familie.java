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
