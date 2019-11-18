package org.abondar.experimental.drawer.exception;

/**
 * Exception thrown if invalid command or params are entered
 *
 * @author a.bondar
 */
public class InvalidCommandException extends Exception {

    public InvalidCommandException(String message){
        super(message);
    }
}
