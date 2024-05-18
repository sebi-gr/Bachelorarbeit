package lambdas;

import java.util.logging.Logger;

/**
 * Represents a person with a name and age.
 */
public class Person {
    private static final Logger LOGGER = Logger.getLogger(Person.class.getName());

    private final String name;
    private final int age;

    /**
     * Constructs a new Person.
     *
     * @param name the name of the person
     * @param age the age of the person
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Returns the name of the person.
     *
     * @return the name of the person
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the age of the person.
     *
     * @return the age of the person
     */
    public int getAge() {
        return age;
    }
}