public interface Weapon {

    int getDamage(int strength, int dexterity);
    String getName();
    void pickUpAmmo(int bullets);
    boolean loseAmmo();

}