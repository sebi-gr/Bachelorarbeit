import org.jdbi.v3.core.Jdbi;

public class Application {

    public static void main(String[] args) {
        // Verbindung zur H2-Datenbank
        Jdbi jdbi = Jdbi.create("jdbc:h2:~/test", "sa", "");

        // Einrichtung der Datenbank und Erstellung eines Benutzers
        jdbi.useHandle(handle -> {
            handle.execute("CREATE TABLE IF NOT EXISTS admin_users (id IDENTITY, username VARCHAR(255), hashed_password VARCHAR(255))");
            AdminUserDAO dao = handle.attach(AdminUserDAO.class);
            String hashedPassword = PasswordService.hashPassword("sicheresPasswort123!");
            dao.insertUser("admin", hashedPassword);
        });

        // Authentifizierung eines Benutzers
        AdminLoginService adminLoginService = new AdminLoginService(jdbi);
        boolean isAuthenticated = adminLoginService.authenticate("admin", "sicheresPasswort123!");

        System.out.println("Authentifizierung erfolgreich: " + isAuthenticated);
    }
}

/**
 * import org.jdbi.v3.core.Jdbi;
 *
 * public class Application {
 *
 *     public static void main(String[] args) {
 *         // Laden der Datenbankkonfiguration aus Umgebungsvariablen
 *         String dbUrl = System.getenv("DB_URL");
 *         String dbUser = System.getenv("DB_USER");
 *         String dbPassword = System.getenv("DB_PASSWORD");
 *
 *         // Verbindung zur Datenbank
 *         Jdbi jdbi = Jdbi.create(dbUrl, dbUser, dbPassword);
 *
 *         // Einrichtung der Datenbank und Erstellung eines Benutzers
 *         jdbi.useHandle(handle -> {
 *             handle.execute("CREATE TABLE IF NOT EXISTS admin_users (id IDENTITY, username VARCHAR(255), hashed_password VARCHAR(255))");
 *             AdminUserDAO dao = handle.attach(AdminUserDAO.class);
 *             String adminUsername = System.getenv("ADMIN_USERNAME");
 *             String adminPassword = System.getenv("ADMIN_PASSWORD");
 *             String hashedPassword = PasswordService.hashPassword(adminPassword);
 *             dao.insertUser(adminUsername, hashedPassword);
 *         });
 *
 *         // Authentifizierung eines Benutzers
 *         String adminUsername = System.getenv("ADMIN_USERNAME");
 *         String adminPassword = System.getenv("ADMIN_PASSWORD");
 *         AdminLoginService adminLoginService = new AdminLoginService(jdbi);
 *         boolean isAuthenticated = adminLoginService.authenticate(adminUsername, adminPassword);
 *
 *         System.out.println("Authentifizierung erfolgreich: " + isAuthenticated);
 *     }
 * }s
 */