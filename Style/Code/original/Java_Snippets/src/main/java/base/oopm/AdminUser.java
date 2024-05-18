package base.oopm;

public class AdminUser extends UserOOPM {
    private String adminLevel;

    public AdminUser(String username, String adminLevel) {
        super(username);
        this.adminLevel = adminLevel;
    }

    public String getAdminLevel() {
        return adminLevel;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Admin Level: " + adminLevel);
    }
}
