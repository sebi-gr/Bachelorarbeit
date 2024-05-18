package generics;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * A generic stack implementation in Java.
 *
 * @param <T> the type of elements in this stack
 */
public class GenericStack<T> {

    private static final Logger LOGGER = Logger.getLogger(GenericStack.class.getName());

    // LinkedList is used as it provides constant time complexity for insertion and deletion operations
    private final LinkedList<T> stack;

    /**
     * Constructs an empty GenericStack.
     */
    public GenericStack() {
        this.stack = new LinkedList<>();
    }

    /**
     * Pushes an element onto the stack.
     *
     * @param element the element to be pushed onto the stack
     */
    public void push(T element) {
        stack.addFirst(element);
        LOGGER.info("Element pushed to stack: " + element);
    }

    /**
     * Removes the element at the top of the stack and returns it.
     *
     * @return the topmost element of the stack
     * @throws EmptyStackException if the stack is empty
     */
    public T pop() throws EmptyStackException {
        if (stack.isEmpty()) {
            LOGGER.severe("Attempted to pop an element from an empty stack");
            throw new EmptyStackException();
        }

        T element = stack.removeFirst();
        LOGGER.info("Element popped from stack: " + element);
        return element;
    }

    /**
     * Returns the element at the top of the stack without removing it.
     *
     * @return the topmost element of the stack
     * @throws EmptyStackException if the stack is empty
     */
    public T peek() throws EmptyStackException {
        if (stack.isEmpty()) {
            LOGGER.severe("Attempted to peek at an empty stack");
            throw new EmptyStackException();
        }

        T element = stack.getFirst();
        LOGGER.info("Element peeked at stack: " + element);
        return element;
    }

    /**
     * Returns true if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}