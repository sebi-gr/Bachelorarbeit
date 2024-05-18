import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserInfoFetcher {
    public static void fetchUserInfo(String username) {
        String query = "SELECT * FROM users WHERE username = ?";

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Setzen des Benutzernamens im PreparedStatement
            statement.setString(1, username);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    // Hier können Sie die Ergebnisse verarbeiten
                    System.out.println("Benutzername: " + resultSet.getString("username"));
                    System.out.println("E-Mail: " + resultSet.getString("email"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        fetchUserInfo("test");
    }
}
