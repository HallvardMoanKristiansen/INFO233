package node;

import friend.Friend;

import java.util.Iterator;

public class FriendList implements IFriendList, Iterable {

    public static FriendNode head;

    public FriendNode tempNode;

    /**
     * Returns an iterator over elements of type {@code T}.
     * Har fått en del venn av Eivind og David med FriendList.
     * @return an Iterator.
     */
    @Override
    public Iterator iterator() {
        return new FriendIterator();
    }

    //funksjon for å printe listen med venner og ha mellomrom mellom dem
    public void printList() {
        FriendNode topOfNode = head;
        while (topOfNode != null) {
            System.out.print(topOfNode.friend.firstname  + " " + topOfNode.friend.lastname + " - ");
            topOfNode = topOfNode.next;
        }
        System.out.println();
    }

    //funksjon for å få antall telle antall venner.
    public int getFriendCounter() {
        FriendNode temp = head;
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.next;

        }
        return count;
    }

    @Override
    //funksjon for å fjerne venn i vennelisten
    public void removeFriend(Friend friend) {
        FriendNode temp = head, prev = null;
        if (temp == null || temp.friend != friend) {
            while (temp != null && temp.friend != friend) {
                prev = temp;
                temp = temp.next;
            }
            if (temp == null) return;
            prev.next = temp.next;
        } else {
            head = temp.next;
            return;
        }
    }

    @Override
    //funksjon for å legge til venn i vennelisten
    public void addFriend(Friend newFriend) {
        FriendNode friendNode = new FriendNode(newFriend);
        friendNode.next = head;
        head = friendNode;
    }

    // Om man foretar en big O kjøretidsanalyse over "sort" funksjonen vil den være O(n^2).

    //slet med å få til sort funksjonen så jeg fikk hjelp av Eivind, her linker jeg til githuben hans.
    //https://github.com/EwyBoy/INFO-233/blob/master/Oblig-02/src/main/node/FriendNode.java
    @Override
    public void sort(FriendNode top) {
        tempNode = null;
        FriendNode header = top;

        if (header != null) {
            do {
                FriendNode nextNode = header.next;
                insert(header);

                header = nextNode;
            }
            while (
                header != null
            );
        }

        FriendList.head = tempNode;
    }

    private void insert(FriendNode friendNode) {
        if (tempNode == null || tempNode.friend.lastname.compareTo(friendNode.friend.lastname) >= 0) {
            friendNode.next = tempNode;
            tempNode = friendNode;
        } else {
            FriendNode newNode = tempNode;

            if (newNode.next != null && newNode.next.friend.lastname.compareTo(friendNode.friend.lastname) < 0) {

                do {
                    newNode = newNode.next;
                }

                while (
                    newNode.next != null &&
                    newNode.next.friend.lastname.compareTo(friendNode.friend.lastname) < 0
                );
            }


            friendNode.next = newNode.next;
            newNode.next = friendNode;
        }
    }

}