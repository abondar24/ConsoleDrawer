package org.abondar.experimental.drawer.command;

/**
 * Executes quit from command
 *
 * @author a.bondar
 */
public class QuitCommand implements Command {
    @Override
    public void exceute() {
       System.exit(0);
    }
}
