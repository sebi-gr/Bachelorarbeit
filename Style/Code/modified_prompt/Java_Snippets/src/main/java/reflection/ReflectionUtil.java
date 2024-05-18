package reflection;

import java.lang.reflect.Method;
import java.util.logging.Logger;

/**
 * A utility class that provides methods for working with Java Reflection.
 */
public class ReflectionUtil {

    private static final Logger LOGGER = Logger.getLogger(ReflectionUtil.class.getName());

    /**
     * Prints the public methods of the specified class.
     *
     * @param className the fully qualified name of the class
     */
    public static void printPublicMethods(String className) {
        try {
            // Load the Class object
            Class<?> clazz = Class.forName(className);

            // Get the public methods of the class
            Method[] methods = clazz.getMethods();

            // Print the public methods
            for (Method method : methods) {
                LOGGER.info("Method: " + method.getName());
            }
        } catch (ClassNotFoundException e) {
            LOGGER.severe("The class " + className + " was not found.");
        } catch (Exception e) {
            LOGGER.severe("An error occurred: " + e.getMessage());
        }
    }
}