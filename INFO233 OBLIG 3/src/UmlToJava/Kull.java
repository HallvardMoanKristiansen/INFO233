package UmlToJava;

//Føler oppgaven var ganske vagt skrevet opp, så forhørte meg litt rundt med medstudenter og gjorde noe samme.
//omgjorde bare database managing system fra main til dette her. Er jo ingen funksjon i det men kan hjelpe med å gi en representasjon. Så medstudenter få full pot ved samme fremgangsmåte så tenkte gjøre det samme.
public class Kull {

    private static String kode;

    private static String skole;


    public Kull(String kode) {

        Kull.kode = kode;

        skole = Skole.getNavn();
    }

    //getter for skole kullet er i og returnerer skolen
    public String getSkole() { return skole; }

    //getter for kullkode og returnerer kullkoden.
    public String getKode() { return kode; }

}

