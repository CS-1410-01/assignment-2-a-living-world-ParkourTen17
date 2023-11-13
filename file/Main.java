package file;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Bug> Creatures = new ArrayList<>();

        World myWorld = new World();

        Creatures.add(new Bug());

        while(true) {
            for (int i = 0; i < Creatures.size(); i++) {
                if(Creatures.get(i).reproduce()) {
                    //reproduces
                }
                if(Creatures.get(i).die()) {
                    //dies   
                }
            }
        }
        
        //make an arraylist of the number of creatures in the world each step
        //or make objects that are creatures with names from the createCreature method

    }

}
