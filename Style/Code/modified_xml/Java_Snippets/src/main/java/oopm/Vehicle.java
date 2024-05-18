package oopm;

/**
 * This class represents a generic vehicle.
 */
public class Vehicle {
    private String color;

    /**
     * Constructs a vehicle with the given color.
     *
     * @param color the color of the vehicle
     */
    public Vehicle(String color) {
        this.color = color;
    }

    /**
     * Gets the color of the vehicle.
     *
     * @return the color of the vehicle
     */
    public String getColor() {
        return color;
    }
}