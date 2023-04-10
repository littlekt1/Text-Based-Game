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
    public static void combat(Player player, Zombie zombie){
        System.out.println("The zombie approaches you.");
        while (player.isAlive() && !zombie.isDead()) {
            int damageZombie = player.attack();
            zombie.getDamaged(damageZombie);
            if (!zombie.isDead()) {
                int damagePlayer = zombie.attack();
                player.getDamaged(damagePlayer);
            }
        }


    }

}