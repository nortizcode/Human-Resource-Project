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
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        try {
            // Open hr.txt file
            File file = new File("hr.txt");
            Scanner fileReader = new Scanner(file);

            // Create PersonSet to hold people data
            PersonSet personSet = new PersonSet();

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

                        // Create Person object and add it to PersonSet
                        Person person = new Person(name, height, weight);
                        personSet.add(person);
                    } catch (NumberFormatException e) {
                        System.out.println("Skipping invalid data for person: " + name);
                    }
                } else {
                    System.out.println("Skipping invalid line: " + line);
                }
            }

            // Close the file reader
            fileReader.close();

            // Print out the unique list of people
            System.out.println("Unique Person Data:");
            System.out.println(personSet.toString());

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}