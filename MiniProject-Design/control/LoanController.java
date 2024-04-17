package control;

import model.*;
/**
 *
 * @author (Matias, Jeppe, Oscar, Magnus, Kasper)
 * @version (16/04/2024)
 */
public class LoanController {
    Loan newLoan;
    public LoanController() {
        
    }

    // Opret et nyt lån og tilføj det til containeren
    public void createLoan(String borrowDate, int period) {
         newLoan = new Loan(borrowDate, period);
        
    }
    
    public Friend findFriendByPhoneNumber(int phoneNumber){
        FriendController fc = new FriendController();
        return fc.findFriendByTlf(phoneNumber);
    }
    
    public Copy typeInCopy(int barcode, int serialNumber){
        LPController lpc = new LPController();
        LP newLP = lpc.findLPByBarcode(barcode);
        return lpc.findCopyBySerialNumber(newLP, serialNumber);
    }

    // Gem et nyt lån i containeren
    public boolean saveLoan() {
        return LoanContainer.getInstance().addLoan(newLoan);
    }

    // Find et lån ved lånenummer
    // public Loan findLoanByLoanNumber(int loanNumber) {
        // return loanContainer.findLoanByLoanNumber(loanNumber);
    // }

    // // Tilføj en kopi til et eksisterende lån
    // public boolean addCopyToLoan(int loanNumber, Copy copy) {
        // LoanContainer lc = LoanContainer.getInstance();
        // Loan loan = findLoanByLoanNumber(loanNumber);
        // return loan.addCopy(copy);
    // }

    // // Tilføj en ven til et eksisterende lån
    // public boolean addFriendToLoan(int loanNumber, Friend friend) {
        // LoanContainer lc = LoanContainer.getInstance();
        // Loan loan = findLoanByLoanNumber(loanNumber);
        // return loan.setFriend(friend);
    // }
}
