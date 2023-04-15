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
            damage = miss;
            System.out.println("You graze your foe. ");
        }
        if (accuracy > 8) {
            damage = critical;
            System.out.println("Nice shot.");
        }
        ammo--;
        if (ammo <= 0) {
            name = "Glock 9 (out of ammo).";
        }
        return damage;
    }

}