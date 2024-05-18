import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private List<Role> roles;

    public User(String username) {
        this.username = username;
        this.roles = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}