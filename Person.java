public class Person {
    private String name;
    private double height;
    private double weight;

    // Constructor
    public Person(String name, double height, double weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    // Overriding equals method to prevent duplicates based on name, height, and weight
    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person p = (Person) o;
        return this.name.equals(p.name) && this.height == p.height && this.weight == p.weight;
    }

    // Overriding toString to return data in database-ready format
    @Override
    public String toString() {
        return name + "\t" + height + "\t" + weight;
    }
}
