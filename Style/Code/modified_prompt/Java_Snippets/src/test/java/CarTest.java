import oopm.Car;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.StreamHandler;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for the Car class.
 */
public class CarTest {
    private Car car;
    private ByteArrayOutputStream logCapturingStream;
    private StreamHandler customLogHandler;

    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        car = new Car("Tesla", "Model S");
        logCapturingStream = new ByteArrayOutputStream();
        PrintStream capturingPrintStream = new PrintStream(logCapturingStream);
        customLogHandler = new StreamHandler(capturingPrintStream, null);
        Logger.getLogger(Car.class.getName()).addHandler(customLogHandler);
    }

    /**
     * Tests the drive method of the Car class.
     */
    @Test
    public void testDrive() {
        car.drive();
        customLogHandler.flush();
        String capturedLog = logCapturingStream.toString();
        assertTrue("The log should contain the car's make and model",
            capturedLog.contains("Driving the car: Tesla Model S"));
    }
}