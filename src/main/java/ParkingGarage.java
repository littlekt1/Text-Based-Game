import java.util.Scanner;

public class ParkingGarage {
    public static Scanner scanner = new Scanner(System.in); // User input scanner
    public static int userInput;
    public static Zombie securityZombie = new Zombie(1);
    public static boolean alreadyInvestigatedGroaning = false;
    public static boolean alreadyRespondedToWalkie = false;
    public static boolean alreadyClimbedOnCar = false;
    public static boolean alreadySearchedTents = false;
    public static boolean alreadyFrontLeft = false;


    public static void initialParkingGarageOptions() { //first options user is presented outside first floor.
        System.out.println("[1] Go left towards a set of parked cars and what sounds like a low groaning from between the vehicles.");
        System.out.println("[2] Go right toward the heavily damaged police vehicle turned on its side.");
        System.out.println("[3] Run further through the parking lot to the back left-hand side toward a flickering flame-lit corner."); // HOBOS
        System.out.println("[4] Move towards the back right of the parking garage where more cars are sitting parked.");
        System.out.println("[5] Do a light jog towards the back side of the parking garage where an ambulance's lights are shining on a closed gate and a security booth.");
        System.out.println("[6] Turn back around and go to the ground floor.");
    }


    public static void runParkingGarage(Player player) {
        System.out.println("You enter the parking garage, a large, cluttered area. There is a cop car on it's side to your right, a security gate on the far end, and cars lining either side of the garage. ");
        System.out.println();
        while (player.getCurrentLocation() == 2) {
            initialParkingGarageOptions();
            userInput = Controller.pickOption(6);
            if (userInput == 1) {
                if (alreadyFrontLeft) {
                    System.out.println("You've already cleared this section.");
                } else {
                    frontLeftParkingGarage(player);
                }
            } else if (userInput == 2) {
                frontRightParkingGarage(player);
            } else if (userInput == 3) {
                backLeftParkingGarage(player);
            } else if (userInput == 4) {
                backRightParkingGarage(player);
            } else if (userInput == 5) {
                securityBooth(player);
            } else {
                player.setCurrentLocation(3);
            }
        }
    }

    public static void frontLeftParkingGarageOptions() {
        if (alreadyInvestigatedGroaning) { //if they have already checked to see what the groaning is this will be displayed.
            System.out.println("[1] Approach the groaning zombie.");
        } else {
            System.out.println("[1] See what that strange groaning is. ");
        }
        System.out.println("[2] Look in the car windows for anything of use. ");
        System.out.println("[3] Try to communicate with groaning noises of your own.");
        System.out.println("[4] Go back.");
    }

    public static void frontLeftParkingGarage(Player player) {
        System.out.println("You decided to go left towards a set of parked cars and hear a loud moaning grow louder. ");
        while (true) {
            frontLeftParkingGarageOptions();
            userInput = Controller.pickOption(4);
            if (userInput == 1) {
                alreadyInvestigatedGroaning = true;
                System.out.println("You investigate the source of that strange groaning, and discover it is " +
                        "coming from the front of the car nearest you. There is a zombie caught between the car and the wall." +
                        " What do you do? ");
                System.out.println("[1] Put it out of its misery by bashing its head in with a weapon?");
                System.out.println("[2} You leave it alone, it can't reach you while you search anyway.");
                System.out.println("[3] You search it for a set of car keys. ");
                userInput = Controller.pickOption(3);
                if (userInput == 1) {
                    System.out.println("You kill the stuck zombie using a nearby rock. No point in wasting a bullet.");
                    System.out.println("A key falls off the zombie and you pick it up. It appears to be for the car it was wedged in front of. ");
                    System.out.println("You use the key and find some bullets on the car seat. ");
                    player.pickUpAmmo(2);
                    alreadyFrontLeft = true;
                    return;
                } else if (userInput == 2) {
                    System.out.println("You leave the dumb ugly zombie alone and weigh your other options.");
                } else if (userInput == 3) {
                    System.out.println("You slowly approach the zombie with your tickle fingers out-stretched.");
                    if (player.getDexterity() < 3) {
                        System.out.println("You get bit searching the zombie.");
                        player.nonCombatDamaged(2);
                    } else {
                        System.out.println("You find a pair of car keys to the car the zombie is wedged in front of.");
                        System.out.println("It has three bullets lying on the seat.");
                        player.pickUpAmmo(3);
                        alreadyFrontLeft = true;
                        return;
                    }
                }
            } else if (userInput == 2) {
                System.out.println("You scan around the area, looking in car windows, the car that appears to be the source of the groaning has several bullets scattered across the " +
                        "front driver's seat. The doors are locked, maybe there is a key nearby.");
            } else if (userInput == 3) {
                System.out.println("You try to communicate with the loud groaning noise by growling back at it and asking if it is a zombie or an angry gopher?");
                System.out.println("The response is what you expected, more groaning. ");
            } else if (userInput == 4) {
                return;
            }
        }
    }

