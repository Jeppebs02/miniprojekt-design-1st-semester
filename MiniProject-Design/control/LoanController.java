package control;

import model.*;
/**
 *
 * @author (Matias, Jeppe, Oscar, Magnus, Kasper)
 * @version (16/04/2024)
 */
public class LoanController {
    private LoanContainer loanContainer;
    private FriendContainer friendContainer;
    public LoanController() {
        loanContainer = LoanContainer.getInstance();
    }

    // Opret et nyt lån og tilføj det til containeren
    public void createLoan(String borrowDate, int period) {
        Loan newLoan = new Loan(borrowDate, period);
        saveLoan(newLoan);
    }

    // Gem et nyt lån i containeren
    public boolean saveLoan(Loan newLoan) {
        return loanContainer.addLoan(newLoan);
    }

    // Find et lån ved lånenummer
    public Loan findLoanByLoanNumber(int loanNumber) {
        return loanContainer.findLoanByLoanNumber(loanNumber);
    }

    // Tilføj en kopi til et eksisterende lån
    public boolean addCopyToLoan(int loanNumber, Copy copy) {
        LoanContainer lc = LoanContainer.getInstance();
        Loan loan = findLoanByLoanNumber(loanNumber);
        return loan.addCopy(copy);
    }

    // Tilføj en ven til et eksisterende lån
    public boolean addFriendToLoan(int loanNumber, Friend friend) {
        LoanContainer lc = LoanContainer.getInstance();
        Loan loan = findLoanByLoanNumber(loanNumber);
        return loan.setFriend(friend);
    }
}
