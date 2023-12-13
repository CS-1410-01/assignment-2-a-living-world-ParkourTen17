package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Creature extends Entity{

    static Random rand = new Random(System.currentTimeMillis());

    //attributes specific to a creature
    private String name;
    protected int speed;
    protected String type;
    protected int age = 0;

    //move method for every creature, passing in that creature's speed
    public void move(int speed) {

        // the creature chooses to move a random distance up to their speed 
        int distance = rand.nextInt(speed) + 1;

        //choosing whether or not to move in the x direction
        if (rand.nextBoolean()) {
            //choosing whether to move positive x or negative x
            if (rand.nextBoolean()) {
                location[0] += distance;
                //if it's moved too far, move back
                if (location[0] > World.sizeX - 1) {
                    location[0] -= distance;
                }
            } else {
                location[0] -= distance;
                //if it's moved too far, move back
                if (location[0] < 0) {
                    location[0] += distance;
                }   
            }
        } 
        //choosing whether or not to move in the y direction
        if (rand.nextBoolean()) {
            //choosing whether to move positive y or negative y
            if (rand.nextBoolean()) {
                location[1] += distance;
                //if it's moved too far, move back
                if (location[1] > World.sizeY - 1) {
                    location[1] -= distance;
                }
            } else {
                location[1] -= distance;
                //if it's moved too far, move back
                if (location[1] < 0) {
                    location[1] += distance;
                }   
            }
        } 
    }

    //sets the location of the newly spawned creature equal to the creature that spawned it 
    public void reproduce(int[] l) {
        location[0] = l[0];
        location[1] = l[1];
    }
    
    //returns a name for a creature from a big list of creatures called "name.txt"
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


    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

}