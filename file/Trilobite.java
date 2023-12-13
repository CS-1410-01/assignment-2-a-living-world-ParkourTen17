package file;

import java.util.Random;

public class Trilobite extends Creature {
    
    static Random rand = new Random(System.currentTimeMillis());

    //trilobite constructor, low speed, low death rate
    //also spawns randomly according to the size of the world
    public Trilobite() {
        type = "Trilobite";
        setName(Creature.createName());
        speed = 1;
        deathRate = .05;
        location[0] = rand.nextInt(World.sizeX);
        location[1] = rand.nextInt(World.sizeY);
    }


}
