package base.annotations;

import java.lang.reflect.Method;

public class MainAnnotations {
    public static void main(String[] args) {
        try {
            Method method = ExampleClass.class.getMethod("testMethod");

            if (method.isAnnotationPresent(CustomAnnotation.class)) {
                CustomAnnotation annotation = method.getAnnotation(CustomAnnotation.class);
                System.out.println("name: " + annotation.name());
                System.out.println("value: " + annotation.value());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
