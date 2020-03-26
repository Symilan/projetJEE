package utilitaire;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public interface CookieFactory {
    String       COOKIE_PLAYER  = "player";
    int          COOKIE_MAX_AGE = 60 * 60 * 24 * 31;

    static void setCookie(HttpServletResponse resp, String nom, String valeur, int maxAge)
    {
        Cookie cookie = new Cookie(nom, valeur);
        cookie.setMaxAge(maxAge);
        resp.addCookie(cookie);
    }
}
