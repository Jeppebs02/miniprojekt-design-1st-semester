package control;
import model.Loan;
import model.LoanContainer;


public class LoanController {
    private LoanContainer loanContainer;

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
    public boolean addCopyToLoan() {
        // Implementer logikken for at tilføje en kopi til et eksisterende lån
        return false;
    }

    // Tilføj en ven til et eksisterende lån
    public boolean addFriendToLoan(Friend friend) {
        // Implementer logikken for at tilføje en ven til et eksisterende lån
        return false;
    }
}
