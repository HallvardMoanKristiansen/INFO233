package node;

import friend.Friend;

//src: https://www.youtube.com/watch?v=gwc9SJtquqg - brukte og skrev om litt av denne koden
public class FriendNode {
    public Friend friend;
    public FriendNode next;

    public FriendNode(Friend friend) {
        this.friend = friend;
        this.next = null;
    }
}
