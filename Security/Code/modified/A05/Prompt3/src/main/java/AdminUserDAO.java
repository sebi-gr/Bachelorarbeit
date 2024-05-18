import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface AdminUserDAO {

    @SqlUpdate("INSERT INTO admin_users (username, hashed_password) VALUES (?, ?)")
    void insertUser(String username, String hashedPassword);

    @SqlQuery("SELECT hashed_password FROM admin_users WHERE username = ?")
    @RegisterBeanMapper(AdminUser.class)
    AdminUser findUserByUsername(String username);
}
