public class AdminInterface {

    private static final String DEFAULT_USERNAME = "admin";
    private static final String DEFAULT_PASSWORD = "password";

    public boolean login(String username, String password) {
        if (DEFAULT_USERNAME.equals(username) && DEFAULT_PASSWORD.equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        AdminInterface adminInterface = new AdminInterface();
        boolean accessGranted = adminInterface.login("admin", "password");

        if (accessGranted) {
            System.out.println("Zugriff gewährt");
        } else {
            System.out.println("Zugriff verweigert");
        }
    }
}