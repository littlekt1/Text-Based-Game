public class Axe extends Item {
    public Axe(String itemName, boolean hasItem) {
        super(itemName, hasItem);
        this.setItemName("Axe");
    }
    public int axeAttack(int strength, int dexterity){
        int accuracy;
        int damage;
        int critical = 10;
        int miss = 0;
        damage = strength * 2;
        accuracy = dexterity * 2;
        if (accuracy>8) {
            damage = critical;
        } if (accuracy<3) {
            damage = miss;
        } return damage;
    }
}
