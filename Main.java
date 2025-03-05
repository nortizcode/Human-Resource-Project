/*
Nathan Ortiz
2/23/2025
Purpose: to practice inheritance, interfaces, and polymorphism.

Q1: Car and Engine are related
by which, Inheritance or Composition?
Composition

Q2: Color and Red are related
by which, Inheritance or Composition?
Inheritance

Q3: Shirt and Clothing are related
by which, Inheritance or Composition?
Inheritance

Q4: Furniture and Desk are related
by which, Inheritance or Composition?
Inheritance

Q5: CellPhone and Battery are related
by which, Inheritance or Composition?
Composition

*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            // Open hr.txt file
            File file = new File("hr.txt");
            Scanner fileReader = new Scanner(file);

            // Create PersonOrderedSet and PersonImperialSet to hold people data
            PersonOrderedSet orderedSet = new PersonOrderedSet();
            PersonImperialSet imperialSet = new PersonImperialSet();

            // Skip the header line
            if (fileReader.hasNextLine()) {
                fileReader.nextLine();
            }

            // Read data in from file
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] data = line.split("\\s+");
                //https://www.geeksforgeeks.org/split-string-java-examples/

                // If line has exactly 3 elements (name, height, weight)
                if (data.length == 3) {
                    String name = data[0];
                    try {
                        double height = Double.parseDouble(data[1]); // Convert height to double
                        double weight = Double.parseDouble(data[2]); // Convert weight to double

                        // Create Person object and add it to PersonOrderedSet and PersonImperialSet
                        Person personOrdered = new Person(name, height, weight);
                        Person personImperial = new Person(name, height, weight);

                        orderedSet.add(personOrdered); // Add to ordered set
                        imperialSet.add(personImperial); // Add to imperial set
                    } catch (NumberFormatException e) {
                        System.out.println("Skipping invalid data for person: " + data[0]);
                    }
                } else {
                    System.out.println("Skipping invalid line: " + line);
                }
            }

            // Close the file reader
            fileReader.close();

            // Write the output to files
            writeToFile("hr_ordered_set_output.txt", orderedSet.toString());
            writeToFile("hr_imperial_set_output.txt", imperialSet.toString());

            // Print out the unique list of people in ordered and imperial sets
            System.out.println("Ordered Set:");
            System.out.println(orderedSet);
            System.out.println("\nImperial Set:");
            System.out.println(imperialSet);

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    // Helper method to write output to a file
    private static void writeToFile(String fileName, String data) {
        try (PrintWriter writer = new PrintWriter(new File(fileName))) {
            writer.println(data);
        } catch (FileNotFoundException e) {
            System.out.println("Error writing to file: " + fileName);
        }
    }
}