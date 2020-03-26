package objectManager;

import model.Player;

import java.sql.SQLOutput;

public class SessionHandler {
    private SessionHandler() {
    }

    private static class SessionHandlerHolder {
        private final static SessionHandler MAIN_SESSION_HANDLER_FACADE = new SessionHandler();
    }

    public static SessionHandler getSessionHandler()
    {
        return SessionHandlerHolder.MAIN_SESSION_HANDLER_FACADE;
    }

    public static Player authFromPseudo(String pseudo, String hashedPassword)
    {
        System.out.println(pseudo);
        System.out.println(hashedPassword);
        System.out.println();
        System.out.println();
        return RequestHandler.getRequestHandler().authenticate(pseudo,hashedPassword);
    }

    public static void main(String[] args) {
        System.out.println(RequestHandler.getRequestHandler().authenticate("noobmaster","AZERTY"));
    }
}
