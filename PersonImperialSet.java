public class PersonImperialSet extends PersonSet {

    @Override
    public void add(Person person) {
        double heightInInches = convertHeight(person.getHeight());
        double weightInPounds = convertWeight(person.getWeight());

        // Create a new Person with converted values
        Person convertedPerson = new Person(person.getName(), heightInInches, weightInPounds);

        super.add(convertedPerson); // Add the converted person
    }

    private double convertHeight(double cm) {
        return cm * 0.393701; // Convert cm to inches
    }

    private double convertWeight(double kg) {
        return kg * 2.20462; // Convert kg to pounds
    }
}