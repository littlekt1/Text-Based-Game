import java.util.Scanner;

public class FifthFloor {
    public static Scanner scanner = new Scanner(System.in); // User input scanner
    public static int userInput;
//    public static int floor = 5;


    public static void firstOptions() { //first options user is presented
        System.out.println("[1] Go left.");
        System.out.println("[2] Go right.");
        System.out.println("[3] Enter the reception area.");
        System.out.println("[4] Turn back around.");
    }

    public static int pickOption (int options) {
        String userInput = scanner.nextLine();
        while (!userInput.equals("1") && !userInput.equals("2") && !userInput.equals(String.valueOf(options - 1)) && !userInput.equals(String.valueOf(options - 2))) {
            System.out.println("Please input a number from 1 to " + options);
            userInput = scanner.nextLine();
        }
        return Integer.parseInt(userInput);
    }

    public static void runFifthFloor(Player player) {
        firstOptions();
        userInput = pickOption(4);//prompting an input
        leftHallwayLeftRoom2(player);

        while (true) {
            if (userInput == 1) {
                System.out.println("You decided to go left, heading towards the flickering lights and the staircase heading upwards. There are several other patient rooms on either side of you.");
            }
            if (userInput == 2) {
                System.out.println("");
            }
            if (userInput == 3) {
                System.out.println();
            }
            if (userInput == 4) {
                System.out.println();
            }

        }
    }
    public static void leftHallwayLeftRoom1() {
        System.out.println("This room is very similar to the one you woke up in, but several cabinets have been removed from the walls, and door has been broken off the hinges. "); //This sout is what you see when you first enter the room

    }
    public static void leftHallwayLeftRoom2(Player player) {
        System.out.println("This is another room that looks similar to the others, but you hear a low groan coming from within one of the tall cabinets.");
        if(player.getDexterity() >= 2) {
            System.out.println("You hear what sounds like a feral animal and the faint sound of scratching on the inside of the metal cabinet doors. ");
        } if (player.getIntelligence()>=2) {
            System.out.println("You get the feeling, this is better left alone. ");
        }
        System.out.println("Do you investigate?");
        System.out.println("[1] Yes. ");
        System.out.println("[2] No. ");
        userInput = pickOption(2);
        if (userInput == 1) {
            System.out.println("You approach the cabinet. And the doors fall outward and a writhing corpse lands onto you, pulling and tearing at your flesh. ");
            if (player.getInventory().contains(KeyItems.pistol)) {
                System.out.println("You quickly draw the pistol you found earlier and shoot the zombie in the head. Its cold, lifeless corpse falls onto you, no longer moving.");
            } else {
                System.out.println("YOU DIED!");
                Application.deadEnd();
            }
        } if (userInput == 2) {
            System.out.println("You decide to leave it alone. ");
        }

    }
    public static void leftHallwayRightRoom1() {


    }
    public static void leftHallwayRightRoom2() {


    }

}
