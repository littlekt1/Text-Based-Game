import java.util.Scanner;


public class Opening {
    public static void firstOptions () {
        System.out.println("[1] Go to the door. ");
        System.out.println("[2] Go to the window. ");
        System.out.println("[3] Explore the room. ");
        System.out.println("[4] Hide under the bed. ");
    }
    public static boolean alreadyHere = false;

    //public static Pistol pistol = new Pistol("Pistol", false);
   public static void runOpening(Player player) { // we put the player we created in Application in here each time we run opening.
       if (alreadyHere == false){
           System.out.println("You wake up in a hospital room, disoriented. The last thing you remember is a car swerving into your lane and it all going black. \n" +
                   "You look around your room and you see a bloody set of hand-prints on the door window, alarmed, you stand up. Your legs are wobbly from lack of movement for some time. You grab the side of the hospital bed to steady yourself. \n" +
                   "You pull the IVs out of your arm and stumble forward. \n \n" +
                   "Do you: \n");
       } alreadyHere = true;

            firstOptions();
            int userInput = Controller.pickOption(4);
            while (true) {
                if (userInput == 1) {
                    System.out.println("You walk up to the door. You turn the knob and stumble into the hallway, looking around. \n" +
                            "To your left, you see flickering lights, and a staircase leading up. \n" +
                            "To your right, you see a brightly lit corridor, and a staircase leading down. \n" +
                            "Directly across from you, there is a reception area with several bloody streaks across the large counter, trailing into the back office. ");
                    player.setCurrentLocation(5);
                    break;

                }
                if (userInput == 2) {
                    System.out.println("You walk to the window and look out. You see a military envoy setting up a blockade outside. \n");
                    while (true) {
                        firstOptions();
                        userInput = Controller.pickOption(4);
                        if (userInput != 2) {
                            break;
                        }
                        System.out.println("You're already at the window. \n");
                    }
                }
                if (userInput == 3 && !player.weaponCheck("pistol")) {
                    System.out.println("You explore the room and find a pistol. You check the magazine, but it's empty. However, there is one in the chamber. \n");
                    Pistol pistol = new Pistol();
                    player.addWeapon("pistol", pistol);
                    firstOptions();
                    userInput = Controller.pickOption(4);
                } else if (userInput == 3 && player.weaponCheck("pistol")){
                    System.out.println("You've already searched the room. \n");
                    firstOptions();
                    userInput = Controller.pickOption(4);

                }
                if (userInput == 4) {
                    System.out.println("You tuck your knees and curl into a ball under the bed sobbing vigorously. \n");
                    firstOptions();
                    userInput = Controller.pickOption(4);
                    if (userInput == 4) {
                        System.out.println("You continue sobbing louder. \n");
                        firstOptions();
                        userInput = Controller.pickOption(4);
                        if (userInput == 4) {
                            System.out.println("Wow you're a big baby. You KEEP crying EVEN LOUDER. \n");
                            firstOptions();
                            userInput = Controller.pickOption(4);
                            if (userInput == 4) {
                                System.out.println("The crying has gotten so loud, a roaming zombie hears it and comes barreling in, attacking you under the bed. YOU HAVE DIED. You big baby. ");
                                Application.deadEnd();
                                break;
                            }
                        }
                    }
                }
            }
        }
  }
