package base.oopm;

public class MainOOPM {
    public static void main(String[] args) {
        UserOOPM regularUser = new UserOOPM("JohnDoe");
        UserOOPM adminUser = new AdminUser("AdminJohn", "Super");

        regularUser.display();
        adminUser.display();
    }
}
