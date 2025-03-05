import java.util.Collections;

public class PersonOrderedSet extends PersonSet {

    @Override
    public void add(Person person) {
        super.add(person); // Add person
        Collections.sort(people); // Sort list
    }
}
