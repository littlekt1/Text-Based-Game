import java.util.Random;

public class Axe implements Weapon {

    private String name = "Fireman's Axe";


    public String getName() {
        return name;
    }

    @Override
    public void pickUpAmmo(int bullets) {}


    public int getDamage(int strength, int dexterity) {
        int accuracy;
        int damage;
        int critical = 10;
        int miss = 0;
        damage = strength * 2;
        accuracy = dexterity * 2;
        if (accuracy > 8) {
            damage = critical;
            System.out.println("Your axe connects with your foe. ");
        } else if (accuracy < 3) {
            Random rand = new Random();
            int num = rand.nextInt(2) +1;
            if (num == 1) {
                damage = miss;
                System.out.println("Your axe hits nothing but air. ");
            } else {
                System.out.println("You get a glancing hit on the zombie.");
            }
        } else {
            System.out.println("You graze your foe with the axe, slowing it down. ");
        }
        return damage;
    }
}