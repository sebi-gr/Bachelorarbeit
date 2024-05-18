import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RoleDao {
    public void addRole(Role role) {
        String SQL = "INSERT INTO roles (name) VALUES (?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {

            stmt.setString(1, role.getName());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException("Error while adding role.", ex);
        }
    }

    public void removeRole(Role role) {
        String SQL = "DELETE FROM roles WHERE name = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {

            stmt.setString(1, role.getName());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException("Error while removing role.", ex);
        }
    }

    public boolean hasRole(Role role) {
        String SQL = "SELECT COUNT(*) FROM roles WHERE name = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {

            stmt.setString(1, role.getName());
            return stmt.executeQuery().getInt(1) > 0;

        } catch (SQLException ex) {
            throw new RuntimeException("Error while checking role.", ex);
        }
    }
}