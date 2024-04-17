package model;

import java.util.ArrayList;
/**
 *
 * @author (Matias, Jeppe, Oscar, Magnus, Kasper)
 * @version (16/04/2024)
 */
public class Loan {
    private int loanNumber;
    private String borrowDate;
    private int period;
    private boolean isReturned;
    private ArrayList<Copy> loanItems;
    private Friend friend;
    public Loan(String borrowDate, int period) {
        this.borrowDate = borrowDate;
        this.period = period;
        this.isReturned = false;
        this.loanItems = new ArrayList<>();
    }
    

    public void setLoanNumber(int loanNumber) {
        this.loanNumber = loanNumber;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public void setIsReturned(boolean isReturned) {
        this.isReturned = isReturned;
    }

    public boolean setFriend(Friend friend){
        this.friend = friend;
        return friend != null;
    }
    
    public int getLoanNumber() {
        return loanNumber;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public int getLendPeriod() {
        return period;
    }

    public Friend getFriend(){
        return friend;
    }
    
    public boolean isReturned() {
        return isReturned;
    }
    
    public boolean addCopy(Copy copy){
        boolean isNotEmpty = false;
        if(copy != null && !copy.isBorrowed()){
            loanItems.add(copy);
            copy.setBorrowed(true);
            isNotEmpty = true;
        }
        return isNotEmpty;
    }

    public void printLoanInfo() {
        System.out.println("Lånenummer: " + loanNumber);
        System.out.println("Udlånsdato: " + borrowDate);
        System.out.println("Låneperiode: " + period + " dage");
        System.out.println("Afleveret: " + isReturned);
    }
}

