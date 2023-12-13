package file;

import java.util.Random;

public class SeaScorpion extends Creature{
    
    static Random rand = new Random(System.currentTimeMillis());

    //sea scorpion constructor, medium speed, medium death rate
    //also spawns randomly according to the size of the world
    public SeaScorpion() {
        type = "Sea Scorpion";
        setName(Creature.createName());
        speed = 2;
        deathRate = .1;
        location[0] = rand.nextInt(World.sizeX);
        location[1] = rand.nextInt(World.sizeY);

    }

}
