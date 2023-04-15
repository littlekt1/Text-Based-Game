import java.util.Scanner;

public class OpeningTest {
    public static void firstOptions() {
        System.out.println("[1] Go to the door. ");
        System.out.println("[2] Go to the window. ");
        System.out.println("[3] Explore the room. ");
        System.out.println("[4] Hide under the bed. ");
    }

    public static void main(String[] args) {
        Player player = new Player("Quang");
        player.setDexterity(3);
        Zombie zombie = new Zombie(5);
        player.addWeapon("pistol", new Pistol());
        player.addWeapon("axe", new Axe());
        Combat.combat(player, zombie);
    }
}