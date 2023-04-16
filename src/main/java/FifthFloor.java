import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class FifthFloor {
    public static Scanner scanner = new Scanner(System.in); // User input scanner
    public static int userInput;
    public static boolean alreadyLeft1 = false;
    public static boolean alreadyLeft2 = false;
    public static boolean alreadyLeft4 = false;
    public static boolean alreadyRight1 = false;
    public static boolean alreadyRight3 = false;
    public static boolean alreadyReception = false;
    public static boolean alreadyReceptionInnerOffice = false;
    public static boolean backOnFloorFive = false;
    public static final String NURSE_KEY = "Nurse's Key";
    public static final String RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static Zombie axeNurseZombie = new Zombie(1);
    public static Zombie hotLadyZombie = new Zombie(1);
    public static Zombie cabinetZombie = new Zombie(1);


//    public static int floor = 5;

    public static void firstOptions() { //first options user is presented outside Opening room.
        System.out.println("[1] Go left.");
        System.out.println("[2] Go right.");
        System.out.println("[3] Enter the reception area.");
        System.out.println("[4] Turn back around.");
    }

    public static void leftHallwayOptions() {
        System.out.println("You're in the left hallway. ");
        System.out.println("[1] Explore the first room on the left.");
        System.out.println("[2] Explore the second room on the left.");
        System.out.println("[3] Take a gander at the first room on the right.");
        System.out.println("[4] Explore the second room on the right.");
        System.out.println("[5] Go towards the stairs.");
        System.out.println("[6] Go back.");
    }

    public static void rightHallwayOptions() {
        System.out.println("You're in the right hallway. ");
        System.out.println("[1] Explore the first room on the right.");
        System.out.println("[2] Check out the second room on the right.");
        System.out.println("[3] Investigate the first door on the left.");
        System.out.println("[4] Check out the second door on the left.");
        System.out.println("[5] Run past the rooms and head toward staircase.");
        System.out.println("[6] Turn back around.");

    }


    public static void runFifthFloor(Player player) {
        while (player.getCurrentLocation() == 5) {
            System.out.println("You're in the hallway. ");
            firstOptions();
            userInput = Controller.pickOption(4);
            if (userInput == 1) {
                System.out.println("You decided to go left, heading towards the flickering lights and the staircase heading upwards. There are several other patient rooms on either side of you. ");
                while (player.getCurrentLocation() == 5) {
                    leftHallwayOptions();
                    userInput = Controller.pickOption(6);
                    if (userInput == 1) {
                        if (alreadyLeft1) {
                            System.out.println("You have already been to this room.");
                        } else {
                            alreadyLeft1 = true;
                            leftHallwayLeftRoom1(player);
                        }
                    } else if (userInput == 2) {
                        if (alreadyLeft2) {
                            System.out.println("You refuse to enter this room again.");
                        } else {
                            alreadyLeft2 = leftHallwayLeftRoom2(player);
                            System.out.println("You leave the room. ");
                        }
                    } else if (userInput == 3) {
                        System.out.println("The door is locked, you give it a slight shove with your shoulder but it doesn't budge.");
                        System.out.println("You decide to move on.");
                    } else if (userInput == 4) {
                        if (alreadyLeft4) {
                            System.out.println("You have already been to this room.");
                        } else {
                            alreadyLeft4 = true;
                            leftHallwayRightRoom2(player);
                        }
                    } else if (userInput == 5) {
                        System.out.println("Looking up the dimly lit staircase with flickering lights and an ominous aura, you question if this is the best path to go. Do you want to go up the stairs?");
                        System.out.println("[1] Yes.");
                        System.out.println("[2] No.");
                        userInput = Controller.pickOption(2);
                        if (userInput == 1) {
                            System.out.println("You start walking up the stairs. You hear a sound behind you and rush up to the sixth floor.");
                            player.setCurrentLocation(6);
                            return;
                        } else {
                            System.out.println("You get scared and decide to explore the other options.");
                            break;
                        }
                    } else if (userInput == 6) {
                        break;
                    }
                }

            } else if (userInput == 2) {
                rightHallway(player);

            } else if (userInput == 3) {
                receptionArea(player);
            } else if (userInput == 4) {
                if (player.weaponCheck("pistol")) {
                    System.out.println("This is where you woke up, you'd be better off moving forward. ");
                } else {
                    System.out.println("You return to the room you woke up in. ");
                    player.setCurrentLocation(0);
                }
            }

        }
    }

    public static void leftHallwayLeftRoom1(Player player) {
        System.out.println("This room is very similar to the one you woke up in, but several cabinets have been removed from the walls, and door has been broken off the hinges. "); //This sout is what you see when you first enter the room
        System.out.println("You see a trail of blood leading to the bed with a clipboard on it. You walk over and pick up the file.");
        if (player.getIntelligence() >= 2) {
            System.out.println("The clipboard describes a patient who became increasingly agitated and unresponsive. The ultimate fate of the patient is unknown. Strange the bed is empty and personal belongings seem missing.");
        } else {
            System.out.println("You're unable to read, get frustrated and rip off the paper.");
        }
        System.out.println("You decide to go back out.");
    }

    public static boolean leftHallwayLeftRoom2(Player player) {
        System.out.println("This is another room that looks similar to the others, but you hear a low groan coming from within one of the tall cabinets.");
        if (player.getDexterity() >= 2) {
            System.out.println("You hear what sounds like a feral animal and the faint sound of scratching on the inside of the metal cabinet doors. ");
        }
        if (player.getIntelligence() >= 2) {
            System.out.println("You get the feeling, this is better left alone. ");
        }
        System.out.println("Do you investigate?");
        System.out.println("[1] Yes. ");
        System.out.println("[2] No. ");
        userInput = Controller.pickOption(2);
        if (userInput == 1) {
            System.out.println("You approach the cabinet. And the doors fall outward and a writhing corpse lands onto you, pulling and tearing at your flesh. " +
                    "\n You shove it off. ");
            Combat.combat(player, cabinetZombie);

        } else if (userInput == 2) {
            System.out.println("You decide to leave it alone. ");
        }
        return cabinetZombie.isDead();

    }

    public static void leftHallwayRightRoom2(Player player) {
        System.out.println("You see a neatly folded pair of Levi's™ on a hospital bed.");
        System.out.println("You rush towards them, desperate to cover your buttocks.");
        if (player.getDexterity() >= 2) {
            System.out.println("You notice some broken shards on the floor and deftly avoid them.");
            System.out.println("You put on the pair of pants. Feeling snazzy, you walk back out of the room.");
        } else {
            System.out.println("You don't notice the broken shards on the floor, you step on it and let out a shriek.");
            if (player.getIntelligence() >= 2) {
                System.out.println("You see the exposed electrical cord and do not grab it. Unable to steady yourself, you fall on the floor and hit your head.");
                Random rand = new Random();
                int chance = rand.nextInt(3) + 1;
                if (chance == 1) {
                    System.out.println("You crack open your head, bleed out and die on the spot.");
                } else if (chance == 2) {
                    System.out.println("You start to lose your consciousness. A swarm of mice come out from a hole in a nearby wall and start gnawing on your toes.");
                    System.out.println("You don't have the strength to fight back and slowly fade into oblivion.");
                } else {
                    System.out.println("Upon rising, you experience a headache, but your discomfort is not too severe.");
                    System.out.println("You put on the pair of pants. Feeling snazzy, you walk back out of the room.");
                }
            } else {
                System.out.println("You try to steady yourself and grab an exposed electrical cord.");
                System.out.println("YOU DIED!");
            }

        }

    }

    public static void rightHallway(Player player) {
        System.out.println("You decide to go right, down the well-lit hallway with several rooms on either side with a staircase leading down at the end.");
        while (player.getCurrentLocation() == 5) {
            rightHallwayOptions();
            userInput = Controller.pickOption(6);
            if (userInput == 1) {
                if (alreadyRight1) {
                    System.out.println("You've already been here.");
                } else {
                    System.out.println("You enter the room, this one is actually rather clean aside from some small blood drops on the floor leading to an observation table.");
                    System.out.println("[1] Walk up to the observation table. ");
                    System.out.println("[2] Leave, you don't feel like observing anything today.");
                    userInput = Controller.pickOption(2);
                    if (userInput == 1) {
                        System.out.println("You pick up a patient file left on the table. " +
                                "It has a handwritten note that states the patient bit three nurses and a doctor before we realized what was going on, " +
                                "but by then it was too late. This appears to be a room where the first documented patient was infected. " +
                                "Initially assumed to be some variant of rabies.");
                        System.out.println("There's nothing else of interest here. So you return to the hallway. ");
                        alreadyRight1 = true;
                    } else if (userInput == 2) {
                        System.out.println("You turn around and scramble out of the room.");

                    }
                }
            } else if (userInput == 2) {
                System.out.println("You see that the door is barricaded off, you hear something banging on the door trying to get out. You try to push the door open, but it doesn't budge.");
                System.out.println("It seems it would be best to just move on.");
            } else if (userInput == 3) { // TO-DO: Need to check if have been to lab after 3rd floor is made
                if (alreadyRight3) {
                    System.out.println("You've already been here, this sick, thick, dying man is still here. Sick and dying. ");

                } else {
                    if (player.keyCheck(NURSE_KEY)) {
                        System.out.println("You press the keycard you so heartlessly stole from the dead " +
                                "nurse against the scanner. It beeps and the door swings open. ");
                        System.out.println("There is a bald man with a mustache and glasses laying in the hospital bed up against the center wall of the room. He says his name is " +
                                "Art Vandalay, but you think his name is probably George. He looks up at you with his cold, weary eyes and asks if you've been bitten.");
                        System.out.println("[1] Tell him yes. ");
                        System.out.println("[2] Tell him no. ");
                        userInput = Controller.pickOption(2);
                        if (userInput == 1) {
                            System.out.println("He screams and throws a heart rate monitor at you and continues his volley of objects that should be heavier than they are, until you leave the room.");

                        } else if (userInput == 2) {
                            System.out.println("He says \"Great, I need your help. There's a lab on the 3rd floor. They were working on a cure, please go get it for me. I'm really sick and " +
                                    "I need your help. Help me random survivor, you're my only hope.\"");
                            System.out.println("[1] Accept this noble quest and depart. ");
                            System.out.println("[2] Ain't nobody got time for that. Punch his thigh and leave. ");
                            userInput = Controller.pickOption(2);
                            if (userInput == 1) {
                                System.out.println("\"Good luck and god speed.\" You leave the room.");
                            } else if (userInput == 2) {
                                System.out.println("\"You jerk!!\" You hear him sobbing into his pillow as you leave.");
                            }
                        }
                        alreadyRight3 = true;
                    } else {
                        System.out.println("The door is locked, maybe there's a key somewhere. ");
                    }
                }
            } else if (userInput == 4) {
                if (hotLadyZombie.isDead()) {
                    System.out.println("You don't want to have to relive the trauma of killing the only chance you ever had at true love.");
                }
                System.out.println("This room has very dim lighting, you're hesitant to enter, but something is drawing you in. You enter, and on the patient bed you discover a hot, lady zombie.");
                System.out.println("You can either:");
                System.out.println("[1] Not be an idiot and fight it.");
                System.out.println("[2] You can be a weirdo, check it out, and get your face bitten off. (Dead end screen says “worth it” with cool guy sunglasses.)");
                System.out.println("[3] You can close the door and walk away slowly, you've seen Gremlins 2 and know how this goes.");
                userInput = Controller.pickOption(3);
                if (userInput == 1) {
                    Combat.combat(player, hotLadyZombie);
                    System.out.println("A big fat tear rolls down your cheek as you killed your only hope for love in this hospital. ");
                } else if (userInput == 2) {
                    System.out.println("You perform a cat call at the zombie, it blushes and then immediately charges you, eating part of your face.");
                    Application.deadEnd();
                } else if (userInput == 3) {
                    System.out.println("You very slowly back away from the room, slowly closing the door and place a small chair against the knob, just in case the zombie starts to roam.");
                }
            } else if (userInput == 5) {
                System.out.println("Looking down the well polished staircase with bright, buzzing overhead lights, you question if this is the best path to go. Do you want to go down the stairs?");
                System.out.println("[1] Yes.");
                System.out.println("[2] No.");
                userInput = Controller.pickOption(2);
                if (userInput == 1) {
                    System.out.println("You start walking down the stairs. You hear a low groan behind you that gives you goose pimples all over your spine and rush down the stairs to the fourth floor.");
                    player.setCurrentLocation(4);
                    return;
                } else {
                    System.out.println("You get scared and decide to explore the other options.");
                }
            } else if (userInput == 6) {
                return;
            }
        }
    }

    public static void receptionArea(Player player) {
        while (player.getCurrentLocation() == 5) {
            System.out.println("You approach what appears to be a receptionist desk, used by the nurses and staff on this floor. There is a door leading into a rear office along with a desk that has some papers on it.");
            System.out.println("[1] Look at the papers on the desk.");
            System.out.println("[2] Go into the office. ");
            userInput = Controller.pickOption(2);
            if (userInput == 1) {
                System.out.println("You pick up the papers from the desk. There are some frantic scribbles from presumably one of the nurses that detail the different exit routes from the hospital.");
                System.out.println(RED + "||FRONT DOOR:\n||a side note from the nurse states this is the most obvious, but getting there might be a challenge.");
                System.out.println("||PARKING GARAGE:\n||a side note from the nurse says there is an employee/emergency vehicle access gate that can be opened using an employee key.");
                System.out.println("||SEWER ACCESS:\n||a side note from the nurse lists this as only viable if you're extremely desperate you mignt be able to find access to the sewer system.");
                System.out.println("||EXECUTIVE EXIT ROUTE:\n||a side note from the nurse lists this as one of the ways the hospital owner gets to and from his office without taking the elevator or stairs. \n" + ANSI_RESET);
            } else if (userInput == 2) {
                System.out.println("You head toward the office, noticing a bloody set of fingerprints on the door knob. You brave forward and open the door.");
                System.out.println("You see an average office area with several computers lining the walls in small desk areas. There is an open area in the center of the room with a bloodied body of a nurse, with an axe sticking out of her back.");
                System.out.println("[1] Approach the corpse and remove the axe? ");
                System.out.println("[2] Leave the corpse alone. ");
                if (player.getIntelligence() > 1) {
                    System.out.println("Something about the corpse makes you feel uneasy.");
                }
                if (player.getIntelligence() >= 4) {
                    System.out.println("With everything you've seen today, you get the feeling that there's something REALLY off about this corpse.");
                }
                userInput = Controller.pickOption(2);
                if (userInput == 1) {
                    System.out.println("You cautiously approach the corpse and get two hands around the handle of the axe and pull.");
                    if (player.getStrength() > 1) { // if not enough strength you don't deal damage on removal.
                        axeNurseZombie.setHealth(5);
                    }
                    System.out.println("You managed to pull the axe out of the nurse's back.");
                    if (player.getDexterity() < 2) {
                        System.out.println("You fall back pulling the axe out and are on the floor watching as the corpse lifts itself off the floor turning towards you.");
                    }
                    player.addWeapon("axe", new Axe());
                    System.out.println("You hear a groan from the corpse as it struggles to lift itself up from the floor.");
                    Combat.combat(player, axeNurseZombie);
                    System.out.println("The undead nurse lies motionless on the floor, its head lying " +
                            "several feet from its body, a viscous green ooze pouring from its now headless " +
                            "corpse. Disguisted though you are, you notice a shining keycard attached to " +
                            "her waist. It seems like it could be useful, but you're also not sure you want " +
                            "to spend any more time in here than you have to.");
                    System.out.println("[1] Approach the nurse and steal her key like the little thieving bastard you are.");
                    System.out.println("[2] Leave the poor woman to rest in peace.");
                    userInput = Controller.pickOption(2);
                    if (userInput == 1) {
                        System.out.println("Well, it looks like being an immoral thief pays off today. You loot " +
                                "the nurse's corpse. You now have a Nurse Key.");
                        player.addKey(NURSE_KEY);
                    } else if (userInput == 2) {
                        System.out.println("You leave the office with the axe in hand feeling good about yourself " +
                                "for not looting an innocent young woman's corpse.");
                    }
                    return;
                } else if (userInput == 2) {
                    System.out.println("You decide to let the nurse rest in peace and leave the room.");
                    return;
                }
            }
        }
    }
}
