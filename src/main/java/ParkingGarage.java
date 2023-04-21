import java.util.Scanner;

public class ParkingGarage {
    public static Scanner scanner = new Scanner(System.in); // User input scanner
    public static int userInput;
    public static boolean alreadyBackLeft = false;
    public static boolean alreadyBackRight = false;
    public static boolean alreadyFrontLeft = false;
    public static boolean alreadyFrontRight = false;
    public static boolean alreadySecurityBooth = false;
    public static Zombie securityZombie = new Zombie(1);
    public static Zombie hoboZombie = new Zombie(1);
    public static boolean alreadyInvestigatedGroaning = false;
    public static boolean alreadyRespondedToWalkie = false;
    public static boolean alreadyClimbedOnCar = false;


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
                frontLeftParkingGarage(player);
            }
            if (userInput == 2) {
                frontRightParkingGarage(player);
            }
            if (userInput == 3) {
                backLeftParkingGarage(player);
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
                    return;
                } else if (userInput == 2) {
                    System.out.println("You leave the dumb ugly zombie alone and weigh your other options.");
                } else if (userInput == 3) {
                    System.out.println("You slowly approach the zombie with your tickle fingers out-stretched.");
                    if (player.getDexterity() < 3) {
                        System.out.println("You get bit searching the zombie.");
                        player.getDamaged(2);
                    } else {
                        System.out.println("You find a pair of car keys to the car the zombie is wedged in front of.");
                        System.out.println("It has three bullets lying on the seat.");
                        player.pickUpAmmo(3);
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
        while(true) {
            frontRightParkingGarageOptions();
            userInput = Controller.pickOption(5);
            if (userInput== 1) {
                if(alreadyClimbedOnCar) {
                    System.out.println("There's nothing left of use in there.");
                } else {
                alreadyClimbedOnCar = true;
                System.out.println("You attempt to climb up on the top of the car so you can look through the driver's side. ");
                if (player.getStrength()< 3){
                    System.out.println("You slip and fall because you aren't strong enough to pull yourself up. ");
                    player.getDamaged(1);
                } else {
                    System.out.println("You successfully climb up on top and find a few bullets wedged into the seat of the driver's side.");
                    player.pickUpAmmo(3);
                } }
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
                if (userInput == 1){
                    alreadyRespondedToWalkie = true;
                    System.out.println("You pick up the walkie and respond to the man on the line by saying 'this is Perkins, what's going on?'");
                    System.out.println("The cop on the line says 'Thank god Perkins, get out of there NOW, the whole place is overrun and there's only a few ways out. If you can get the parking gate open, take the ambulance out!'");
                } else if (userInput == 2) {
                    return;
                }}
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

    public static void backLeftParkingGarage(Player player){
        System.out.println();
    }


    public static void backRightParkingGarageOptions(Player player) {
        System.out.println("[1] Look around the cars parked here for any supplies.");
        System.out.println("[2] Follow the blood trail leading directly to a body leaned up against the center car.");
        System.out.println("[3] Investigate the puddle of water accumulating near the storm drain.");
        System.out.println("[4] Yell out to any potential survivors.");
        System.out.println("[5] Click your car keys.");
        System.out.println("[6] Turn back around.");

    }

    public static void securityBoothOptions(Player player) {
        System.out.println("[1] Investigate the big red exit button with a keyhole next to it.");
        System.out.println("[2] Check out the ambulance parked right outside.");
        System.out.println("[3] Investigate the big gate blocking the ambulance.");
        System.out.println("[4] Check out the second door on the left.");
    }
}