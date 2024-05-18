import org.jdbi.v3.core.Jdbi;

public class AdminLoginService {
    private final Jdbi jdbi;

    public AdminLoginService(Jdbi jdbi) {
        this.jdbi = jdbi;
    }

    public boolean authenticate(String username, String password) {
        AdminUser adminUser = jdbi.withExtension(AdminUserDAO.class, dao -> dao.findUserByUsername(username));
        if (adminUser == null) {
            return false;
        }
        return PasswordService.checkPassword(password, adminUser.getHashedPassword());
    }
}
