package oopm;

/**
 * This class represents a car.
 */
public class Car extends Vehicle {
    private int numberOfDoors;

    /**
     * Constructs a car with the given color and number of doors.
     *
     * @param color the color of the car
     * @param numberOfDoors the number of doors on the car
     */
    public Car(String color, int numberOfDoors) {
        super(color);
        this.numberOfDoors = numberOfDoors;
    }

    /**
     * Gets the number of doors on the car.
     *
     * @return the number of doors on the car
     */
    public int getNumberOfDoors() {
        return numberOfDoors;
    }
}