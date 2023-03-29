import java.util.ArrayList;
import java.util.List;

public class Player {
    //Instance Variables
    private List<Item> inventory = new ArrayList<>();
    private String name;
    private int dexterity, strength, intelligence;
    private int currentLocation;
    private boolean isAlive = true;

    public Player(String name) {
        this.name = name;
        this.dexterity = 1;
        this.strength = 1;
        this.intelligence = 1;
        this.currentLocation = 0;
        this.isAlive = true;


      //  this.inventory = getInventory();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(int currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void getInventory() {
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println("[" + (i+1) + "] " + inventory.get(i).getItemName() + "\n" + "\n");
        }
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public List<Item> getInventoryList() {
        return inventory;
    }

//    player location & infection counter
}
