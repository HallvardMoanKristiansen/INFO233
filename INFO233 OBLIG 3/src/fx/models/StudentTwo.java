package fx.models;

public class StudentTwo {

    //setter private parametre for skole og kull
    private String skole;

    private String kull;

    //lager en public for student 2, hvor skole go kull skal ha string verdi og gjør slik at det leses som skole og kull
    public StudentTwo(String skole, String kull) {

        this.skole = skole;

        this.kull = kull;
    }

    //alt + insert getters and setters

    public String getSkole() {
        return skole;
    }

    public void setSkole(String skole) {
        this.skole = skole;
    }

    public String getKull() {
        return kull;
    }

    public void setKull(String kull) {
        this.kull = kull;
    }
}
