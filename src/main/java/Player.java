import java.util.*;

public class Player {
    //Instance Variables
    private List<String> keys = new ArrayList<>();
    private Map<String, Weapon> weapons = new HashMap<>();
    private String name;
    private int dexterity, strength, intelligence;
    private int currentLocation;
    private int poisonLevel = 0;
    private int health = 25;
    private boolean poisonPaused = false;
    private boolean isAlive = true;
    private boolean hasVest;

    public Player(String name) {
        this.name = name;
        this.dexterity = 1;
        this.strength = 1;
        this.intelligence = 1;
        this.currentLocation = 0;
        weapons.put("fist", new Fist());
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void poisonPlayer() {
        poisonLevel = 1;
        System.out.println("You've been infected! Find the antidote before it's too late!");
    }

    public void pausePoison() {
        poisonPaused = true;
    }

    public void unpausePoison() {
        poisonPaused = false;
    }

    public void curePoison() {
        poisonLevel = 0;
        System.out.println("Ah, much better!");
    }

    public boolean incrementPoison() {
        if (poisonPaused) {
            return false;
        }

        Random rand = new Random();
        int randomNum = rand.nextInt((10 - 1) + 1) + 1;
        if (randomNum > 7) {
            poisonLevel++;
            poisonLevel++;
            return true;
        }
        if (randomNum > 3) {
            poisonLevel++;
            return true;
        }
        return false;
    }


    public void handlePoison() {
        if (poisonLevel < 1) {
            return;
        }
        if (!incrementPoison()) {
            return;
        } else if (poisonLevel > 9) {
            System.out.println("The infection has completely taken over, green stuff is pouring out of your eyes, mouth and nose.");
            System.out.println("You are not long for this world... ");
            System.out.println("ugh");
            isAlive = false;
            Application.deadEnd();
        } else if (poisonLevel > 8) {
            System.out.println("Green goo pours out of your wound.");
            System.out.println("find the antidote immediately or die.");

            if (intelligence >= 2) {
                System.out.println("Your judgement is affected.");
                intelligence--;
                strength++;
            }

        } else if (poisonLevel > 7) {
            System.out.println("Your grievous wounds are beginning to catch up to you.");

            if (intelligence >= 2) {
                System.out.println("Your judgement is affected.");
                intelligence--;
                strength++;
            }
        } else if (poisonLevel > 6) {
            System.out.println("You are running out of time...");
        } else if (poisonLevel > 5) {
            System.out.println("The infection is getting serious...");
            System.out.println("You feel feverish and have a strange craving for White Castle hamburgers");
        } else if (poisonLevel > 4) {
            System.out.println("You feel..weirdly...hungry?  Odd.");
        } else if (poisonLevel > 3) {
            System.out.println("Your wound hurts a lot more than it should... something ain't right.");
        } else if (poisonLevel > 2) {
            System.out.println("Did something green just come out of your wound?  No, surely not.  Your eyes are playing tricks on you.");
            System.out.println("That must be it.");
        } else if (poisonLevel >= 1) {
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

    public void addWeapon(String name, Weapon weapon) {
        weapons.put(name, weapon);
    }

    public void printWeapons() {
        for (String key : weapons.keySet()) {
            System.out.println(weapons.get(key).getName());
        }
    }

    public void addKey(String keyName) {
        keys.add(keyName);
    }

    public List<String> getKeys() {
        List<String> tempKeys = new ArrayList<>();
        for (int i = 0; i < keys.size(); i++) {
            String [] formattedName = keys.get(i).split("_");
            for (int j = 0; j < formattedName.length; j++) {
                formattedName[j] = formattedName[j].substring(0,1).toUpperCase() + formattedName[j].substring(1).toLowerCase();
            }

            tempKeys.add(String.join(" ", formattedName));

        }
        System.out.println(tempKeys);
        return tempKeys;
    }

    public Map<String, Weapon> getWeapons() {
        return weapons;
    }

    public boolean weaponCheck(String weapon) {
        return weapons.containsKey(weapon);
    }

    public boolean keyCheck(String keyName){
        return keys.contains(keyName);
    }

    public void findVest(){
        //we could put a sout here explaining the vest...
        hasVest = true;
    }

    public void useVest(){
        System.out.println("Luckily you had a vest so you did not get infected but it's no longer usable.");
        hasVest = false;
    }

    public boolean hasVest(){
        return hasVest;
    }



    public void pickUpAmmo(int bullets) {
        if (weaponCheck("pistol")) {
            weapons.get("pistol").pickUpAmmo(bullets);
        } else {
            System.out.println("You have no use for this right now. ");
        }
    }
    public boolean loseAmmo() {
        return weaponCheck("pistol") && weapons.get("pistol").loseAmmo();
    }

    public List<Object> attack() {
        handlePoison();
        System.out.println();
        System.out.println("You have the following weapons available. Which would you like to attack with?");
        int counter = 1;
        String[] weaponsArray = new String[weapons.size()];
        for (String key : weapons.keySet()) {
            weaponsArray[counter - 1] = key;
            System.out.printf("[%d] %s\n", counter, weapons.get(key).getName());
            counter++;
        }
        int userInput = 0;
        userInput = Controller.pickOption(weapons.size());
        Weapon weaponInUse = weapons.get(weaponsArray[userInput - 1]);
        return Arrays.asList(weaponsArray[userInput - 1], weaponInUse.getDamage(strength, dexterity));
    }

    public void getDamaged(int damage) {
        health -= damage;
        Random rand = new Random();
        int randomNum = rand.nextInt(10) + 1;

        if (randomNum >= 9 && poisonLevel <= 0 && damage > 0) {
            if (hasVest()) {
                useVest();
                return;
            }
            poisonPlayer();
        }
    }
    public void resetPlayer() {
        weapons.clear();
        weapons.put("fist", new Fist());
        keys.clear();
        poisonLevel = 0;
        health = 25;
        currentLocation = 0;
    }
    public void nonCombatDamaged(int damage) {
        health -= damage;
        if (health<1) {
            System.out.println("YOU HAVE DIED.");
            Application.deadEnd();
            return;
        }
        System.out.println("Ouch, I took damage. ");
        System.out.println("You are at " + health + " HP");
    }

}