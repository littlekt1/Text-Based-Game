import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Combat {
    Scanner scanner = new Scanner(System.in);

    public void runCombat(Player player, Zombie zombie) {
        Random random = new Random(); //creates a "random" object, similar to scanner
        int roll = random.nextInt(11); //creates a random int between 0 and 10

        if (zombie.getSpeed() == 1) { //check zombie speed to determine how many shots the player gets
            //before being bitten
            System.out.print("A zombie is crawling towards you, ");
            if (roll <= 3) {
                System.out.println("dragging its legless corpse in your direction.");
            }//random flavor text for each encounter
            else if (roll <= 7) {
                System.out.println("groaning as it leaves a trail of blood in its wake.");
            } else {
                System.out.println("snarling and snapping its jaws at you.");
            }

        }
        if (zombie.getSpeed() == 2) {

        }

        if (zombie.getSpeed() == 3) {

        }


    }

    public static void combat(Player player, Zombie zombie) {
        System.out.println("The zombie approaches you.");
        while (player.isAlive() && !zombie.isDead()) {
            int damageZombie = (int) player.attack().get(1);
            zombie.getDamaged(damageZombie);
            if (!zombie.isDead()) {
                int damagePlayer = zombie.attack();
                player.getDamaged(damagePlayer);
            }
        }
        if (!player.isAlive()) {
            Application.deadEnd();
        }

    }

    public static void multipleCombat(Player player, List<Zombie> zombies) {
        System.out.println(zombies.size() + " zombies approach you.");
        while (player.isAlive() && zombies.size() > 0) {
            List<Object> list = player.attack();
            int damageZombie = (int) list.get(1);
            if (damageZombie >= 5 && zombies.size() >= 2) {
                if (list.get(0).toString().equals("pistol")) {
                    System.out.println("Your bullet blasts through to another zombie, damaging them both at once.");
                } else if (list.get(0).toString().equals("axe")) {
                    System.out.println("Your axe swing keeps going and slashes another zombie.");
                }
                zombies.get(0).setHealth(zombies.get(0).getHealth() - damageZombie);
                zombies.get(1).setHealth(zombies.get(1).getHealth() - damageZombie + 1);
                if (zombies.get(0).isDead()) {
                    zombies.remove(0);
                    if (zombies.get(0).isDead()) {
                        zombies.remove(0);
                        System.out.println("You kill 2 zombies.");
                    } else {
                        System.out.println("You kill 1 zombie.");
                    }
                } else if (zombies.get(1).isDead()) {
                    zombies.remove(1);
                    System.out.println("You kill 1 zombie.");
                }
                if (zombies.size() == 1) {
                    System.out.println("There's only 1 zombie left.");
                }
            } else {
                zombies.get(0).getDamaged(damageZombie);
                if (zombies.get(0).isDead()) {
                    zombies.remove(0);
                }
            }
            int damagePlayer = 0;
            if (zombies.size() > 1) {
                int randomNum = (int)(Math.random() * 10) + 1;
                if (randomNum >= 9) {
                    System.out.println("The horde of zombies launch a series of attacks on you.");
                    damagePlayer = 8;
                } else if (randomNum >= 2) {
                    System.out.println("You dodge the zombies' attack but one of them manages to hit you.");
                    damagePlayer = 5;
                } else {
                    System.out.println("You narrowly escape the zombies' attacks.");
                }
            } else if (zombies.size() == 1) {
                damagePlayer = zombies.get(0).attack();
            }
            player.getDamaged(damagePlayer);
        }
        if (!player.isAlive()) {
            Application.deadEnd();
        }
    }
}
