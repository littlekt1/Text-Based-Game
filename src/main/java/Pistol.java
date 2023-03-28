public class Pistol extends Item{
    public Pistol(String itemName, boolean hasItem) {
        super(itemName, hasItem);
        this.setItemName("Pistol");
    }
    int ammo;
    public int pistolAttack(int dexterity) {
        int damage = 5;
        int critical = 10;
        int miss = 0;
        int accuracy=dexterity*2;
        if(accuracy<3){
            damage = miss;
        } if(accuracy>8) {
            damage = critical;
        } ammo--;
        return damage;
    }
}
