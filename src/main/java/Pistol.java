import java.util.Random;

public class Pistol implements Weapon {

    private String name = "Glock 9";
    private int ammo = 1;


    public String getName() {
        return name;
    }

    public int getAmmo() {
        return ammo;
    }

    public void pickUpAmmo(int bullets) {
        ammo += bullets;
        name = "Glock 9";
    }

    @Override
    public boolean loseAmmo() {
        if (ammo >= 1) {
            ammo--;
            if (ammo == 0) {
                name = "Glock 9 (out of ammo).";
            }
            return true;
        }
        return false;
    }


    public int getDamage(int strength, int dexterity) {
        if (ammo <= 0) {
            System.out.println("You pull the trigger, but all you hear is a heart-sinking click " +
                    "as you realize that you're out of ammo. ");
            return 0;
        }
        int damage = 5;
        int critical = 10;
        int miss = 0;
        int accuracy = dexterity * 2;
        if (accuracy < 3) {
            Random rand = new Random();
            int num = rand.nextInt(2) +1;
            if (num == 1) {
                damage = miss;
                System.out.println("You graze your foe. ");
            } else {
                System.out.println("You hit the zombie with your bullet. ");
            }
        } else if (accuracy > 8) {
            damage = critical;
            System.out.println("Nice shot.");
        } else {
            System.out.println("You hit the zombie with your bullet. ");
        }
        ammo--;
        if (ammo <= 0) {
            name = "Glock 9 (out of ammo).";
        }
        return damage;
    }

}