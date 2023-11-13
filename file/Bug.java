package file;

import java.util.Random;

public class Bug implements Creature {

    Random rand = new Random(System.currentTimeMillis());

    @Override
    public boolean reproduce() {
        double productivity = .7;
        if (productivity > rand.nextDouble()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean die() {
        double resilience = .1;
        if (resilience > rand.nextDouble()) {
            return true;
        } else {
            return false;
        }
    }
    
}
