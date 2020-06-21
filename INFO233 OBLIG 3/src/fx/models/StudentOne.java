package fx.models;

public class StudentOne {

    //setter private parametre som skal være mer i klassen
    private String kursnavn;

    private String kurs;

    private String karakter;

    private String year;

    //gir dem string values, og = hva jeg vil at de skal hete
    public StudentOne(String kursnavn, String kurs, String karakter, String year) {

        this.kursnavn = kursnavn;

        this.kurs = kurs;

        this.karakter = karakter;

        this.year = year;
    }

    //alt + insert getters and setters

    public String getKursnavn() {
        return kursnavn;
    }

    public void setKursnavn(String kursnavn) {
        this.kursnavn = kursnavn;
    }

    public String getKurs() {
        return kurs;
    }

    public void setKurs(String kurs) {
        this.kurs = kurs;
    }

    public String getKarakter() {
        return karakter;
    }

    public void setKarakter(String karakter) {
        this.karakter = karakter;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}