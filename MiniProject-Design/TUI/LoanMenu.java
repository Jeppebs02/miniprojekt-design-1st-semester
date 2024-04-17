package TUI;

import java.util.Scanner;
import control.*;
import model.Friend;
import model.LP;
import model.Loan;
import model.Copy;
/**
 *
 * @author (Matias, Jeppe, Oscar, Magnus, Kasper)
 * @version (16/04/2024)
 */
public class LoanMenu {
    public LoanMenu() {// initialise instance variables
    }
    public void start() {
        loanMenu();
    }

    private void loanMenu() {
        boolean running = true;
        while (running) {
            int choice = writeLoanMenu();
            switch (choice) {
                case 1:
                    createLoanMenu();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("En uforklarlig fejl er sket med choice = " + choice);
                    break;
            }
        }
    }

    private int writeLoanMenu() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("** lån menu **");
        System.out.println(" (1) Opret lån");
        System.out.println(" (0) Tilbage");
        System.out.print("\n Vælg:");
        int choice = getIntegerFromUser(keyboard);
        return choice;
    }

    public void createLoanMenu(){
        LoanController lc = new LoanController();
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("Skriv lånedato: ");
        String borrowDate = keyboard.nextLine();
        System.out.println("Skriv antal dage på lånet: ");
        int period = getIntegerFromUser(keyboard);
        keyboard.nextLine();
        
        Loan newLoan = lc.createLoan(borrowDate, period);
        int newLoanNumber= newLoan.getLoanNumber();
        System.out.println("Lånenummeret er: " + newLoanNumber);
        
        System.out.println("Skriv tlf nummber på låner: ");
        int phoneNumber = getIntegerFromUser(keyboard);
        keyboard.nextLine();
        Friend friend = lc.findFriendByPhoneNumber(phoneNumber);
        
        friend.printFriendInfo();
        System.out.println("er tilføjet til lånet");
        
        System.out.println("Skriv stregkode på LP: ");
        int barcode = getIntegerFromUser(keyboard);
        keyboard.nextLine();
        
        System.out.println("Skriv kopiens serienummer: ");
        int serialNumber = getIntegerFromUser(keyboard);
        keyboard.nextLine();
        
        Copy copy = lc.typeInCopy(barcode, serialNumber);
    
        
        System.out.println("En kopi af ");
        LP lp = lc.findLPByBarcode(barcode);
        lp.printLPInfo();
        System.out.println(" er tilføjet til lånet.");
        
        lc.saveLoan();
        System.out.println("Dit lån er nu oprettet.");
        
        
    }
    
    private int getIntegerFromUser(Scanner keyboard) {
        while (!keyboard.hasNextInt()) {
            System.out.println("Input skal være et tal - prøv igen");
            keyboard.nextLine();
        }
        return keyboard.nextInt();
    }
}
