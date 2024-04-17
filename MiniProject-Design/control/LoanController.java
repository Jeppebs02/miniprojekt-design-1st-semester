package control;

import model.*;
/**
 *
 * @author (Matias, Jeppe, Oscar, Magnus, Kasper)
 * @version (16/04/2024)
 */
public class LoanController {
    Loan newLoan;
    Friend newFriend;
    public LoanController() {
        
    }

    // Opret et nyt lån
    public Loan createLoan(String borrowDate, int period) {
         newLoan = new Loan(borrowDate, period);
        return newLoan;
    }
    
    public Friend findFriendByPhoneNumber(int phoneNumber){
        FriendController fc = new FriendController();
        newFriend = fc.findFriendByTlf(phoneNumber);
        return newFriend;
    }
    
    public LP findLPByBarcode(int barcode){
        LPController lpc = new LPController();
        LP newLP = lpc.findLPByBarcode(barcode);
        return newLP;
    }
    
    //finder copy fra barcoden på copiens LP og copies serie nummer
    public Copy typeInCopy(int barcode, int serialNumber){
        LPController lpc = new LPController();
        LP newLP = lpc.findLPByBarcode(barcode);
        return lpc.findCopyBySerialNumber(newLP, serialNumber);
    }

    // Gem et nyt lån i containeren
    public boolean saveLoan() {
        newLoan.setFriend(newFriend);
        return LoanContainer.getInstance().addLoan(newLoan);
    }

}
