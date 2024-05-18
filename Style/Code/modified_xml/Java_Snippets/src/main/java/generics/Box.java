package generics;

/**
 * This class represents a box that can hold an object of any type.
 *
 * @param <T> the type of the object that this box can hold
 */
public class Box<T> {

    private T object;

    /**
     * Puts the given object into this box.
     *
     * @param object the object to be put into this box
     */
    public void put(T object) {
        this.object = object;
    }

    /**
     * Gets the object that is currently in this box.
     *
     * @return the object that is currently in this box
     */
    public T get() {
        return object;
    }
}