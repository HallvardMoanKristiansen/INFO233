package node;

import friend.Friend;

//oppretter et interface til FriendList
public interface IFriendList {

    //grensesnitt for å slette venn
    void removeFriend (Friend friend);

    //grensesnitt for addFriend
    void addFriend (Friend friend);

    //grensesnitt for sortering
    void sort(FriendNode list);
}
