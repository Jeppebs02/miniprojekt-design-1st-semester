package TUI;

import TUI.MainMenu;
import control.FriendController; 
import control.*;
import model.*;

/**
 * Testdata
 * @author (Matias, Jeppe, Oscar, Magnus, Kasper)
 * @version (16/04/2024)
 */
public class TryMe {
    /* only for generating data to test */
    public static void addTestData() {
        LoanContainer lc = LoanContainer.getInstance();
        FriendContainer fc = FriendContainer.getInstance();
        LPContainer lpc = LPContainer.getInstance();
        
        fc.addFriend(new Friend("Magnus", "UCN1", 9000, "Aalborg", 22112233));
        fc.addFriend(new Friend("Oscar", "UCN2", 9200, "Aalborg", 11112233));
        fc.addFriend(new Friend("Kasper", "UCN3", 9400, "Nørresundby", 21112233));
        fc.addFriend(new Friend("Matias", "Sin brændte bil", 9100, "Aalborg", 12112233));
        fc.addFriend(new Friend("Jeppe", "Under en bro", 9000, "Aalborg", 33112233));
        
        lpc.addLP(new LP(1111, "Gammel plade 1", "Gammel Artist 1", "1-1-1924"));
        lpc.addLP(new LP(1222, "Gammel plade 2", "Gammel Artist 2", "1-3-1923"));
        lpc.addLP(new LP(1333, "Gammel plade 3", "Gammel Artist 3", "1-2-1922"));
        lpc.addLP(new LP(1444, "Gammel plade 4", "Gammel Artist 4", "1-4-1920"));
        lpc.addLP(new LP(1555, "Gammel plade 5", "Gammel Artist 5", "1-5-1919"));
    }
}
