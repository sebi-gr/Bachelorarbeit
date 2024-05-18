package threads;

import java.util.logging.Logger;

/**
 * This class demonstrates the use of threads in Java.
 */
public class ThreadExample {

    private static final Logger LOGGER = Logger.getLogger(ThreadExample.class.getName());

    /**
     * This method starts two threads and logs their execution.
     */
    public void startThreads() {
        Thread thread1 = new Thread(new RunnableTask(), "Thread 1");
        Thread thread2 = new Thread(new RunnableTask(), "Thread 2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            LOGGER.severe("Thread interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        }

        LOGGER.info("Both threads have finished execution");
    }

    /**
     * This class implements Runnable and overrides the run method.
     */
    private class RunnableTask implements Runnable {

        @Override
        public void run() {
            LOGGER.info(Thread.currentThread().getName() + " is running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                LOGGER.severe("Thread interrupted: " + e.getMessage());
                Thread.currentThread().interrupt();
            }
            LOGGER.info(Thread.currentThread().getName() + " has finished");
        }
    }
}