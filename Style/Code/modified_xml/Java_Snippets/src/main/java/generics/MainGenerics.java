package generics;

/**
 * This class demonstrates the use of the Box class.
 */
public class MainGenerics {

    /**
     * The main method.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Box<String> box = new Box<>();
        box.put("Hello, World!");
        System.out.println(box.get());
    }
}