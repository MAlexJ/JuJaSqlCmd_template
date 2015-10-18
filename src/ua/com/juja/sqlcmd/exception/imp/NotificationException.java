package ua.com.juja.sqlcmd.exception.imp;

import ua.com.juja.sqlcmd.exception.JuJaSqlCmdException;

/**
 * Created by ION on 19.10.2015.
 */
public class NotificationException extends JuJaSqlCmdException {

    public NotificationException() {
    }

    public NotificationException(String message) {
        super(message);
    }

    public NotificationException(String message, Throwable cause) {
        super(message, cause);
    }
}
