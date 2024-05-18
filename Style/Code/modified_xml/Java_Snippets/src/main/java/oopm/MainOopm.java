package oopm;

/**
 * This class demonstrates the use of the Vehicle and Car classes.
 */
public class MainOopm {

    /**
     * The main method.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Car car = new Car("red", 4);
        System.out.println("The car is " + car.getColor() + " and has " + car.getNumberOfDoors() + " doors.");
    }
}