    public static void frontRightParkingGarageOptions() {
        System.out.println("[1] Explore the driver's seat of the tilted cop car (This involves climbing up on top of it).");
        System.out.println("[2] Check the back seat of the cop car.");
        System.out.println("[3] Search the ground around the cop car.");
        System.out.println("[4] Call out for any surviving police officers.");
        System.out.println("[5] Go Back.");
    }


    public static void frontRightParkingGarage(Player player) {
        System.out.println("You decide to approach the police vehicle that has been turned onto its side. ");
        while (true) {
            frontRightParkingGarageOptions();
            userInput = Controller.pickOption(5);
            if (userInput == 1) {
                if (alreadyClimbedOnCar) {
                    System.out.println("There's no reason to go back up there.");
                } else {
                    alreadyClimbedOnCar = true;
                    System.out.println("You attempt to climb up on the top of the car so you can look through the driver's side. ");
                    if (player.getStrength() < 3) {
                        System.out.println("You slip and fall because you aren't strong enough to pull yourself up. ");
                        player.nonCombatDamaged(1);
                    } else {
                        System.out.println("You successfully climb up on top and find a few bullets wedged into the seat of the driver's side.");
                        player.pickUpAmmo(3);
                    }
                }
            } else if (userInput == 2) {
                System.out.println("You find some handcuffs... with one end attached to a severed hand. Not really feeling like getting HIV you leave it be.");
            } else if (userInput == 3) {
                if (alreadyRespondedToWalkie) {
                    System.out.println("You feel bad for the cop on the walkie and leave it be. ");
                } else {
                    System.out.println("You decide to look around the wreck to see if anything fell out onto the ground. ");
                    System.out.println("There's a trail of blood leading further into the parking garage you can investigate once you leave this area.");
                    System.out.println("There's also a small walkie talkie lying in a puddle of blood with what sounds like a concerned police officer asking for an Officer Perkins to please respond.");
                    System.out.println("Do you: ");
                    System.out.println("[1] Pretend to be Perkins and find out what's going on. ");
                    System.out.println("[2] Leave it be and go back to the cop car. ");
                    userInput = Controller.pickOption(2);
                    if (userInput == 1) {
                        alreadyRespondedToWalkie = true;
                        System.out.println("You pick up the walkie and respond to the man on the line by saying 'this is Perkins, what's going on?'");
                        System.out.println("The cop on the line says 'Thank god Perkins, get out of there NOW, the whole place is overrun and there's only a few ways out. If you can get the parking gate open, take the ambulance out!'");
                    } else if (userInput == 2) {
                        return;
                    }
                }
            } else if (userInput == 4) {
                System.out.println("You call out for any survivors. You hear a faint static sound and a voice coming over what sounds like a walkie talkie.");
            } else if (userInput == 5) {
                return;
            }
        }
    }

    public static void backLeftParkingGarageOptions() {
        System.out.println("[1] Explore the fire pit for any survivors.");
        System.out.println("[2] Search the tents surrounding the fire pit for any survivors.");
        System.out.println("[3] Look through the sleeping bags that appear to be shaking vigorously.");
        System.out.println("[4] Click your car keys.");
        System.out.println("[5] Walk away slowly and go back towards the center of the parking garage.");
    }

    public static void backLeftParkingGarage(Player player) {
        System.out.println("You put your cardio to the test and jog to the back left of the parking garage where you come across several tents and a small barrel fire.");
        System.out.println("It seems to be a home to several unemployed members of society that were trapped here after the outbreak. There are several shaking sleeping bags on the ground that make " +
                "you hesitant. You wonder if there are any survivors left. ");
        while (true) {
            backLeftParkingGarageOptions();
            userInput = Controller.pickOption(5);
            if (userInput == 1) {
                System.out.println("You search around for any human remains or survivors for evidence of them being there. There is a half cooked can of beans next to the barrel of fire. There are" +
                        " a few severed fingers near it holding a spoon. You weigh your other options.");
            } else if (userInput == 2) {
                if (!alreadySearchedTents) {
                    System.out.println("You search the tents around the area and find a few loose bullets the homeless must've been planning to recycle. There are several cans scattered about as well" +
                            " but you dont have anywhere to recycle them.");
                    player.pickUpAmmo(2);
                    alreadySearchedTents = true;
                } else {
                    System.out.println("You've already searched the tents. Stop robbing the homeless. ");
                }
            } else if (userInput == 3) {
                Zombie hoboZombie = new Zombie(1);
                System.out.println("You make the regrettable decision of unzipping the sleeping bag and allow a hobo to emerge before deciding to not open any more.");
                System.out.println("You draw your weapon, and the hobo asks you for change before slowly crawling toward you, clearly infected.");
                Combat.combat(player, hoboZombie);
            } else if (userInput == 4) {
                System.out.println("You pat your thighs looking for a set of keys in your pants, but then you remember you definitely didn't drive here. ");
                System.out.println("Maybe there are keys to one of these vehicles nearby.");
            } else if (userInput == 5) {
                System.out.println("You decide you didn't like that episode of South Park called Night of the Living Homeless and go back to the center of the garage.");
                return;
            }
        }
    }

