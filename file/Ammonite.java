package file;

import java.util.Random;

public class Ammonite extends Creature{
    
    static Random rand = new Random(System.currentTimeMillis());

    //ammonite constructor, high speed, medium death rate
    //also spawns randomly according to the size of the world
    public Ammonite() {
        type = "Ammonite";
        setName(Creature.createName());
        speed = 3;
        deathRate = .1;
        location[0] = rand.nextInt(World.sizeX);
        location[1] = rand.nextInt(World.sizeY);
    }
    

}
