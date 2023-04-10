public class Axe implements Weapon {

    private String name = "Fireman's Axe";


    public String getName() {
        return name;
    }

    @Override
    public void pickUpAmmo(int bullets) {
        return;
    }

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
        }
        if (accuracy < 3) {
            damage = miss;
            System.out.println("Your axe hits nothing but air. ");
        } else {
            System.out.println("You graze your foe with the axe, slowing it down. ");
        }
        return damage;
    }
}