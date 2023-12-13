package file;

import java.util.Random;

public class Food extends Entity{
    
    static Random rand = new Random(System.currentTimeMillis());

    //food constructor, pretty small chance of it decaying and disappearing
    //also spawns randomly according to the size of the world
    public Food() {
        deathRate = .05;
        location[0] = rand.nextInt(World.sizeX);
        location[1] = rand.nextInt(World.sizeY);
    }

}
