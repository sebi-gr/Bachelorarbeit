package oopm;

import java.util.logging.Logger;

/**
 * Represents a car, which is a specific type of vehicle.
 */
public class Car extends Vehicle implements Drivable {
    private static final Logger LOGGER = Logger.getLogger(Car.class.getName());

    /**
     * Constructs a new Car.
     *
     * @param make the make of the car
     * @param model the model of the car
     */
    public Car(String make, String model) {
        super(make, model);
    }

    /**
     * Drives the car.
     */
    @Override
    public void drive() {
        try {
            LOGGER.info("Driving the car: " + getMake() + " " + getModel());
        } catch (Exception e) {
            LOGGER.severe("An error occurred while driving the car: " + e.getMessage());
        }
    }
}