package model;

import java.util.ArrayList;
import java.util.Iterator;

public class FriendContainer {
    private ArrayList<Friend> friends;
    private static FriendContainer instance;
    private Iterator<Friend> iterator;

    private FriendContainer() {
        friends = new ArrayList<>();
    }

    public static FriendContainer getInstance() {
        if (instance == null) {
            instance = new FriendContainer();
        }
        return instance;
    }

    public boolean addFriend(Friend friend) {
        boolean addedFriend = false;
        if (friend!=null) {
            friends.add(friend);
            addedFriend = true;
        }
        return addedFriend;
    }

    public Iterator<Friend> getIterator() {
        iterator = friends.iterator();
        return iterator;
    }

    public Friend findFriendByName(String name) {
        Friend foundFriend = null; 
        for (Friend friend : friends) {
            if (friend.getName().equals(name)) {
                foundFriend = friend;
            }
        }
        return foundFriend;
    }
}
