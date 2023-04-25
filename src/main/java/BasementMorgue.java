import java.util.Scanner;

public class BasementMorgue {
    public static Scanner scanner = new Scanner(System.in); // User input scanner
    public static int userInput;

    public static void initialBasementMorgueOptions() { //first options user is presented outside first floor.
        System.out.println("[1] Push onward down the hall. ");
        System.out.println("[2] Turn back and go back up to the ground floor. ");
    }

    public static void runBasementMorgue(Player player) {
        System.out.println("You are faced with a poorly-lit hallway. Emergency lighting is illuminating the narrow path from overhead in an eerie red tint. ");
        System.out.println("It stretches for what appears to be hundreds of meters. You can make out several small shapes on either side that you can guess to be gourneys, chairs and file cabinets.");
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

    public static void firstHallwaySectionOptions() {
        System.out.println("[1] Continue further down the hallway. ");
        System.out.println("[2] Look around the hallway. ");
        System.out.println("[3] Go back upstairs to the ground floor. It's not too late to turn back. ");
    }

    public static void firstHallwaySection(Player player) {
        System.out.println("You move a few dozen meters down the hall. It's still an uncomfortable dim red tint. There's an out-of-service elevator to your left with the doors pried open. It leads " +
                "down to darkness. ");
        while (player.getCurrentLocation() == 1) {
            firstHallwaySectionOptions();
            userInput = Controller.pickOption(3);
            if (userInput == 1) {
                System.out.println("You move further down the hallway.");
                System.out.println();
                System.out.println("[1] Continue towards the light? ");
                System.out.println("[2] Turn back. GO BACK TO SAFETY. ");
                userInput = Controller.pickOption(2);
                if (userInput == 1) {
                    endOfHallway(player);
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

    public static void endOfHallwayOptions() {
        System.out.println("[1] Investigate the surgical tables. ");
        System.out.println("[2] Investigate the body lockers on the right-hand side of the Morgue. ");
        System.out.println("[3] Investigate the left side of the room where you see a dark shape leaned against the wall. ");

    }

    public static void endOfHallway(Player player) {
        System.out.println("You make the choice to continue on. You are right outside of the large white room resonating the beaming clear light from it. ");
        System.out.println("Do you: ");
        while (true) {
            System.out.println("[1] Enter the room. (There is no going back from here. )");
            System.out.println("[2] Look back through the hallway. ");
            System.out.println("[3] Sprint to the stairs and leave. ");
            userInput = Controller.pickOption(3);
            if (userInput == 1) {
                System.out.println("You have a feeling of dread fall over you as you enter the room that was at the end of the hall. A plaque is mounted to the right as you walk through the doorway. It reads 'St. Wesker's Morgue'.");
                System.out.println("What will you do from here? ");
                while (true) {
                    endOfHallwayOptions();
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
                }
            } else if (userInput == 2) {
                System.out.println("There is a very cluttered red tinted hallway behind you with a fire staircase at the end of it. The way you entered. The way to safety from the unknown. " +
                        "It somehow seems appealing, even though you haven't come across a single zombie down here. There is no sign of infection down here. This might be one of the safe areas in this hospital, " +
                        "but why does it still make you feel dread? ");
            } else {
                System.out.println("Good choice. ");
                player.setCurrentLocation(3);
            }
        }
    }

    public static void morgueBeastOptions() {
        System.out.println("[1] Get in for a closer look.");
        System.out.println("[2] You don't like this. Take a look around one more time and see if you can leave. ");
    }

    public static void morgueBeast(Player player) {
        morgueBeastOptions();
        userInput = Controller.pickOption(2);
        if (userInput == 1) {
            System.out.println("You lean in. ");
            if (player.getDexterity() >= 4) {
                System.out.println("There's a key inside the large shape. With your keen sight you see it says 'Parking Garage'.");
            } else {
                System.out.println("You see a cloaked figure. It looks too large to be human. ");
            }

        } else {
            System.out.println("You scan the room one more time, nothing of any real use is in the room. You try to leave, but your legs are frozen as you approach the door. You feel you need to inspect that figure in the shadows. ");
        }
        morgueBeastMore(player);

    }

    public static void morgueBeastMoreOptions() {
        System.out.println("[1] Reach for the shiny shape in the large figure and grab it. ");
        System.out.println("[2] Shoot the figure several times to be safe. ");
    }

    public static void morgueBeastMore(Player player) {
        morgueBeastMoreOptions();
        userInput = Controller.pickOption(2);
        while (true) {
            if (userInput == 1) {
                if (player.getDexterity()>=5){
                    System.out.println("You snag the key with no complication. You were worried for nothing. You head to the ground floor.");
                    player.setCurrentLocation(3);
                } else {
                    System.out.println("You grab the key, the figure begins shaking. You realize it wasn't just a shapeless figure, but a pile of bodies. All the bodies from the morgue stacked.");
                    System.out.println("In the center of the bodies, where the key was located is a large creature. With sunken eyes. That begins convulsing and devouring all the corpses around it.");
                }

            } else {
                if (player.loseAmmo()) {
                    System.out.println("You fire a bullet. There was a small growling but aside from that shooting the pile did a whole lot of nothing. ");
                } else {
                    System.out.println("You don't have any bullets left nerd. ");
                }
            }
        }
    }

    public static void morgueBossFightSkillCheck(Player player) {
        if (player.getDexterity() >= 3) {
            player.addKey("Gate Key");
            System.out.println("You quickly slide into a body locker. Hiding from the creature as it assembles itself off the floor. ");
            System.out.println("The beast struggles to its feet, a corpse hanging out of its mouth. It stands around 9 feet tall. It scans the room for you. Then staggers out of the room into the hallway.");
            System.out.println("You stealthily follow after it into the hall while clutching the exit key.");
        } else if (player.getStrength()>=3) {
            System.out.println("You throw two chairs and a surgical cabinet at the creature as it tries to stand. It instead stumbles backward.");
            System.out.println("This gives you an opportunity, key in hand you sprint for the red lit hallway.");
        }
        else if (player.getIntelligence()>=3) {
            System.out.println("You grab a surgical saw and cut deep into the monster's leg. It lets out a horrifying scream as you cut through the bone. It swipes at you as it struggles to stand on its stump.");
            System.out.println("You decide to sprint to the door while you have a small lead and the key in hand.");
        }}
    public static void morgueBossFight(Player player) {
        System.out.println("You fall backward as you plan your next move. Landing on a can of Monster Energy Drink TM. You chug the drink and feel rejuvenated.");
        System.out.println("You do this while the horrifying creature before you, lumbers forward.");
        morgueBossFightSkillCheck(player);
        player.setHealth(25);
        System.out.println("In the hall, the lumbering monster spots you and busts through the dark glass to your left. You're several dozen feet ahead of it already.");
        System.out.println("What do you do from here?");
        System.out.println("[1] Run for dear life, jumping over the gourneys and cabinets in your way.");
        System.out.println("[2] Run as you push gourneys and file cabinets over to block the creature's path.");
        System.out.println("[3] Make a flamethrower out of the parts in the hallway and leftover surgical tools and stave the creature off as you back towards the exit. ");
        userInput = Controller.pickOption(3);
        if (userInput == 1) {
            if (player.getDexterity()>=3) {
                System.out.println("You jump and dodge over different obstacles in your way as to avoid slowing down your pace.");
            } else {
                System.out.println("You aren't agile enough and the monster lunges at you, tearing a large piece of flesh off your back. ");
                player.getDamaged(15);
            }
        } else if(userInput == 2) {
            if (player.getStrength()>=3) {
                System.out.println("You run as fast as you can and turn over every cabinet you can as you run to the end of the hall. Slowing the monster as it has to climb around or move the obstacles.");
            } else {
                System.out.println("You try to move a cabinet over behind you and can't budge it, but the creature catches up and slashes.");
                player.getDamaged(15);
            }
        } else if (userInput == 3) {
            if (player.getIntelligence()>=4) {
                System.out.println("You ignite the creature ablaze using some sort of weird make-shift flamethrower, not even you fully understand how you made it.");
                System.out.println("You back up further down the hall and scared the beast until the fuel runs out. Now you're being chased by a flaming, angrier monster.");
            } else {
                System.out.println("You try to mash things together, but they don't work that way and you end up cutting your thumb.");
                System.out.println("That cut was nothing compared to the creature slashing your back as it catches you.");
                player.getDamaged(15);
            }
        }
    }
    public static void endOfMorgueBossOptions(Player player) {
        System.out.println("[1] Run as fast as you can to the exit and block the door."); // lose some more health as the creature narrowly slashes you as you close the door
        System.out.println("[2] Climb into a vent to escape the creature."); //dexterity 4+
        System.out.println("[3] You've seen avengers too many times to not try this. Tell the monster 'The sun is getting real low' as you hold out your hand."); //Intelligence 4+
        System.out.println("[4] Punch it on the snout just like you saw on Shark Week."); //strength 4+
       if (player.weaponCheck("pistol")) {
        System.out.println("[5] Shoot your gun at it. ");
       }
    }
    public static void endOfMorgueBoss(Player player) {
        endOfMorgueBossOptions(player);
        userInput = Controller.pickOption(5);
        if (userInput == 1) {
            System.out.println("You receive a gnarly slash as the creature strikes one more time as you slam the door in its face.");
            player.getDamaged(10);
        } else if (userInput == 2) {
            if (player.getDexterity() >= 4) {
                System.out.println("You leap into the vent and make it out safely while the monster shrieks a blood curdling screech and its claws flail in the vent.");
                player.setCurrentLocation(3);
            } else {
                System.out.println("You aren't fast enough. The creature snags your leg and slashes you.");
                player.getDamaged(15);
            }
        } else if (userInput == 3) {
            if (player.getIntelligence() >= 4) {
                System.out.println("You tell the creature the sun is getting real low, and it reaches out and touches your hand.");
                System.out.println("It calms its breathing and allows you onto its back and you ride it it up the stairs to the ground floor where it lets you off.");
                player.setCurrentLocation(3);
            } else {
                System.out.println("That was a terrible idea, what is actually wrong with you? It slashes your torso and immediately eats you.");
                player.getDamaged(15);
            }
        } else if (userInput == 4) {
            if (player.getStrength() >= 4) {
                System.out.println("You fist the creature as hard as you can and it scurries off whimpering.");
                System.out.println("You don't look back and walk to the exit like a badass.");
                player.setCurrentLocation(3);
            } else {
                System.out.println("That just made things worse. You get slashed. And crumble forward.");
                player.getDamaged(15);
            }
        } else {
            if (player.loseAmmo()) {
                System.out.println("You open fire on his laser cannons and hit the beast twice in the head. Staggering it long enough to escape.");
                player.setCurrentLocation(3);
            } else {
                System.out.println("You're out of ammo.");
                System.out.println("The creature wastes no time and closes the gap. Slashing you.");
                player.getDamaged(15);
            }

        }
    }
}
