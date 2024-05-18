package base.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) {
        try {
            Class<?> personClass = Class.forName("Person");
            Constructor<?> constructor = personClass.getConstructor(String.class);
            Method getNameMethod = personClass.getMethod("getName");

            Object personObject = constructor.newInstance("John Doe");
            String name = (String) getNameMethod.invoke(personObject);

            System.out.println("Name: " + name);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
