package file;

import java.util.Random;

public class Coral extends Creature{
    
    static Random rand = new Random(System.currentTimeMillis());



    public Coral() {
        type = "Coral";
        setName(Creature.createName());
        speed = 0;
        deathRate = .05;
        location[0] = rand.nextInt(10);
        location[1] = rand.nextInt(10);
    }

}
