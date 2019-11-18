package org.abondar.experimental.drawer.command;


import org.abondar.experimental.drawer.draw.Canvas;
import org.abondar.experimental.drawer.exception.CanvasException;

public class ClearCommand  implements Command{
    private Canvas canvas;

    public ClearCommand(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void exceute() throws CanvasException {
       canvas.clearCanvas();
       canvas.render();
    }
}
