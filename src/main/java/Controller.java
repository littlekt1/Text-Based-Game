import java.util.Scanner;

public class Controller {
    private static Scanner scanner = new Scanner(System.in);

    //    method that takes in a int which reps a floor, then is a big case switch.
//    if num = 1, calls static method on floor 1 from the floor class
//    So it checks the player's location and then runs the floor that is associated with that floor
//    from a list of floors.
    public static int pickOption(int options) {
        while (true) {
            String userInput = scanner.nextLine();
            int choice = 0;
            try {
                choice = Integer.parseInt(userInput);
                if (choice > 0 && choice <= options) {
                    return choice;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Please input a number between 1 and " + options);
            }
        }
    }

    public static int pickOption2(int options, Player player) {
        player.handlePoison();
        int choice = 0;
        while (true) {
            String userInput = scanner.nextLine();

            try {
                choice = Integer.parseInt(userInput);
                if (choice > 0 && choice <= options) {
                    return choice;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Please input a number between 1 and " + options);
            }

        }
    }


    public static void move(Player player) {
        switch (player.getCurrentLocation()) {
            case 0:
                Opening.runOpening(player);
            case 5:
                FifthFloor.runFifthFloor(player);
        }
    }

}