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
                firstHallwaySection(player);
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
        while (true) {
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
                    if (userInput == 1) {
                        System.out.println("You have a feeling of dread fall over you as you enter the room that was at the end of the hall. A plaque is mounted to the right as you walk through the doorway. It reads 'St. Wesker's Morgue'.");
                        System.out.println("What will you do from here? ");
                        System.out.println("[1] Investigate the surgical tables. ");
                        System.out.println("[2] Investigate the body lockers on the right-hand side of the Morgue. ");
                        System.out.println("[3] Investigate the left side of the room where you see a dark shape leaned against the wall. ");
                        userInput = Controller.pickOption(3);
                        if (userInput == 1) {
                            if (player.getIntelligence() > 2) {
                                System.out.println("Lots of equipment lines the tables in the center of the room. You aren't very well-versed in surgical tools, but there " +
                                        "are several of them that are clearly used to open up dead bodies. Theres a note illustrating how you can remove the head using a saw-shaped" +
                                        "tool. This may be useful in a pinch. ");
                            } else {
                                System.out.println("You see sharp objects lining the tables. You don't want to get to close.");
                            }
                        } else if (userInput == 2) {
                            if (player.getDexterity() > 2) {
                                System.out.println(" Empty body coolers to preserve the freshly dead bodies. Could be a potential hiding place for later. The bodies that were here seem " +
                                        "to have been moved elsewhere, though there are no blood trails or scuff marks to suggest the bodies moved on their own.");
                            } else {
                                System.out.println("They're cold freezers for storing dead bodies. Nothing of major use here.");
                            }
                        } else {
                            System.out.println("You slowly approach a figure wedged in the corner between two tables. Though the room is lit well, this shape is hidden in the little shadows there are.");
                            System.out.println("Do you: ");
                            morgueBeast(player);

                        }
                    } else if (userInput == 2) {
                        System.out.println("There is a very cluttered red tinted hallway behind you with a fire staircase at the end of it. The way you entered. The way to safety from the unknown. " +
                                "It somehow seems appealing, even though you haven't come across a single zombie down here. There is no sign of infection down here. This might be one of the safe areas in this hospital, " +
                                "but why does it still make you feel dread? ");
                    } else {
                        System.out.println("Good choice. ");
                        player.setCurrentLocation(3);
                    }
                } else if (userInput == 2) {
                    System.out.println("You made the right choice.");
                    player.setCurrentLocation(3);
                }
            } else if (userInput == 2) {
                System.out.println("You find more gourneys, a tilted file cabinet and some old boxes. The hall seems remarkably clean. No blood or anything out of the ordinary aside from the messy" +
                        "hospital equipment. ");
            } else {
                System.out.println("Good choice.");
                player.setCurrentLocation(3);
            }

        }
    }

    public static void morgueBeastOptions() {
        System.out.println("[1] Get in for a closer look.");
        System.out.println("[2] You don't like this. Take a look around one more time and see if you can leave. ");
    }
    public static void morgueBeast(Player player) {
        while (true) {
            morgueBeastOptions();
            userInput = Controller.pickOption(2);
            if (userInput == 1) {
                System.out.println("You lean in. ");
                if (player.getDexterity() >= 4) {
                    System.out.println("There's a key inside the large shape. With your keen sight you see it says 'Parking Garage'.");
                    morgueBeastMoreOptions();
                } else {
                    System.out.println("You see a cloaked figure. It looks too large to be human. ");
                    morgueBeastMoreOptions();
                }
            } else {
                System.out.println("You scan the room one more time, nothing of any real use is in the room. You try to leave, but your legs are frozen as you approach the door. You feel you need to inspect that figure in the shadows. ");
                morgueBeastMoreOptions();
            }
        }
    }
    public static void morgueBeastMoreOptions(){
        System.out.println("[1] Reach for the shiny shape in the large figure and grab it. ");
        System.out.println("[2] Shoot the figure several times to be safe. ");
    }
    public static void morgueBeastMore(Player player) {
        morgueBeastMoreOptions();
        userInput = Controller.pickOption(2);
        while(true) {

        }
    }
}