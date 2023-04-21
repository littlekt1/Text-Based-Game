import javax.naming.ldap.Control;

public class SixthFloor {
    private static Zombie copZombie = new Zombie(1);
    private static boolean alreadyPresidentRoom = false;
    public static void firstOptions() {
        System.out.println("[1] Investigate the first room on the right.");
        System.out.println("[2] Check out the second room on the right.");
        System.out.println("[3] Explore the third room on the right.");
        if (!copZombie.isDead()) {
            System.out.println("[4] Fight the zombie.");
        } else {
            System.out.println("[4] Approach the giant oak doors.");
        }
        System.out.println("[5] Run to the staircase leading up.");
        System.out.println("[6] Go back.");
    }
    public static void runSixthFloor(Player player) {
        System.out.println("You enter a hallway with two giant oak doors on the left and multiple offices on the right.\n" +
                "There is a cop zombie standing in front of the oak doors.\n" +
                "At the end of the corridor, there is a staircase leading up.");
        while (player.getCurrentLocation() == 5 && player.isAlive()) {
            firstOptions();
            int userInput = Controller.pickOption(6);
            if (userInput == 1) {

            } else if (userInput == 2) {

            } else if (userInput == 3) {

            } else if (userInput == 4) {
                presidentRoom(player);
            } else if (userInput == 5) {

            } else if (userInput == 6) {
                player.setCurrentLocation(5);
            }
        }

    }
    public static void firstRoom(Player player) {
        System.out.println("You bolt into the room, desperate to escape the zombie");
    }
    public static void presidentRoom(Player player) {
        int userInput = 0;
        if (!copZombie.isDead()) {
            Combat.combat(player, copZombie);
            System.out.println("You look at the undead cop lying on the ground, craving to ravage any weapons that he might have.");
            System.out.println("[1] Search his body.");
            System.out.println("[2] Let him rest in peace.");
            userInput = Controller.pickOption(2);
            if (userInput == 1) {
                System.out.println("You loot the dead body and found 5 bullets.");
                player.pickUpAmmo(5);
            } else {
                System.out.println("You decide to leave him alone.");
            }
            return;
        }
        System.out.println("You approach the giant oak doors and give them a shove but they are locked.");
        if (player.keyCheck("President Key")) {
            System.out.println("You use the fancy key you just found to unlock the door.");
            System.out.println("You enter a baroque room that seems to be the president room.");
        }
        System.out.println("You hear a muffling sound behind the president desk.");
        if (player.getIntelligence() >= 3) {
            System.out.println("You think there can be a person behind it.");
        }

        System.out.println("[1] Investigate the source of the sound.");
        System.out.println("[2] Leave the room.");
        userInput = Controller.pickOption(2);
        if (userInput == 1) {
            System.out.println("You carefully approach the desk when a man suddenly comes out from " +
                    "under it and attacks you with a menorah.");
            if (player.getDexterity() >= 2) {
                System.out.println("You masterfully avoid the attack and kick the man to the floor.");
            } else {
                player.getDamaged(2);
                System.out.println("The man hits you in the head.");
                System.out.println("[1] Punch the idiot.");
                System.out.println("[2] Leave the man alone. He was scared.");
            }

        }



    }
}
