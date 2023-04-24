import java.util.Scanner;

public class BasementMorgue {
    public static Scanner scanner = new Scanner(System.in); // User input scanner
    public static int userInput;

    public static void initialBasementMorgueOptions() { //first options user is presented outside first floor.
        System.out.println("[1] Push onward down the hall. ");
        System.out.println("[2] Turn back and go back up to the ground floor. ");
    }

    public static void runBasementMorgue(Player player) {
        System.out.println("You are faced with a poorly-lit hallway. Emergency lighting is illuminating the narrow path from overhead in an eerie red tint. " +
                "It stretches for what appears to be hundreds of meters. You can make out several small shapes on either side that you can guess to be gourneys, chairs and file cabinets. ");
        System.out.println();
        while (player.getCurrentLocation() == 1) {
            initialBasementMorgueOptions();
            userInput = Controller.pickOption(2);
            if (userInput == 1) {
                firstHallwayOptions();
            } else {
                player.setCurrentLocation(3);
            }
        }
    }
    public static void firstHallwayOptions() {
        System.out.println("[1] Continue further down the hallway. ");
        System.out.println("[2] Look around the hallway. ");
        System.out.println("[3] Go back upstairs to the ground floor. It's not too late to turn back. ");
    }
    public static void firstHallwaySection(Player player) {
        System.out.println("You move a few dozen meters down the hall. It's still an uncomfortable dim red tint. There's an out of server elevator to your left with the doors pried open. It leads" +
                "down to darkness. ");
        while(true){
            firstHallwayOptions();
            userInput = Controller.pickOption(3);
            if (userInput == 1) {
                System.out.println("You move further down the hallway.");
                System.out.println();
                System.out.println("[1] Continue towards the light? ");
                System.out.println("[2] Turn back. GO BACK TO SAFETY. ");
                userInput = Controller.pickOption(2);
                if (userInput == 1) {
                    System.out.println("You make the choice to continue on. You are right outside of the large white room resonating the beaming clear light from it. ");
                    System.out.println("Do you: ");
                    System.out.println("[1] Enter the room. (There is no going back from here. )");
                    System.out.println("[2] Look back through the hallway. ");
                    System.out.println("[3] Sprint to the stairs and leave. ");
                    userInput = Controller.pickOption(3);
                    if (userInput==1) {
                        System.out.println("You have a feeling of dread fall over you as you enter the room that was at the end of the hall. A plaque is mounted to the right as you walk through the doorway. It reads 'St. Wesker's Morgue'.");
                        System.out.println("What will you do from here? ");
                        System.out.println("[1] Investigate the surgical tables. ");
                        System.out.println("[2] Investigate the body lockers on the righthand side of the Morgue. ");
                        System.out.println("[3] Investigate the left side of the room where you see a dark shape leaned against the wall. ");
                        userInput = Controller.pickOption(3);
                        if (userInput==1) {
                            
                        }
                    } else if (userInput == 2) {
                        System.out.println("There is a very cluttered red tinted hallway behind you with a fire staircase at the end of it. The way you entered. The way to safety from the unknown. " +
                                "It somehow seems appealing, even though you haven't come across a single zombie down here. There is no sign of infection down here. This might be one of the safe areas in this hospital, " +
                                "but why does it still make you feel dread? ");
                    } else {
                        player.setCurrentLocation(3);
                    }
                } else if (userInput==2) {
                    player.setCurrentLocation(3);
                }
            } else if (userInput == 2) {
                System.out.println("You find more gourneys, a tilted file cabinet and some old boxes. The hall seems remarkably clean. No blood or anything out of the ordinary aside from the messy" +
                        "hospital equipment. ");
            } else {
                player.setCurrentLocation(3);
            }

        }
    }
}
