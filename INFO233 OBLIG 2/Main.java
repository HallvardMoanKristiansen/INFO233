import friend.Friend;
import node.FriendList;
import node.FriendNode;

import java.util.Scanner;

public class Main {

    /*  Sources: [
     *  Jobber mye med Eivind Nordling og David Kvasnes Olsen så vi jobber ofte sammen og deler kode om det er noe vi sliter med
     *  Så enkelte deler av koden er noe lunde likt, så vet du hvorfor.
     *  https://github.com/EwyBoy/INFO-233/blob/master/Oblig-02/src/MainApplication.java - låner en del kode her hos klassekamerat
     *  https://www.youtube.com/watch?v=gwc9SJtquqg
     *  https://www.geeksforgeeks.org/linked-list-set-2-inserting-a-node/
     *  https://www.geeksforgeeks.org/linked-list-set-3-deleting-node/ ]
     *  ];
     */

    //oppretter en private friendList
    private static FriendList friendList = new FriendList();

    //Instansierer applikasjonen
    private static void init() {
        //lager nye venner
        Friend friendOne = new Friend("Anne","Atlas", "Anneatlas@gmail.com", "01020304");
        Friend friendTwo = new Friend("Jonas","Jonasson", "jonasjonasson@gmail.com", "02020202");
        Friend friendThree = new Friend("Gunn","Gunsene", "Gunwiththegs@hotmail.com", "89734287897324");

        //legger till venner i venelisten
        friendList.addFriend(friendTwo);
        friendList.addFriend(friendOne);
        friendList.addFriend(friendThree);
    }

    //Itererer venner i vennelisten
    public static void iterate(Scanner scanner) {
        for (Object friend : friendList) {
            System.out.println(friend.toString());
        }
        runApplication(scanner);
    }

    //  Kjører hoved hubben for vennelist applikasjonen
    private static void runApplication(Scanner scanner) {

        //printer alle i vennelisten
        friendList.printList();

        //forklarer hvilke funksjoner man skal skrive
        System.out.println("Skriv 'add' for å legge til en ny venn: ");
        System.out.println("Skriv 'remove' for å fjerne venn: ");
        System.out.println("Skriv 'sort' for å sortere listen: ");
        System.out.println("Skriv 'iterate' for å iterere: ");
        String option = scanner.nextLine().toLowerCase();

        //om man skriver add blir man tatt til addFriend funksjonen
        if (option.contentEquals("add")) {
            addFriend(scanner);
            //eller om man skriver remove så vil man bli tatt til removeFriend funksjonen
        } else if (option.contentEquals("remove")) {
            removeFriend(scanner);
            //eller om man skriver iterate vil den iterere via iterate funksjonen
        } else if (option.contentEquals("iterate")) {
            iterate(scanner);
            //eller om man skriver sort vil den sortere listen.
        } else if (option.contentEquals("sort")) {
            sort(scanner);
        } else  {
            runApplication(scanner);
        }
    }

    //private sort funksjon, som sorterer friendlist.head
    private static void sort(Scanner scanner) {
        friendList.sort(FriendList.head);
        runApplication(scanner);
    }

    //lager en funksjon som skal fjerne venner. Denne funksjonen er sensitiv for ekstra mellomrom og man er nødt til å skrive fullt navn.
    private static void removeFriend(Scanner scanner) {
        System.out.println("Skriv inn fullt navn 'firstname lastname' av vennen du ønsker å fjerne fra FriendList: ");
        String name = scanner.nextLine().toLowerCase();

        //legger til mellomrom mellom navnene
        String[] names = name.split(" ");
        String firstname = names[0];
        String lastname = names[1];

        //lager en funksjon for ikke gyldige navn.
        if (firstname == null || lastname == null) {
            removeFriend(scanner);
            System.out.println("Dette er ikke et gyldig navn, prøv igjen");
        }

        FriendNode topOfNode = friendList.head;
        Friend friend = null;

        while (topOfNode != null) {
            //gjør om firstname og lastname til lowercase og fortsetter
            if (!topOfNode.friend.firstname.toLowerCase().equals(firstname) || !topOfNode.friend.lastname.toLowerCase().equals(lastname)) {
                topOfNode = topOfNode.next;
            } else {
                friend = topOfNode.friend;
                break;
            }
        }
        //lager funksjon svarer dersom man søker etter en person som enten er tom eller ikke er i listen.
        if (friend == null) {
            System.out.println("Finner ikke noen ved det navnet.");
        } else {
            friendList.removeFriend(friend);
            System.out.println("Friend: " + friend.firstname + " " + friend.lastname + " har blitt fjernet fra din FriendList.");
        }

        runApplication(scanner);
    }

    // brukes for å legge til venner i venne objektet og legge dem til i listen
    private static void addFriend(Scanner scanner) {
        String firstName = inputStringHelper(scanner, "fornavn");
        String lastName = inputStringHelper(scanner, "etternavn");
        String phone = inputStringHelper(scanner, "telefonnummer");
        String address = inputStringHelper(scanner, "epost-adresse");

        Friend friend = new Friend(firstName, lastName, phone, address);
        friendList.addFriend(friend);
        System.out.println("Friend: " + firstName + " " + lastName + " har blitt lagt til i din Friend List");

        runApplication(scanner);
    }

    // A helper method to avoid reused code --taken from EwyBoy src github
    private static String inputStringHelper(Scanner scanner, String field) {
        System.out.println("Skriv inn din nye venns " + field + ": ");
        return scanner.nextLine();
    }


    //ain - Starts the application and initializes the input scanner -taken from EwyBoy src github*/
    public static void main(String[] args) {
        init();
        Scanner scanner = new Scanner(System.in);
        runApplication(scanner);
    }
}
