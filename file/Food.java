package file;

import java.util.Random;

public class Food {
    
    static Random rand = new Random(System.currentTimeMillis());

    private int[] location = new int[2];
    
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

    private double deathRate;

    public boolean die() {
        if (deathRate > rand.nextDouble()) {
            return true;
        } else {
            return false;
        }
    }

    public Food() {
        deathRate = .05;
        location[0] = rand.nextInt(10);
        location[1] = rand.nextInt(10);
    }

}