    public static void backRightParkingGarageOptions() {
        System.out.println("[1] Look around the cars parked here for any supplies.");
        System.out.println("[2] Follow the blood trail leading under a car.");
        System.out.println("[3] Investigate the puddle of water accumulating near the storm drain.");
        System.out.println("[4] Yell out to any potential survivors.");
        System.out.println("[5] Click your car keys.");
        System.out.println("[6] Turn back around and go to the center of the parking garage.");
    }

    public static void backRightParkingGarage(Player player) {
        System.out.println("You walk to the back right of the garage where more cars are parked up against the wall. There is a blood trail leading under one of the cars.");
        while (true) {
            backRightParkingGarageOptions();
            userInput = Controller.pickOption(6);
            if (userInput == 1) {
                System.out.println("You look around the cars and don't find anything besides a worn shirt and some old trash. Someone should fire the cleaner. ");
            } else if (userInput == 2) {
                if (securityZombie.isDead()) {
                    System.out.println("The zombie is dead already, no point in looking under the car again. ");

                } else {
                    System.out.println("You follow the blood trail under the car.");
                    System.out.println("When you bend over to look under the car, a hand reaches out and grabs you by the wrist. ");
                    System.out.println("It's a security guard zombie! You draw your weapon and shake it off you.");
                    Combat.combat(player, securityZombie);
                }
            } else if (userInput == 3) {
                System.out.println("You look at the flooded storm drain. It appears to be clogged up with a yellow rain coat.");
                System.out.println("What do you do? ");
                System.out.println("[1] Lift up the rain coat and look down the drain. ");
                System.out.println("[2] Leave it alone. ");
                userInput = Controller.pickOption(2);
                if (userInput == 1) {
                    System.out.println("You lift up the yellow coat. And look down as the water falls into the drain.");
                    System.out.println("You feel uncomfortable as you are positive you hear a very distant sound of circus music coming from the drain. ");
                    System.out.println("You decide to move on. ");
                } else if (userInput == 2) {
                    return;
                }
            } else if (userInput == 4) {
                System.out.println("You yell out to any potential survivors to see if you get a response.");
                System.out.println("You hear a low groaning from off in the distance and what sounds like someone asking for change. ");
            } else if (userInput == 5) {
                System.out.println("You didn't drive here. Why do you think you have car keys?");
            } else if (userInput == 6) {
                return;
            }
        }
    }

    public static void securityBoothOptions() {
        System.out.println("[1] Investigate the security booth. ");
        System.out.println("[2] Check out the ambulance parked right next to the security booth.");
        System.out.println("[3] Investigate the big gate blocking the ambulance.");
        System.out.println("[4] Head back out to the center of the garage.");
    }

    public static void securityBooth(Player player) {
        System.out.println("You approach the security gate at the back of the lot. Behind it is a large closed garage gate. There is an ambulance still running in front of the gate. ");
        while (true) {
            securityBoothOptions();
            userInput = Controller.pickOption(4);
            if (userInput == 1) {
                System.out.println("You walk into the security booth and immediately notice a big red button labeled 'gate button' and a trail of blood leading out of the entrance to the booth. ");
                System.out.println("There is a small keyhole next to the big red button. ");
                while(true){
                System.out.println("What do you do? ");
                System.out.println("[1] Press the button? ");
                System.out.println("[2] Look around the booth more in-depth. ");
                System.out.println("[3] Go back out to the security booth exterior. ");
                userInput = Controller.pickOption(3);
                if (userInput == 1) {
                    if (player.keyCheck("Gate Key")) {
                        System.out.println("You insert the key and push the big red button. The parking gate opens up as you climb into the ambulance and floor it. ");
                        //need to insert winning method if player has key
                    } else {
                        System.out.println("The button clicks, but nothing happens without the key. There has to be a key around here somewhere.");
                    }
                } else if (userInput == 2) {
                    System.out.println("You find a small note that says 'Carl I swear you better bring back that key, I'm not going in that basement to get it from you. That place gives me the " +
                            "heebie-jeebies.'");
                } else if (userInput == 3) {
                    break;
                }
                }
            } else if (userInput == 2) {
                System.out.println("You search the ambulance and find it still running, but it's pressed up against the parking garage gate, this could be your way out of here if you can get the gate open.");
            } else if (userInput == 3) {
                System.out.println("It's a large metal gate. Nothing is getting through here unless you find a semi truck in the hospital. Even then, this thing is THICK. ");
            } else if (userInput == 4) {
                return;
            }
        }
    }
}