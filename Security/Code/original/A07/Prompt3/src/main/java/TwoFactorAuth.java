import java.util.Random;

public class TwoFactorAuth {
    private User user;

    public TwoFactorAuth(User user) {
        this.user = user;
    }

    public void generateOtp() {
        Random random = new Random();
        String otp = String.format("%04d", random.nextInt(10000));
        user.setOtp(otp);
    }

    public boolean authenticate(String password, String otp) {
        return user.checkPassword(password) && user.checkOtp(otp);
    }
}