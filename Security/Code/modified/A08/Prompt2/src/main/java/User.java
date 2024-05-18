import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
    private String username;
    private String email;

    // Standardkonstruktor ist für JAXB erforderlich
    public User() {
    }

    // Getter und Setter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
