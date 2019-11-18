package org.abondar.experimental.drawer.command;


import org.abondar.experimental.drawer.draw.Canvas;
import org.abondar.experimental.drawer.draw.Point;
import org.abondar.experimental.drawer.exception.CanvasException;

/**
 * Command to execute bucket fill
 *
 * @author a.bondar
 */
public class BucketFillCommand implements Command{

    private Canvas canvas;
    private String[] params;

    public BucketFillCommand(Canvas canvas, String[] params) {
        this.canvas = canvas;
        this.params = params;
    }

    @Override
    public void exceute() throws CanvasException {
        var point = new Point(Integer.parseInt(params[0]),Integer.parseInt(params[1]));
        canvas.bucketFill(point,params[2].charAt(0));
        canvas.render();
    }
}
