import java.util.Collections;
import java.util.Scanner;

public class Application {

    public static Scanner scanner = new Scanner(System.in);
    public static Player player = new Player("");

    public static void main(String[] args) {
        run();
    }
    public static void run (){
//        while(!gameover// player is alive), move player
        startGame();
        createPlayer();

//        Opening.runOpening(player);
//        FifthFloor.runFifthFloor(player); // Adds the player object to the fifth floor
//        one run method(interface) that applies to all the different superclass-floors
//        the run method itself will contain a check for whether the player is alive
    //    System.out.println(Opening.player.getName());
    }
    public void floors() {
       // Opening opening = new Opening();
    }
    //methods
    public static void startGame() {
        System.out.println(" \n".repeat(50)); // getting it to clear the console 50 lines
        //System.out.print("\033[H\033[2J");
        //System.out.flush();

    }

    public static int pickOption (int options) {
        String userInput = scanner.nextLine();
        while (!userInput.equals("1") && !userInput.equals("2") && !userInput.equals(String.valueOf(options - 1)) && !userInput.equals(String.valueOf(options - 2))) {
            System.out.println("Please input a number from 1 to " + options);
            userInput = scanner.nextLine();
        }
        return Integer.parseInt(userInput);
    }

    public static void createPlayer() {
        int strengthCount = 1;
        int dexterityCount = 1;
        int intelligenceCount = 1;
        //this is setting the player name
        System.out.println("Enter your name: ");
        String playerName = scanner.nextLine();
        player.setName(playerName);
        //Questions to set player stats based on responses
        System.out.println("Someone insults you. What do you do? ");
        System.out.println("[1] Beat their face in with a rock. "); // Strength
        System.out.println("[2] Insult them back. "); // dexterity
        System.out.println("[3] Strike up a counter argument about why William Shakespeare is the real villain behind modern illiteracy. "); //Intelligence


        int userInput = pickOption(3);
        if (userInput == 1) {
            strengthCount++;
        }
        if (userInput == 2) {
            dexterityCount++;
        }
        if (userInput == 3) {
            intelligenceCount++;
        }
        System.out.println("What do you value most?");
        System.out.println("[1] Power"); // Strength
        System.out.println("[2] Wealth"); // Dexterity
        System.out.println("[3] Wisdom"); // Intelligence
        userInput = pickOption(3);

        if (userInput == 1) {
            strengthCount++;
        }
        if (userInput == 2) {
            dexterityCount++;
        }
        if (userInput == 3) {
            intelligenceCount++;
        }

        System.out.println("You're trapped in a blocked off cave after a horrific caving experience with several other cavers. What is your next step?");
        System.out.println("[1] You start throwing the rocks out of the way to clear a path."); // Strength
        System.out.println("[2] You explore the cave to find another potential exit."); // Dexterity
        System.out.println("[3] You convince the others to dig a way out while you manage their efforts."); // Intelligence
        userInput = pickOption(3);

        if (userInput == 1) {
            strengthCount++;
        }
        if (userInput == 2) {
            dexterityCount++;
        }
        if (userInput == 3) {
            intelligenceCount++;
        }

        System.out.println("What fictional character do you most identify with? ");
        System.out.println("[1] Maximus from Gladiator"); // Strength
        System.out.println("[2] Legolas from Lord of the Rings"); // Dexterity
        System.out.println("[3] Morpheus from The Matrix Revolutions"); // Intelligence
        userInput = pickOption(3);

        if (userInput == 1) {
            strengthCount++;
        }
        if (userInput == 2) {
            dexterityCount++;
        }
        if (userInput == 3) {
            intelligenceCount++;
        }
        player.setStrength(strengthCount);
        player.setDexterity(dexterityCount);
        player.setIntelligence(intelligenceCount);
        player.getInventory().clear();
        while(true) {
            Controller.move(player);
        }
    }
    public static void deadEnd() {
        System.out.println("Game Over \n" +
                "Would you like to start again?");
        System.out.println("[1] Yes");
        System.out.println("[2] No");
        int userInput = pickOption(2);
        if (userInput==1) {
//            Clear player inventory/data and start fresh
            run();
        }
        else {
            System.out.println("Thanks for playing! ");
            System.exit(0);
        }

    }

}
