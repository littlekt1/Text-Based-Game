public class Axe implements Weapon {

    private String name = "Fireman's Axe";


    public String getName(){
        return name;
    }
    public int attack(Player player){
        int accuracy;
        int damage;
        int critical = 10;
        int miss = 0;
        damage = player.getStrength() * 2;
        accuracy = player.getDexterity() * 2;
        if (accuracy>8) {
            damage = critical;
        } if (accuracy<3) {
            damage = miss;
        } return damage;
    }
}
