package file;

import java.util.Random;

public class Ammonite extends Creature{
    
    static Random rand = new Random(System.currentTimeMillis());

    public Ammonite() {
        type = "Ammonite";
        setName(Creature.createName());
        speed = 3;
        deathRate = .3;
        location[0] = rand.nextInt(10);
        location[1] = rand.nextInt(10);
    }
    

}
