public class Pistol implements Weapon, Item{

    private String name = "Glock 9";
    private int ammo = 1;


    public String getName(){
        return name;
    }

    public int getAmmo(){
        return ammo;
    }

    public void pickUpAmmo(int bullets){
        ammo += bullets;
    }

    public int attack(Player player) {
        int damage = 5;
        int critical = 10;
        int miss = 0;
        int accuracy= player.getDexterity() * 2;
        if(accuracy<3){
            damage = miss;
        } if(accuracy>8) {
            damage = critical;
        } ammo--;
        return damage;
    }

}
