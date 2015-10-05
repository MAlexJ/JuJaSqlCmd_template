package ua.com.juja.sqlcmd.exception;

public class JuJaSqlCmdException extends Exception {

    public JuJaSqlCmdException() {
    }

    public JuJaSqlCmdException(String message) {
        super(message);
    }

    public JuJaSqlCmdException(String message, Throwable cause) {
        super(message, cause);
    }
}
