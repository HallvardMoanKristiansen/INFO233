package friend;

//lager klasse for "friend"
public class Friend {

    //bestemmer hvilke variabler klaasen firned skal inneholde
    public String firstname;
    public String lastname;
    public String email;
    public String phonenumber;

    //returnerer alle verdier, om ikke noe er oppgitt i main vil vi da returnere på null, på de variablene som ikke er spesifisert.
    public Friend(String firstname, String lastname, String email, String phonenumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phonenumber = phonenumber;
    }

    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    //skal override memory location til string value. denne vil ikke override når jeg kjører koden av en eller annen grunn
    public String toString() {
        return this.firstname + " " + this.lastname;
    }
}
