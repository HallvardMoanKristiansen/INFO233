package node;

import friend.Friend;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FriendIterator implements Iterator<Friend> {

    private FriendNode node;

    public FriendIterator() {
        node = FriendList.head;
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        return node != null;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public Friend next() {
        if (node != null) {

            FriendNode placeholderNode = node;
            node = node.next;

            return placeholderNode.friend;
        } else {

            throw new NoSuchElementException();

        }
    }
}
