import java.util.Collections;

public class PersonOrderedSet extends PersonSet {

    @Override
    public void add(Person p) {
        super.add(p); // Add the person
        Collections.sort(people); // Sort list
    }
}
