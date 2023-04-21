public class FloorTest {
    public static void main(String[] args) {
        Player player = new Player("Quangomania");
        player.setStrength(23);
        player.setDexterity(3);
        player.setIntelligence(10);
        player.setCurrentLocation(2);
        player.addWeapon("pistol", new Pistol());
        ParkingGarage.runParkingGarage(player);
    }
}
