package org.abondar.experimental.drawer.command;


import org.abondar.experimental.drawer.draw.Canvas;
import org.abondar.experimental.drawer.draw.Point;
import org.abondar.experimental.drawer.exception.CanvasException;

/**
 * Draw line or rectangle command
 *
 * @author a.bondar
 */
public class DrawCommand implements Command {

    private String[] params;
    private Canvas canvas;
    private boolean isLine;

    public DrawCommand(Canvas canvas, String[] params,boolean isLine) {
        this.canvas = canvas;
        this.params = params;
        this.isLine = isLine;

    }

    @Override
    public void exceute() throws CanvasException {
        var point1 = new Point(Integer.parseInt(params[0]),Integer.parseInt(params[1]));
        var point2 = new Point(Integer.parseInt(params[2]),Integer.parseInt(params[3]));

        if (isLine){
            canvas.drawLine(point1,point2);
        } else {
            canvas.drawRectangle(point1,point2);
        }

        canvas.render();
    }
}
