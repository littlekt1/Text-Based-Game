import java.util.Random;
import java.util.Scanner;

public class Combat {
    Scanner scanner = new Scanner(System.in);

    public void runCombat(Player player, Zombie zombie){
        Random random = new Random(); //creates a "random" object, similar to scanner
        int roll = random.nextInt(11); //creates a random int between 0 and 10

        if (zombie.getSpeed() == 1){ //check zombie speed to determine how many shots the player gets
                                    //before being bitten
            System.out.print("A zombie is crawling towards you, ");
            if (roll <=3){
                System.out.println("dragging its legless corpse in your direction.");
            }//random flavor text for each encounter
            else if (roll <= 7){
                System.out.println("groaning as it leaves a trail of blood in its wake.");
            }
            else{
                System.out.println("snarling and snapping its jaws at you.");
            }

        }
        if (zombie.getSpeed() == 2){

        }

        if (zombie.getSpeed() ==3){

        }


    }
    public void firstTurn(Player player, Zombie zombie, Pistol pistol){
        System.out.println("[1] Shoot the zombie\n[2] Attack the zombie with an axe");
        int userInput = scanner.nextInt();
        if(userInput == 1) {
            if (player.getWeapons().containsKey("pistol")) {
                if (pistol.getAmmo() > 0) {
                    pistol.attack(player);
                } else {
                    System.out.println("You pull the trigger, but all you hear is a heart-sinking click" +
                            "as you realize that you're out of ammo. The zombie continues to approach.");
                }
            } else {
                System.out.println("You don't have a pistol.");
            }
        }
        else if (userInput == 2){
            if (player.getWeapons().containsKey("axe")){
                KeyItems.axe.attack(player);
            }
            else {
                System.out.println("You don't have an axe.");
            }
        }
    }

}
