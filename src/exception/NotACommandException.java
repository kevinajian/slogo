package exception;
/**
 * Throws custom command if a command is not implemented.
 * @author carlosreyes
 *
 */
public class NotACommandException extends Exception {
    public NotACommandException() {}

    public NotACommandException(String message)
    {
       super(message);
    }
}
