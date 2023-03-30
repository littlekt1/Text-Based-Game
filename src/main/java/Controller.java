public class Controller {
//    method that takes in a int which reps a floor, then is a big case switch.
//    if num = 1, calls static method on floor 1 from the floor class
//    So it checks the player's location and then runs the floor that is associated with that floor
//    from a list of floors.

    public static void move(Player player){
        switch (player.getCurrentLocation()){
            case 0 :
                Opening.runOpening(player);
            case 5 :
                FifthFloor.runFifthFloor(player);
        }
    }





}
