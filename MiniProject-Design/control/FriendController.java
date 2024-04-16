package control;
import model.Friend;
import model.FriendContainer;
/**
 *
 * @author (Matias, Jeppe, Oscar, Magnus, Kasper)
 * @version (16/04/2024)
 */
public class FriendController {
    private FriendContainer friendContainer;

    public FriendController() {
        friendContainer = FriendContainer.getInstance();
    }

    // Opret en ny ven og tilføj den til containeren
    public void createFriend(String name, String address, int postalCode, String city, int phone) {
        Friend newFriend = new Friend(name, address, postalCode, city, phone);
        saveFriend(newFriend);
    }

    // Gem en ny ven i containeren
    public boolean saveFriend(Friend newFriend) {
        return friendContainer.addFriend(newFriend);
    }

    // Find en ven ved navn
    public Friend findFriendByName(String name) {
        return friendContainer.findFriendByName(name);
    }
}
    
    
    
    

