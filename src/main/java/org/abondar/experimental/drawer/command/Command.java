package org.abondar.experimental.drawer.command;


import org.abondar.experimental.drawer.exception.CanvasException;

/**
 * Basic command interface
 *
 * @author a.bondar
 */
public interface Command {
    void exceute()  throws CanvasException;
}
