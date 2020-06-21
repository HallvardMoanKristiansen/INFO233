package UmlToJava;

//Føler oppgaven var ganske vagt skrevet opp, så forhørte meg litt rundt med medstudenter og gjorde noe samme.
//omgjorde bare database managing system fra main til dette her. Er jo ingen funksjon i det men kan hjelpe med å gi en representasjon. Så medstudenter få full pot ved samme fremgangsmåte så tenkte gjøre det samme.
public class Student {

    private static String nr;

    private static String navn;

    private static String kull;


    public Student(String nr, String navn, String kull) {

        Student.nr = nr;

        Student.navn = navn;

        Student.kull = kull;
    }


    //getter for student nummer og returner det nummeret.
    public static String getNr() { return nr; }

    //getter for studentnavn og returnerer student navnet.
    public static String getNavn() { return navn; }

    //getter for kull studenten er i og returner dette.
    public static String getKull() { return kull; }

}