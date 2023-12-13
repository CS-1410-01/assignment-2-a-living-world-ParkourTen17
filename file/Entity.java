package file;

import java.util.Random;

public class Entity {
    
    //attributes for all entities, including creatures and food
    static Random rand = new Random(System.currentTimeMillis());
    protected int[] location = new int[2];
    protected double deathRate;

    //getters and setters
    public int getX() {
        return location[0];
    }
    public int getY() {
        return location[1];
    }

    public void setLocation(int[] in){
        location = in;
    }

    public int[] getLocation() {
        return location;
    }

    //if a randomly generated double is less than a creature or a food's death rate, it dies
    public boolean die() {
        if (deathRate > rand.nextDouble()) {
            return true;
        } else {
            return false;
        }
    }

}
