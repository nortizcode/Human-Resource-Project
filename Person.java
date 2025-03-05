public class Person implements Comparable < Person > {

    //https://www.geeksforgeeks.org/comparable-interface-in-java-with-examples/
    // Instance variables to store name, height, and weight
    private String name;
    private double height;
    private double weight;

    // constructor to initialize the Person object with name, height, and weight
    public Person(String name, double height, double weight) {
        this.name = name; // Set the name
        this.height = height; // Set the height
        this.weight = weight; // Set the weight
    }

    // Getter to return persons name
    public String getName() {
        return name;
    }

    // Getter to return persons height
    public double getHeight() {
        return height;
    }

    // Getter to return persons weight
    public double getWeight() {
        return weight;
    }

    // Override the equals method to compare two Person objects
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        // Compare name, height, and weight to check if they are the same
        return name.equals(person.name) && height == person.height && weight == person.weight;
    }

    @Override
    public String toString() {
        // Return persons name, height, and weight in a readable format
        return name + "\t" + height + " cm\t" + weight + " kg";
    }

    // compareTo method for sorting by name (Alphabetical order)
    @Override
    public int compareTo(Person otherPerson) {
        return this.name.compareTo(otherPerson.name); // Compare names in alphabetical order
    }
    //https://www.geeksforgeeks.org/java-string-compareto-method-with-examples/
}