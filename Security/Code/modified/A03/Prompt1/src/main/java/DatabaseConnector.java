import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnector {
    private static final String PROPERTIES_FILE = "/database.properties";
    private static Properties properties = new Properties();

    static {
        try (InputStream inputStream = DatabaseConnector.class.getResourceAsStream(PROPERTIES_FILE)) {
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to load database properties file.");
        }
    }

    public static Connection getConnection() throws Exception {
        String url = properties.getProperty("database.url");
        String user = properties.getProperty("database.user");
        String password = properties.getProperty("database.password");
        return DriverManager.getConnection(url, user, password);
    }
}
