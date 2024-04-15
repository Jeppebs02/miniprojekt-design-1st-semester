package model;

import java.util.ArrayList;
import java.util.Iterator;

public class LoanContainer {
    private ArrayList<Loan> loans;
    private static LoanContainer instance;
    private Iterator<Loan> iterator;

    private LoanContainer() {
        loans = new ArrayList<>();
    }

    public static LoanContainer getInstance() {
        if (instance == null) {
            instance = new LoanContainer();
        }
        return instance;
    }

    public boolean addLoan(Loan loan) {
        boolean addedLoan = false;
        if (loan!=null) {
            loans.add(loan);
            addedLoan = true;
        }
        return addedLoan;
    }

    public Iterator<Loan> getIterator() {
        iterator = loans.iterator();
        return iterator;
    }

    public Loan findLoanByLoanNumber(int loanNumber) {
        Loan foundLoan = null;
        
        for (Loan loan : loans) {
            if (loan.getLoanNumber() == loanNumber) {
                foundLoan = loan;
            }
        }
        return foundLoan;
    }
}
