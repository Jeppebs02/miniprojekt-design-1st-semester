package TUI;
import java.util.Scanner;
import control.LPController;
import model.LP;
import model.LPContainer;
import java.util.Iterator;

/**
 *
 * @author (Matias, Jeppe, Oscar, Magnus, Kasper)
 * @version (16/04/2024)
 */
public class LPMenu {
    private LPController lpc;
    public LPMenu() {// initialise instance variables
    }

    public void start() {
        lpMenu();
    }

    private void lpMenu() {
        lpc = createLPController();
        Scanner keyboard = new Scanner(System.in);
        boolean running = true;
        while (running) {
            int choice = writeLPMenu();
            switch (choice) {
                case 1:
                    createLPMenu();
                    break;
                case 2:
                    createCopyMenu();
                    break;
                case 3:
                    findLP();
                    break;
                case 4:
                    printAllLP();
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

    private int writeLPMenu() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("** LP menu **");
        System.out.println(" (1) Opret LP");
        System.out.println(" (2) Opret kopi");
        System.out.println(" (3) Find LP");
        System.out.println(" (4) Se alle LP'er");
        System.out.println(" (0) Tilbage");
        System.out.print("\n Vælg:");
        int choice = getIntegerFromUser(keyboard);
        return choice;
    }

    private LPController createLPController(){
        LPController lpc = new LPController();
        return lpc;
    }

    private void createLPMenu(){
        lpc = createLPController();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Skriv venligst LP'ens stregkode");
        int barcode = keyboard.nextInt();
        //TODO FailSafe
        keyboard.nextLine();
        System.out.println("Skriv venligst LP'ens Titel");
        String title = keyboard.nextLine();
        System.out.println("Skriv venligst LP'ens Artist");
        String artist = keyboard.nextLine();
        System.out.println("Skriv venligst LP'ens udgivelses dato");
        String date = keyboard.nextLine();
        lpc.createLP(barcode, title, artist, date);
    }

    private void createCopyMenu(){
        lpc = createLPController();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Skriv venligst LP'ens stregkode");
        int barcode = keyboard.nextInt();
        //TODO FailSafe
        System.out.println("Skriv venligst kopiens serienummer");
        int serialNumber = keyboard.nextInt();
        //TODO FailSafe
        System.out.println("Skriv venligst kopiens købsdato");
        String purchaseDate = keyboard.nextLine();
        keyboard.nextLine();
        System.out.println("Skriv venligst kopiens købspris");
        int purchasePrice = keyboard.nextInt();
        keyboard.nextLine();
        //TODO FailSafe
        lpc.createLPCopy(lpc.findLPByBarcode(barcode),serialNumber, purchaseDate, purchasePrice);
        
    }
    
    private void findLP(){
        lpc = createLPController();
        Scanner keyboard = new Scanner(System.in);  
        System.out.println("Skriv venligst LP'ens stregkode");
        int barcode = keyboard.nextInt();
        keyboard.nextLine();
        LP foundLP = lpc.findLPByBarcode(barcode);
        foundLP.printLPInfo();
        
        
    }
    
    private void printAllLP(){
        LPContainer lpc = LPContainer.getInstance();
        Iterator<LP> iterator = lpc.getIterator();
        while(iterator.hasNext()){
            LP currentLP = iterator.next();
            currentLP.printLPInfo();
            System.out.println();
        }
    }
    
    private int getIntegerFromUser(Scanner keyboard) {
        while (!keyboard.hasNextInt()) {
            System.out.println("Input skal være et tal - prøv igen");
            keyboard.nextLine();
        }
        return keyboard.nextInt();
    }
}
