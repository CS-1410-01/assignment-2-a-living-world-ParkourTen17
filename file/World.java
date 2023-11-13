package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;


public class World {

    public World() {
        
    }

    public String createCreature() {
            Scanner in;
            try {
                Random random = new Random(System.currentTimeMillis());
                in = new Scanner(new File("name.txt"));

                String tempString = in.next();
                String[] names = tempString.split(",");

                for (int i = 0; i < names.length; i++) {
                    names[i] = names[i].substring(1, names[i].length() - 1);
                }

                String creatureName = names[random.nextInt(names.length)];
                return creatureName;
                //I should move this to the Creature constructor
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return null;
            }


    

}

}