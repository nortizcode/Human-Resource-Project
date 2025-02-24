import java.util.ArrayList;

public class PersonSet implements PersonList {
    protected ArrayList<Person> people;

    public PersonSet() {
        people = new ArrayList<>();
    }

    // Add a Person, making sure no duplicates
    @Override
    public void add(Person p) {
        if (!people.contains(p)) {
            people.add(p);
        }
    }

    // Get a Person by index
    @Override
    public Person get(int index) {
        return people.get(index);
    }

    // Return the set as a string for easy display
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Person p : people) {
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }
}
