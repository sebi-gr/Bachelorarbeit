public class User {
    private String username;
    private String password;
    private String otp;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public boolean checkOtp(String otp) {
        return this.otp.equals(otp);
    }
}