import java.util.Scanner;

public class ZombieTest {
    public static void firstOptions() {
        System.out.println("[1] Go to the door. ");
        System.out.println("[2] Go to the window. ");
        System.out.println("[3] Explore the room. ");
        System.out.println("[4] Hide under the bed. ");
    }

    public static void main(String[] args) {
        boolean hasPistol = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("You wake up in a hospital room, disoriented. The last thing you remember is a car swerving into your lane and it all going black. \n" +
                "You look around your room and you see a bloody set of hand-prints on the door window, alarmed, you stand up. Your legs are wobbly from lack of movement for some time. You grab the side of the hospital bed to steady yourself. \n" +
                "You pull the IVs out of your arm and stumble forward. \n \n" +
                "Do you: \n");
        firstOptions();
        int userInput = scanner.nextInt();

        while (true) {
            if (userInput == 1) {
                System.out.println("You walk up to the door. You turn the knob and stumble into the hallway, looking around. \n" +
                        "To your left, you see flickering lights, and a staircase leading up. \n" +
                        "To your right, you see a brightly lit corridor, and a staircase leading down. ");
                break;

            }
            if (userInput == 2) {
                System.out.println("You walk to the window and look out. You see a military envoy setting up a blockade outside. \n");
                firstOptions();
                userInput = scanner.nextInt();
                if (userInput == 2) {
                    System.out.println("You're already at the window. \n");
                    firstOptions();
                    userInput = scanner.nextInt();
                }
            }
            if (userInput == 3 && !hasPistol) {
                System.out.println("You explore the room and find a pistol. You check the magazine, but it's empty. However, there is one in the chamber. \n");
                hasPistol = true;
                firstOptions();
                userInput = scanner.nextInt();
            }else if (userInput == 3 && hasPistol) {
                    System.out.println("You've already searched the room. \n");
                    firstOptions();
                    userInput = scanner.nextInt();

            }
            if (userInput == 4) {
                System.out.println("You tuck your knees and curl into a ball under the bed sobbing vigorously. \n");
                firstOptions();
                userInput = scanner.nextInt();
                if (userInput == 4) {
                    System.out.println("You continue sobbing louder. \n");
                    firstOptions();
                    userInput = scanner.nextInt();
                    if (userInput == 4) {
                        System.out.println("Wow you're a big baby. You KEEP crying EVEN LOUDER. \n");
                        firstOptions();
                        userInput = scanner.nextInt();
                        if (userInput == 4) {
                            System.out.println("The crying has gotten so loud, a roaming zombie hears it and comes barreling in, attacking you under the bed. YOU HAVE DIED. You big baby. ");
                        }
                    }
                }
            }
        }
    }
}
