public class SixthFloorTest {
    public static void main(String[] args) {
        Player player = new Player("Kevin");
        player.setStrength(3);
        player.setDexterity(4);
        player.setIntelligence(3);
        player.addWeapon("pistol", new Pistol());
        player.addWeapon("axe", new Axe());
        player.pickUpAmmo(10);
        player.setCurrentLocation(6);
        SixthFloor.runSixthFloor(player);

    }

}
