package base.annotations;

public class ExampleClass {
    @CustomAnnotation(name = "Test", value = 10)
    public void testMethod() {
        System.out.println("Inside testMethod()");
    }
}
