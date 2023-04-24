import java.util.LinkedList;
import java.util.List;

public class SixthFloor {
    private static Zombie copZombie = new Zombie(1);
    private static Zombie zombie1 = new Zombie(1);
    private static Zombie zombie2 = new Zombie(1);
    private static Zombie zombie3 = new Zombie(1);
    private static boolean alreadyPresidentRoom = false;

    public static void firstOptions() {
        System.out.println("\nYou're at the hallway.");
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
        while (player.getCurrentLocation() == 6 && player.isAlive()) {
            firstOptions();
            int userInput = Controller.pickOption(6);
            if (userInput == 1) {
                firstRoom(player);
            } else if (userInput == 2) {

            } else if (userInput == 3) {
                office(player);

            } else if (userInput == 4) {
                if (!alreadyPresidentRoom) {
                    presidentRoom(player);
                }
            } else if (userInput == 5) {

            } else if (userInput == 6) {
                player.setCurrentLocation(5);
            }
        }
    }

    public static void firstRoom(Player player) {
        if (!copZombie.isDead()) {
            System.out.println("You bolt into the room, desperate to escape the zombie");
        }
        System.out.println("You enter what looks like a janitor closet.");
        System.out.println("Across from you, there's a zombie stuck to the wall, impaled by a mop, flailing its shriveled arms at you.");
        System.out.println("In its pocket, you can see a shiny silver key.");
        if (player.weaponCheck("pistol")) {
            System.out.println("[1] Shoot it with your gun, no point to put yourself in danger.");
        }



    }

    public static void office(Player player) {
        System.out.println("You enter a spacious office area where a swarm of zombies are mindlessly roaming around.");
        System.out.println("[1] Take them head on.");
        System.out.println("[2] Hide behind the nearest desk.");
        System.out.println("[3] Leave the room.");
        int userInput = Controller.pickOption(3);
        if (userInput == 1) {
            Combat.multipleCombat(player, new LinkedList<>(List.of(zombie1, zombie2, zombie3)));
        } else if (userInput == 2) {
            if (player.getDexterity() >= 2) {
                System.out.println("You nimbly dive behind the nearest desk, barely avoid the zombies line of sight.");
            } else {
                System.out.println("You trip over and fell, the zombies spot you and hungrily pour over.");
            }
        } else {

        }
    }

    public static void presidentRoom(Player player) {
        int userInput = 0;
        if (!copZombie.isDead()) {
            Combat.combat(player, copZombie);
            System.out.println("You look at the undead cop lying on the ground, thinking about what weapons he might be carrying.");
            System.out.println("[1] Search his body.");
            System.out.println("[2] Let him rest in peace.");
            userInput = Controller.pickOption(2);
            if (userInput == 1) {
                System.out.println("You loot the dead body and find" + (!player.weaponCheck("pistol") ? " a pistol and" : "") + " 5 bullets.");
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
            System.out.println("You hear a muffled sound behind the president desk.");
            if (player.getIntelligence() >= 2) {
                System.out.println("You think there can be a person behind it.");
            }
            System.out.println("[1] Investigate the source of the sound.");
            System.out.println("[2] Leave the room.");
            userInput = Controller.pickOption(2);
            if (userInput == 1) {
                System.out.println("You carefully approach the desk when a man suddenly comes out from " +
                        "under it and attacks you with a menorah.");
                if (player.getDexterity() >= 4) {
                    System.out.println("You masterfully avoid the attack and kick the man to the floor.");
                } else {
                    System.out.println("The man hits you.");
                    player.nonCombatDamaged(2);
                    System.out.println("[1] Beat up the idiot.");
                    System.out.println("[2] Leave the man alone. He was scared.");
                    userInput = Controller.pickOption(2);
                    if (userInput == 1) {
                        System.out.println("You connect a roundhouse kick with the man's head and knock him unconscious.");
                        System.out.println("Satisfied with yourself, you ravage the fancy room and get a granola bar to energize your self.");
                        player.setHealth(player.getHealth() + 5);
                        if (player.getHealth() > 25) {
                            player.setHealth(25);
                        }
                        System.out.println("You shake the man to wake him up.");
                    }
                }
                System.out.println("You try to convince him that you are not a zombie and ask him for an escape route.");
                System.out.println("Impressed with your physique, the man tells you about his private helicopter on the rooftop and asks if he can come with you as you look for an escape.");
                if (player.getIntelligence() >= 4) {
                    System.out.println("You're confident in your ability to figure out how to pilot a helicopter and think the man can help you with your escape.");
                }
                System.out.println("[1] Let the man come with you.");
                System.out.println("[2] Leave the man to rot in his zombie-besieged room.");
                System.out.println("[3] Mug the man for something useful and leave him.");
                Controller.pickOption(3);
                if (userInput == 1) {
                    System.out.println("You decide to let the man come with you.");
                    alreadyPresidentRoom = true;
                } else if (userInput == 2) {
                    System.out.println("You leave the room");
                } else {
                    player.addKey("Helicopter Key");
                    System.out.println("You strip him off his helicopter key and leave the defenseless man behind.");
                    alreadyPresidentRoom = true;
                }
            }
        }

    }
}
