package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.*;
import utilitaire.*;


public class Registration extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/registration.jsp").forward(req, resp);
    }

    public Player inscrirePlayer (HttpServletRequest request)
    {
        String pseudo = RegistrationForm.getValeurChamp(request, RegistrationForm.CHAMP_PSEUDO);
        String mail = RegistrationForm.getValeurChamp(request, RegistrationForm.CHAMP_MAIL);
        return null;


    }
}
