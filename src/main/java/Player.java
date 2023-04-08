
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {
    //Instance Variables
    private List<Item> inventory = new ArrayList<>();
    private String name;
    private int dexterity, strength, intelligence;
    private int currentLocation;
    private int poisonLevel = 0;
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

    //
    public void poisonPlayer(){
        poisonLevel = 1;
        System.out.println("You've been infected! Find the antidote before it's too late!");
    }

    public void curePoison(){
        poisonLevel = 0;
        System.out.println("Ah, much better!");
    }

    public boolean incrementPoison(){
        Random rand = new Random();
        int randomNum = rand.nextInt((10 - 1) + 1) + 1;
        if (randomNum > 7){
            poisonLevel++;
            poisonLevel++;
            return true;
        }
        if (randomNum > 3){
            poisonLevel++;
            return true;
        }
        return false;
    }


    public void handlePoison() {
        if (poisonLevel < 1) {
            return;
        }
        if (!incrementPoison()){
            return;
        }

        if (poisonLevel > 9) {
            System.out.println("The infection has completely taken over, green stuff is pouring out of your eyes, mouth and nose.");
            System.out.println("You are not long for this world... ");
            System.out.println("ugh");
            isAlive = false;
            Application.deadEnd();
        }
        if (poisonLevel > 8) {
            System.out.println("Green goo pours out of your wound.");
            System.out.println("find the antitode immediately or die.");

            if (intelligence >= 2) {
                System.out.println("Your judgement is affected.");
                intelligence--;
            }

        }
        if (poisonLevel > 7) {
            System.out.println("Your grievous wounds are beginning to catch up to you.");

            if (intelligence >= 2) {
                System.out.println("Your judgement is affected.");
                intelligence--;
            }
        }

        if (poisonLevel > 6) {
            System.out.println("You are running out of time...");

        }

        if (poisonLevel > 5) {
            System.out.println("The infection is getting serious...");
            System.out.println("You feel feverish and have a strange craving for White Castle hamburgers");
        }
        if (poisonLevel > 4){
            System.out.println("You feel..weirdly...hungry?  Odd.");
        }
        if (poisonLevel > 3){
            System.out.println("Your wound hurts a lot more than it should... something ain't right.");
        }
        if (poisonLevel > 2){
            System.out.println("Did something green just come out of your wound?  No, surely not.  Your eyes are playing tricks on you.");
            System.out.println("That must be it.");
        }
        if (poisonLevel >= 1){
            System.out.println("You feel a slight itching sensation coming from your wound...");
        }

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

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void printInventory() {
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println("[" + (i+1) + "] " + inventory.get(i).getItemName() + "\n" + "\n");
        }
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }
    //    player location & infection counter
}
