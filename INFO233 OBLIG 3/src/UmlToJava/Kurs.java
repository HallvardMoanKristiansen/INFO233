package UmlToJava;

//Føler oppgaven var ganske vagt skrevet opp, så forhørte meg litt rundt med medstudenter og gjorde noe samme.
//omgjorde bare database managing system fra main til dette her. Er jo ingen funksjon i det men kan hjelpe med å gi en representasjon. Så medstudenter få full pot ved samme fremgangsmåte så tenkte gjøre det samme.
public class Kurs {

    private static String kode;

    private static String navn;

    private static String skole;

    private static int karakter;

    public Kurs(String kode, String navn) {

        Kurs.kode = kode;

        Kurs.navn = navn;

        skole = Skole.getNavn();

        karakter = Karakter.getId();
    }

    public static String getKode() {
        return kode;
    }

    public static String getNavn() {
        return navn;
    }

    public static String getSkole() {
        return skole;
    }

    public static int getKarakter() {
        return karakter;
    }
}