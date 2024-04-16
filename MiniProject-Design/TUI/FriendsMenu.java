package TUI;
import java.util.Scanner;

import control.FriendController;
import model.Friend;
/**
 *
 * @author (Matias, Jeppe, Oscar, Magnus, Kasper)
 * @version (16/04/2024)
 */

public class FriendsMenu {
  public FriendsMenu() {// initialise instance variables
    }
    public void start() {
        friendsMenu();
    }

    private void friendsMenu() {
        boolean running = true; while (running) {
            int choice = writeFriendsMenu();
            switch (choice) {
                case 1:
                    createFriendMenu();
                    break;
                case 2:
                    searchFriendMenu();
                case 3:
                    printAllFriendsMenu(); 
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("En uforklarlig fejl er sket med choice = " + choice);
                    break;
            }
        }
    }

    private int writeFriendsMenu() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("** Udlånsmenu **");
        System.out.println(" (1) Opret ven");
        System.out.println(" (2) Søg ven");
        System.out.println(" (3) Vis alle venner");
        System.out.println(" (0) Tilbage");
        System.out.print("\n Vælg:");
        int choice = getIntegerFromUser(keyboard);
        return choice;
    }

    private int getIntegerFromUser(Scanner keyboard) {
        while (!keyboard.hasNextInt()) {
            System.out.println("Input skal være et tal - prøv igen");
            keyboard.nextLine();
        }
        return keyboard.nextInt();}

        private FriendController createFriendController(){
            FriendController fc=new FriendController();
            return fc;
        }


    private void createFriendMenu() {
        FriendController fc= createFriendController();
        
        Scanner keyboard = new Scanner(System.in);
         System.out.println("Skriv venligst din vens navn");
         String name = keyboard.nextLine();
         keyboard.nextLine();
         System.out.println("Skriv venligst din vens adresse");
         String address= keyboard.nextLine().replace("\n", "");
         System.out.println("Skriv venligst din vens postnummer");     
         int postalCode = getIntegerFromUser(keyboard);
         keyboard.nextLine();
         System.out.println("Skriv venligst din vens by");
         String city = keyboard.nextLine().replace("\n", ""); 
         System.out.println("Skriv venligst din vens tlf nr"); 
         int phone= getIntegerFromUser(keyboard);
         keyboard.nextLine();

         fc.createFriend(name, address, postalCode, city, phone);


        }

        private void searchFriendMenu(){
            FriendController fc = createFriendController();

            Scanner keyboard = new Scanner(System.in);
            System.out.println("Skriv venligst din vens tlf nr");
            int tlfSearch = getIntegerFromUser(keyboard);
            keyboard.nextLine(); 
            Friend foundFriend =    fc.findFriendByTlf(tlfSearch);
            foundFriend.printFriendInfo();            

        }

        //Struktureret på en anden måde end LP menu print all LP function. Spørg underviser hvad der er rigtigt. - Jeppe
        private void printAllFriendsMenu(){
            FriendController fc = createFriendController();
            fc.printAllFriends();
        }
    }

