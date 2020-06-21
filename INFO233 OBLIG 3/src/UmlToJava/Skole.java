package UmlToJava;

//Føler oppgaven var ganske vagt skrevet opp, så forhørte meg litt rundt med medstudenter og gjorde noe samme.
//omgjorde bare database managing system fra main til dette her. Er jo ingen funksjon i det men kan hjelpe med å gi en representasjon. Så medstudenter få full pot ved samme fremgangsmåte så tenkte gjøre det samme.
public class Skole {

    private static String navn;

    public Skole(String navn) {

        Skole.navn = navn;

    }

    //getter for skole navn og returnerer dette navnet.
    public static String getNavn() { return navn; }
}
