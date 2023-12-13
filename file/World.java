package file;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class World {

    //Attributes of the world
    public static int sizeX = 0;
    public static int sizeY = 0;
    public static String[][] World;

    //Creating arraylists of creatures and food, also random and scanner methods
    static ArrayList<Creature> Creatures = new ArrayList<>();
    static ArrayList<Food> Food = new ArrayList<>();
    static Random rand = new Random(System.currentTimeMillis());
    static Scanner in = new Scanner(System.in);

    //printWorld method, according to the size that the user enters
    public static void printWorld(String[][] w) {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                //fills each blank space with dots
                w[i][j] = ".";
            }
        }

        //Fills the world matrix with food icons according to their random location 
        for (int i = 0; i < Food.size(); i++) {
            //food is a * icon
            w[Food.get(i).getX()][Food.get(i).getY()] = "*";
        }

        //fills the world matrix with creature icons according to their random location
        for (int i = 0; i < Creatures.size(); i++) {
            if (Creatures.get(i).type == "Ammonite") {
                //Ammonites are an A
                w[Creatures.get(i).getX()][Creatures.get(i).getY()] = "A";
            }
            if (Creatures.get(i).type == "Coral") {
                //Corals are a C
                w[Creatures.get(i).getX()][Creatures.get(i).getY()] = "C";
            }
            if (Creatures.get(i).type == "Sea Scorpion") {
                //Sea Scorpions are an S
                w[Creatures.get(i).getX()][Creatures.get(i).getY()] = "S";
            }
            if (Creatures.get(i).type == "Trilobite") {
                //Trilobites are a T
                w[Creatures.get(i).getX()][Creatures.get(i).getY()] = "T";
            }
        }
        //printing out the populated matrix
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                System.out.print(w[i][j]);
            }
            System.out.println();
        }
        //printing out basic stats about the world
        System.out.println("Number of Creatures: " + Creatures.size());
        System.out.println("Number of Food: " + Food.size());
        System.out.println("|||||||||||||||||||||");

    }


    //method to print out more advanced creature statistics
    public static void printCreatures() {
        for(int i = 0; i < Creatures.size(); i++) {
            System.out.printf("%s named %s at (%d, %d) is %d steps old\n", 
            Creatures.get(i).type, Creatures.get(i).getName(),
            Creatures.get(i).getX(),Creatures.get(i).getY(), Creatures.get(i).age);
        }
    }

    
    //Main Method!
    public static void main(String[] args) {

        //Intro printlns
        System.out.println("Welcome to the greatest marine ecology simulator ever!");
        System.out.println("Enter two numbers for the size of the world: (best is between 5-15)");
        //setting the size of the world equal to whatever the user enters
        sizeX = in.nextInt();
        sizeY = in.nextInt();

        //instructions
        System.out.println("Hit enter to move forward in time, print to list the creatures, and stop to quit.");

        //creating a world with the size equal to the size entered
        World = new String[sizeX][sizeY];
        String[][] world = World;

        //filling the Creature arraylists with a starting population proportional to the size of the world
        for (int i = 0; i < ((sizeX + sizeY) / 2); i++) {
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
        in.nextLine();

        //filling the food arraylist with a starting amount proportional to the size of the world
        for(int i = 0; i < ((sizeX + sizeY) / 2); i++) {
            Food.add(new Food());
        }

        //Prints the creature stats and the world matrix to start out
        printCreatures();
        printWorld(world);

        boolean pleaseContinue = true;
        int worldStep = 0;
        //main iterating loop of the world
        while (pleaseContinue) {
            //takes in user input
            String temp = in.nextLine();
            //if else statements that depend on user input: enter, print, stop, anything else
            if (temp.equals("")) {
                worldStep++;
                if (worldStep % 2 == 0) {
                    //adds food to the world every other step, an amount proportional to the size of the world, minimum 1
                    for(int i = 0; i < ((sizeX + sizeY) / 10) + 1; i++) {
                        Food.add(new Food());
                    }
                }

                //runs through the creature arraylist, checking lots of things for each creature:
                for (int i = 0; i < Creatures.size(); i++) { 
                    if (Creatures.get(i).type != "Coral") {
                        //if its not a coral, each creature moves
                        Creatures.get(i).move(Creatures.get(i).speed);
                    }
                    //each creature gets older
                    Creatures.get(i).age++;

                    for (int j = 0; j < Food.size(); j++) {
                        //checks the location of each food relative to each creature
                        if (Arrays.equals(Creatures.get(i).getLocation(), Food.get(j).getLocation())) {
                            //if a creature lands on a food, then we add a new creature of that type to the arraylist
                            //creatures can only reproduce when they land on food
                            switch (Creatures.get(i).type) {
                                case "Coral": 
                                    Creatures.add(new Coral());
                                    break;
                                case "Trilobite":
                                    //trilobites are particularly good at reproducing, and each time they reproduce, they spawn two more
                                    //this helps, because they can get eaten by sea scorpions and ammonites
                                    Creatures.add(new Trilobite());
                                    Creatures.add(new Trilobite());
                                    break;
                                case "Sea Scorpion":
                                    Creatures.add(new SeaScorpion());
                                    break;
                                case "Ammonite":
                                    Creatures.add(new Ammonite());
                                    break;
                                default:
                                    System.out.println("uh oh!");
                                }
                            //if its not a coral, that creature spawns at the same location that the original creature is at
                            //corals can't move on their own, so that's the only way they move
                            if (Creatures.get(i).type != "Coral") {
                                Creatures.get(Creatures.size() - 1).reproduce(Creatures.get(i).getLocation());
                            }    
                            //the food is eaten, removed from the food arraylist
                            Food.remove(Food.get(j));
                        }
                    }
                    //checks the location of each creature relative to each other creature
                    for (int j = 0; j < Creatures.size(); j++) {
                        if (Arrays.equals(Creatures.get(i).getLocation(), Creatures.get(j).getLocation())) {
                            //if an ammonite or a sea scorpion landed on a trilobite, they eat it
                            if ((Creatures.get(i).type == "Ammonite" || Creatures.get(i).type == "Sea Scorpion") && (Creatures.get(j).type == "Trilobite")) {
                                switch (Creatures.get(i).type) {
                                    //add a sea scorpion/ammonite to the creature arraylist
                                    case "Sea Scorpion":
                                        Creatures.add(new SeaScorpion());
                                        break;
                                    case "Ammonite":
                                        Creatures.add(new Ammonite());
                                        break;
                                    default:
                                        System.out.println("uh oh!");
                                    }
                                    //they get spawned at the same location of the creature that removed it
                                    Creatures.get(Creatures.size() - 1).reproduce(Creatures.get(i).getLocation());
                                    //this is a special thing, the user deserves to know about it
                                    System.out.printf("An %s just ate a %s!\n", Creatures.get(i).type, Creatures.get(j).type);
                                //The trilobite is removed from the arraylist, is eaten
                                Creatures.remove(j);
                            }

                        }
                    }
                    //after they move and eat food/each other, each creature has a chance to die of natural causes
                    if (Creatures.get(i).die()) {
                        Creatures.remove(Creatures.get(i)); 
                    }
                }
                //prints the world out again after everything in the world step is accomplished
                printWorld(world);
            } else if (temp.contains("print")) {
                //prints out the stats of the world and creatures
                printCreatures();
                System.out.println("World age:" + worldStep);
            } else if (temp.contains("stop")) {
                //prints the world one last time, then ends the while loop
                pleaseContinue = false;
                printWorld(world);
            } else {
                //if the user enters anything else, nothing happens and they're reminded of what inputs do things
                System.out.println("Not a command! Here's what you can do:");
                System.out.println("Hit enter to move forward in time, print to list the creatures, and stop to quit.");
            }


        }


    }

}

