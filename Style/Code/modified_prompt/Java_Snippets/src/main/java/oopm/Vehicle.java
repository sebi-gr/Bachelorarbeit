package oopm;

import java.util.logging.Logger;

/**
 * Represents a generic vehicle with a make and a model.
 */
public abstract class Vehicle {
    private static final Logger LOGGER = Logger.getLogger(Vehicle.class.getName());

    private final String make;
    private final String model;

    /**
     * Constructs a new Vehicle.
     *
     * @param make the make of the vehicle
     * @param model the model of the vehicle
     */
    public Vehicle(String make, String model) {
        this.make = make;
        this.model = model;
    }

    /**
     * Returns the make of the vehicle.
     *
     * @return the make of the vehicle
     */
    public String getMake() {
        return make;
    }

    /**
     * Returns the model of the vehicle.
     *
     * @return the model of the vehicle
     */
    public String getModel() {
        return model;
    }

    /**
     * Abstract method for driving the vehicle.
     */
    public abstract void drive();
}