package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * Demonstrates the use of lambdas to sort a list of Person objects by age.
 */
public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    /**
     * The main method.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        try {
            // Create a list of Person objects
            List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 20),
                new Person("Charlie", 40)
            );

            // Sort the list by age using a lambda
            people.sort((Person p1, Person p2) -> p1.getAge() - p2.getAge());

            // Log the sorted list
            people.forEach(person -> LOGGER.info(person.getName() + ": " + person.getAge()));
        } catch (Exception e) {
            LOGGER.severe("An error occurred: " + e.getMessage());
        }
    }
}