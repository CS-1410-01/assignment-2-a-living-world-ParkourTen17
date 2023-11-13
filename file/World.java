package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.Math;

public class World {

    public World() {
        
    }

    public String createCreature() {

            Scanner in;
            try {
                in = new Scanner(new File("name.txt"));

                String tempString = in.next();
                String[] names = tempString.split(",");

                for (int i = 0; i < names.length; i++) {
                    names[i] = names[i].substring(1, names[i].length() - 1);
                }

                String creatureName = names[(int)(Math.random() * names.length)];
                return creatureName;
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return null;
            }


    

}

}