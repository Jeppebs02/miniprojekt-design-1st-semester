package model;

import java.util.ArrayList;

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
        if(copy != null){
            loanItems.add(copy);
            isNotEmpty = true;
        }
        return isNotEmpty;
    }

    public void printLoanInfo() {
        System.out.println("Loan Number: " + loanNumber);
        System.out.println("Borrow Date: " + borrowDate);
        System.out.println("Loan Period: " + period + " days");
        System.out.println("Is Returned: " + isReturned);
    }
}

