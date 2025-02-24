import java.util.ArrayList;

public class PersonSet implements PersonList {
    // Declare an ArrayList to hold the Person objects
    private ArrayList < Person > people = new ArrayList < > ();

    // Method to add a person to the set
    @Override
    public void add(Person person) {
        // Check if the person is not already in list
        if (!people.contains(person)) {
            people.add(person);
        }
    }

    // Method to get a person from the list by their index
    @Override
    public Person get(int index) {
        return people.get(index);
    }

    // Method to convert the list of people into a readable string format
    @Override
    public String toString() {
        // empty string to hold the result
        String result = "";

        for (Person person: people) {
            result += person + "\n";
        }

        // Return string
        return result;
    }
}