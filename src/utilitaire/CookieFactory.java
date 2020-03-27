package utilitaire;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This interface CookieFactory is used to implement every tool to manipulate cookies
 */
public interface CookieFactory {
    String       COOKIE_PLAYER  = "player";
    String       COOKIE_GAME    = "game";
    int          COOKIE_MAX_AGE = 60 * 60 * 24 * 31;

    /**
     * Method to create a cookie or delete one
     * To delete a cookie, set name to the cookie's name and set maxAge to 0
     * @param resp          HTTP response
     * @param nom           The name of the cookie
     * @param valeur        The value inside the cookie, what it will transport
     * @param maxAge        The duration while the cookie is active. After maxAge (in seconds), the cookie will be deleted
     */
    static void setCookie(HttpServletResponse resp, String nom, String valeur, int maxAge)
    {
        Cookie cookie = new Cookie(nom, valeur);
        cookie.setMaxAge(maxAge);
        resp.addCookie(cookie);
    }

    /**
     * Method to get what a cookie transports
     * @param req           HTTP request
     * @param nom           The name of the cookie
     * @return              Return the string in the cookie
     */
    static String getCookieValue(HttpServletRequest req, String nom)
    {
        Cookie[] cookies = req.getCookies();
        if (cookies != null)
        {
            for (Cookie cookie : cookies)
            {
                if (cookie != null && nom.equals(cookie.getName()))
                {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
