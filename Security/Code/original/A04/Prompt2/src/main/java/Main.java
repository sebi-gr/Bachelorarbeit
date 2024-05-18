import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class Main {
    public void saveDataInCookie(HttpServletResponse response, String key, String value) {
        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(60 * 60 * 24); // Set cookie to expire after 24 hours
        response.addCookie(cookie);
    }
}