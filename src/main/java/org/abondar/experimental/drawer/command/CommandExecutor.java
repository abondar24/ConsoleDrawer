package org.abondar.experimental.drawer.command;


import org.abondar.experimental.drawer.exception.CanvasException;
import org.abondar.experimental.drawer.exception.InvalidCommandException;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores command history and executes them
 *
 * @author a.bondar
 */
public class CommandExecutor {

    private final List<Command> history = new ArrayList<>();

    public void storeAndExecute(Command command) throws InvalidCommandException {
        try {
            command.exceute();
            this.history.add(command);
        } catch (CanvasException ex){
            throw new InvalidCommandException(ex.getMessage());
        }

    }
}
