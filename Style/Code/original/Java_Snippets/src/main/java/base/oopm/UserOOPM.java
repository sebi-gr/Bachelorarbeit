package base.oopm;

public class UserOOPM {
    private String username;

    public UserOOPM(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void display() {
        System.out.println("Username: " + username);
    }
}
