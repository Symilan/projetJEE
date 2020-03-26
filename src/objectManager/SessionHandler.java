package objectManager;

import model.Player;

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

    public Player getSessionFromHash(String id, int hashedPassword)
    {

        return new Player();
    }
}
