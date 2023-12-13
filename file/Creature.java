package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Creature{

    static Random rand = new Random(System.currentTimeMillis());

    private String name;
    protected int[] location = new int[2];
    protected int speed;
    protected double deathRate;
    protected String type;

    public void move(int a) {
        boolean x = rand.nextBoolean();
        boolean y = rand.nextBoolean();

            if (x == true) {
                location[0] += a;
                if (location[0] > 9) {
                    location[0] -= a;
                }
            } else {
                location[0] -= a;
                if (location[0] < 0) {
                    location[0] += a;
                }   
            }
            if (y == true) {
                location [1] += a;
                if (location[1] > 9) {
                    location[1] -= a;
                }
            } else {
                location[1] -= a;
                if (location[1] < 0) {
                    location[1] += a;
                }
            }
    }

    public boolean die() {
        if (deathRate > rand.nextDouble()) {
            return true;
        } else {
            return false;
        }
    }
    
    public void reproduce(int[] l) {
        location[0] = l[0];
        location[1] = l[1];
    }


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

    public int getX() {
        return location[0];
    }
    public int getY() {
        return location[1];
    }

    public void setLocation(int[] in){
        location = in;
    }
    public int[] getLocation() {
        return location;
    }

}