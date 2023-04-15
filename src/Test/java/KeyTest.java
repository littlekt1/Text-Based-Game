import org.junit.Assert;
import org.junit.Test;

public class KeyTest {
    Player player = new Player("lilkev");

    @Test
    public void keyTest() {
        player.addKey("kevin's_special_key");
        Assert.assertEquals("Kevin's Special Key", player.getKeys().get(0));
    }
}
