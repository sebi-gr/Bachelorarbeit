import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginService {

    public boolean authenticate(String username, String password) {
        String dbUrl = "jdbc:yourdb://yourhost:port/dbname";
        String dbUser = "dbuser";
        String dbPass = "dbpassword";

        String sql = "SELECT password FROM users WHERE username = ?";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String storedHash = rs.getString("password");
                    return PasswordService.checkPassword(password, storedHash);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
