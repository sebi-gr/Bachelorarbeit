package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class demonstrates the use of lambda functions.
 */
public class LambdaExample {

    /**
     * The main method.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jane", "Adam", "Eve");
        List<String> sortedNames = names.stream()
            .sorted((name1, name2) -> name1.compareTo(name2))
            .collect(Collectors.toList());

        System.out.println(sortedNames);
    }
}