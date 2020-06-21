package test;

import friend.Friend;
import node.FriendList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//lager en test for å enhetsteste vennelisten.
class FriendListTest {

    private FriendList friendList = new FriendList();
    //lager private klasser av av venner for å finne ut få et bilde over hva som printes ut.
    private Friend friend01 = new Friend("Amanda", "Aalesund", "12322244", "Andegaten 420");
    private Friend friend02 = new Friend("Jensine", "Stensen", "11111111", "Grusneset 18");
    private Friend friend03 = new Friend("Lars", "Bars", "92725372", "Pimpgata 8");
    private Friend friend04 = new Friend("Bender", "Hover", "64209294", "Canadavegen 122");
    //Lot friend05 stå tom, ettersom jeg lurte hvordan listen ville reagere dersom jeg legger inn en tom verdi.
    private Friend friend05 = new Friend("", "", "", "");

    @Test
    void addFriend() {
        friendList.printList();
        // Her begynner jeg å teste om vennelisten er tom(0), dersom listen ikke er tom vil assertEquals gi meg en feilmelding.
        //assertEquals har jeg funnet til å funke best til enhetstesting i dette tilfellet.
        assertEquals(0, friendList.getFriendCounter());

        //Legger til en venn i listen
        friendList.addFriend(friend01);

        //tester at vennen har blitt lagt til i venne-listen og at vi sitter igjen med en venn i venne-listen.
        assertEquals(1, friendList.getFriendCounter());

        //ser hva som skjer dersom jeg legger til to venner i venne-listen samtidig.
        friendList.addFriend(friend02);
        friendList.addFriend(friend03);

        //tester at vennen har blitt lagt til i venne-listen og at vi sitter igjen med tre venner i venne-listen.
        assertEquals(3, friendList.getFriendCounter());

        //tester hvordan koden reagerer dersom jeg legger til samme verdi flere ganger.
        friendList.addFriend(friend04);
        friendList.addFriend(friend04);

        //tester at vennen har blitt lagt til i venne-listen og at vi sitter igjen med fem venner i venne-listen.
        assertEquals(5, friendList.getFriendCounter());

        //tester hva som skjer dersom jeg legger inn en venn med tom verdi.
        friendList.addFriend(friend05);

        //tester at vennen har blitt lagt til i venne-listen og at vi sitter igjen med seks venner i venne-listen.
        assertEquals(6, friendList.getFriendCounter());

        //printer antall venner i listen.
        System.out.println("Friend Count: " + friendList.getFriendCounter());
        friendList.printList();

    }

    @Test
    //lager venneliste og legger til venner
    void removeFriend() {
        friendList.addFriend(friend01);
        friendList.addFriend(friend02);
        friendList.addFriend(friend03);
        friendList.addFriend(friend04);
        friendList.addFriend(friend05);

        //tester at vi har alle 5 vennene i listen
        assertEquals(5, friendList.getFriendCounter());

        //tester for hva som skjer når man fjerner vennen som ligger på toppen av listen.
        friendList.removeFriend(friend05);

        //tester at vennen har blitt fjernet og at vi sitter igjen med fire venner i venne-listen.
        assertEquals(4, friendList.getFriendCounter());

        //tester hva som skjer dersom man fjerner venner som ligger på bunnen av listen.
        friendList.removeFriend(friend01);

        //tester at vennen har blitt fjernet og at vi sitter igjen med tre venner i venne-listen.
        assertEquals(3, friendList.getFriendCounter());

        //tester hva som skjer dersom man fjerner en venn som ligger midt i listen.
        friendList.removeFriend(friend03);

        //tester at vennen har blitt fjernet og at vi sitter igjen med to venner i venne-listen.
        assertEquals(2, friendList.getFriendCounter());

        //tester hva som skjer dersom man fjerner to venner fra venne-listen samtidig.
        friendList.removeFriend(friend02);
        friendList.removeFriend(friend04);

        //tester at alle venner har blitt fjernet og at vi sitter igjen med en tom liste.
        assertEquals(0, friendList.getFriendCounter());

        //tester hva som skjer dersom man fjerner en venn, som allerede har blitt fjernet tidligere
        friendList.removeFriend(friend01);

        //tester at vi fremdeles sitter igjen med en tom venneliste, ettersom man ikke kan fjerne venner som ikke er i vennelisten.
        assertEquals(0, friendList.getFriendCounter());
    }

    @Test
    void sort() {
        //tester om det an å sortere en tom liste og se om programmet krasjer.
        friendList.sort(friendList.head);

        //forventer at listen er tom
        assertEquals(0, friendList.getFriendCounter());

        //legger til tre venner i listen
        friendList.addFriend(friend01);
        friendList.addFriend(friend03);
        friendList.addFriend(friend04);

        //passer på at vennene har blitt lagt til og at vi sitter igjen med en totalt på tre.
        assertEquals(3, friendList.getFriendCounter());

        //printer listen før man har sortert listen
        friendList.printList();
        //sorterer listen
        friendList.sort(friendList.head);
        //printer listen etter den har blitt sortert
        friendList.printList();
        //passer på at vi fremdeles kun har tre venner i listen
        assertEquals(3, friendList.getFriendCounter());

    }
}