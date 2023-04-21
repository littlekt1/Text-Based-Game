import java.util.Random;

public class Fist implements Weapon {

    private String name = "Your Fist";

    @Override
    public int getDamage(int strength, int dexterity) {
        int accuracy;
        int damage;
        int critical = 10;
        int miss = 0;
        damage = strength;
        accuracy = dexterity * 2;
        if (accuracy > 8) {
            damage = critical;
            System.out.println("You hit the zombie with a roundhouse kick. ");
        } else if (accuracy < 3) {
            Random rand = new Random();
            int num = rand.nextInt(2) + 1;
            if (num == 1) {
                damage = miss;
                System.out.println("Your fist hits nothing but air. ");
            } else {
                System.out.println("You punch the zombie. ");
            }
        } else {
            System.out.println("You punch the zombie. ");
        }
        return damage;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void pickUpAmmo(int bullets) {}

}
