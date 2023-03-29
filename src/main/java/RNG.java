//import java.util.Random;
//
//public class RNG {
//    public static void main(String[] args) {
//        Random rand = new Random();
//
//        // Generate a random number between 1 and 10
//        int encounterType = rand.nextInt(10) + 1;
//
//        // Print the type of encounter based on the random number generated
//        switch (encounterType) {
//            case 1:
//                System.out.println("You encounter a group of roaming zombies!");
//                int zombieCount = rand.nextInt(5) + 1;
//                System.out.println("There are " + zombieCount + " zombies.");
//                break;
//            case 2:
//                System.out.println("You find a hidden storage container!");
//                int ammoCount = rand.nextInt(100) + 1;
//                System.out.println("It contains " + ammoCount + " pistol rounds.");
//                break;
//            case 3:
//                System.out.println("You stumble upon a cracked open closet.");
//                int itemType = rand.nextInt(3) + 1;
//                switch (itemType) {
//                    case 1:
//                        System.out.println("It's a vest!");
//                        break;
//                    case 2:
//                        System.out.println("It's five rounds for your pistol!");
//                        break;
//                    case 3:
//                        System.out.println("It's a zombie!");
//                        break;
//                }
//                break;
//            default:
//                System.out.println("You move on.");
//                break;
//        }
//    }
//}


//import java.util.Random;
//import java.util.Scanner;
//
//public class RNG {
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        Random random = new Random(); // Setting new random object to randomly select a response when asked.
//
//        String[] responses = {"Zombie appears, ammo found, vest found"}; // Array of all potential responses for the game
//
//        while (true) { // while loop to ask user to input which choice they want and print out random event
//            System.out.println("Input a number"); // What the program prints for the player
//            Integer playerChoice = 1;
//
//            if (playerChoice.equals(1)) {
//                System.out.println(random);
//            }
//
//            int index = random.nextInt(responses.length); //spans length of the responses provided
//            String answer = responses[index];
//            System.out.println(answer);
//        }
//    }
//}
//
//import java.util.Random;
//
//public class RNG {
//    public static void main(String[] args) {
//        // create a Random object
//        Random random = new Random();
//
//        // generate a random integer between 0 and 50
//        int randomNumber = random.nextInt(50);
//
//        // print the random number
//        System.out.println("Random number: " + randomNumber);
//    }
//}
//
////Do we want the RNG to just print off a number? Or the actual event? I don't think my simple brain knows how to transfer a user input as a string event.