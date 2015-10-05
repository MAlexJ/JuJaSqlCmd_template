package ua.com.juja.sqlcmd.exception.imp;

import ua.com.juja.sqlcmd.exception.JuJaSqlCmdException;

/**
 * Created by oleksandr.baglai on 28.08.2000.
 */
public class ExitException extends JuJaSqlCmdException {

    public ExitException() {
    }

    public ExitException(String message) {
        super(message);
    }

    public ExitException(String message, Throwable cause) {
        super(message, cause);
    }
}
