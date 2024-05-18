import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class AuthFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
        // Initialisierung des Filters, wenn nötig
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Session überprüfen
        HttpSession session = httpRequest.getSession(false);
        
        boolean isLoggedIn = session != null && session.getAttribute("user") != null;
        boolean isAuthorizedPageRequested = httpRequest.getRequestURI().endsWith("protected.jsp");

        if (isLoggedIn && isAuthorizedPageRequested) {
            // Der Benutzer ist angemeldet und fordert eine geschützte Seite an
            chain.doFilter(request, response);
        } else if (!isLoggedIn && isAuthorizedPageRequested) {
            // Der Benutzer ist nicht angemeldet und fordert eine geschützte Seite an
            httpResponse.sendRedirect("login.jsp");
        } else {
            // Zugriff auf öffentliche Seiten oder der Benutzer ist bereits angemeldet
            chain.doFilter(request, response);
        }
    }

    public void destroy() {
        // Bereinigung bei der Zerstörung des Filters, wenn nötig
    }
}
