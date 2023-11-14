package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Bug implements Creature {

    Random rand = new Random(System.currentTimeMillis());

    String name;

    public Bug() {
            Scanner in;
            try {
                Random random = new Random(System.currentTimeMillis());
                in = new Scanner(new File("name.txt"));

                String tempString = in.next();
                String[] names = tempString.split(",");

                for (int i = 0; i < names.length; i++) {
                    names[i] = names[i].substring(1, names[i].length() - 1);
                }

                name = names[random.nextInt(names.length)];
                
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
    }

    @Override
    public boolean reproduce() {
        double productivity = .45;
        if (productivity > rand.nextDouble()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean die() {
        double frailty = .55;
        if (frailty > rand.nextDouble()) {
            return true;
        } else {
            return false;
        }
    }
    
}
