package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Creature {

    static Random rand = new Random(System.currentTimeMillis());

    private String name;

    public static String createName() {
                    Scanner in;
            try {

                in = new Scanner(new File("name.txt"));

                String tempString = in.next();
                String[] names = tempString.split(",");

                for (int i = 0; i < names.length; i++) {
                    names[i] = names[i].substring(1, names[i].length() - 1);
                }

                return names[rand.nextInt(names.length)];
                
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return null;
            }
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public boolean reproduce(double productivity) {
        
        if (productivity > rand.nextDouble()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean die(double frailty) {
        if (frailty > rand.nextDouble()) {
            return true;
        } else {
            return false;
        }
    }

    


}