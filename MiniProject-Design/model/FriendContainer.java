package model;

import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author (Matias, Jeppe, Oscar, Magnus, Kasper)
 * @version (16/04/2024)
 */
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

    public Friend findFriendByTlf(int tlf){
        Friend foundFriend = null;
        for(Friend friend : friends){
            if(friend.getPhone()==tlf){
                foundFriend=friend;
            } 
        }
        return foundFriend;
    }

    public void printAllFriends(){
        for(Friend friend: friends){
            friend.printFriendInfo();
        }
    }

}
