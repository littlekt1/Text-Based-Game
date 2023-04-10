import java.util.Random;

public class Zombie {
    //instance variables
    private boolean isDead;
    private int health;
    private int speed;

    //constructor

    public Zombie(int speed) {
        this.isDead = false;
        this.health = 10;
        this.speed = speed;
    }

    //getter setters
    public boolean isDead() {
        return isDead;
    }

    public void setDead() {
        isDead = true;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health=health;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void zombieStatus() {
        if (health >= 9) {
            System.out.println("The zombie approaches you menacingly. ");
        } else if (health >= 4) {
            System.out.println("The zombie seems to be at half health. ");
        } else if (health >= 1) {
            System.out.println("The zombie seems weak. You can probably finish it with a bullet or a swing of an axe. ");
        }
    }
    public void getDamaged (int damage) {
        health -= damage;
        zombieStatus();
        if (health <= 0) {
            isDead = true;
            System.out.println("You kill the zombie. ");
        }
    }
    public int attack() {
        Random rand = new Random();
        int randomNum = rand.nextInt((10 - 1) + 1) + 1;
        if (randomNum >= 9) {
            System.out.println("The zombie chomps down on you. ");
            return 5;
        } else if (randomNum >= 3) {
            System.out.println("The zombie scratches you. ");
            return 3;
        } else {
            System.out.println("The zombie misses. You are unharmed. ");
            return 0;
        }
    }

}