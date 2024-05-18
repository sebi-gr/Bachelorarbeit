import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
    public void addUser(User user) {
        String SQL = "INSERT INTO users (username) VALUES (?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {

            stmt.setString(1, user.getUsername());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException("Error while adding user.", ex);
        }
    }

    // Implement other methods like removeUser, updateUser, getUser, etc.
}