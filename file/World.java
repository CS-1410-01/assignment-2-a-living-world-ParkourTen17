package file;
import java.util.ArrayList;
public class World {

    static ArrayList<Creature> Creatures = new ArrayList<>();
    public static void main(String[] args) {
        Creatures.add(new Trilobite());
        System.out.println(Creatures.get(0).getName() + " was born.");






        // while(Creatures.size() > 0) {
        //     for (int i = 0; i < Creatures.size(); i++) {
        //         if(Creatures.get(i).reproduce()) {
        //             Creatures.add(new Bug());
        //             System.out.println(Creatures.get(i).name + " was born.");
        //         }
        //         if(Creatures.get(i).die()) {
        //             System.out.println(Creatures.get(i).name + " has died."); 
        //             Creatures.remove(Creatures.get(i)); 

        //         }
        //     }
        // }
    }

}

