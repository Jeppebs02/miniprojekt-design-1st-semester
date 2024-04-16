package TUI;
import java.util.Scanner;

public class MainMenu {
    // instance variables 
    private LoanMenu loanMenu;
    private LPMenu lpMenu;
    private FriendsMenu friendsMenu;
    
    /**
     * Constructor for objects of class MainMenu
     */
    public MainMenu() {
        // initialise instance variables
        loanMenu = new LoanMenu();
        lpMenu = new LPMenu();
        friendsMenu = new FriendsMenu();
        
    }
    
    public void start() {
        mainMenu();
    }

    private void mainMenu() {
        boolean running = true;
        while (running) {
            int choice = writeMainMenu();
            switch (choice) {
                case 1:
                    friendsMenu.start();
                    break;
                case 2:
                    lpMenu.start();
                    break;
                case 3:
                    loanMenu.start();
                    break;
                case 9:
                    //TryMe.generateTestData();
                    //createTestData();
                    break;
                case 0:
                    System.out.println("Tak for denne gang.");
                    running = false;
                    break;
                default:
                    System.out.println("Der er sket en uforklarlig fejl, choice = "+choice);
                    break;
            }
        }
    }

    private int writeMainMenu() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("****** Hovedmenu ******");
        System.out.println(" (1) Lånermenu");
        System.out.println(" (2) LP menu");
        System.out.println(" (3) Udlånsmenu");
        System.out.println(" (9) Generer testdata");// will generate testdata, delete in final version
        System.out.println(" (0) Afslut programmet");
        System.out.print("\n Vælg:");

        while (!keyboard.hasNextInt()) {
            System.out.println("Input skal være et tal - prøv igen");
            keyboard.nextLine();
        }
        int choice = keyboard.nextInt();
        return choice;
    }

    
}