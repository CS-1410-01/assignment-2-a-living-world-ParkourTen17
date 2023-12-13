package file;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class World {

    public static String[][] World = new String[10][10];

    static ArrayList<Creature> Creatures = new ArrayList<>();
    static ArrayList<Food> Food = new ArrayList<>();
    static Random rand = new Random(System.currentTimeMillis());
    static Scanner in = new Scanner(System.in);


    public static void printWorld(String[][] w) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                w[i][j] = ".";
            }
        }

        for (int i = 0; i < Food.size(); i++) {
            w[Food.get(i).getX()][Food.get(i).getY()] = "*";
        }

        for (int i = 0; i < Creatures.size(); i++) {
            if (Creatures.get(i).type == "Ammonite") {
                w[Creatures.get(i).getX()][Creatures.get(i).getY()] = "A";
            }
            if (Creatures.get(i).type == "Coral") {
                w[Creatures.get(i).getX()][Creatures.get(i).getY()] = "C";
            }
            if (Creatures.get(i).type == "Sea Scorpion") {
                w[Creatures.get(i).getX()][Creatures.get(i).getY()] = "S";
            }
            if (Creatures.get(i).type == "Trilobite") {
                w[Creatures.get(i).getX()][Creatures.get(i).getY()] = "T";
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(w[i][j]);
            }
            System.out.println();
        }
                System.out.println("Number of Creatures: " + Creatures.size());
                System.out.println("Number of Food: " + Food.size());
                System.out.println("|||||||||||||||||||||");

            }

        

    

    public static void main(String[] args) {

        System.out.println("Welcome to the greatest marine ecology simulator ever!");
        System.out.println("Type step to go forward in time, show to show the world, and stop to quit.");

        String[][] world = World;

        for (int i = 0; i < 10; i++) {
            switch(rand.nextInt(4)) {
                case 0: 
                    Creatures.add(new Coral());
                    break;
                case 1:
                    Creatures.add(new Trilobite());
                    break;
                case 2:
                    Creatures.add(new SeaScorpion());
                    break;
                case 3:
                    Creatures.add(new Ammonite());
                    break;
                default:
                    System.out.println("uh oh!");
            }
        }

        Food.add(new Food());
        Food.add(new Food());
        Food.add(new Food());

        for(int i = 0; i < Creatures.size(); i++) {
            System.out.print(Creatures.get(i).type);
            System.out.print(" at (" + Creatures.get(i).getX()); 
            System.out.println(", " + Creatures.get(i).getY() + ")"); 
        }

        printWorld(world);
        

            


        boolean pleaseContinue = true;
        int worldStep = 0;
        while (pleaseContinue) {
            String temp = in.nextLine();
            if (temp.contains("step")) {
                worldStep++;
                if (worldStep % 2 == 0) {
                    // food++;
                    Food.add(new Food());
                    Food.add(new Food());
                    Food.add(new Food());
                }
                for (int i = 0; i < Creatures.size(); i++) { 
                    Creatures.get(i).move(Creatures.get(i).speed);
                    for (int j = 0; j < Food.size(); j++) {
                        System.out.println(Creatures.get(i).getX() + ", " + Creatures.get(i).getY());
                        System.out.println("  " + Food.get(j).getX() + ", " + Food.get(j).getY());
                        if (Creatures.get(i).getLocation() == Food.get(j).getLocation()) {
                            switch (Creatures.get(i).type) {
                                case "Coral": 
                                    Creatures.add(new Coral());
                                    Creatures.get(Creatures.size()).reproduce(Creatures.get(i).getLocation());
                                    break;
                                case "Trilobite":
                                    Creatures.add(new Trilobite());
                                    Creatures.get(Creatures.size()).reproduce(Creatures.get(i).getLocation());
                                    break;
                                case "Sea Scorpion":
                                    Creatures.add(new SeaScorpion());
                                    Creatures.get(Creatures.size()).reproduce(Creatures.get(i).getLocation());
                                    break;
                                case "Ammonite":
                                    Creatures.add(new Ammonite());
                                    Creatures.get(Creatures.size()).reproduce(Creatures.get(i).getLocation());
                                    break;
                                default:
                                    System.out.println("uh oh!");
                            }

                        }
                    }
                    if (Creatures.get(i).die()) {
                        Creatures.remove(Creatures.get(i)); 
                    }
                }
                

            }
            if (temp.contains("show")) {
                printWorld(world);
            }
            if (temp.contains("stop")) {
                pleaseContinue = false;
                printWorld(world);
            }


        }

        // Creatures.add(new Trilobite());
        // System.out.println(Creatures.get(0).getName() + " was born.");
        






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

