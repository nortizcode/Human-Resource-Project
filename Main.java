import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        try {
            // Open the hr.txt file
            File file = new File("hr.txt");
            Scanner fileReader = new Scanner(file);

            // Create a PersonSet to hold people data
            PersonSet personSet = new PersonSet();

            // Skip the header line
            if (fileReader.hasNextLine()) {
                fileReader.nextLine();
            }

            // Read data from the file
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                // Use a regular expression to split by one or more spaces
                String[] data = line.split("\\s+");  // This splits on one or more spaces

                // If the line has exactly 3 elements (name, height, weight)
                if (data.length == 3) {
                    String name = data[0];
                    try {
                        double height = Double.parseDouble(data[1]);  // Convert height to double
                        double weight = Double.parseDouble(data[2]);  // Convert weight to double

                        // Create a Person object and add it to the PersonSet
                        Person person = new Person(name, height, weight);
                        personSet.add(person);  // Adds only if it's not a duplicate
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
