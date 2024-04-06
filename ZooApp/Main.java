package ZooApp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        // local variables
        String name = "NeedName";
        String species;
        int age;
        String gender;
        String birthday;
        String color;
        String weight;
        String habitat;
        String id;

        // ArrayList of Animal objects
        ArrayList<Animal> animals = new ArrayList<>();

        // HashMap will be holding animal count

        HashMap<String, Integer> animalCount = new HashMap<>();

        // Open an external file, parse it line by line, and get age and species
        String filePath = "./ZooApp/arrivingAnimals.txt";
        File file = new File(filePath);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Age is in the first element of the array named parts
                String[] parts = line.split(", ");

                // Check if the line has at least 1 part
                if (parts.length >= 1) {
                    String ageAndSpecies = parts[0];
                    String birthSeason = parts[1];
                    String animalColor = parts[2];
                    String animalWeight = parts[3];
                    String animLocationA = parts[4];
                    String animLocationB = parts[5];

                    // Get age out of 'ageAndSpecies'
                    String[] theParts = ageAndSpecies.split(" ");
                    for (int i = 0; i < theParts.length; i++) {
                    }
                    age = Integer.parseInt(theParts[0]);
                    species = theParts[4];
                    gender = theParts[3];

                    // Get birthday
                    String[] theParts2 = birthSeason.split(" ");
                    for (int i = 0; i < theParts2.length; i++) {
                    }
                    birthday = theParts2[2];

                    // Get color
                    String[] theParts3 = animalColor.split(" ");
                    for (int i = 0; i < theParts3.length; i++) {
                    }
                    color = String.join(" ", theParts3);
                    // System.out.println("color: " + color);

                    // Get weight
                    String[] theParts4 = animalWeight.split(" ");
                    for (int i = 0; i < theParts4.length; i++) {
                    }
                    weight = String.join(" ", theParts4);

                    // Get Location Part 1
                    String[] theParts5 = animLocationA.split(" ");
                    for (int i = 0; i < theParts5.length; i++) {
                    }

                    // Get Location Part 2
                    String[] theParts6 = animLocationB.split(" ");
                    for (int i = 0; i < theParts6.length; i++) {
                    }

                    String habitat1 = String.join(" ", theParts5);
                    String habitat2 = String.join(" ", theParts6);
                    habitat = habitat1 + ", " + habitat2;
                    // System.out.println("Habitat: " + habitat);

                    id = "XX00";

                    // Create a new animal object.
                    Animal myAnimal = new Animal(name, age, species, gender, birthday, color, weight, habitat, id);

                    // Add the new Animal object to the ArrayList of Animals
                    animals.add(myAnimal);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
            e.printStackTrace();
        }

        // Parse the animalNames.txt file and pull the names separated by commas
        // Then use the setter to overwrite the names in the ArrayList

        // ArrayList of Hyena names.
        ArrayList<String> hyenaNames = new ArrayList<>();
        // ArrayList of Lion names.
        ArrayList<String> lionNames = new ArrayList<>();
        // ArrayList of Tiger names.
        ArrayList<String> tigerNames = new ArrayList<>();
        // ArrayList of Bear names.
        ArrayList<String> bearNames = new ArrayList<>();

        // Open an external file, parse it line by line, and fill the name arrayLists
        String aFilePath = "./ZooApp/animalNames.txt";
        File aFile = new File(aFilePath);

        try (Scanner scanner = new Scanner(aFile)) {
            while (scanner.hasNextLine()) {
                String aLine = scanner.nextLine();

                if (aLine.contains("Hyena")) {
                    // Skip the next line because it is a blank line.
                    scanner.nextLine();
                    // Now... this line will have the hyena names!
                    // Split this line on a comma and a space and save the hyena names to a String
                    // array.
                    String[] myHyenaNamesArray = scanner.nextLine().split(", ");
                    // Use the same for loop to get the array into the proper ArrayList.
                    for (String someName : myHyenaNamesArray)
                        hyenaNames.add(someName);
                }

                if (aLine.contains("Lion")) {
                    // Skip the next line because it is a blank line.
                    scanner.nextLine();
                    // Now... this line will have the lion names!
                    // Split this line on a comma and a space and save the hyena names to a String
                    // array.
                    String[] myLionsNamesArray = scanner.nextLine().split(", ");
                    // Use the same for loop to get the array into the proper ArrayList.
                    for (String someName : myLionsNamesArray)
                        lionNames.add(someName);
                }

                if (aLine.contains("Tiger")) {
                    // Skip the next line because it is a blank line.
                    scanner.nextLine();
                    // Now... this line will have the tiger names!
                    // Split this line on a comma and a space and save the hyena names to a String
                    // array.
                    String[] myTigerNamesArray = scanner.nextLine().split(", ");
                    // Use the same for loop to get the array into the proper ArrayList.
                    for (String someName : myTigerNamesArray)
                        tigerNames.add(someName);
                }

                if (aLine.contains("Bear")) {
                    // Skip the next line because it is a blank line.
                    scanner.nextLine();
                    // Now... this line will have the bear names!
                    // Split this line on a comma and a space and save the hyena names to a String
                    // array.
                    String[] myBearsNamesArray = scanner.nextLine().split(", ");
                    // Use the same for loop to get the array into the proper ArrayList.
                    for (String someName : myBearsNamesArray)
                        bearNames.add(someName);
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + aFilePath);
            e.printStackTrace();
        }

        // Name the animals, removing the name after each loop
        // Setting a unique ID as well during the loop.  With the names removed
        // the IDs/Names can't be duplicated

        int hyID = 1;
        int liID = 1;
        int tiID = 1;
        int beID = 1;

        for (Animal animal : animals) {
            if (animal.species.equals("hyena")) {
                animal.setName(hyenaNames.getFirst());
                animal.setId("Hy0" + hyID);
                hyID++;
                // Pop the first hyena name off the list
                hyenaNames.remove(0);
            }
            if (animal.species.equals("lion")) {
                animal.setName(lionNames.getFirst());
                animal.setId("Li0" + liID);
                liID++;
                // Pop the first lion name off the list
                lionNames.remove(0);
            }
            if (animal.species.equals("tiger")) {
                animal.setName(tigerNames.getFirst());
                animal.setId("Ti0" + tiID);
                tiID++;
                // Pop the first tiger name off the list
                tigerNames.remove(0);
            }
            if (animal.species.equals("bear")) {
                animal.setName(bearNames.getFirst());
                animal.setId("Be0" + beID);
                beID++;
                // Pop the first bear name off the list
                bearNames.remove(0);
            }
            // Determine birthday
            String birthCalc = genBirthDay(animal.getAge(), animal.getBirthday());
            animal.setBirthday(birthCalc);
        }

        // Write the report, iterating through the animal objects and outputting the
        // data by species with name and age
        // At the end of the report, pull the HashMap data to show a tally of animals
        // per species

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("./ZooApp/zooPopulation.txt"));
            String animalReport;
            writer.write(" -+- Super Snazzy New Animal Report -+- \n\n");
            writer.write("Hyena Habitat:");
            int lineNumber = 1;

            for (Animal animal : animals) {

                if (lineNumber == 5) {
                    writer.write("\n\nLion Habitat:");
                }
                if (lineNumber == 9) {
                    writer.write("\n\nTiger Habitat:");
                }
                if (lineNumber == 13) {
                    writer.write("\n\nBear Habitat:");
                }

                lineNumber++;

                animalReport = ("\n" + animal.getId() + ":" + animal.getName() + " : " + "Birthdate: "
                        + animal.getBirthday() + " : "
                        + animal.getColor() + " : " + animal.getWeight() + " : " + animal.getHabitat())
                        + " : arriving April 1st, 2024";

                writer.write(animalReport);
            }
            writer.write("\n\n" + "Current Species Count: ");
            for (Animal animal : animals) {
                String animalType = animal.getSpecies();
                animalCount.put(animalType, animalCount.getOrDefault(animalType, 0) + 1);
            }
            writer.write(animalCount.toString());
            writer.write("\n" + "Total Number of Animals: " + Animal.numOfAnimals);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String genBirthDay(int animAge, String animBirthday) {
        String month = "";
        int day = 0;
        int year = 0;
        int birthYear = 0;
        String birthString = "";

        if (animBirthday.equals("spring")) {
            month = "Mar";
            day = 20;
            year = 2024;
        } else if (animBirthday.equals("fall")) {
            month = "Sep";
            day = 21;
            year = 2024;
        } else if (animBirthday.equals("winter")) {
            month = "Dec";
            day = 21;
            year = 2024;
        } else {
            return "Unknown";
        }

        birthYear = year - animAge;
        birthString = (month + " " + day + ", " + birthYear).toString();
        return birthString;

    }

}
