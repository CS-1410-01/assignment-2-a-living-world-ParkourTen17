package file;

import java.util.Random;

public class Coral extends Creature{
    
    static Random rand = new Random(System.currentTimeMillis());

    //coral constructor, no speed, low death rate
    //also spawns randomly according to the size of the world
    public Coral() {
        type = "Coral";
        setName(Creature.createName());
        speed = 0;
        deathRate = .05;
        location[0] = rand.nextInt(World.sizeX);
        location[1] = rand.nextInt(World.sizeY);
    }

}
