package org.abondar.experimental.drawer.command;


import org.abondar.experimental.drawer.draw.Canvas;
import org.abondar.experimental.drawer.exception.CanvasException;

/**
 * Create canvas command
 *
 * @author a.bondar
 */
public class CreateCommand implements Command {

    private String width;
    private String height;

    public CreateCommand(String width, String height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void exceute() throws CanvasException {
        var canvas = Canvas.getInstance();
        canvas.createCanvas(Integer.parseInt(width), Integer.parseInt(height));
        canvas.render();
    }
}
