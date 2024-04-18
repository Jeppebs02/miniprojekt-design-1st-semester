package TUI;

import java.util.Scanner;
import control.*;
import model.Friend;
import model.Loan;
import model.Copy;
import model.LP;
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
                case 2:
                    searchLoanByLoanNumber();
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
        System.out.println(" (2) Søg lån");
        System.out.println(" (0) Tilbage");
        System.out.print("\n Vælg:");
        int choice = getIntegerFromUser(keyboard);
        return choice;
    }

    public void createLoanMenu(){
        LoanController lc = new LoanController();
        Scanner keyboard = new Scanner(System.in);
        int phoneNumber = 0;
        boolean foundPhoneNumber = false;
        int barcode = 0;
        boolean foundBarcode = false;
        int serialNumber = 0;
        boolean foundSerialNumber = false;

        System.out.println("Skriv lånedato: ");
        String borrowDate = keyboard.nextLine();
        System.out.println("Skriv antal dage på lånet: ");
        int period = getIntegerFromUser(keyboard);
        keyboard.nextLine();

        Loan newLoan = lc.createLoan(borrowDate, period);
        int newLoanNumber= newLoan.getLoanNumber();
        System.out.println("Lånenummeret er: " + newLoanNumber);

        while (!foundPhoneNumber) {
            System.out.println("Skriv tlf nummer på låner: ");
            phoneNumber = getIntegerFromUser(keyboard);
            keyboard.nextLine();
            
            lc.findFriendByPhoneNumber(phoneNumber);

            //check for null
            if (lc.findFriendByPhoneNumber(phoneNumber) == null) {
                System.out.println("Telefon nr. findes ikke");
            } else {
                foundPhoneNumber = true;
            }
        }

        Friend friend = lc.findFriendByPhoneNumber(phoneNumber);
        friend.printFriendInfo();
        System.out.println("er tilføjet til lånet");

        //check for null
        while (!foundBarcode) {
            System.out.println("Skriv stregkode på LP: ");
            barcode = getIntegerFromUser(keyboard);
            keyboard.nextLine();
            
            lc.findLPByBarcode(barcode);
            
            if (lc.findLPByBarcode(barcode) == null) {
                System.out.println("Stregkode findes ikke");
            } else {
                foundBarcode = true;
            }
        }
        
        //check for null
        while (!foundSerialNumber) {
            System.out.println("Skriv kopiens serienummer: ");
            serialNumber = getIntegerFromUser(keyboard);
            keyboard.nextLine();
            
            lc.typeInCopy(barcode, serialNumber);
            
            if (lc.typeInCopy(barcode, serialNumber) == null) {
                System.out.println("Serie nr. findes ikke");
            } else {
                foundSerialNumber = true;
            }
        }
        
        Copy copy = lc.typeInCopy(barcode, serialNumber);
        copy.setBorrowed(true);
        
        System.out.println("En kopi af ");
        LP lp = lc.findLPByBarcode(barcode);
        lp.printLPInfo();
        System.out.println(" er tilføjet til lånet.");
        
        lc.saveLoan();
        System.out.println("Dit lån er nu oprettet.");

    }

    public void searchLoanByLoanNumber(){
        LoanController lc = new LoanController();
        
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Skriv venligst lånenummeret");
        
        int loanNumber = getIntegerFromUser(keyboard);
        keyboard.nextLine(); 
        
        Loan foundLoan = lc.findLoanByLoanNumber(loanNumber);
        
        foundLoan.printLoanInfo();
    }
    
    private int getIntegerFromUser(Scanner keyboard) {
        while (!keyboard.hasNextInt()) {
            System.out.println("Input skal være et tal - prøv igen");
            keyboard.nextLine();
        }
        return keyboard.nextInt();
    }
}

