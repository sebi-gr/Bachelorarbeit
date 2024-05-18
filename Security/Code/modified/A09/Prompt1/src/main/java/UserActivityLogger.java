import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserActivityLogger {
    private static final Logger logger = LoggerFactory.getLogger(UserActivityLogger.class);

    public static void logUserActivity(String message) {
        logger.info("Message={}", message);
    }

    public static void main(String[] args) {
        logUserActivity("API Call erfolgreich");
    }
}
