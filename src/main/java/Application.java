import java.util.Scanner;

public class Application {

    public static Scanner scanner = new Scanner(System.in);
    public static Player player = new Player("");

    public static void main(String[] args) {
        Application game = new Application();
        game.run();
    }
    public void run (){
        startGame();
        createPlayer();
        Opening.runOpening(player);
        FifthFloor.runFifthFloor(player); // Adds the player object to the fifth floor
    //    System.out.println(Opening.player.getName());
    }
    public void floors() {
       // Opening opening = new Opening();
    }
    //methods
    public void startGame() {
        System.out.println(" \n".repeat(50)); // getting it to clear the console 50 lines
        //System.out.print("\033[H\033[2J");
        //System.out.flush();
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


        int userInput = scanner.nextInt();
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
        userInput = scanner.nextInt();

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
        userInput = scanner.nextInt();

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
        userInput = scanner.nextInt();

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
    }
    public void deadEnd() {
        System.out.println("Game Over \n" +
                "Would you like to start again?");
        System.out.println("[1] Yes");
        System.out.println("[2] No");
        int userChoice = scanner.nextInt();
        if (userChoice==1) {
            Application game = new Application();
            game.run();
        }
        else {
            System.out.println("Thanks for playing! ");
        }
    }

}
