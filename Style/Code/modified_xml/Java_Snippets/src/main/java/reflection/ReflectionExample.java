package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * This class demonstrates the use of reflection.
 */
public class ReflectionExample {

    /**
     * The main method.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Class<?> boxClass = Class.forName("generics.Box");

            System.out.println("Fields:");
            for (Field field : boxClass.getDeclaredFields()) {
                System.out.println(field);
            }

            System.out.println("Methods:");
            for (Method method : boxClass.getDeclaredMethods()) {
                System.out.println(method);
            }

            System.out.println("Constructors:");
            for (Constructor<?> constructor : boxClass.getDeclaredConstructors()) {
                System.out.println(constructor);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}