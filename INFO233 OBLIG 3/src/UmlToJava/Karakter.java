package UmlToJava;

//Føler oppgaven var ganske vagt skrevet opp, så forhørte meg litt rundt med medstudenter og gjorde noe samme.
//omgjorde bare database managing system fra main til dette her. Er jo ingen funksjon i det men kan hjelpe med å gi en representasjon. Så medstudenter få full pot ved samme fremgangsmåte så tenkte gjøre det samme.
public class Karakter {

    private static int id;

    private static String karakter;

    private static int year;

    private static String student;

    //setter verdier
    public Karakter(int id, String karakter, int year) {

        Karakter.id = id;

        Karakter.karakter = karakter;

        Karakter.year = year;

        student = Student.getNr();
    }

    //getter for id og returner id
    public static int getId() { return id; }

    //getter for karakter og returnerer id
    public static String getKarakter() { return karakter; }

    //getter for year og returnerer year
    public static int getYear() { return year; }

    //getter for student og returnerer student
    public static String getStudent() { return student; }

}
