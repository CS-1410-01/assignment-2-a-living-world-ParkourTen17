package file;

import java.util.Random;

public class SeaScorpion extends Creature{
    
    static Random rand = new Random(System.currentTimeMillis());

    public SeaScorpion() {
        type = "Sea Scorpion";
        setName(Creature.createName());
        speed = 2;
        deathRate = .2;
        location[0] = rand.nextInt(10);
        location[1] = rand.nextInt(10);

    }

}
