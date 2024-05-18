public class AdminUser {
    private int id; // Die ID des Benutzers in der Datenbank
    private String username; // Der Benutzername
    private String hashedPassword; // Das gehashte Passwort

    // Konstruktor
    public AdminUser(int id, String username, String hashedPassword) {
        this.id = id;
        this.username = username;
        this.hashedPassword = hashedPassword;
    }

    // Standardkonstruktor ohne Parameter, falls benötigt
    public AdminUser() {
    }

    // Getter und Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    // Überlagerung der toString()-Methode für eine bessere Lesbarkeit, falls die Instanz ausgegeben wird
    @Override
    public String toString() {
        return "AdminUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", hashedPassword='" + hashedPassword + '\'' +
                '}';
    }
}
