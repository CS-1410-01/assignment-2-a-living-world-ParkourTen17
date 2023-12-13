package file;

import java.util.Random;

public class Trilobite extends Creature {
    
    static Random rand = new Random(System.currentTimeMillis());

    public Trilobite() {
        type = "Trilobite";
        setName(Creature.createName());
        speed = 1;
        deathRate = .1;
        location[0] = rand.nextInt(10);
        location[1] = rand.nextInt(10);
    }


}
