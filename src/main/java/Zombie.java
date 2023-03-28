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

}
